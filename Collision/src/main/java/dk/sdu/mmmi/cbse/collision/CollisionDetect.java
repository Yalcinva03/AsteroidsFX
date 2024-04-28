package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class CollisionDetect implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

    }


    public boolean Colliding(Entity e1, Entity e2){
        float dx = (float) e1.getX() - (float)e2.getX();
        float dy = (float) e1.getY() - (float)e2.getY();
        float distance = (float) Math.sqrt(dx*dx + dy*dy);
        return distance < e1.getRadius() + e2.getRadius();
    }
}
