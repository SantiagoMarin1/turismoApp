package com.santiagomarin.ejemploclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String nombreUsuario, correo;
    TextView tNombre,tContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Bundle extras= getIntent().getExtras();
        nombreUsuario=extras.getString("NombreUsuario");
        correo=extras.getString("Correo");
        tNombre=(TextView) findViewById(R.id.tNombre);
        tContrasena=(TextView) findViewById(R.id.tContrasena);

        tNombre.setText(nombreUsuario);
        tContrasena.setText(correo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menup,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.close:
                Intent intent2 =new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.mperfil:
                Intent intent =new Intent(PerfilActivity.this, MainActivity.class);
                intent.putExtra("NombreUsuario",nombreUsuario);
                intent.putExtra("Correo",correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
