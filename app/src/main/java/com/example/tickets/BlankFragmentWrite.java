package com.example.tickets;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tickets.Model.GestorTickets;
import com.example.tickets.Model.Ticket;

import java.io.File;
import java.util.List;

public class BlankFragmentWrite extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_write, container, false);


    }

    public void onStart() {
        super.onStart();
        if(getActivity() instanceof MainActivity){

            MainActivity mainActivity = ((MainActivity) getActivity());
            LinearLayout btnLayout = (LinearLayout) mainActivity.findViewById(R.id.linearLayout);
            TextView ticketBtn;

            File file = new File("/data/user/0/com.example.tickets/files/userList.txt");
            List<Ticket> tikectList = GestorTickets.getTicketList(file);

            createTicketBtn(tikectList, btnLayout);
        }
    }


    public void createTicketBtn(List<Ticket> ticketList, LinearLayout btnLayout){

        for(int i = 0; i <= ticketList.size() -1; i++){

            Ticket ticket = ticketList.get(i);
            String btnText = "ID: " + ticket.getId() + "  Nombre: " + ticket.getName();

            TextView ticketBtn = new Button((MainActivity) getActivity());
            ticketBtn.setText(btnText);
            ticketBtn.setOnClickListener(v -> {
                try{
                    ((MainActivity) getActivity()).abrirEditarTicket();
                    ((MainActivity) getActivity()).fragmentView.setTicketView(ticket);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            TextView ticketBtnActualizado = btnColorManager(ticket, ticketBtn);
            btnLayout.addView(ticketBtnActualizado);
        }


    }

    private static TextView btnColorManager(Ticket ticket, TextView btn){

        String nuevo = "Nuevo";
        String abierto = "Abierto";
        String pendiente = "Pendiente";
        String resuelto = "Resuelto";
        String cerrado = "Cerrado";

        int azul = Color.parseColor("#66A6E1");
        int rojo = Color.parseColor("#E0716C");
        int naranja = Color.parseColor("#E0A349");
        int amarillo = Color.parseColor("#DEE157");
        int verde = Color.parseColor("#45E592");

        if(ticket.getEstadoTickets().equals(nuevo)){
            btn.setBackgroundColor(azul);
        }

        if(ticket.getEstadoTickets().equals(abierto)){
            btn.setBackgroundColor(rojo);
        }

        if(ticket.getEstadoTickets().equals(pendiente)){
            btn.setBackgroundColor(naranja);
        }

        if(ticket.getEstadoTickets().equals(resuelto)){
            btn.setBackgroundColor(amarillo);
        }

        if(ticket.getEstadoTickets().equals(cerrado)){
            btn.setBackgroundColor(verde);
        }

        return btn;
    }

    private static void abrirTicket(){


    }

}