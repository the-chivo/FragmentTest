package com.example.tickets.Model;

public class Ticket {

    public Ticket(String estadoTickets, String name, String description, String steps) {
        this.estadoTickets = estadoTickets;
        this.name = name;
        this.description = description;
        this.steps = steps;
    }

    private String estadoTickets;
    private String name;
    private String description;
    private String steps;

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
}
