package com.example.tickets;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tickets.Model.GestorTickets;
import com.example.tickets.Model.Ticket;

import java.io.File;
import java.util.List;

public class BlankFragmentWrite extends Fragment {

    Spinner spinner;
    LinearLayout btnLayout;
    GestorTickets gestorTickets = new GestorTickets();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_blank_write, container, false);

        spinner = (Spinner) rootview.findViewById(R.id.spinner);
        btnLayout = (LinearLayout) rootview.findViewById(R.id.linearLayout);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                createTicketBtn(btnLayout, position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        return rootview;
    }

    public void onStart() {
        super.onStart();
        if(getActivity() instanceof MainActivity){

            MainActivity mainActivity = ((MainActivity) getActivity());
            LinearLayout btnLayout = (LinearLayout) mainActivity.findViewById(R.id.linearLayout);
            TextView ticketBtn;

            File file = new File("/data/user/0/com.example.tickets/files/userList.txt");
            List<Ticket> tikectList = gestorTickets.getTicketList(file);

            createTicketBtn(btnLayout, 0);
        }
    }


    public void createTicketBtn(LinearLayout btnLayout, int position){

        File file = new File("/data/user/0/com.example.tickets/files/userList.txt");
        List<Ticket> ticketList = gestorTickets.getTicketList(file);
        btnLayout.removeAllViews();

        String[] estados = {"Todos", "Nuevo", "Abierto", "Pendiente", "Resuelto", "Cerrado"};
        String estadoSeleccionado = estados[position];

        if(position == 0){

            for(int i = 0; i <= ticketList.size() -1; i++){

                Ticket ticket = ticketList.get(i);
                String btnText = "ID: " + ticket.getId() + "  Nombre: " + ticket.getName();

                TextView ticketBtn = new Button((MainActivity) getActivity());
                ticketBtn.setText(btnText);
                ticketBtn.setOnClickListener(v -> {
                    try{

                        Bundle ticketData = new Bundle();
                        ticketData.putSerializable("Ticket", ticket);
                        ((MainActivity) getActivity()).fragmentView.setArguments(ticketData);
                        setArguments(ticketData);
                        ((MainActivity) getActivity()).abrirEditarTicket();

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                TextView ticketBtnActualizado = btnColorManager(ticket, ticketBtn);
                btnLayout.addView(ticketBtnActualizado);
            }
        }
        else {
            for(int i = 0; i <= ticketList.size() -1; i++){

                Ticket ticket = ticketList.get(i);
                if(ticketList.get(i).getEstadoTickets().equals(estadoSeleccionado)){

                    String btnText = "ID: " + ticket.getId() + "  Nombre: " + ticket.getName();

                    TextView ticketBtn = new Button((MainActivity) getActivity());
                    ticketBtn.setText(btnText);
                    ticketBtn.setOnClickListener(v -> {
                        try{

                            Bundle ticketData = new Bundle();
                            ticketData.putSerializable("Ticket", ticket);
                            ((MainActivity) getActivity()).fragmentView.setArguments(ticketData);
                            setArguments(ticketData);
                            ((MainActivity) getActivity()).abrirEditarTicket();

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });

                    TextView ticketBtnActualizado = btnColorManager(ticket, ticketBtn);
                    btnLayout.addView(ticketBtnActualizado);
                }

            }
        }

    }

    private TextView btnColorManager(Ticket ticket, TextView btn){

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

}