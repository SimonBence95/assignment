package hu.nye.progtech.foxandhounds.service.map.validation.impl;

import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.InvalidRowException;
import hu.nye.progtech.foxandhounds.service.exception.MapValidationException;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;

/**
 * Validates the rows of a map.(Rows should match number of columns).
 */
public class MapByRowValidator implements MapValidator {

    private final MapUtil mapUtil;

    public MapByRowValidator(MapUtil mapUtil) {
        this.mapUtil = mapUtil;
    }

    @Override
    public MapVO validate(MapVO mapVO) throws MapValidationException {
        for (int i = 0; i < mapVO.getNumberOfRows(); i++) {
            List<Integer> row = mapUtil.getRowOfMap(mapVO, i);
            validateRow(row);
        }
        return mapVO;
    }

    private void validateRow(List<Integer> row) throws InvalidRowException {
    }

}


