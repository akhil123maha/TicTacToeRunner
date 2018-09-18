import com.app.game.tictactoerunner.components.GameState;
import com.app.game.tictactoerunner.components.TicTacToeBoard;
import com.app.game.tictactoerunner.player.ComputerPlayer;
import com.app.game.tictactoerunner.player.HumanPlayer;
import com.app.game.tictactoerunner.player.Players;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by AKHIL-JARVIS on 15-09-2018.
 */
public class TicTacToeRunnerTest {

    private TicTacToeBoard board;
    private Players players;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private TicTacToeRunner ticTacToeGame;

    @Before
    public void setUp() throws Exception {
        board = mock(TicTacToeBoard.class);
        players = mock(Players.class);
        humanPlayer = mock(HumanPlayer.class);
        computerPlayer = mock(ComputerPlayer.class);
        when(players.nextPlayer()).thenReturn(humanPlayer, computerPlayer);
        ticTacToeGame = new TicTacToeRunner(board, players);
    }

    @Test
    public void shouldContinuePlayingGameWhenBoardMoveResultIsContinue() throws Exception {
        when(board.playerMove(humanPlayer)).thenReturn(GameState.PLAYING);
        when(board.playerMove(computerPlayer)).thenReturn(GameState.DRAW);
        ticTacToeGame.start();
        verify(board).playerMove(humanPlayer);
        verify(board).playerMove(computerPlayer);
    }

    @Test
    public void shouldNotContinuePlayingGameWhenBoardMoveResultIsWithdraw() throws Exception {
        when(board.playerMove(humanPlayer)).thenReturn(GameState.DRAW);
        when(board.playerMove(computerPlayer)).thenReturn(GameState.DRAW);
        ticTacToeGame.start();
        verify(board).playerMove(humanPlayer);
        verify(board, never()).playerMove(computerPlayer);
    }

    @Test
    public void shouldNotContinuePlayingGameWhenBoardMoveResultIsWon() throws Exception {
        when(board.playerMove(humanPlayer)).thenReturn(GameState.WON);
        when(board.playerMove(computerPlayer)).thenReturn(GameState.DRAW);
        ticTacToeGame.start();
        verify(board, never()).playerMove(computerPlayer);
    }

    @Test
    public void shouldContinuePlayingGameWithSamePlayerWhenBoardMoveEnterWasWrong() throws Exception {
        when(board.playerMove(humanPlayer)).thenReturn(GameState.RETRY, GameState.PLAYING);
        when(board.playerMove(computerPlayer)).thenReturn(GameState.DRAW);

        ticTacToeGame.start();
        verify(board, times(2)).playerMove(humanPlayer);
        verify(board).playerMove(computerPlayer);
    }

}
