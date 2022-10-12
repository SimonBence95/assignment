package hu.nye.progtech.foxandhounds.service.map;

import java.util.List;

import hu.nye.progtech.foxandhounds.model.MapVO;
import hu.nye.progtech.foxandhounds.service.exception.MapReadException;
import hu.nye.progtech.foxandhounds.service.map.parser.MapParser;
import hu.nye.progtech.foxandhounds.service.map.reader.MapReader;
import hu.nye.progtech.foxandhounds.service.map.validation.MapValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Facade that makes it easier to read a map.
 */
public class MapReaderFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapReaderFacade.class);

    private final MapReader mapReader;
    private final MapParser mapParser;
    private final MapValidator mapValidator;

    public MapReaderFacade(MapReader mapReader, MapParser mapParser, MapValidator mapValidator) {
        this.mapReader = mapReader;
        this.mapParser = mapParser;
        this.mapValidator = mapValidator;
    }

    /**
     * Reads a map.
     *
     * This method hides the low level operations of reading a map, like reading it
     * in a raw format, parsing the map then also running a validation on it.
     *
     * @return a parsed map as a {@link MapVO} object
     */
    public MapVO readMap() {
        MapVO result;

        try {
            List<String> rawMap = mapReader.read();
            result = mapParser.parse(rawMap);
            mapValidator.validate(result);
        } catch (MapReadException e) {
            LOGGER.error("Failed to read map");
            throw new RuntimeException("Failed to read map");
        } catch (RuntimeException e) {
            LOGGER.error("Unknown exception", e);
            throw new RuntimeException("Unknown exception");
        }

        return result;
    }

}
