package hu.nye.progtech.sudoku.service.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.foxandhounds.service.util.CollectionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CollectionUtilTest {

    private CollectionUtil underTest;

    @BeforeEach
    public void setUp(){
        underTest = new CollectionUtil();
    }

    @Test
    public void testCollectNonZeroValuesShouldReturnCorrectListWhenCalled(){
        // given
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        List<Integer> result = new ArrayList<>();

        for (int value : integerList){
            if (value != 0){
                result.add(value);
            }
        }

        // when
        result = underTest.collectNonZeroValues(integerList);

        // then
        List<Integer> expected = List.of(1,2);
        assertEquals(expected,result);
    }

}
