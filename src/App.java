import controller.MazeController;
import model.Maze;
import model.Position;
import view.MazeView;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        // Crear el modelo del laberinto con el tamaño deseado
        int rows = 10;
        int cols = 10;
        Maze maze = new Maze(rows, cols);

        // Configurar algunas celdas como no transitables (ejemplo)
        maze.setCell(0, 1, false);
        maze.setCell(1, 1, false);
        maze.setCell(2, 1, false);
        maze.setCell(3, 1, false);
        maze.setCell(3, 2, false);
        maze.setCell(3, 3, false);

        // Establecer las posiciones de inicio y fin del laberinto
        maze.setStart(new Position(0, 0));
        maze.setEnd(new Position(9, 9));

        // Crear la vista del laberinto
        MazeView mazeView = new MazeView(rows, cols);
        mazeView.setWalkable(getWalkableGrid(maze));

        // Crear el controlador del laberinto
        MazeController mazeController = new MazeController(maze);
        mazeController.setView(mazeView);

        // Crear la interfaz gráfica
        JFrame frame = new JFrame("Maze Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Añadir la vista del laberinto al marco
        frame.add(mazeView, BorderLayout.CENTER);

        // Crear panel de botones para seleccionar el método de resolución
        JPanel buttonPanel = new JPanel();
        JButton recursiveButton = new JButton("Solve Recursively");
        JButton cacheButton = new JButton("Solve with Cache");
        JButton bfsButton = new JButton("Solve with BFS");
        JButton dfsButton = new JButton("Solve with DFS");

        // Añadir acciones a los botones
        recursiveButton.addActionListener(e -> mazeController.solveRecursive());
        cacheButton.addActionListener(e -> mazeController.solveWithCache());
        bfsButton.addActionListener(e -> mazeController.solveBFS());
        dfsButton.addActionListener(e -> mazeController.solveDFS());

        // Añadir los botones al panel
        buttonPanel.add(recursiveButton);
        buttonPanel.add(cacheButton);
        buttonPanel.add(bfsButton);
        buttonPanel.add(dfsButton);

        // Añadir el panel de botones al marco
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Ajustar el tamaño del marco y hacerlo visible
        frame.pack();
        frame.setVisible(true);
    }

    // Método auxiliar para convertir el laberinto en una matriz de celdas transitables
    private static boolean[][] getWalkableGrid(Maze maze) {
        int rows = maze.getRows();
        int cols = maze.getCols();
        boolean[][] walkable = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                walkable[row][col] = maze.isWalkable(row, col);
            }
        }
        return walkable;
    }
}
