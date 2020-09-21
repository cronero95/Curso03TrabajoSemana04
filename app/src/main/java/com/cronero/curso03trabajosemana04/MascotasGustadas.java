package com.cronero.curso03trabajosemana04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cronero.curso03trabajosemana04.adapter.MascotasGustadasAdaptador;
import com.cronero.curso03trabajosemana04.pojo.Mascota;

import java.util.ArrayList;

public class MascotasGustadas extends AppCompatActivity {

    private Toolbar toolbar;
    private ArrayList<Mascota> mascotasGustadas;
    private RecyclerView listaMascotasGustadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gustadas_mascotas);

        toolbar = findViewById(R.id.miActionBarBack);

        listaMascotasGustadas = findViewById(R.id.rvMascotasGustadas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasGustadas.setLayoutManager(llm);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        inicializarListaMascotasGustadas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotasGustadas(){
        mascotasGustadas = new ArrayList<>();

        mascotasGustadas.add(new Mascota(R.drawable.bulldog, R.drawable.corazonperrolike, "Lucky"));
        mascotasGustadas.add(new Mascota(R.drawable.husky, R.drawable.corazonperrolike, "Snow"));
        mascotasGustadas.add(new Mascota(R.drawable.labrador, R.drawable.corazonperrolike, "Buddy"));
        mascotasGustadas.add(new Mascota(R.drawable.pastor, R.drawable.corazonperrolike, "Lucy"));
        mascotasGustadas.add(new Mascota(R.drawable.sharpei, R.drawable.corazonperrolike, "Molly"));
    }

    public void inicializarAdaptador(){
        MascotasGustadasAdaptador adaptador = new MascotasGustadasAdaptador(mascotasGustadas);
        listaMascotasGustadas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_secundario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_contacto:
                Intent intent02 = new Intent(this, Contacto.class);
                startActivity(intent02);
                break;

            case R.id.menu_acerca:
                Intent intent03 = new Intent(this, Acerca.class);
                startActivity(intent03);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}