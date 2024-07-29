package model;

// Clase que representa una celda en el laberinto
public class Cell {
    private boolean isWalkable; // Indica si la celda es transitable

    // Constructor que inicializa la celda con su estado de transitabilidad
    public Cell(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }

    // Método para obtener si la celda es transitable
    public boolean isWalkable() {
        return isWalkable;
    }

    // Método para establecer si la celda es transitable
    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }
}
