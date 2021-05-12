package com.example.masterdetailpettern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

// Programación genérica, debe extender de la clase Adapter<T> de tipo PaisajesViewHolder
// y a su vez la clase PaisajesViewHolder debe extender de ViewHolder.

// De varias maneras podemos agregar el evento de Click al RecyclerView
// Dos de estos metodos son:
// 1. Creando una interfaz y comunicando al acivity con el adaptador y usando una clase anónima.
// 2. Hacer que el adaptador implemente la interfaz OnClickListener para obligarlo a
// sobreescribir el método OnClick
// en ambos casos debemos tener un miembro que hace referencia a una interfaz.

public class AdaptadorPaisajes
        extends RecyclerView.Adapter<AdaptadorPaisajes.PaisajesViewHolder> implements View.OnClickListener {

    private ArrayList<PaisajeVo> listaPaisajes;

    // Debe de tener un miembro que hace referencia a una interfaz.
    private View.OnClickListener listener;

    AdaptadorPaisajes(ArrayList<PaisajeVo> listaPaisajes){
        this.listaPaisajes = listaPaisajes;

    }

    @NonNull
    @Override
    public PaisajesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paisaje,parent,false);

        view.setOnClickListener(this);

        return new PaisajesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaisajesViewHolder holder, int position) {

        PaisajeVo paisaje = listaPaisajes.get(position);

        if(Utilities.portrait){
            holder.tvDescrip.setText(paisaje.getInformation());
        }

        holder.tvNombre.setText(paisaje.getNameCity());

        holder.image.setImageResource(paisaje.getImageResource());

    }

    @Override
    public int getItemCount() {
        return listaPaisajes.size();
    }

    // -------------------------------------------------------------
    // Creamos nuestro propio método setOnClickListener para el RecyclerView
    public void setOnClickListenerRecycler(View.OnClickListener listener){
        this.listener = listener;

    }
    // -------------------------------------------------------------

    // Cuando se ejecute el evento de OnClick se llama a otro onClick
    // perteneciente al miembro listener de esta clase Adaptador
    @Override
    public void onClick(View v) {

        if(listener!=null){
            listener.onClick(v);
        }

    }

    public class PaisajesViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre;
        TextView tvDescrip;
        ImageView image;

        View view;

        public PaisajesViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.textView_name);

            if(Utilities.portrait){
                tvDescrip = itemView.findViewById(R.id.textView_descrip);

            }

            image = itemView.findViewById(R.id.imageView_image);
        }
    }
}
