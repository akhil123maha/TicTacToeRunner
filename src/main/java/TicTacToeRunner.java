import com.app.game.tictactoerunner.components.GameState;
import com.app.game.tictactoerunner.components.TicTacToeBoard;
import com.app.game.tictactoerunner.config.FileConfigReader;
import com.app.game.tictactoerunner.config.GameConfiguration;
import com.app.game.tictactoerunner.player.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKHIL-JARVIS on 15-09-2018.
 */
public class TicTacToeRunner {

    //current TicTacToeBoard
    private TicTacToeBoard ticTacToeBoard;
    // the current state of the game (of enum GameState)
    private GameState currentState;
    // list of player
    private Players players;

    private Player currentPlayer;


    public TicTacToeRunner(TicTacToeBoard ticTacToeBoard, Players players) throws IOException {
        this.ticTacToeBoard = ticTacToeBoard;
        this.players = players;
        this.currentState = GameState.PLAYING;
    }

    public void start() throws IOException {
        currentState = GameState.PLAYING;
        do {
            currentPlayer = players.nextPlayer();
            currentState = ticTacToeBoard.playerMove(currentPlayer);
            ticTacToeBoard.paint();
            // Print message if game-over
            if (currentState == GameState.WON) {
                System.out.println("'"+currentPlayer.getSymbol()+"' won! Bye!");
            } else if (currentState == GameState.DRAW) {
                System.out.println("It's Draw! Bye!");
            } else if (currentState == GameState.RETRY)
                currentState = ticTacToeBoard.playerMove(currentPlayer);
            // Switch player
            currentPlayer = players.nextPlayer();
        } while (currentState == GameState.PLAYING);
    }

    public static void main(String[] args) throws IOException {
    }
}
