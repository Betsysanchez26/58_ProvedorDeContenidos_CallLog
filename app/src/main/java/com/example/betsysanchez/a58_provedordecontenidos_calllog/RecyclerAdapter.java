package com.example.betsysanchez.a58_provedordecontenidos_calllog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by BetsySanchez on 20/05/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    String [][] data;

    public RecyclerAdapter(String[][] data) {
        this.data = data;
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calls,parent,false);
                return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.numero.setText(" Numero: "+data[position][0]);
        holder.nombre.setText("Nombre: "+data[position][1]);
        holder.duracion.setText(" Duración: "+data[position][2]+" minutes");
        switch (data[position][3]){
            case "1":
                    holder.tipo.setText(" Tipo: Llamada Entrante");
                    break;
            case "2":
                    holder.tipo.setText(" Tipo: Llamada Saliente");
                    break;
            case "3":
                    holder.tipo.setText(" Tipo: Llamada Perdida");
                    break;
        }

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,numero,duracion,tipo;
        public RecyclerViewHolder(View itemView) {
                super(itemView);
                nombre=itemView.findViewById(R.id.nombre);
                numero=itemView.findViewById(R.id.numero);
                duracion=itemView.findViewById(R.id.duracion);
                tipo=itemView.findViewById(R.id.tipo);
            }
    }
}
