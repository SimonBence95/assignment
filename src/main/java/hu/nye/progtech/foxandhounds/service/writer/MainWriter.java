package hu.nye.progtech.foxandhounds.service.writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import hu.nye.progtech.foxandhounds.Main;
import hu.nye.progtech.foxandhounds.command.Command;
import hu.nye.progtech.foxandhounds.command.InputHandler;
import hu.nye.progtech.foxandhounds.command.impl.ExitCommand;
import hu.nye.progtech.foxandhounds.command.impl.PrintCommand;
import hu.nye.progtech.foxandhounds.command.impl.PutCommand;
import hu.nye.progtech.foxandhounds.model.GameState;
import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.game.GameController;
import hu.nye.progtech.foxandhounds.service.game.GameStepPerformer;
import hu.nye.progtech.foxandhounds.service.input.UserInputReader;
import hu.nye.progtech.foxandhounds.service.map.MapReaderFacade;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import hu.nye.progtech.foxandhounds.service.map.reader.MapReader;
import hu.nye.progtech.foxandhounds.service.map.reader.impl.BufferedReaderMapReader;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;
import hu.nye.progtech.foxandhounds.service.map.validation.impl.MapByRowValidator;
import hu.nye.progtech.foxandhounds.service.performer.PutPerformer;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;
import hu.nye.progtech.foxandhounds.ui.MapPrinter;
import hu.nye.progtech.foxandhounds.ui.PrintWrapper;

/**
 * {@summary <p>This is for my @Main.class. <p/>}
 */

public class MainWriter {

    /**
     * Method to set the proper args in Main.
     */
    public void SetArgs() throws IOException {

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginnerMap.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new BufferedReaderMapReader(reader);

        MapParser mapParser = new MapParser(8, 8);

        MapUtil maputil = new MapUtil();

        MapValidator mapValidator = new MapByRowValidator(maputil);

        MapReaderFacade mapReaderFacade = new MapReaderFacade(mapReader, mapParser, mapValidator);
        MapVO mapVO = mapReaderFacade.readMap();

        GameState gameState = new GameState(mapVO,false);

        BufferedReader standardInputReader = new BufferedReader(new InputStreamReader(System.in));

        UserInputReader userInputReader = new UserInputReader(standardInputReader);

        PrintWrapper printWrapper = new PrintWrapper();
        MapPrinter mapPrinter = new MapPrinter(1,1,maputil,printWrapper);

        PutPerformer putPerformer = new PutPerformer();

        List<Command> commandList = Arrays.asList(
                new NameWriter(gameState),
                new PrintCommand(mapPrinter,gameState),
                new PutCommand(gameState,putPerformer,mapValidator),
                new ExitCommand(gameState)
        );

        InputHandler inputHandler = new InputHandler(commandList);

        GameStepPerformer gameStepPerformer = new GameStepPerformer(userInputReader, inputHandler);

        GameController gameController = new GameController(gameState,maputil,gameStepPerformer);
        gameController.gameLoop();


    }

}
