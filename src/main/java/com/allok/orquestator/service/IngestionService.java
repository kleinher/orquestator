package com.allok.orquestator.service;

import com.allok.orquestator.client.IngestionClient;
import com.allok.orquestator.client.model.Intercourse;
import com.allok.orquestator.controller.directory.DataRecieved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngestionService {
    private final IngestionClient client;

    @Autowired
    public IngestionService(IngestionClient client) {
        this.client = client;
    }

    public void saveIntercourseData(DataRecieved data) {
        Intercourse intercourse = new Intercourse(data.getCondom());
        client.saveIntercourseData(intercourse);
    }
}
