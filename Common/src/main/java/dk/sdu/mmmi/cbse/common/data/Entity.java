package dk.sdu.mmmi.cbse.common.data;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();
    
    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private float radius;
    private int Healf;
    private boolean Destroyed;
    private boolean Out;

    public boolean isDestroyed() {
        if(getHealf() <= 0){
            Destroyed = true;
        }
        return Destroyed;
    }

    public boolean isOut() {
        return Out;
    }

    public void setOut(boolean out) {
        Out = out;
    }

    public void setDestroyed(boolean destroyed) {
        Destroyed = destroyed;
    }



    public String getID() {
        return ID.toString();
    }


    public void setPolygonCoordinates(double... coordinates ) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }
       

    public void setX(double x) {
        this.x =x;
    }

    public double getX() {
        return x;
    }

    
    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }


    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getHealf() {
        return Healf;
    }

    public void setHealf(int healf) {
        Healf = healf;
    }
}
