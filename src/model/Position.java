package model;

// Clase que representa una posición en el laberinto
public class Position {
    private int row; // Fila de la posición
    private int col; // Columna de la posición

    // Constructor que inicializa la posición con fila y columna
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Métodos para obtener la fila y la columna de la posición
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // Método para comparar si dos posiciones son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }

    // Método para obtener el hash code de la posición
    @Override
    public int hashCode() {
        return 31 * row + col;
    }
}
