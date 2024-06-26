package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;
import java.lang.Math;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        int spawnE = (int)(Math.random()*(5000)) - 1;
        if(spawnE==56){
            world.addEntity(createEnemies(gameData));
        }
        for (Entity enemy : world.getEntities(Enemy.class)){
            int max = 10;
            int min = 1;
            int range = max - min + 1;
            int shootOrNo = (int)(Math.random()*(range*17)) - min;
            int moveOrNo = (int)(Math.random()*range) - min;
            enemy.setRotation(enemy.getRotation() + (4 - moveOrNo));
            if (true) { //forward
                double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
                enemy.setX(enemy.getX() + changeX);
                enemy.setY(enemy.getY() + changeY);
            }
            if (shootOrNo==7){ //shoot
                for (BulletSPI bullet : getBulletSPIs()){
                    world.addEntity(bullet.createBullet(enemy,gameData));
                }
            }
            if (enemy.getX() < 0) {
                enemy.setX(1);
            }
            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(gameData.getDisplayWidth()-1);
            }
            if (enemy.getY() < 0) {
                enemy.setY(1);
            }
            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(gameData.getDisplayHeight()-1);
            }
            if(enemy.isDestroyed()){
                world.removeEntity(enemy);
            }
        }
    }
    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
    public Entity createEnemies(GameData gameData) {
        Entity Enemy = new Enemy();
        int spawncoordsE = (int)(Math.random()*(5)) - 1;
        Enemy.setX((double) gameData.getDisplayWidth()/spawncoordsE);
        Enemy.setY((double )gameData.getDisplayWidth()/spawncoordsE);
        Enemy.setPolygonCoordinates(-5,-5,10,-2,10,2,-5,5);
        Enemy.setRadius(5);
        return Enemy;
    }
}
