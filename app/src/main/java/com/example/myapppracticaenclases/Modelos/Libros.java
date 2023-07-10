package com.example.myapppracticaenclases.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Libros {
    private String cover;
    private String fecha;
    private String titulo;


    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Libros(JSONObject a) throws JSONException {
        cover = a.getString("cover").toString();
        fecha = a.getString("date_published").toString() ;
        titulo = a.getString("title").toString() ;

    }
    public static ArrayList<Libros> JsonObjectsBuild(JSONArray informacion) throws JSONException {
        ArrayList<Libros> libros = new ArrayList<>();
        for (int i = 0; i < informacion.length() && i<20; i++) {
            libros.add(new Libros(informacion.getJSONObject(i)));
        }
        return libros;
    }


}
