package com.example.masterdetailpettern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IComunicaFragmentsListener{

    ListaPaisajesFragment listaPaisajesFragment;
    DetallePaisajeFragment detallePaisajeFragment;

    DetallePaisajeFragment flagDetallePaisajeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.contenedorFragm)!=null){

            Utilities.portrait = true;
            if (savedInstanceState!=null){
                // Si la instancia existe no hacemos nada y carga por defecto
                // la pantalla dividida.
                Toast.makeText(this,"instance isn't null",Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(this,"instance is null",Toast.LENGTH_SHORT).show();
            }
            // Si queda cargado un fragment en modo portrait se queda reemplazado
            // y cuando se pasa a modo landscape se muestra la pantalla dividida
            Toast.makeText(this,"load list",Toast.LENGTH_SHORT).show();
            listaPaisajesFragment = new ListaPaisajesFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedorFragm,listaPaisajesFragment)
                    .commit();

        } else {
            Utilities.portrait = false;
        }

    }

    @Override
    public void enviarPaisaje(PaisajeVo paisaje) {

        detallePaisajeFragment = (DetallePaisajeFragment) this.getSupportFragmentManager()
                .findFragmentById(R.id.fragmentDetails);
        Toast.makeText(this,(detallePaisajeFragment!=null)+"",Toast.LENGTH_SHORT).show();

        if(detallePaisajeFragment!=null && findViewById(R.id.contenedorFragm)==null){
            detallePaisajeFragment.asignarInformacion(paisaje);

        } else {

            flagDetallePaisajeFragment = (DetallePaisajeFragment)
                    this.getSupportFragmentManager().findFragmentById(R.id.fragmentDetails);
            Toast.makeText(this,(detallePaisajeFragment!=null)+"",Toast.LENGTH_SHORT).show();

            detallePaisajeFragment = new DetallePaisajeFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("objeto",paisaje);

            detallePaisajeFragment.setArguments(bundleEnvio);

            // Load fragment in Activity
            // Si queda cargado un fragment en modo portrait se queda reemplazado
            // y cuando se pasa a modo landscape se muestra la pantalla dividida
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedorFragm,detallePaisajeFragment)
                    .addToBackStack(null)
                    .commit();


        }

    }
}
