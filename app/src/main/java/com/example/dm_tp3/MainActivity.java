package com.example.dm_tp3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Lugar> lista = new ArrayList<Lugar>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarLugares();
        mostrarLugares();
    }

    private void cargarLugares() {
        lista.add(new Lugar(R.drawable.foto1,"Taj Mahal - India"));
        lista.add(new Lugar(R.drawable.foto2,"Palma de Mallorca - España"));
        lista.add(new Lugar(R.drawable.foto3,"Berlin - Alemania"));
        lista.add(new Lugar(R.drawable.foto4,"Puerto Pirámides - Argentina"));
    }

    private void mostrarLugares() {
        ArrayAdapter<Lugar> adapter = new AdapterLista(this, R.layout.lugar, lista, getLayoutInflater());
        ListView lv = findViewById(R.id.lista);
        lv.setAdapter(adapter);
    }

    private class AdapterLista extends ArrayAdapter<Lugar> {
        private Context context;
        private List<Lugar> lista;
        private LayoutInflater li;

        public AdapterLista(@NonNull Context context, int resource, @NonNull List<Lugar> objects, LayoutInflater li) {
            super(context, resource, objects);
            this.context = context;
            this.lista = objects;
            this.li = li;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View itemView = convertView;

            if (itemView == null) {
                itemView = li.inflate(R.layout.lugar,parent,false);
            }

            Lugar lugar = lista.get(position);

            ImageView foto = itemView.findViewById(R.id.foto);
            foto.setImageResource(lugar.getFoto());

            TextView nombre = itemView.findViewById(R.id.nombre);
            nombre.setText(lugar.getNombre());

            return itemView;
        }
    }
}
