import enums.CellStatus;
import enums.PieceType;
import model.Board;
import model.Cell;
import model.Game;
import model.Player;
import service.TicTacToeService;

import java.util.*;

public class Main {


   public static void main(String[] args) {

      // input data

      Scanner scanner = new Scanner(System.in);
      List<Player> playerList = new ArrayList<>();
      Map<Player, PieceType> playerPieceTypeMap = new HashMap<>();
      Player firstPlayer = null;

      for(int i = 0; i < 2; i++) {
         String pieceType =  scanner.next();
         String name = scanner.next();
         Player player = new Player(name,i, PieceType.valueOf(pieceType));
         playerList.add(player);
         if(PieceType.valueOf(pieceType).compareTo(PieceType.O) == 0) {
            firstPlayer = player;
         }
         playerPieceTypeMap.put(player,PieceType.valueOf(pieceType));
      }


      ArrayList<ArrayList<Cell>> matrix = new ArrayList<>();

      for(int i= 0; i < 3; i++) {
         ArrayList<Cell> cells = new ArrayList<>();
         for(int j = 0; j < 3;j++) {
            Cell cell = new Cell();
            cell.setPieceType(PieceType.NA);
            cell.setCol(j);
            cell.setRow(i);
            cell.setStatus(CellStatus.EMPTY);
            cells.add(cell);
         }
         matrix.add(cells);
      }

      Board board = new Board(matrix);

      Game game = new Game(playerList,board,playerPieceTypeMap);
      TicTacToeService ticTacToeService = new TicTacToeService(game, firstPlayer);
      ticTacToeService.startGame();


   }
}
