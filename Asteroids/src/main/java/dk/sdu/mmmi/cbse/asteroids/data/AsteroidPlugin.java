package dk.sdu.mmmi.cbse.asteroids.data;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.commonAsteroids.data.Asteroid;

public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {

        Entity asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(-10,-10,10,-10,10,10,-10,10); //-10,-10,10,-10,10,10,-10,10
        asteroid.setX(100);
        asteroid.setY(100);
        int max = 360;
        int min = 1;
        int range = max - min + 1;
        asteroid.setRotation(asteroid.getRotation()+ (Math.random()*range));
        asteroid.setRadius(10);
        asteroid.setType(EntityType.ASTEROID);
        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }
}
