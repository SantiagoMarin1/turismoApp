package com.santiagomarin.ejemploclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, ePassword;
    Button bIniicar;
    TextView tRegistrarse;
    String nombreUsuario,contrasena, correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eUsername =(EditText) findViewById(R.id.eUsername);
        ePassword=(EditText) findViewById(R.id.ePassword);
        bIniicar=(Button)findViewById(R.id.bIniciar);
        tRegistrarse=(TextView) findViewById(R.id.eRegistrarse);

        bIniicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((eUsername.getText().toString().isEmpty()&&(ePassword.getText().toString().isEmpty())))
                {
                    Toast.makeText(getApplicationContext(),"Debe llenar los campos",Toast.LENGTH_SHORT).show();
                }
                if((eUsername.getText().toString().equals(nombreUsuario))&&(ePassword.getText().toString().equals(contrasena)))
                {
                    Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("NombreUsuario",nombreUsuario);
                    intent.putExtra("Correo",correo);
                    startActivity(intent);
                    finish();
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Error al iniciar sesion",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234 && resultCode==RESULT_OK)
        {
            //Bundle extras = getIntent().getExtras();
            nombreUsuario = data.getExtras().getString("NombreUsuario");
            contrasena = data.getExtras().getString("Contrasena");
            correo = data.getExtras().getString("Correo");
            Log.d("NombreUsuario", nombreUsuario);
        }
        else
        {
            if(requestCode==1234 && resultCode== RESULT_CANCELED)
            {
                Toast.makeText(this,"Error en registro",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
