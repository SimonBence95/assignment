package hu.nye.progtech.foxandhounds.service.game;

import hu.nye.progtech.foxandhounds.model.GameState;
import hu.nye.progtech.foxandhounds.service.util.MapUtil;

/**
 * Component that controls the flow of a game.
 */
public class GameController {

    public GameController(GameState gameState, MapUtil mapUtil, GameStepPerformer gameStepPerformer) {
        this.gameState = gameState;
        this.mapUtil = mapUtil;
        this.gameStepPerformer = gameStepPerformer;
    }

    private GameState gameState;
    private MapUtil mapUtil;
    private GameStepPerformer gameStepPerformer;

    /**
     * Starts the game loop.
     */
    public void gameLoop() {
        while (isGameInProgress()) {
            gameStepPerformer.performGameStep();
        }
    }

    private boolean isGameInProgress() {
        return !mapUtil.isMapCompleted(gameState.getMapVO()) && !gameState.isUserWantsToExit();
    }

}
