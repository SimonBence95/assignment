package hu.nye.progtech.foxandhounds.test.command.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import hu.nye.progtech.foxandhounds.command.impl.PutCommand;
import hu.nye.progtech.foxandhounds.model.GameState;
import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.MapValidationException;
import hu.nye.progtech.foxandhounds.service.exception.PutException;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;
import hu.nye.progtech.foxandhounds.service.performer.PutPerformer;
import hu.nye.progtech.foxandhounds.ui.MapPrinter;
import hu.nye.progtech.foxandhounds.ui.PrintWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for {@link PutCommand}.
 */
@ExtendWith(MockitoExtension.class)
public class PutCommandTest {

    private static final String PUT_COMMAND = "put 0 0 1";
    private static final String NOT_PUT_COMMAND = "not-put";

    private static final int ROW_INDEX = 0;
    private static final int COLUMN_INDEX = 0;
    private static final int NUMBER = 1;

    private static final MapVO MAP = new MapVO(0, 0, null, null);
    private static final MapVO NEW_MAP = new MapVO(0, 0, null, null);

    private static final String PUT_ERROR_MESSAGE = "Can't write to a fixed position";
    private static final String MAP_VALIDATION_ERROR_MESSAGE = "Can't write the given number to that position";

    private GameState gameState;
    @Mock
    private PutPerformer putPerformer;
    @Mock
    private MapValidator mapValidator;

    private PutCommand underTest;

    @BeforeEach
    public void setUp() {
        gameState = new GameState(MAP, false);
        underTest = new PutCommand(gameState,putPerformer,mapValidator);
    }

    @Test
    public void testCanProcessShouldReturnTrueWhenTheGivenInputIsValidPutCommand() {
        // given in setup

        // when
        boolean result = underTest.canProcess(PUT_COMMAND);

        // then
        assertTrue(result);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenTheGivenInputIsNotValidPutCommand() {
        // given in setup

        // when
        boolean result = underTest.canProcess(NOT_PUT_COMMAND);

        // then
        assertFalse(result);
    }

    @Test
    public void testProcessShouldPerformValidPutOperation() throws PutException, MapValidationException {
        // given
        given(putPerformer.performPut(MAP, ROW_INDEX, COLUMN_INDEX, NUMBER)).willReturn(NEW_MAP);

        // when
        underTest.process(PUT_COMMAND);

        // then
        verify(putPerformer).performPut(MAP, ROW_INDEX, COLUMN_INDEX, NUMBER);
        assertEquals(NEW_MAP, gameState.getMapVO());
    }

    @Test
    public void testProcessShouldNotUpdateGameStateWhenNewMapValidationFails() throws PutException, MapValidationException {
        // given
        given(putPerformer.performPut(MAP, ROW_INDEX, COLUMN_INDEX, NUMBER)).willReturn(NEW_MAP);
        doThrow(MapValidationException.class).when(mapValidator).validate(NEW_MAP);

        // when
        underTest.process(PUT_COMMAND);

        // then
        assertEquals(MAP, gameState.getMapVO());
    }

}