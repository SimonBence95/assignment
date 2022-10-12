package hu.nye.progtech.foxandhounds.command.impl;

import hu.nye.progtech.foxandhounds.command.Command;
import hu.nye.progtech.foxandhounds.model.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to exit from the game.
 */
public class ExitCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExitCommand.class);

    private static String EXIT_COMMAND = "exit";

    private GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean canProcess(String input) {
        return EXIT_COMMAND.equals(input);
    }

    @Override
    public String process(String input) {
        LOGGER.info("Setting exit flag to true");
        gameState.setUserWantsToExit(true);
        return input;
    }

}
