package controller;

import model.Maze;
import model.Position;
import view.MazeView;

import java.util.List;

// Clase que representa el controlador del laberinto
public class MazeController {
    private Maze maze; // Modelo del laberinto
    private MazeView view; // Vista del laberinto

    // Constructor que inicializa el controlador con el modelo del laberinto
    public MazeController(Maze maze) {
        this.maze = maze;
    }

    // Método para establecer la vista del laberinto
    public void setView(MazeView view) {
        this.view = view;
    }

    // Método para resolver el laberinto recursivamente y mostrar la solución
    public List<Position> solveRecursive() {
        List<Position> solution = maze.solveRecursive();
        if (view != null && solution != null) {
            view.showSolution(solution); // Mostrar la solución en la vista
        }
        return solution;
    }

    // Método para resolver el laberinto usando caché y mostrar la solución
    public List<Position> solveWithCache() {
        List<Position> solution = maze.solveWithCache();
        if (view != null && solution != null) {
            view.showSolution(solution); // Mostrar la solución en la vista
        }
        return solution;
    }

    // Método para resolver el laberinto usando BFS y mostrar la solución
    public List<Position> solveBFS() {
        List<Position> solution = maze.solveBFS();
        if (view != null && solution != null) {
            view.showSolution(solution); // Mostrar la solución en la vista
        }
        return solution;
    }

    // Método para resolver el laberinto usando DFS y mostrar la solución
    public List<Position> solveDFS() {
        List<Position> solution = maze.solveDFS();
        if (view != null && solution != null) {
            view.showSolution(solution); // Mostrar la solución en la vista
        }
        return solution;
    }
}
