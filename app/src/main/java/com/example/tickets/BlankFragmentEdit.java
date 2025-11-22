package com.example.tickets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tickets.Model.GestorTickets;
import com.example.tickets.Model.Ticket;


public class BlankFragmentEdit extends Fragment {

    Button sendBtn;
    Spinner spinner;
    EditText nameEditText;
    EditText descriptionEditText;
    EditText stepsEditText;
    public boolean ticketIsNew = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank_view, container, false);

        sendBtn = (Button) rootView.findViewById(R.id.sendTicketBtn);
        spinner = (Spinner) rootView.findViewById(R.id.spinnerView);
        nameEditText = (EditText) rootView.findViewById(R.id.nameEditText);
        descriptionEditText = (EditText) rootView.findViewById(R.id.descriptionEditText);
        stepsEditText = (EditText) rootView.findViewById(R.id.stepsEditText);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0 && ticketIsNew){
                    spinner.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        return rootView;

    }

    @Override
    public void onStart() {

        super.onStart();
        if(getActivity() instanceof MainActivity){

            if(getArguments() != null){
                Ticket ticket = (Ticket) getArguments().getSerializable("Ticket");
                if(ticket != null){
                    setTicketView(ticket);
                }
            }

            MainActivity mainActivity = ((MainActivity) getActivity());
            sendBtn = (Button) mainActivity.findViewById(R.id.sendTicketBtn);
            spinner = (Spinner) mainActivity.findViewById(R.id.spinnerView);
            nameEditText = (EditText) mainActivity.findViewById(R.id.nameEditText);
            descriptionEditText = (EditText) mainActivity.findViewById(R.id.descriptionEditText);
            stepsEditText = (EditText) mainActivity.findViewById(R.id.stepsEditText);


            sendBtn.setOnClickListener(v -> {

                String name = nameEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String steps = stepsEditText.getText().toString();
                String spinnerPosition = getSpinnerString(spinner.getSelectedItemPosition());
                System.out.println(spinnerPosition);

                try {
                    String textoBruto = name + description + steps;
                    if(name.equals("")|| description.equals("") || steps.equals("")){
                        Toast.makeText(mainActivity, "No puede haber campos vacios", Toast.LENGTH_SHORT).show();
                    }
                    if (textoBruto.contains("~")){
                        Toast.makeText(mainActivity, "Ningun campo puede contener '~' listo k eres un listo", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        GestorTickets.getTicketInfo(name, description, steps, spinnerPosition);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }


    public void setTicketView(Ticket ticket){

        nameEditText.setText(ticket.getName());
        descriptionEditText.setText(ticket.getDescription());
        stepsEditText.setText(ticket.getSteps());
        descriptionEditText.setText(ticket.getDescription());
        spinner.setSelection(getSpinnerInt(ticket.getEstadoTickets()));
        ticketIsNew = false;
    }

    private  int getSpinnerInt(String itemPosition){
        int spinnerInt = 0;
        switch (itemPosition){

            case "Nuevo":
                spinnerInt = 0;
                break;
            case "Abierto":
                spinnerInt = 1;
                break;
            case "Pendiente":
                spinnerInt = 2;
                break;
            case "Resuelto":
                spinnerInt = 3;
                break;
            case "Cerrado":
                spinnerInt = 4;
                break;
        }

        return spinnerInt;
    }

    private  String getSpinnerString(int itemPosition){
        String spinerstring = "";
        switch (itemPosition){

            case 0:
                spinerstring = "Nuevo";
                break;
            case 1:
                spinerstring = "Abierto";
                break;
            case 2:
                spinerstring = "Pendiente";
                break;
            case 3:
                spinerstring = "Resuelto";
                break;
            case 4:
                spinerstring = "Cerrado";
                break;
        }

        return spinerstring;
    }

    public void clearTicket(){

        spinner.setSelection(0);
        nameEditText.setText("");
        descriptionEditText.setText("");
        stepsEditText.setText("");
    }


}