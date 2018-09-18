package com.app.game.tictactoerunner.config;

import java.io.IOException;

public interface ConfigReader {
    GameConfiguration readGameConfig() throws IOException;
}
