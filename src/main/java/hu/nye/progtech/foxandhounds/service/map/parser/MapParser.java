package hu.nye.progtech.foxandhounds.service.map.parser;

import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.MapParseException;

/**
 * Parses a raw representation of a map into a {@link MapVO} object.
 */
public class MapParser {

    private final int numberOfRows;
    private final int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * Parses a map from a raw representation.
     *
     * @param rawMap the raw representation of a map
     * @return a parsed map as a {@link MapVO} object
     */
    public MapVO parse(List<String> rawMap) {
        checkNumberOfRows(rawMap);
        checkNumberOfColumns(rawMap);


        int[][] values = getValues(rawMap);
        boolean[][] fixed = getFixed(values);

        return new MapVO(numberOfRows, numberOfColumns, values, fixed);
    }

    private int[][] getValues(List<String> rawMap) {
        int[][] result = new int[numberOfRows][];

        for (int i = 0; i < numberOfRows; i++) {
            result[i] = new int[numberOfColumns];

            String row = rawMap.get(i);
            String[] numbersAsString = row.split("");

            for (int j = 0; j < numberOfColumns; j++) {
                int n = Integer.parseInt(numbersAsString[j]);
                result[i][j] = n;
            }
        }

        return result;
    }

    private boolean[][] getFixed(int[][] map) {
        boolean[][] fixed = new boolean[numberOfRows][numberOfColumns];

        for (int x = 0; x < numberOfRows; x++) {
            for (int y = 0; y < numberOfColumns; y++) {
                fixed[x][y] = map[x][y] != 0;
            }
        }

        return fixed;
    }

    private void checkNumberOfRows(List<String> rawMap) {
        if (rawMap.size() != numberOfRows) {
            throw new MapParseException("Number of rows are incorrect, it was " + rawMap.size());
        }
    }

    private void checkNumberOfColumns(List<String> rows) throws MapParseException {
        for (String row : rows) {
            if (row.length() != numberOfColumns) {
                throw new MapParseException("Number of columns must be " + numberOfColumns);
            }
        }
    }



}
