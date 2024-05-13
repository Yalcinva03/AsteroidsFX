package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

/**
 *
 * @author corfixen
 */
public interface BulletSPI {
    /**
     * Processes the behavior of the entities in the game.
     *
     * Preconditions:
     * - gameData is not null
     * - entity is not null
     *
     * Postconditions:
     * - The shooter has spawned a bullet.
     *
     * @param gameData holds data such as the display width and height and the user input keys.
     * @param e is the entity that is shooting the bullet.
     * @throws
     */
    Entity createBullet(Entity e, GameData gameData);
}
