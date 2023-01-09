public class Board {
    private int totalUnoccupiedPlaces;
    public char board[][];
    private int size;
    Board(int size){
        this.size=size;
        this.totalUnoccupiedPlaces=size*size;
        board=new char[size][size];
        initialize();
    }

    public int getSize(){
        return size;
    }

    private void initialize(){
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                board[i][j]=' ';
    }

    public int getTotalUnoccupiedPlaces(){
        return totalUnoccupiedPlaces;
    }

    public Boolean addSymbolToBoard(char symbol,int row,int column){
        if(row>=size || column>=size || board[row][column]!=' '){
            return false;
        }
        board[row][column]=symbol;
        totalUnoccupiedPlaces-=1;
        return true;
    }

    public void printBoard() {
        for(int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                System.out.print(board[i][j]);
                if((j+1)<size)
                    System.out.print(" |");
            }
            if((i+1)<size)
                System.out.println("\n--------");
        }
        System.out.println();
    }

}
