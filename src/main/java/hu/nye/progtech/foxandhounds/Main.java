package hu.nye.progtech.foxandhounds;

import java.io.IOException;

import hu.nye.progtech.foxandhounds.service.map.writer.MainWriter;

/**
 * Entry point of the FoxAndHounds game.
 */
public class Main {

    /**
     * Entrypoint of the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws IOException {

        MainWriter mainWriter = new MainWriter();
        mainWriter.SetArgs();

    }
}
