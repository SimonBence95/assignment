package hu.nye.progtech.foxandhounds.service.map.validation.impl;

import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.MapValidationException;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;
import hu.nye.progtech.foxandhounds.service.util.CollectionUtil;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;

public class MapByRowValidator implements MapValidator {

    private final MapUtil mapUtil;
    private final CollectionUtil collectionUtil;

    public MapByRowValidator(MapUtil mapUtil, CollectionUtil collectionUtil) {
        this.mapUtil = mapUtil;
        this.collectionUtil = collectionUtil;
    }

    @Override
    public void validate(MapVO mapVO) {
        int numberOfRows = mapVO.getNumberOfColumns();


        for (int i = 0; i < numberOfRows; i++) {
            List<Integer> rowOfMap = mapUtil.getRowOfMap(mapVO, i);
            List<Integer> nonZeroValues = collectionUtil.collectNonZeroValues(rowOfMap);

            if(!collectionUtil.containsOnlyDistinctValues(nonZeroValues)){
                throw new MapValidationException("invalid row");
            }
        }
    }
}
