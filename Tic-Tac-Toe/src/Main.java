import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PlayingPlayer> playingPlayersList=new ArrayList<>();
        PlayingPlayer player1=new PlayingPlayer(new Player("1"),Symbols.CROSS);
        PlayingPlayer player2=new PlayingPlayer(new Player("2"),Symbols.ZERO);
        playingPlayersList.add(player1);
        playingPlayersList.add(player2);
        Game game=new Game(3,playingPlayersList);
        game.play();
    }
}