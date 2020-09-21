package com.cronero.curso03trabajosemana04.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cronero.curso03trabajosemana04.R;
import com.cronero.curso03trabajosemana04.adapter.MascotaAdaptador;
import com.cronero.curso03trabajosemana04.adapter.MascotaPerfilAdaptador;
import com.cronero.curso03trabajosemana04.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> misFotos;
    private String[] listaMascotas;
    private TextView textoNombreMascota;
    private RecyclerView fotosMascota;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = getResources().getStringArray(R.array.nombres_cachorros);
        textoNombreMascota = v.findViewById(R.id.textoNombreMascota);
        fotosMascota = v.findViewById(R.id.rvMascotaPerfil);

        textoNombreMascota.setText(listaMascotas[2]);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        fotosMascota.setLayoutManager(glm);

        inicializarMisFotos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarMisFotos(){
        misFotos = new ArrayList<>();

        misFotos.add(new Mascota(R.drawable.snow_01));
        misFotos.add(new Mascota(R.drawable.snow_02));
        misFotos.add(new Mascota(R.drawable.snow_03));
        misFotos.add(new Mascota(R.drawable.snow_04));
        misFotos.add(new Mascota(R.drawable.snow_05));
        misFotos.add(new Mascota(R.drawable.snow_06));
        misFotos.add(new Mascota(R.drawable.snow_07));
    }

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(misFotos);
        fotosMascota.setAdapter(adaptador);
    }
}