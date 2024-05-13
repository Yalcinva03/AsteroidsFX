package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     * Processes the behavior of the entities in the game.
     *
     * Preconditions:
     * - gameData is not null
     * - world is not null
     *
     * Postconditions:
     * - The entities in the game's behaviors have been processed.
     *
     * @param gameData holds data such as the display width and height and the user input keys.
     * @param world holds the map<> of the entities added into the game.
     * @throws
     */
    void process(GameData gameData, World world);
}
