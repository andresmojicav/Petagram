package com.andoriyu.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    private FloatingActionButton FABfive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FABfive = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        listamascotas= (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listamascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        FABfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TopFive.class);
                startActivity(intent);
            }
        });

    }


    public MascotaAdaptador adaptador;
        public void inicializarAdaptador(){
            adaptador = new MascotaAdaptador(mascotas,this);
            listamascotas.setAdapter(adaptador);
        }

    public void inicializarListaMascotas(){
            mascotas= new ArrayList<Mascota>();

            mascotas.add(new Mascota("Agata","0",R.drawable.agata));
            mascotas.add(new Mascota("Flipa","0",R.drawable.flipa));
            mascotas.add(new Mascota("Luka","0",R.drawable.luka));
            mascotas.add(new Mascota("Mara","0",R.drawable.mara));
        mascotas.add(new Mascota("Mauri","0",R.drawable.mauri));
        mascotas.add(new Mascota("Milo","0",R.drawable.milo));
        mascotas.add(new Mascota("Nero","0",R.drawable.nero));
        mascotas.add(new Mascota("Odin","0",R.drawable.odin));

    }

    }

