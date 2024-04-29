package com.allok.orquestator.controller;

import com.allok.orquestator.client.model.Intercourse;
import com.allok.orquestator.controller.directory.DataRecieved;
import com.allok.orquestator.service.IngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingest")
public class IngestionController {

    private final IngestionService service;

    @Autowired
    public IngestionController(IngestionService service) {
        this.service = service;
    }

    @PostMapping("/intercourse")
    public ResponseEntity<String> setIntercourseData(@RequestBody DataRecieved data) {
        service.saveIntercourseData(data);
        return ResponseEntity.ok("Data saved successfully!");
    }
}