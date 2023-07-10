package com.example.myapppracticaenclases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myapppracticaenclases.Adaptadores.AdaptadorLibros;
import com.example.myapppracticaenclases.Modelos.Libros;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity2 extends AppCompatActivity implements Asynchtask {
    ListView Lstlibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle  = this.getIntent().getExtras();
        Lstlibros = (ListView)findViewById(R.id.lista_libro);
        View header = getLayoutInflater().inflate(R.layout.lyheaderusuarios,null);
        Lstlibros.addHeaderView(header);
        int a = bundle.getInt("ID");
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=" + a;
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(url, datos, MainActivity2.this, MainActivity2.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Libros> lstUsuarios = Libros.JsonObjectsBuild(jsonArray);
        AdaptadorLibros adaptadorLibros = new AdaptadorLibros(this, lstUsuarios);
        Lstlibros.setAdapter(adaptadorLibros);

    }
}