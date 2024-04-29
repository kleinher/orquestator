package com.allok.orquestator.client.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Intercourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private LocalDateTime date;

    private Boolean condom;

    public Intercourse() {
    }

    public Intercourse(Boolean condom) {
        this.date = LocalDateTime.now();
        this.condom = condom;
    }

    public String toString() {
        return "Intercourse{id=" + this.id + ", date=" + this.date + ", condom=" + this.condom + "}";
    }

}
