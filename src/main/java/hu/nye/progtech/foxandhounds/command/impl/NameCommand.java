package hu.nye.progtech.foxandhounds.command.impl;

import java.io.InputStream;
import java.util.Scanner;

import hu.nye.progtech.foxandhounds.command.Command;
import hu.nye.progtech.foxandhounds.model.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to set username.
 */
public class NameCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameCommand.class);

    private static String NAME_COMMAND = "name";

    private GameState gameState;

    Scanner scanner = new Scanner(System.in);

    public NameCommand(GameState gameState) {
        this.gameState = gameState;
    }


    @Override
    public boolean canProcess(String input) {
        return NAME_COMMAND.contentEquals(input);
    }

    @Override
    public String process(String input) {
        LOGGER.info("Getting username");
        System.out.print("username: ");
        input = scanner.nextLine();
        System.out.println("Welcome to the fox and hounds game: " + input);
        return input;
    }
}
