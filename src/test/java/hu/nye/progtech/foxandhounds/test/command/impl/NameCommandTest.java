package hu.nye.progtech.foxandhounds.test.command.impl;

import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;


import hu.nye.progtech.foxandhounds.command.impl.NameCommand;
import hu.nye.progtech.foxandhounds.model.GameState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link NameCommand}.
 */
public class NameCommandTest {

    private static final String NAME_COMMAND = "name";
    private static final String NO_NAME_COMMAND = "no-name";
    private GameState gameState;
    private NameCommand underTest;

    private static final InputStream DEFAULT_STDIN = System.in;

    @AfterEach
    public void rollbackChangesToStdin() {
        System.setIn(DEFAULT_STDIN);
    }

    @BeforeEach
    public void setUp(){
        gameState = new GameState(null, false);
        underTest = new NameCommand(gameState);
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
