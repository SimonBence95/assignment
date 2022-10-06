package hu.nye.progtech.foxandhounds.service.util;

import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;

public class MapUtil {

    public List<Integer> getRowOfMap(MapVO mapVO, int rowIndex) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVO.getValues();
        for (int i = 0; i < mapVO.getNumberOfColumns(); i++) {
            result.add(map[rowIndex][i]);
        }

        return result;
    }

}
