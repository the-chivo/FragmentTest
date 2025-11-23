package com.example.tickets.Model;

import com.example.tickets.BlankFragmentEdit;
import com.example.tickets.BlankFragmentWrite;
import com.example.tickets.MainActivity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class GestorTickets {

    public void getTicketInfo(String name, String description, String steps, String ticketStatus) throws IOException {
        File file = createTicketFile();
        FileReader fr = new FileReader(file);
        boolean ticketIsNew = false;


        if(fr.read() == -1){  //Comprueba si hay texto en el documento y crea el primer ticket
            Ticket ticket = new Ticket(ticketStatus,name, description, steps, 0, ticketIsNew);
            añadirTicketATxt(file, ticket);
            System.out.println("dxdsd");
        }
        else {
                //Si ya ahi un ticket o mas crea el ticket con id +1 del ultimo ticket de la lista
            List<Ticket> ticketList = getTicketList(file);
            int id = getLastId(ticketList);
            Ticket ticket = new Ticket(ticketStatus, name, description, steps, id, ticketIsNew);
            añadirTicketATxt(file, ticket);
            leerFile();
        }


    }


    private File createTicketFile() throws IOException {
        File file = new File("/data/user/0/com.example.tickets/files/userList.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return file;
    }


    public void eliminarTexto(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.setLength(0);
    }


    private void añadirTicketATxt(File file, Ticket ticket) throws IOException {
        FileWriter fw = new FileWriter(file ,true);
        fw.write(ticket.getEstadoTickets() + "~" + ticket.getName() + "~" + ticket.getDescription() + "~" + ticket.getSteps() + "~" +  ticket.getId() + "\n");
        fw.close();
    }

    public List<Ticket> getTicketList(File file){

        int separador = 126; //Se usa para separar los datos en el txt, es "~" en acsci
        int linea = 10; // Representa un salto de linea
        int cr = 13; // Representa un carriage return

        List<Ticket> ticketList = new ArrayList<>();

        try(RandomAccessFile raf = new RandomAccessFile(file, "r")){

            while (raf.getFilePointer() < raf.length()){

                String estadoStr = "";
                String nombreStr = "";
                String descripcionStr = "";
                String pasosStr = "";
                String idStr = "";
                boolean ticketIsNew = false;
                int b;

                while ((b = raf.read()) != separador && b != -1) {
                    estadoStr += (char) b;
                    System.out.println(estadoStr);
                }
                System.out.println(estadoStr);
                while ((b = raf.read()) != separador && b != -1) {
                    nombreStr += (char) b;
                }

                while ((b = raf.read()) != separador && b != -1) {
                    descripcionStr += (char) b;
                }

                while ((b = raf.read()) != separador && b != -1) {
                    pasosStr += (char) b;
                }

                while ((b = raf.read()) != linea && b != -1 && b != cr) {
                    idStr += (char) b;
                }

                if (b == cr && raf.getFilePointer() < raf.length()) {
                    raf.read();
                }

                int id = Integer.parseInt(idStr.trim()) + 1;
                System.out.println("El id es " + id);
                ticketList.add(new Ticket(estadoStr, nombreStr, descripcionStr, pasosStr, id, ticketIsNew));

            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return  ticketList;
    }

    public void leerFile() throws IOException {

        File file = new File("/data/user/0/com.example.tickets/files/userList.txt");
        FileReader fr = new FileReader(file);
        int i;
        while ((i = fr.read()) != -1){
            System.out.println((char) i);
        }
    }

    public int getLastId(List<Ticket> ticketList){

        int id;
        int index = ticketList.size() -1;
        id = ticketList.get(index).getId();
        return id;
    }



}
