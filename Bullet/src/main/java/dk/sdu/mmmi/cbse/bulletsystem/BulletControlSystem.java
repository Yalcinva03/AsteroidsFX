package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX*5);
            bullet.setY(bullet.getY() + changeY*5);

            if (bullet.getX() > gameData.getDisplayWidth()) {
                bullet.setOut(true);
            }
            if (bullet.getY() > gameData.getDisplayHeight()) {
                bullet.setOut(true);
            }
            if (bullet.getX() < 0) {
                bullet.setOut(true);
            }
            if (bullet.getY() < 0) {
                bullet.setOut(true);
            }
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        double extraX = Math.cos(Math.toRadians(shooter.getRotation()));
        double extraY = Math.sin(Math.toRadians(shooter.getRotation()));
        Entity bullet = new Bullet();
        bullet.setX(shooter.getX() + extraX*17);
        bullet.setY(shooter.getY() + extraY*17);
        bullet.setRotation(shooter.getRotation());
        bullet.setPolygonCoordinates(-2,-2,2,-2,2,2,-2,2);
        System.out.println("space");
        return bullet;
    }

    private void setShape(Entity entity) {
    }

}
