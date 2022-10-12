package hu.nye.progtech.foxandhounds.command.impl;

import hu.nye.progtech.foxandhounds.command.Command;
import hu.nye.progtech.foxandhounds.model.GameState;
import hu.nye.progtech.foxandhounds.ui.MapPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to request the printing of the current state
 * of the game map.
 */
public class PrintCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintCommand.class);

    private static final String PRINT_COMMAND = "print";

    public PrintCommand(MapPrinter mapPrinter, GameState gameState) {
        this.mapPrinter = mapPrinter;
        this.gameState = gameState;
    }

    private MapPrinter mapPrinter;
    private GameState gameState;

    @Override
    public boolean canProcess(String input) {
        return PRINT_COMMAND.equals(input);
    }

    @Override
    public String process(String input) {
        mapPrinter.printMap(gameState.mapVO);
        return input;
    }
}
