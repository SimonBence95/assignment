package hu.nye.progtech.foxandhounds.service.map.writer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import hu.nye.progtech.foxandhounds.Main;
import hu.nye.progtech.foxandhounds.command.impl.DefaultCommand;
import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import hu.nye.progtech.foxandhounds.service.map.reader.MapReader;
import hu.nye.progtech.foxandhounds.service.map.reader.impl.BufferedReaderMapReader;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;

/**
 * Class that helps Main class write correct values.
 */
public class MainWriter {

    /**
     * Set the proper args in Main.
     */
    public void SetArgs() {

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginnerMap.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new BufferedReaderMapReader(reader);
        List<String> rawMap = mapReader.read();

        MapParser mapParser = new MapParser(8,8);
        MapVO mapVO = mapParser.parse(rawMap);

        MapUtil mapUtil = new MapUtil();
        PrintWrapper printWrapper = new PrintWrapper();

        DefaultCommand defaultCommand = new DefaultCommand(printWrapper);

        MapPrinter mapPrinter = new MapPrinter(mapVO.getNumberOfRows(),mapVO.getNumberOfColumns(), mapUtil,printWrapper);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select option: Display game-field[dgf],Select username [alias], Start Game [start] ");
        System.out.print("Chosen option: ");
        String valasztas = scanner.nextLine();

        switch (valasztas) {
            case "alias":
                System.out.print("username: ");
                String name = scanner.nextLine();
                System.out.println("Welcome to the fox and hounds game: " + name);
                break;
            case "dgf":
                mapPrinter.printMap(mapVO);
                break;
            case "start":
                mapPrinter.printMap(mapVO);
                break;
            default:
                defaultCommand.process("");
        }



    }

}
