package service;

import enums.PieceType;
import model.Cell;
import model.Game;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeService {

    private Game game;
    private Player currentPlayer;
    public TicTacToeService(Game game , Player player) {
        this.game = game;
        this.currentPlayer = player;
    }


    public void startGame() {

        Scanner scanner = new Scanner(System.in);
        while(!game.isGameCompleted()) {

            Player currentPlayer = getCurrentPlayer();
            while(scanner.hasNext()) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                int cnt = 0;
                for(int i = 0; i < 3; i++) {
                    int j = 0;
                    for( j = 0; j < 3;j++) {
                        if(game.getBoard().getMatrix().get(i).get(j).getPieceType() == PieceType.NA) cnt++;
                    }
                }

                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3;j++) {
                        game.getBoard().getMatrix().get(i).forEach(System.out::println);
                    }
                }

                if(cnt == 0) {
                    System.out.println("Game Over!");
                    return;
                }



                ArrayList<ArrayList<Cell>> matrix = game.getBoard().getMatrix();
                if ( !matrix.get(row).get(col).getPieceType().equals(PieceType.O)) {
                    System.out.println("Invalid Move");

                }
                else {
                    matrix.get(row).get(col).setPieceType(game.getPlayerPieceTypeMap().get(currentPlayer));
                }

                if(checkIfPlayerWon(currentPlayer)) {
                    System.out.println(currentPlayer.getName() + " won the game!");
                    return;
                }
            }


        }

    }


    private Player getCurrentPlayer() {
        int id = currentPlayer.getId();
        return game.getPlayerList().get((id + 1)%game.getPlayerList().size());
    }


    private boolean checkIfPlayerWon(Player currentPlayer) {
        PieceType pieceType = game.getPlayerPieceTypeMap().get(currentPlayer);
        boolean ans = false;
        // check current row
        for(int i = 0; i < 3; i++) {
            int j = 0;
            for( j = 0; j < 3;j++) {
                if(game.getBoard().getMatrix().get(i).get(j).getPieceType() != pieceType) break;
            }
            if(j == 2) ans = true;

        }

        for(int i = 0; i < 3; i++) {
            int j = 0;
            for( j = 0; j < 3;j++) {
                if(game.getBoard().getMatrix().get(j).get(i).getPieceType() != pieceType) break;
            }
            if(j == 2) ans = true;

        }

        int i = 0, j = 0;
        while(i < 3 && j < 3) {
            if(game.getBoard().getMatrix().get(j).get(i).getPieceType() != pieceType) break;
            i++;
            j++;
        }

        if(i == 2) {
            ans = true;
        }

         i = 0;
         j = 2;
        while(i < 3 && j < 3) {
            if(game.getBoard().getMatrix().get(j).get(i).getPieceType() != pieceType) break;
            i++;
            j--;
        }

        if(i == 2) ans = true;


        if(ans) {
            game.setGameCompleted(true);
            game.setWinner(currentPlayer);
        }

        return ans;

    }




}
