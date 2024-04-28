package dk.sdu.mmmi.cbse.asteroids.data;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.commonAsteroids.data.Asteroid;

public class AsteroidProcessor implements IEntityProcessingService{
    @Override
    public void process(GameData gameData, World world) {
        int spawnE = (int)(Math.random()*(1000)) - 1;
        if(spawnE<=3){
            world.addEntity(createAsteroid(gameData));
        }
        for (Entity asteroid : world.getEntities(Asteroid.class)){
            double Dx = Math.cos(Math.toRadians(asteroid.getRotation()));
            double Dy = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + Dx*0.5);
            asteroid.setY(asteroid.getY() + Dy*0.5);
            if (asteroid.getX() < 0) {
                asteroid.setX(gameData.getDisplayWidth());
            }
            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(0);
            }
            if (asteroid.getY() < 0) {
                asteroid.setY(gameData.getDisplayHeight());
            }
            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(0);
            }
        }
    }
    private Entity createAsteroid(GameData gameData) {

        Entity asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(-10,-10,10,-10,10,10,-10,10); //-10,-10,10,-10,10,10,-10,10
        asteroid.setX(2);
        asteroid.setY(Math.random()*(gameData.getDisplayHeight()));
        int max = 360;
        int min = 1;
        int range = max - min + 1;
        asteroid.setRotation(asteroid.getRotation()+ (Math.random()*range));
        return asteroid;
    }

}
