package com.example.tickets;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    public BlankFragmentEdit fragmentView;
    public BlankFragmentWrite fragmentWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
        startActivity(intent);




        Button fragmentViewBtn = (Button) findViewById(R.id.button);
        Button fragmentWriteBtn = (Button) findViewById(R.id.button1);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transact = fragmentManager.beginTransaction();

        fragmentView = new BlankFragmentEdit();
        fragmentWrite = new BlankFragmentWrite();
        transact.replace(R.id.fragmentContainer, fragmentView);
        transact.commit();

        fragmentWriteBtn.setOnClickListener(v -> {

            abrirListaTicket();

        });

        fragmentViewBtn.setOnClickListener(v -> {

            abrirEditarTicket();
        });



    }

    public void test(){

    }

    public void abrirListaTicket(){

        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction writeTransact = fragmentManager.beginTransaction();
            writeTransact.replace(R.id.fragmentContainer, fragmentWrite);
            writeTransact.commit();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void abrirEditarTicket(){

        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction writeTransact = fragmentManager.beginTransaction();
            writeTransact.replace(R.id.fragmentContainer, fragmentView);
            writeTransact.commit();
            fragmentView.clearTicket();
            fragmentView.ticketIsNew = true;

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}