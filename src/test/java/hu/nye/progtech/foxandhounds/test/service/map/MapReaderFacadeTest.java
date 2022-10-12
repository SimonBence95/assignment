package hu.nye.progtech.foxandhounds.test.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.MapParseException;
import hu.nye.progtech.foxandhounds.service.exception.MapReadException;
import hu.nye.progtech.foxandhounds.service.exception.MapValidationException;
import hu.nye.progtech.foxandhounds.service.map.MapReaderFacade;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import hu.nye.progtech.foxandhounds.service.map.reader.MapReader;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for {@link MapReaderFacade}.
 */
@ExtendWith(MockitoExtension.class)
public class MapReaderFacadeTest {

    private static final List<String> RAW_MAP = List.of(
            "row1",
            "row2"
    );

    private static final MapVO MAP_VO = new MapVO(0, 0, null, null);

    @Mock
    private MapReader mapReader;
    @Mock
    private MapParser mapParser;
    @Mock
    private MapValidator mapValidator;

    private MapReaderFacade underTest;

    @BeforeEach
    public void setUp() {
        underTest = new MapReaderFacade(mapReader, mapParser, mapValidator);
    }

    @Test
    public void testReadMapShouldReturnReadAndParsedAndValidatedMap() throws MapReadException, MapParseException, MapValidationException {
        // given
        given(mapReader.read()).willReturn(RAW_MAP);
        given(mapParser.parse(RAW_MAP)).willReturn(MAP_VO);

        // when
        MapVO result = underTest.readMap();

        // then
        verify(mapReader).read();
        verify(mapParser).parse(RAW_MAP);
        verify(mapValidator).validate(MAP_VO);
        assertEquals(MAP_VO, result);
    }

    @Test
    public void testReadMapShouldThrowRuntimeExceptionWhenReadingOfTheMapFails() throws MapReadException {
        // given
        doThrow(MapValidationException.class).when(mapReader).read();

        // when - then
        assertThrows(RuntimeException.class, () -> {
            underTest.readMap();
        });
    }

    @Test
    public void testReadMapShouldThrowRuntimeExceptionWhenParsingOfTheMapFails() throws MapReadException, MapParseException {
        // given
        given(mapReader.read()).willReturn(RAW_MAP);
        doThrow(MapParseException.class).when(mapParser).parse(RAW_MAP);

        // when - then
        assertThrows(RuntimeException.class, () -> {
            underTest.readMap();
        });
    }

    @Test
    public void testReadMapShouldThrowRuntimeExceptionWhenValidationOfTheMapFails() throws MapReadException, MapParseException, MapValidationException {
        // given
        given(mapReader.read()).willReturn(RAW_MAP);
        given(mapParser.parse(RAW_MAP)).willReturn(MAP_VO);
        doThrow(MapValidationException.class).when(mapValidator).validate(MAP_VO);

        // when - then
        assertThrows(RuntimeException.class, () -> {
            underTest.readMap();
        });
    }

}
