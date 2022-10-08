package hu.nye.progtech.sudoku.service.validation.impl;

import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.map.validation.impl.MapByRowValidator;
import hu.nye.progtech.foxandhounds.service.util.CollectionUtil;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapByRowValidatorTest {

    private MapByRowValidator underTest;

    MapUtil mapUtil = new MapUtil();

    CollectionUtil collectionUtil = new CollectionUtil();

    @BeforeEach
    public void setUp(){
        underTest = new MapByRowValidator(mapUtil,collectionUtil);
    }

    @Test
    public void testValidateShouldReturnCorrectListWhenCalled(){
        // given
        int[][] values = {
                {0,1},
                {2,3}
        };
        boolean[][] fixed = {
                {false,true},
                {true,true}
        };
        MapVO mapVO = new MapVO(2,2,values,fixed);
        // when
        underTest.validate(mapVO);

        // then

        //TODO mashogy kell foxandhounds eseten

    }



}
