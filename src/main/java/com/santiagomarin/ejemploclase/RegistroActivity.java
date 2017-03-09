package com.santiagomarin.ejemploclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eNombreUsuario, eContrasena, eRepeir, eCorreo;
    Button bRegister, bCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eNombreUsuario=(EditText) findViewById(R.id.eNombreUsuario);
        eContrasena=(EditText) findViewById(R.id.eContrasena);
        eRepeir=(EditText) findViewById(R.id.eRepetir);
        eCorreo=(EditText) findViewById(R.id.eCorreo);
        bRegister=(Button) findViewById(R.id.bRegister);
        bCancelar=(Button) findViewById(R.id.bCancelar);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent= new Intent(RegistroActivity.this,LoginActivity.class);
                if(eContrasena.getText().toString().equals(eRepeir.getText().toString())&&(!eNombreUsuario.getText().toString().equals(""))
                        &&(!eContrasena.getText().toString().equals("")))
                {
                    Intent intent= new Intent();
                    intent.putExtra("NombreUsuario",eNombreUsuario.getText().toString());
                    intent.putExtra("Contrasena",eContrasena.getText().toString());
                    intent.putExtra("Correo",eCorreo.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error al registrarse",Toast.LENGTH_SHORT).show();
                }


            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent= new Intent(RegistroActivity.this,LoginActivity.class);
                Intent intent= new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }
}
