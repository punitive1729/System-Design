import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<PlayingPlayer> playingPlayers;
    Game(int size, List<PlayingPlayer> playingPlayers){
        board=new Board(size);
        this.playingPlayers=playingPlayers;
    }
    void play(){
        board.printBoard();
        // 0 1 2 3 ... n-1 0
        int i=0,totalPlayers=playingPlayers.size();
        while(board.getTotalUnoccupiedPlaces()>0){
            PlayingPlayer currentPlayer=playingPlayers.get(i);
            System.out.println("Current Player"+
                    currentPlayer.getPlayerId());

            System.out.println("Input cell number where you want to move..");

            Scanner inputScanner=new Scanner(System.in);
            String[] values=inputScanner.nextLine().split(",");

            int row=Integer.valueOf(values[0].strip());
            int column=Integer.valueOf(values[1].strip());

            if(!board.addSymbolToBoard(currentPlayer.getSymbol(),row,column)){
                System.out.println("Invalid cell selected. Please select new cell..");
                continue;
            }

            if(hasCurrentPlayerWon(currentPlayer.getSymbol())){
                System.out.println("Winner is "+currentPlayer);
                return;
            }

            board.printBoard();
            i=(i+1)%totalPlayers;
        }

        System.out.println("The game has tied...");
    }
    private Boolean hasCurrentPlayerWon(char currentPlayerSymbol){
        int countMainDiagonal=0, countCrossDiagonal=0;

        for(int i=0;i<board.getSize();i++){
            // check if ith row is filled with current Player's symbol
            int cnt=0;
            for(int j=0;j<board.getSize();j++){
                if(board.board[i][j]==currentPlayerSymbol) {
                    cnt++;
                    if(i==j)
                        countMainDiagonal+=1;
                    if((i+j)==(board.getSize()-1))
                        countCrossDiagonal+=1;
                }
            }

            if(cnt==board.getSize()){
                return true;
            }

            // Check if ith column is filled with current Player's symbol
            cnt=0;
            for(int j=0;j<board.getSize();j++){
                if(board.board[j][i]==currentPlayerSymbol)
                    cnt++;
                else
                    break;
            }

            if(cnt==board.getSize())
                return true;
        }
        if(countMainDiagonal==board.getSize() || countCrossDiagonal==board.getSize())
            return true;

        return false;
    }

}
