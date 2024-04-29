package com.allok.orquestator.client;

import com.allok.orquestator.client.model.Intercourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class IngestionClient {
    private final IntercourseRepository intercourseRepository;
    private static final Logger logger = LoggerFactory.getLogger(IngestionClient.class);

    @Autowired
    public IngestionClient(IntercourseRepository intercourseRepository) {
        this.intercourseRepository = intercourseRepository;
    }

    public void saveIntercourseData(Intercourse data) {
        logger.info("Saving intercourse data: {}", data);
        intercourseRepository.save(data);
        logger.info("Data saved successfully!");
    }
}