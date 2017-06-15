package com.soundmeter.api.service;

import com.soundmeter.api.model.Measure;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by user on 15/06/2017.
 */
public interface MeasureRepository extends PagingAndSortingRepository<Measure,Long> {
}
