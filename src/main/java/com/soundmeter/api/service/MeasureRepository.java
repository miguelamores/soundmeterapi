package com.soundmeter.api.service;

import com.soundmeter.api.model.Measure;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 15/06/2017.
 */
public interface MeasureRepository extends PagingAndSortingRepository<Measure,Long> {
    List<Measure> findByCreatedBetween(Date startDate, Date endDate);
}
