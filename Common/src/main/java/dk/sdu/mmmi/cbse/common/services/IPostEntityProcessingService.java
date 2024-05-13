package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {
    /**
     * Processes the behavior of the entities in the game.
     *
     * Preconditions:
     * - gameData is not null
     * - world is not null
     * - entities must have been processed by IEntityProcessingService
     *
     * Postconditions:
     * - The behaviors of the implemented service have been processed.
     *
     * @param gameData holds data such as the display width and height and the user input keys.
     * @param world holds the map<> of the entities added into the game.
     * @throws
     */
    void process(GameData gameData, World world);
}
