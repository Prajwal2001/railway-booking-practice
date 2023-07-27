package railway.booking.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import railway.booking.app.entities.AppUser;
import railway.booking.app.entities.Coach;
import railway.booking.app.entities.Engine;
import railway.booking.app.logger.Log;
import railway.booking.app.repository.CoachRepository;
import railway.booking.app.repository.EngineRepository;

@RestController
public class MainController {

    @Autowired
    private Log log;

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private CoachRepository coachRepository;

    @GetMapping(path = "/test")
    public ResponseEntity<Engine> test() {

        ResponseEntity<Engine> response;

        Engine engine = new Engine();
        AppUser user = new AppUser();

        Coach coach = new Coach();
        coach.setEngine(engine);
        coach.setCreatedUser(user);

        Coach coach1 = new Coach();
        coach1.setEngine(engine);
        coach1.setDeleteFl(false);

        engineRepository.saveAndFlush(engine);
        coachRepository.saveAllAndFlush(Arrays.asList(coach, coach1));

        response = new ResponseEntity<>(engine, HttpStatus.OK);
        return response;
    }

    @GetMapping(path = "/test1")
    public ResponseEntity<EngineReponse> test1() {
        ResponseEntity<EngineReponse> response;

        Engine engine = engineRepository.findById(2L).orElse(null);
        if (engine != null) {
            try {
                response = new ResponseEntity<>(new EngineReponse(engine, engine.getCoaches()), HttpStatus.OK);
            } catch (Exception e) {
                log.error(e.getLocalizedMessage());
                response = null;
            }
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}

record EngineReponse(Engine engine, List<Coach> coaches) {
}

record CoachResponse(Integer coachId, Integer engineId) {
}
