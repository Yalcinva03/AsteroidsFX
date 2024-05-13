package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {
    /**
     * Processes the behavior of the entities in the game.
     *
     * Preconditions:
     * - gameData is not null
     * - world is not null
     *
     * Postconditions:
     * - The implemented initialization for the module have been processed.
     *
     * @param gameData holds data such as the display width and height and the user input keys.
     * @param world holds the map<> of the entities added into the game.
     * @throws
     */

    void start(GameData gameData, World world);

    /**
     * Processes the behavior of the entities in the game.
     *
     * Preconditions:
     * - gameData is not null
     * - world is not null
     * - start(GameData gameData, World world) must have been called
     *
     * Postconditions:
     * - The implemented initialization for the module have been processed.
     *
     * @param gameData holds data such as the display width and height and the user input keys.
     * @param world holds the map<> of the entities added into the game.
     * @throws
     */
    void stop(GameData gameData, World world);
}
