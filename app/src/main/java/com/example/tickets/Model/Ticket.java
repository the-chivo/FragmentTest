package com.example.tickets.Model;

import java.io.Serializable;

public class Ticket implements Serializable {

    public Ticket(String estadoTickets, String name, String description, String steps, int id) {
        this.estadoTickets = estadoTickets;
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.id = id;
    }

    private String estadoTickets;
    private String name;
    private String description;
    private String steps;
    private int id;
    public String getEstadoTickets() {
        return estadoTickets;
    }

    public void setEstadoTickets(String estadoTickets) {
        this.estadoTickets = estadoTickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
