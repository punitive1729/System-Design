public class Player {
    private String playerId;
    private long totalGamesWon;
    private long totalGamesPlayed;

    public String getPlayerId() {
        return playerId;
    }

    public Player(String playerId){
        this.playerId=playerId;
    }
}
