package com.andoriyu.petagram;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
final Mascota mascota = mascotas.get(position);
mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
mascotaViewHolder.tvNombre.setText(mascota.getNombre());
mascotaViewHolder.tvVotos.setText(mascota.getVotos());

mascotaViewHolder.tvVotos.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        //activity.startActivity(intent);


    }
});

mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(activity, "Diste Like a "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
        mascota.setVotos("1");
        Intent intent = new Intent(activity, TopFive.class);
        intent.putExtra("nombre",mascota.getNombre());
        intent.putExtra("votos",mascota.getVotos());
        intent.putExtra("foto",mascota.getFoto());


    }
});

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder  extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvVotos;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvVotos = (TextView) itemView.findViewById(R.id.tvVotos);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
