package dk.sdu.mmmi.cbse.asteroids.data;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
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
            if (asteroid.getX() < -12) {
                asteroid.setX(gameData.getDisplayWidth()+11);
            }
            if (asteroid.getX() > gameData.getDisplayWidth()+12) {
                asteroid.setX(-11);
            }
            if (asteroid.getY() < -12) {
                asteroid.setY(gameData.getDisplayHeight()+11);
            }
            if (asteroid.getY() > gameData.getDisplayHeight()+12) {
                asteroid.setY(-11);
            }
            if(asteroid.isDestroyed()){
                world.removeEntity(asteroid);
                if(asteroid.getRadius()>6){
                    splitAsteroid(asteroid,world);
                }
            }
        }
    }
    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(-10,-10,10,-10,10,10,-10,10); //-10,-10,10,-10,10,10,-10,10
        asteroid.setX(Math.random()*10-20);
        asteroid.setY(Math.random()*(gameData.getDisplayHeight()));
        int max = 360;
        int min = 1;
        int range = max - min + 1;
        asteroid.setRotation((Math.random()*range));
        asteroid.setRadius(10);
        asteroid.setType(EntityType.ASTEROID);
        return asteroid;
    }
    private void splitAsteroid(Entity asteroid,World world){
        Entity asteroid1 = new Asteroid();
        Entity asteroid2 = new Asteroid();
        asteroid1.setPolygonCoordinates(-5,-5,5,-5,5,5,-5,5);
        asteroid2.setPolygonCoordinates(-5,-5,5,-5,5,5,-5,5);
        int spawnDirAngle = 25;
        double extraX1 = Math.cos(Math.toRadians(asteroid.getRotation()+spawnDirAngle));
        double extraY1 = Math.sin(Math.toRadians(asteroid.getRotation()+spawnDirAngle));
        double extraX2 = Math.cos(Math.toRadians(asteroid.getRotation()-spawnDirAngle));
        double extraY2 = Math.sin(Math.toRadians(asteroid.getRotation()-spawnDirAngle));
        asteroid1.setRotation(asteroid.getRotation()+spawnDirAngle);
        asteroid2.setRotation(asteroid.getRotation()-spawnDirAngle);
        asteroid1.setX(asteroid.getX() + (extraX1*20));
        asteroid1.setY(asteroid.getY() + (extraY1*20));
        asteroid2.setX(asteroid.getX() + (extraX2*20));
        asteroid2.setY(asteroid.getY() + (extraY2*20));
        asteroid1.setRadius(5);
        asteroid2.setRadius(5);
        asteroid1.setType(EntityType.ASTEROID);
        asteroid2.setType(EntityType.ASTEROID);
        world.addEntity(asteroid1);
        world.addEntity(asteroid2);
    }

}
