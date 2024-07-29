package model;

import java.util.*;

// Clase que representa el laberinto
public class Maze {
    private Cell[][] grid; // Matriz de celdas que representa el laberinto
    private Position start; // Posición de inicio del laberinto
    private Position end; // Posición de fin del laberinto

    // Constructor que inicializa el laberinto con el número de filas y columnas
    public Maze(int rows, int cols) {
        grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(true); // Inicializa todas las celdas como transitables
            }
        }
    }

    // Método para establecer el estado de transitabilidad de una celda
    public void setCell(int row, int col, boolean isWalkable) {
        grid[row][col].setWalkable(isWalkable);
    }

    // Método para verificar si una celda es transitable
    public boolean isWalkable(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col].isWalkable();
    }

    // Métodos para establecer las posiciones de inicio y fin del laberinto
    public void setStart(Position start) {
        this.start = start;
    }

    public void setEnd(Position end) {
        this.end = end;
    }

    // Métodos para obtener las posiciones de inicio y fin del laberinto
    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    // Métodos para obtener el número de filas y columnas del laberinto
    public int getRows() {
        return grid.length;
    }

    public int getCols() {
        return grid[0].length;
    }

    // Método para resolver el laberinto recursivamente
    public List<Position> solveRecursive() {
        boolean[][] visited = new boolean[getRows()][getCols()]; // Matriz de celdas visitadas
        List<Position> path = new ArrayList<>(); // Lista para almacenar el camino
        if (solveRecursiveHelper(start.getRow(), start.getCol(), visited, path)) {
            return path;
        }
        return null;
    }

    // Método auxiliar recursivo para resolver el laberinto
    private boolean solveRecursiveHelper(int row, int col, boolean[][] visited, List<Position> path) {
        if (row == end.getRow() && col == end.getCol()) {
            path.add(new Position(row, col));
            return true;
        }

        if (!isWalkable(row, col) || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        path.add(new Position(row, col));

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Direcciones de movimiento
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (solveRecursiveHelper(newRow, newCol, visited, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1); // Deshacer el movimiento
        return false;
    }

    // Método para resolver el laberinto usando caché
    public List<Position> solveWithCache() {
        int rows = getRows();
        int cols = getCols();
        boolean[][] visited = new boolean[rows][cols]; // Matriz de celdas visitadas
        Position[][] parent = new Position[rows][cols]; // Matriz de padres para reconstruir el camino
        boolean[][] cache = new boolean[rows][cols]; // Caché para almacenar resultados de subproblemas
        for (int i = 0; i < rows; i++) {
            Arrays.fill(cache[i], false);
        }

        if (solveWithCacheHelper(start.getRow(), start.getCol(), visited, parent, cache)) {
            return reconstructPath(parent, end);
        }
        return null;
    }

    // Método auxiliar para resolver el laberinto usando caché
    private boolean solveWithCacheHelper(int row, int col, boolean[][] visited, Position[][] parent, boolean[][] cache) {
        if (row == end.getRow() && col == end.getCol()) {
            return true;
        }

        if (!isWalkable(row, col) || visited[row][col]) {
            return false;
        }

        if (cache[row][col]) {
            return false;
        }

        visited[row][col] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (solveWithCacheHelper(newRow, newCol, visited, parent, cache)) {
                parent[newRow][newCol] = new Position(row, col);
                return true;
            }
        }

        cache[row][col] = true;
        return false;
    }

    // Método para resolver el laberinto usando BFS
    public List<Position> solveBFS() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[getRows()][getCols()];
        Position[][] parent = new Position[getRows()][getCols()];

        queue.offer(start);
        visited[start.getRow()][start.getCol()] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(parent, end);
            }

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newRow = current.getRow() + dir[0];
                int newCol = current.getCol() + dir[1];

                if (isWalkable(newRow, newCol) && !visited[newRow][newCol]) {
                    queue.offer(new Position(newRow, newCol));
                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = current;
                }
            }
        }

        return null;
    }

    // Método para resolver el laberinto usando DFS
    public List<Position> solveDFS() {
        boolean[][] visited = new boolean[getRows()][getCols()];
        Position[][] parent = new Position[getRows()][getCols()];

        if (solveDFSHelper(start.getRow(), start.getCol(), visited, parent)) {
            return reconstructPath(parent, end);
        }
        return null;
    }

    // Método auxiliar para resolver el laberinto usando DFS
    private boolean solveDFSHelper(int row, int col, boolean[][] visited, Position[][] parent) {
        if (row == end.getRow() && col == end.getCol()) {
            return true;
        }

        if (!isWalkable(row, col) || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (solveDFSHelper(newRow, newCol, visited, parent)) {
                parent[newRow][newCol] = new Position(row, col);
                return true;
            }
        }

        return false;
    }

    // Método para reconstruir el camino desde el final hasta el inicio
    private List<Position> reconstructPath(Position[][] parent, Position end) {
        List<Position> path = new ArrayList<>();
        Position step = end;
        while (step != null) {
            path.add(step);
            step = parent[step.getRow()][step.getCol()];
        }
        Collections.reverse(path); // Invertir el camino para que vaya desde el inicio hasta el final
        return path;
    }
}
