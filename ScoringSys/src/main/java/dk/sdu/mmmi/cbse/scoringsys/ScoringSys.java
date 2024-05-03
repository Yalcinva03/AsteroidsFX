package dk.sdu.mmmi.cbse.scoringsys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ScoringSys {
    // Variables
    private Long TotesScores = 0L;
    private Long playerLives = 3L;

    public static void main(String[] args){
        SpringApplication.run(ScoringSys.class, args);
    }

    // GET
    @GetMapping("/score")
    public Long getScore(){
        return TotesScores;
    }
    @GetMapping("/lives")
    public Long getLives(){
        return playerLives;
    }

    // PUT
    @PutMapping("/score/update/{score}")
    public Long updateScore(@PathVariable (value = "score") Long score){
        TotesScores += score;
        return TotesScores;
    }
    @PutMapping("/lives/update/{decrementLives}")
    public Long updateLives(@PathVariable (value = "decrementLives") Long decrementLives){
        playerLives -= decrementLives;
        return playerLives;
    }
}
