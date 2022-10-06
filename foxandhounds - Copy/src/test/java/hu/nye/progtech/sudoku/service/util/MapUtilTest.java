package hu.nye.progtech.sudoku.service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapUtilTest {

    private MapUtil uderTest;

    @BeforeEach
    public void setUp(){
        uderTest = new MapUtil();
    }

    @Test
    public void testGetRowOfMapShouldReturnCorrectListWhenCalled(){
        // given
        int[][] values = {
                {0,1},
                {2,3}
        };
        boolean[][] fixed = {
                {false,true},
                {true,true}
        };
        MapVO mapVO = new MapVO(2,2,values,fixed);//null

        // when
        List<Integer> result = uderTest.getRowOfMap(mapVO, 0);

        // then
        List<Integer> expected = List.of(0,1);
        assertEquals(expected,result);
    }

}
