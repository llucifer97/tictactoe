package model;

import java.util.ArrayList;

public class Board {

    private ArrayList<ArrayList<Cell>> matrix;

    public Board(ArrayList<ArrayList<Cell>> matrix) {
        this.matrix = matrix;
    }

    public ArrayList<ArrayList<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Cell>> matrix) {
        this.matrix = matrix;
    }
}
