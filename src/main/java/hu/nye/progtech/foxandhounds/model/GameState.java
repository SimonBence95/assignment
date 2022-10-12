package hu.nye.progtech.foxandhounds.model;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Represents the current state of the game.
 */
public class GameState {

    public MapVO mapVO;
    private boolean userWantsToExit;

    public GameState(MapVO mapVO, boolean userWantsToExit) {
        this.mapVO = mapVO;
        this.userWantsToExit = userWantsToExit;
    }

    public MapVO getMapVO() {
        return mapVO;
    }

    public void setMapVO(MapVO mapVO) {
        this.mapVO = mapVO;
    }

    public boolean isUserWantsToExit() {
        return userWantsToExit;
    }

    public void setUserWantsToExit(boolean userWantsToExit) {
        this.userWantsToExit = userWantsToExit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameState gameState = (GameState) o;
        return userWantsToExit == gameState.userWantsToExit && mapVO.equals(gameState.mapVO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapVO, userWantsToExit);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameState.class.getSimpleName() + "[", "]")
                .add("mapVO=" + mapVO)
                .add("userWantsToExit=" + userWantsToExit)
                .toString();
    }
}
