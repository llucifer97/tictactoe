package model;

import enums.PieceType;

public class Player {

    private String name;
    private int id;
    private PieceType pieceType;

    public Player(String name, int id, PieceType pieceType) {
        this.name = name;
        this.id = id;
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
