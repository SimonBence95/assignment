package hu.nye.progtech.foxandhounds.service.map.validation;

import hu.nye.progtech.foxandhounds.model.MapVO;

/**
 * Interface used to validate a {@link MapVO} object.
 */
public interface MapValidator {

    MapVO validate(MapVO mapVO);

}
