package com.example.tp_final_inmobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp_final_inmobiliaria.ui.perfil.Propietario;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;
    private EditText usuario;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.iniciar);
        usuario = findViewById(R.id.editMail);
        password = findViewById(R.id.editPass);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            // Equivalente a crear una clase que implemente la interfaz y luego enviar el objeto de la misma como parametro
            @Override
            public void onClick(View view) {

                Propietario propietario = new Propietario("admin","admin@admin.com","admin");

                if(usuario.getText().toString().equals(propietario.getEmail()) && password.getText().toString().equals(propietario.getPassword())) {

                    Intent i = new Intent(getApplicationContext(), NavigationActivity.class);
                    i.putExtra("nombre", propietario.getNombre());
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(),"Email y/o contraseña incorrecto",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
