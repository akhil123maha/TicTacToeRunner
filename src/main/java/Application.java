import com.app.game.tictactoerunner.components.TicTacToeBoard;
import com.app.game.tictactoerunner.config.FileConfigReader;
import com.app.game.tictactoerunner.config.GameConfiguration;
import com.app.game.tictactoerunner.player.ComputerPlayer;
import com.app.game.tictactoerunner.player.HumanPlayer;
import com.app.game.tictactoerunner.player.Player;
import com.app.game.tictactoerunner.player.Players;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.playGame();
    }

    private void playGame() throws IOException, NullPointerException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader
                .getResource("config.properties")
                .getFile());

        FileConfigReader fileConfigReader = new FileConfigReader(file);
        GameConfiguration gameConfiguration = fileConfigReader.readGameConfig();

        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(gameConfiguration.getSize());


        Player player1 = new HumanPlayer(gameConfiguration.getSymbolOne(), "Player 1");
        Player player2 = new HumanPlayer(gameConfiguration.getSymbolTwo(), "Player 2");
        Player jarvis = new ComputerPlayer(gameConfiguration.getComputerSymbol(), "Jarvis", ticTacToeBoard);

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(jarvis);

        Players players = new Players(playerList);
        TicTacToeRunner ticTacToeRunner = new TicTacToeRunner(ticTacToeBoard, players);
        ticTacToeRunner.start();
    }
}
