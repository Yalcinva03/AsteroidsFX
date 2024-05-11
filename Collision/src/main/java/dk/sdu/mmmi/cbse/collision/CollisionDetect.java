package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

public class CollisionDetect implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()) {
            for(Entity entity2 : world.getEntities()){
                if(!entity1.equals(entity2)){
                    if(colliding(entity1, entity2)){
                        entity1.setHealf(entity1.getHealf()-1);
                        entity2.setHealf(entity2.getHealf()-1);
                    }
                }
            }
        }
    }

    public boolean colliding(Entity e1, Entity e2){
        float dx = (float)e1.getX() - (float)e2.getX();
        float dy = (float)e1.getY() - (float)e2.getY();
        float distance = (float) Math.sqrt(dx*dx + dy*dy);
        return distance < (e1.getRadius() + e2.getRadius());
    }
}
