import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

module Collision {
    requires Common;
    requires java.net.http;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.collision.CollisionDetect;
}
