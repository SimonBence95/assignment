package hu.nye.progtech.foxandhounds.service.game;

import hu.nye.progtech.foxandhounds.command.InputHandler;
import hu.nye.progtech.foxandhounds.service.input.UserInputReader;

/**
 * Component that performs a game step.
 */
public class GameStepPerformer {

    private UserInputReader userInputReader;
    private InputHandler inputHandler;

    public GameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        this.userInputReader = userInputReader;
        this.inputHandler = inputHandler;
    }

    /**
     * Performs a game step.
     *
     * A game step consists of taking the input from the user, then handling
     * the input.
     */
    public void performGameStep() {

        String input = userInputReader.readInput();
        inputHandler.handleInput(input);

    }

}
