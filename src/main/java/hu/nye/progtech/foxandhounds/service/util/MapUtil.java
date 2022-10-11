package hu.nye.progtech.foxandhounds.service.util;

import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;

/**
 * Util class that helps to extract given parts of a {@link MapVO} object.
 */
public class MapUtil {

    /**
     * Returns all the numbers from a chosen row as a list.
     *
     * @param mapVO    the map
     * @param rowIndex the index of the chosen row
     * @return a list of integers
     */
    public List<Integer> getRowOfMap(MapVO mapVO, int rowIndex) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVO.getValues();
        for (int i = 0; i < mapVO.getNumberOfColumns(); i++) {
            result.add(map[rowIndex][i]);
        }

        return result;
    }

    /**
     * Returns all the numbers from a chosen column as a list.
     *
     * @param mapVO       the map
     * @param columnIndex the index of the column
     * @return a list of integers
     */
    public List<Integer> getColumnOfMap(MapVO mapVO, int columnIndex) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVO.getValues();
        for (int i = 0; i < mapVO.getNumberOfRows(); i++) {
            result.add(map[i][columnIndex]);
        }
        return result;
    }

    /**
     * Determines if the given map is completed or not.
     *
     * A map is considered as completed, if there are no more
     * zeros left in it.
     *
     * @param mapVO the map to check
     * @return {@code true} if the map is completed, {@code false} otherwise
     */
    public boolean isMapCompleted(MapVO mapVO) {
        boolean result = true;

        int[][] map = mapVO.getValues();
        for (int[] row : map) {
            for (int number : row) {
                if (number == 0) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }


}
