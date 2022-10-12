package hu.nye.progtech.foxandhounds.command.impl;

import java.util.regex.Pattern;

import hu.nye.progtech.foxandhounds.command.Command;
import hu.nye.progtech.foxandhounds.model.GameState;
import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.MapValidationException;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;
import hu.nye.progtech.foxandhounds.service.performer.PutPerformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to write a number to a given field of the map.
 */
public class PutCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutCommand.class);

    private static final String PUT_COMMAND_REGEX = "^put [0-7] [0-7] [1-2]$";

    private final GameState gameState;
    private final PutPerformer putPerformer;
    private final MapValidator mapValidator;

    public PutCommand(GameState gameState, PutPerformer putPerformer, MapValidator mapValidator) {
        this.gameState = gameState;
        this.putPerformer = putPerformer;
        this.mapValidator = mapValidator;
    }

    @Override
    public boolean canProcess(String input) {
        return Pattern.matches(PUT_COMMAND_REGEX,input);
    }

    @Override
    public String process(String input) {
        String[] parts = input.split(" ");
        int rowIndex = Integer.parseInt(parts[1]);
        int columnIndex = Integer.parseInt(parts[2]);
        int number = Integer.parseInt(parts[3]);

        LOGGER.info("Performing command with parameters: rowIndex{} columnIndex{} number{}",rowIndex,columnIndex,number);

        MapVO originalMapVO = gameState.getMapVO();
        MapVO newMapVO = putPerformer.performPut(originalMapVO, rowIndex, columnIndex, number);

        try {
            mapValidator.validate(newMapVO);
            gameState.setMapVO(newMapVO);

            LOGGER.info("Successfully updated game state");
        } catch (MapValidationException e) {
            System.out.println("Invalid game state");
        }

        return input;
    }

}
