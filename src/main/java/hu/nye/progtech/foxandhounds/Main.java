package hu.nye.progtech.foxandhounds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import hu.nye.progtech.foxandhounds.service.map.reader.MapReader;
import hu.nye.progtech.foxandhounds.service.map.reader.impl.BufferedReaderMapReader;

public class Main {

    public static void main(String[] args) throws IOException {

        //TODO NE FELEJTDS EL VISSZAKAPCSOLNI
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("username: ");
        String name = scanner.nextLine();
        System.out.println("Welcome: "+name);*/

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginnerMap.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new BufferedReaderMapReader(reader);
        List<String> rawMap = mapReader.read();

        MapParser mapParser = new MapParser(4,4);
        MapVO mapVO = mapParser.parse(rawMap);

        System.out.println(mapVO);


    }

}
