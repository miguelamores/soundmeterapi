package com.soundmeter.api.rest;

import com.soundmeter.api.model.Measure;
import com.soundmeter.api.service.MeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 15/06/2017.
 */
@RestController
@RequestMapping("/measures")
public class MeasureRestController {

    final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    private final MeasureRepository measureRepository;

    public MeasureRestController(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<?> addMeasure(@RequestBody Measure measure) {
        Measure measure1 = this.measureRepository.save(measure);
        logger.info("Measure created", measure1);
        return new ResponseEntity<Object>(measure1, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<Measure> getAllMeasure() {
        logger.info("Getting all measures");
        return (List<Measure>) this.measureRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/date")
    private List<Measure> getMeasureByDate(@RequestParam @DateTimeFormat(pattern = "MMddyyyy hh:mm") Date startDate,
                                           @RequestParam @DateTimeFormat(pattern = "MMddyyyy hh:mm") Date endDate) {
        logger.info("Listing measures by date");
        return this.measureRepository.findByCreated(startDate, endDate);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    private ResponseEntity<?> deleteMeasure(@RequestParam long id) {
        Measure measure = this.measureRepository.findOne(id);
        if(measure == null) {
            logger.info("Measure with id: " + id + "does not exists");
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        logger.info("Deleting measure with id: " + measure.getId());
        this.measureRepository.delete(id);
        return new ResponseEntity<Measure>(HttpStatus.OK);
    }
}
