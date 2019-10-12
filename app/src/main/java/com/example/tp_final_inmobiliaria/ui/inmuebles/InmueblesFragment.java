package com.example.tp_final_inmobiliaria.ui.inmuebles;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tp_final_inmobiliaria.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;

import java.util.ArrayList;

public class InmueblesFragment extends Fragment {

    private InmueblesViewModel inmueblesViewModel;
    private ArrayList<Inmueble> lista = new ArrayList<>();
    private ListView lv;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        cargarDatos();
       inmueblesViewModel =
                ViewModelProviders.of(this).get(InmueblesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inmueble, container, false);
        final ListView lv = root.findViewById(R.id.listInmuebles);

        ArrayAdapter<Inmueble>  adapter = new InmuebleAdapter(getContext(), R.layout.inmueble_item, lista, getLayoutInflater());
        lv.setAdapter(adapter);
        lv.setClickable(true);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Inmuebles");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), InmuebleActivity.class);
                intent.putExtra("posicion", lista.get(i));
                startActivity(intent);
            }
        });

        return root;

    }

    public void cargarDatos(){
        lista.add(new Inmueble(R.drawable.casa1,"Gral Paz 148, Villa Mercedes", 8000, " Casa antigua con galeria, Living comedor, 3 dormitorios, cocina y comedor diario, , Patio y fondo libre.","casa"));
        lista.add(new Inmueble(R.drawable.casa2,"San Martin 789, Villa Mercedes", 11400, "Casa con Hall de ingreso, recepción, 3 dormitorios, sala de estar, cocina, 2 baños, patio con escalera a altillo.","casa"));
        lista.add(new Inmueble(R.drawable.casa3,"Buenos Aires 23, Villa Mercedes", 9500, "Casa con living comedor, 3 habitación con baño, cocina, 2 pieza en el fondo con baño y 2 terrazas con una pieza de servicio y 2 , uno con lavadero y churrasquera","casa"));
    }
}