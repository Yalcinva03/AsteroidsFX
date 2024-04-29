package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {
    private Entity enemy1;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        enemy1 = createPlayerShip(gameData);
        world.addEntity(enemy1);
    }

    private Entity createPlayerShip(GameData gameData) {

        Entity enemy = new Enemy();
        enemy.setPolygonCoordinates(-5,-5,10,-2,10,2,-5,5); //-5,-5,10,-2,10,2,-5,5
        enemy.setX(2);
        enemy.setY(2);
        enemy.setRadius(10);
        return enemy;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy1);
    }
}
