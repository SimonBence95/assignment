package hu.nye.progtech.foxandhounds.test.command.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import hu.nye.progtech.foxandhounds.service.writer.NameWriter;
import hu.nye.progtech.foxandhounds.model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for {@link NameWriter}.
 */
@ExtendWith(MockitoExtension.class)
public class NameWriterTest {

    private static final String NAME_COMMAND = "name";
    private static final String NO_NAME_COMMAND = "no-name";
    private GameState gameState;
    private NameWriter underTest;

    @Mock
    Scanner mockScanner = new Scanner(System.in);

    @BeforeEach
    public void setUp(){
        gameState = new GameState(null, false);
        underTest = new NameWriter(gameState);
    }

    @Test
    public void testCanProcessShouldReturnTrueWhenInputIsName() {
        // given in setup

        // when
        boolean result = underTest.canProcess(NAME_COMMAND);

        // then
        assertTrue(result);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenInputIsNotName() {
        // given in setup

        // when
        boolean result = underTest.canProcess(NO_NAME_COMMAND);

        // then
        assertFalse(result);
    }



    @Test
    public void TestProcessShouldGetProperUsernameFromInputStream()
    {

    }



}
