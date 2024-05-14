import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collision.CollisionDetect;
    exports dk.sdu.mmmi.cbse.collision; //for testing
}
