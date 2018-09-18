package com.app.game.tictactoerunner.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileConfigReader implements ConfigReader {
    private static final String SIZE = "size";
    private static final String playerOne = "player_symbol_one";
    private static final String playerTwo = "player_symbol_two";
    private static final String computer = "computer_symbol";
    private File configFile;

    public FileConfigReader(File configFile) {
        this.configFile = configFile;
    }

    public GameConfiguration readGameConfig() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(configFile);
        prop.load(fileInputStream);
        int size = Integer.parseInt(prop.getProperty(SIZE));
        String symbol_one = prop.getProperty(playerOne);
        String symbol_two = prop.getProperty(playerTwo);
        String computer_symbol = prop.getProperty(computer);
        return new GameConfiguration(size, symbol_one, symbol_two, computer_symbol);
    }
}
