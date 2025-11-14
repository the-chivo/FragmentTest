package com.example.tickets.Model;

import android.widget.Toast;

import com.example.tickets.MainActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestorTickets {

    MainActivity mainActivity;

    public static void getTicketInfo(String name, String description, String steps, String ticketStatus) throws IOException {
        Ticket ticket = new Ticket(ticketStatus,name, description, steps);
        System.out.println(name + description + ticketStatus + steps);
        createTicketFile();
    }

    private static void addTicketToList(Ticket ticket){

    }

    private static void createTicketFile() throws IOException {

        File file = new File("/data/user/0/com.example.tickets/files/userList.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        FileWriter fw = new FileWriter(file, true);
        fw.write("hola");
        fw.close();
    }




}
