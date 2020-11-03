package com.andoriyu.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TopFive extends AppCompatActivity {

    ArrayList<Mascota> mascotasTF;
    private RecyclerView listamascotasTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);

        listamascotasTF= (RecyclerView) findViewById(R.id.rvMascotasTopFive);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listamascotasTF.setLayoutManager(llm);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            inicializarListaMascotas(parametros.getString("nombre"), parametros.getString("votos"), parametros.getInt("foto"));

            inicializarAdaptador();
        }

    }


    public MascotaAdaptador adaptadorTF;
    public void inicializarAdaptador(){
        adaptadorTF = new MascotaAdaptador(mascotasTF,this);
        listamascotasTF.setAdapter(adaptadorTF);
    }

    public void inicializarListaMascotas(String nombre, String votos, int Foto){

        mascotasTF= new ArrayList<Mascota>();

        mascotasTF.add(new Mascota(nombre, votos, Foto));

        /*mascotasTF.add(new Mascota("Agata","1",R.drawable.agata));
        mascotasTF.add(new Mascota("Flipa","1",R.drawable.flipa));
        mascotasTF.add(new Mascota("Luka","1",R.drawable.luka));
        mascotasTF.add(new Mascota("Mara","1",R.drawable.mara));
        mascotasTF.add(new Mascota("Mauri","1",R.drawable.mauri));*/

    }

}