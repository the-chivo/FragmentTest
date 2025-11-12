package com.example.tickets.Model_View;

import com.example.tickets.Model.Ticket;
import com.example.tickets.Model.ticketsEstados;

public class EnviarTickets {

    public static void crearTicket(ticketsEstados estado, String name, String description, String steps){
        Ticket ticket = new Ticket(estado, name, description, steps);
    }
}
