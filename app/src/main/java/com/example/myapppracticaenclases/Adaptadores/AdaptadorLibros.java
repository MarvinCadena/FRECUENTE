package com.example.myapppracticaenclases.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapppracticaenclases.Modelos.Libros;
import com.example.myapppracticaenclases.R;


import java.util.ArrayList;

public class AdaptadorLibros extends ArrayAdapter<Libros> {
    public AdaptadorLibros(Context context, ArrayList<Libros> informacion) {
        super(context, R.layout.lista_libros, informacion);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_libros, null);
        TextView lbltitulo = (TextView) item.findViewById(R.id.titulo);
        lbltitulo.setText(getItem(position).getTitulo());
        TextView lblfecha = (TextView) item.findViewById(R.id.fecha);
        lblfecha.setText(getItem(position).getFecha());
        ImageView imageView = (ImageView) item.findViewById(R.id.portada);
        Glide.with(this.getContext())
                .load(getItem(position).getCover())
                .into(imageView);
        return (item);
    }
}

