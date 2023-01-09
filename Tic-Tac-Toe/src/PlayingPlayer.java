public class PlayingPlayer {
    private Player player;
    private char symbol;
    public String getPlayerId(){
        return player.getPlayerId();
    }

    public char getSymbol(){
        return symbol;
    }

    public PlayingPlayer(Player player,char symbol){
        this.player=player;
        this.symbol=symbol;
    }
}
