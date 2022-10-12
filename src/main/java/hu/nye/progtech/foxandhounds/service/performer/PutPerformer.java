package hu.nye.progtech.foxandhounds.service.performer;

import java.io.IOException;

import hu.nye.progtech.foxandhounds.model.MapVO;

/**
 * Helper class used to write a number to a given position of a map.
 */
public class PutPerformer {

    /**
     * Writes a number to a given position into the provided map.
     * <p>
     * A write can only be performed, if there is no fixed number at
     * the requested position.
     *
     * @param originalMapVO the map to update
     * @param rowIndex      the index of the row
     * @param columnIndex   the index of the column
     * @param value         the number to write into the map
     */
    public MapVO performPut(MapVO originalMapVO, int rowIndex, int columnIndex, int value) throws RuntimeException {

            int numberOfRows = originalMapVO.getNumberOfRows();
            int numberOfColumns = originalMapVO.getNumberOfColumns();
            int[][] values = originalMapVO.getValues();
            boolean[][] fixed = originalMapVO.getFixed();

            values[rowIndex][columnIndex] = value;

            return new MapVO(numberOfRows, numberOfColumns, values, fixed);

            
        }

    }
