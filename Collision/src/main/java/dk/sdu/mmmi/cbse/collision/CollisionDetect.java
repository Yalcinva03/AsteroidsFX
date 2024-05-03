package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class CollisionDetect implements IEntityProcessingService {
    HttpClient client = HttpClient.newHttpClient();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()) {
            for(Entity entity2 : world.getEntities()){
                if(!entity1.equals(entity2)){
                    if(colliding(entity1, entity2)){
                        entity1.decrementHealf();
                        entity2.decrementHealf();
                        if(entity1.getType() == EntityType.PLAYER){
                            System.out.println("Player hit");
                            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/lives/update/1")).PUT(HttpRequest.BodyPublishers.ofString("")).build();
                            try {
                                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                                System.out.println(response.body());
                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if(entity1.getType() == EntityType.ASTEROID && entity2.getType() == EntityType.PBULLET){
                            System.out.println("Asteroid hit");
                            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/score/update/1")).PUT(HttpRequest.BodyPublishers.ofString("")).build();
                            try {
                                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                                System.out.println(response.body());
                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if(entity1.getType() == EntityType.ENEMY && entity2.getType() == EntityType.PBULLET){
                            System.out.println("Enemy hit");
                            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/score/update/5")).PUT(HttpRequest.BodyPublishers.ofString("")).build();
                            try {
                                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                                System.out.println(response.body());
                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
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
