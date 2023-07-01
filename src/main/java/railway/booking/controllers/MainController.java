package railway.booking.controllers;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import railway.booking.entities.Coach;
import railway.booking.entities.Engine;
import railway.booking.logger.Log;

@RestController
public class MainController {

    @Autowired
    private Log log;

    @GetMapping(path = "/test")
    public ResponseEntity<Coach> get() {

        ResponseEntity<Coach> response;

        Engine engine = new Engine();
        engine.setEngineId(0);

        Coach coach = new Coach();
        coach.setCoachId(0);
        coach.setEngine(engine);

        log.info(coach.toString());
        log.error(coach.toString());

        response = new ResponseEntity<>(coach, HttpStatus.OK);
        return response;
    }
}
