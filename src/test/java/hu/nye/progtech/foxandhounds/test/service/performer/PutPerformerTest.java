package hu.nye.progtech.foxandhounds.test.service.performer;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.performer.PutPerformer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

/**
 * Unit tests for {@link PutPerformer}.
 */
public class PutPerformerTest {

    private static final int NUMBER_OF_ROWS = 2;
    private static final int NUMBER_OF_COLUMNS = 2;

    private static final int TARGET_ROW_INDEX = 0;
    private static final int VALID_TARGET_COLUMN_INDEX = 0;
    private static final int INVALID_TARGET_COLUMN_INDEX = 1;
    private static final int TARGET_NUMBER = 2;

    private static final int[][] INPUT_MAP = {
            {0, 1},
            {0, 0}
    };
    private static final boolean[][] FIXED = {
            {false, true},
            {false, false}
    };
    private static final int[][] EXPECTED_MAP = {
            {2, 1},
            {0, 0}
    };

    private static final MapVO INPUT_MAP_VO = new MapVO(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, INPUT_MAP, FIXED);
    private static final MapVO EXPECTED_MAP_VO = new MapVO(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, EXPECTED_MAP, FIXED);

    private PutPerformer underTest;

    @BeforeEach
    public void setUp() {
        underTest = new PutPerformer();
    }

    @Test
    public void testPerformShouldPerformPutAndReturnNewMap() throws RuntimeException {
        // given in setup

        // when
        MapVO result = underTest.performPut(INPUT_MAP_VO, TARGET_ROW_INDEX, VALID_TARGET_COLUMN_INDEX, TARGET_NUMBER);

        // then
        assertEquals(EXPECTED_MAP_VO, result);
    }

    @Test
    public void testPerformShouldThrowPutExceptionWhenWeTryToPutIntoFixedPosition() {
        // given in setup

        // when - then
       // Assertions.assertThrows(RuntimeException.class, () -> {
              underTest.performPut(INPUT_MAP_VO, TARGET_ROW_INDEX, INVALID_TARGET_COLUMN_INDEX, TARGET_NUMBER);
        };
    }


