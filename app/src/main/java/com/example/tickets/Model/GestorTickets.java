package com.example.tickets.Model;

import android.widget.Toast;

import com.example.tickets.MainActivity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class GestorTickets {

    MainActivity mainActivity;

    public static void getTicketInfo(String name, String description, String steps, String ticketStatus) throws IOException {
        Ticket ticket = new Ticket(ticketStatus,name, description, steps);
        System.out.println(name + description + ticketStatus + steps);
        createTicketFile(ticket);
    }


    private static void createTicketFile(Ticket ticket) throws IOException {

        File file = new File("/data/user/0/com.example.tickets/files/userList.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        FileReader fr = new FileReader(file);

        añadirTicketATxt(file, ticket);

        int i;
        while ((i = fr.read()) != -1){
            System.out.println((char) i);
        }

        getTicketList(file);


    }


    private static void eliminarTexto(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.setLength(0);
    }


    private static void añadirTicketATxt(File file, Ticket ticket) throws IOException {
        FileWriter fw = new FileWriter(file ,true);
        fw.write(ticket.getEstadoTickets() + " " + ticket.getName() + " " + ticket.getDescription() + " " + ticket.getSteps() + "\n");
        fw.close();
    }

    private static List<Ticket> getTicketList(File file){

        int espacio = 32; //Representa un espacio de texto en binario
        int linea = 10; // Representa un salto de linea
        int cr = 13; // Representa un carriage return

        List<Ticket> ticketList = new ArrayList<>();

        try(RandomAccessFile raf = new RandomAccessFile(file, "r")){

            while (raf.getFilePointer() < raf.length()){

                String estadoStr = "";
                String nombreStr = "";
                String descripcionStr = "";
                String pasosStr = "";
                int b;

                while ((b = raf.read()) != espacio && b != -1) {
                    estadoStr += (char) b;
                }

                while ((b = raf.read()) != espacio && b != -1) {
                    nombreStr += (char) b;
                }

                while ((b = raf.read()) != espacio && b != -1) {
                    descripcionStr += (char) b;
                }

                while ((b = raf.read()) != espacio && b != -1) {
                    pasosStr += (char) b;
                }

                if (b == cr && raf.getFilePointer() < raf.length()) {
                    raf.read();
                }

                ticketList.add(new Ticket(estadoStr, nombreStr, descripcionStr, pasosStr));

            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return  ticketList;
    }



}
