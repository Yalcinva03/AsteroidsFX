package dk.sdu.mmmi.cbse.commonAsteroids.data;
import dk.sdu.mmmi.cbse.common.data.Entity;


public class Asteroid extends Entity{
    private boolean split = false;
    void setSplit(boolean split){
        this.split = true;
    }
}
