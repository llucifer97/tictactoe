package model;

import enums.PieceType;

import java.util.List;
import java.util.Map;

public class Game {

    private List<Player> playerList;
    private Board board;
    private Map<Player , PieceType> playerPieceTypeMap;
    private Player winner;
    private boolean isGameCompleted;


    public Game(List<Player> playerList, Board board, Map<Player, PieceType> playerPieceTypeMap) {
        this.playerList = playerList;
        this.board = board;
        this.playerPieceTypeMap = playerPieceTypeMap;
    }


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Map<Player, PieceType> getPlayerPieceTypeMap() {
        return playerPieceTypeMap;
    }

    public void setPlayerPieceTypeMap(Map<Player, PieceType> playerPieceTypeMap) {
        this.playerPieceTypeMap = playerPieceTypeMap;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public boolean isGameCompleted() {
        return isGameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        isGameCompleted = gameCompleted;
    }
}
