import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
module Asteroids {
    requires Common;
    requires CommonBullet;
    requires CommonAsteroids;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with dk.sdu.mmmi.cbse.asteroids.data.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.asteroids.data.AsteroidProcessor;

}
