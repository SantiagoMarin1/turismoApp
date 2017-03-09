package com.santiagomarin.ejemploclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nombreUsuario, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras= getIntent().getExtras();
        nombreUsuario=extras.getString("NombreUsuario");
        correo=extras.getString("Correo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.CerrarS:
                Intent intent2 =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.perfil:
                Intent intent =new Intent(MainActivity.this,PerfilActivity.class);
                intent.putExtra("NombreUsuario",nombreUsuario);
                intent.putExtra("Correo",correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
