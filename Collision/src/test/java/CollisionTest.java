import dk.sdu.mmmi.cbse.collision.CollisionDetect;
import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollisionTest {
    private CollisionDetect collisionDetect;

    @Before
    public void setUp() {
        collisionDetect = new CollisionDetect();
    }

    @Test
    public void testNoCollision() {
        Entity e1 = new Entity();Entity e2 = new Entity(); //instantiate two entities
        e1.setRadius(5);e2.setRadius(5);//Set entity radii
        e1.setX(0);e1.setY(0);e2.setX(0);
        e2.setY(15); //Set entity positions
        // Test if two entities do not collide
        assertFalse(collisionDetect.colliding(e1, e2));
    }

    @Test
    public void testCollision() {
        Entity e1 = new Entity();Entity e2 = new Entity(); //instantiate two entities
        e1.setRadius(5);e2.setRadius(5);//Set entity radii
        e1.setX(0);e1.setY(0);e2.setX(0);
        e2.setY(9); //Set entity positions
        // Test if two entities do not collide
        assertTrue(collisionDetect.colliding(e1, e2));
    }
}
