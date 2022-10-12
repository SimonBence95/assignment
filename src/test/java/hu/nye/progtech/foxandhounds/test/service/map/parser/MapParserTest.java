package hu.nye.progtech.foxandhounds.test.service.map.parser;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.InvalidColumnException;
import hu.nye.progtech.foxandhounds.service.exception.InvalidRowException;
import hu.nye.progtech.foxandhounds.service.exception.MapParseException;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link MapParser}.
 */
public class MapParserTest {

    private static final int NUMBER_OF_ROWS = 2;
    private static final int NUMBER_OF_COLUMNS = 2;

    private static final List<String> VALID_RAW_MAP = List.of(
            "01",
            "20"
    );
    private static final List<String> INVALID_RAW_MAP_FEW_ROWS = List.of(
            "01"
    );
    private static final List<String> INVALID_RAW_MAP_FEW_COLUMNS = List.of(
            "01",
            "2"
    );
    private static final List<String> INVALID_RAW_MAP_INVALID_CHARACTERS = List.of(
            "01",
            "ab"
    );

    private static final int[][] MAP = {
            {0, 1},
            {2, 0}
    };

    private static final boolean[][] FIXED = {
            {false, true},
            {true, false}
    };

    private static final MapVO EXPECTED_MAP_VO = new MapVO(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, MAP, FIXED);

    private MapParser underTest;

    @BeforeEach
    public void setUp() {
        underTest = new MapParser(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    }

    @Test
    public void testParseMapShouldReturnNewParsedMap() throws MapParseException {
        // given

        // when
        MapVO result = underTest.parse(VALID_RAW_MAP);

        // then
        assertEquals(EXPECTED_MAP_VO, result);
    }

    @Test
    public void testParseMapShouldThrowMapParsingExceptionWhenThereAreNotEnoughRows() throws InvalidRowException {
        // given in setup

        // when - then
        assertThrows(MapParseException.class, () -> {
            underTest.parse(INVALID_RAW_MAP_FEW_ROWS);
        });
    }

    @Test
    public void testParseMapShouldThrowMapParsingExceptionWhenThereAreNotEnoughColumns() throws InvalidColumnException{
        // given in setup

        // when - then
        assertThrows(MapParseException.class, () -> {
            underTest.parse(INVALID_RAW_MAP_FEW_COLUMNS);
        });
    }
    
}
