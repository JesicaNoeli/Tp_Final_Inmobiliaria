package com.example.tp_final_inmobiliaria.ui.inmuebles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp_final_inmobiliaria.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;

public class InmuebleActivity extends AppCompatActivity {

    private ImageView fotoGrande;
    private TextView txtDescripcion;
    private TextView txtDireccion;
    private TextView txtPrecio;
    private TextView txtTipo;
    private Switch disponible;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmueble);
        fotoGrande=findViewById(R.id.fotoGrande);
        txtDescripcion=findViewById(R.id.textDescripcion);
        txtDireccion=findViewById(R.id.textDireccion);
        txtPrecio=findViewById(R.id.textPrecio1);
        txtTipo=findViewById(R.id.textTipo);
        disponible=findViewById(R.id.switchDisponible);
        getSupportActionBar().setTitle("Propiedad");
        Intent x= getIntent();
        Inmueble casa = (Inmueble) x.getSerializableExtra("posicion");

        fotoGrande.setImageResource(casa.getFoto());
        txtDescripcion.setText(casa.getDescripcion());
        txtPrecio.setText(casa.getPrecio()+"");
        txtDireccion.setText(casa.getDireccion());
        txtTipo.setText(casa.getTipo());

       disponible.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(disponible.isChecked()){
                   Toast.makeText(getApplicationContext(),"La propiedad cambio a disponible",Toast.LENGTH_LONG).show();
               }else{Toast.makeText(getApplicationContext(),"La propiedad cambio a no disponible",Toast.LENGTH_LONG).show();}
           }
       });
        }
    }
