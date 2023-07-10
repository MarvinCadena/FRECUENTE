package com.example.myapppracticaenclases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapppracticaenclases.Adaptadores.AdaptadorUsuario;
import com.example.myapppracticaenclases.Modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {
    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.lstListaUsuario);
        View header = getLayoutInflater().inflate(R.layout.lyheaderusuarios, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Usuario> lstUsuarios = Usuario.JsonObjectsBuild(jsonArray);
        AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(this, lstUsuarios);
        lstOpciones.setAdapter(adaptadorUsuario);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Usuario usuario = (Usuario) adapterView.getItemAtPosition(position);
        if (position== 1) {
            int a = 3;
            Bundle b = new Bundle();
            b.putInt("ID", a);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 2) {
            int d = 2;
            Bundle b = new Bundle();
            b.putInt("ID", d);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 3) {
            int c = 1;
            Bundle b = new Bundle();
            b.putInt("ID", c);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
    }
}