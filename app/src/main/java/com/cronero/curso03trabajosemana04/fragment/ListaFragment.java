package com.cronero.curso03trabajosemana04.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronero.curso03trabajosemana04.R;
import com.cronero.curso03trabajosemana04.adapter.MascotaAdaptador;
import com.cronero.curso03trabajosemana04.pojo.Mascota;

import java.util.ArrayList;

public class ListaFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private String[] nombreMascota;

    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        nombreMascota = getResources().getStringArray(R.array.nombres_cachorros);
        listaMascotas = v.findViewById(R.id.rvMascotasInicio);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.bulldog, R.drawable.corazonperrolike, nombreMascota[0], "0"));
        mascotas.add(new Mascota(R.drawable.dalmata, R.drawable.corazonperrolike, nombreMascota[1], "0"));
        mascotas.add(new Mascota(R.drawable.husky, R.drawable.corazonperrolike, nombreMascota[2], "0"));
        mascotas.add(new Mascota(R.drawable.labrador, R.drawable.corazonperrolike, nombreMascota[3], "0"));
        mascotas.add(new Mascota(R.drawable.pastor, R.drawable.corazonperrolike, nombreMascota[4], "0"));
        mascotas.add(new Mascota(R.drawable.pitbull, R.drawable.corazonperrolike, nombreMascota[5], "0"));
        mascotas.add(new Mascota(R.drawable.sharpei, R.drawable.corazonperrolike, nombreMascota[6], "0"));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
}