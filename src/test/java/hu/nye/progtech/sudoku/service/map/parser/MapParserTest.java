package hu.nye.progtech.sudoku.service.map.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapParserTest {

   private MapParser underTest;

   @BeforeEach
    public void setUp(){
       underTest = new MapParser(1,1);
   }

   @Test
    public void testParse(){
       // given
       List<String> rawMap = new ArrayList<>();
       rawMap.add("1");

       // when
       MapVO result = underTest.parse(rawMap);

       // then
       MapVO expected = underTest.parse(rawMap);
       assertEquals(expected,result);
   }

}
