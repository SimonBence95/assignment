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

}
