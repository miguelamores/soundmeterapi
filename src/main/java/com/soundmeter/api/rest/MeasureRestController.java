package com.soundmeter.api.rest;

import com.soundmeter.api.model.Measure;
import com.soundmeter.api.service.MeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
