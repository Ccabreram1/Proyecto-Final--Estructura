package view;

import model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// Clase que representa la vista del laberinto
public class MazeView extends JPanel {
    private static final int CELL_SIZE = 20; // Tamaño de cada celda
    private final int rows; // Número de filas del laberinto
    private final int cols; // Número de columnas del laberinto
    private boolean[][] walkable; // Matriz de celdas transitables
    private List<Position> solution; // Solución del laberinto

    // Constructor que inicializa la vista con el número de filas y columnas
    public MazeView(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.walkable = new boolean[rows][cols];
        this.setPreferredSize(new Dimension(cols * CELL_SIZE, rows * CELL_SIZE));
    }

    // Método para actualizar la matriz de celdas transitables
    public void setWalkable(boolean[][] walkable) {
        this.walkable = walkable;
        repaint(); // Re-pintar la vista
    }

    // Método para mostrar la solución en la vista
    public void showSolution(List<Position> solution) {
        this.solution = solution;
        repaint(); // Re-pintar la vista
    }

    // Método para pintar el laberinto y la solución
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (walkable[row][col]) {
                    g.setColor(Color.WHITE); // Celdas transitables son blancas
                } else {
                    g.setColor(Color.BLACK); // Celdas no transitables son negras
                }
                g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY); // Líneas de la cuadrícula en gris
                g.drawRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        if (solution != null) {
            g.setColor(Color.RED); // Solución en rojo
            for (Position pos : solution) {
                g.fillOval(pos.getCol() * CELL_SIZE + CELL_SIZE / 4, pos.getRow() * CELL_SIZE + CELL_SIZE / 4, CELL_SIZE / 2, CELL_SIZE / 2);
            }
        }
    }
}
