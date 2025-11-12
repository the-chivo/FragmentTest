package com.example.tickets.Model;

public class Ticket {

    public Ticket(ticketsEstados estadoTickets, String name, String description, String steps) {
        this.estadoTickets = estadoTickets;
        this.name = name;
        this.description = description;
        this.steps = steps;
    }

    private ticketsEstados estadoTickets = ticketsEstados.NUEVO;
    private String name;
    private String description;
    private String steps;

    public ticketsEstados getEstadoTickets() {
        return estadoTickets;
    }

    public void setEstadoTickets(ticketsEstados estadoTickets) {
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
