package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton addButao;
    private static final String[] COUNTRIES= new String[]{
        "Antonio", "Bruno", "José Franciso","João Marcos", "Wallesson"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButao = (ImageButton) findViewById(R.id.addButao);


        final ListView lista = (ListView)findViewById(R.id.lstClientes);
        final ArrayList<String> clientes = Dados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,clientes);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Pessoa: " + clientes.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, COUNTRIES);
        editText.setAdapter(adapter);

        RadioButton sel1 = (RadioButton)findViewById(R.id.se1);
        RadioButton sel2 = (RadioButton)findViewById(R.id.sel2);
        sel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selecionado: Campo 1",Toast.LENGTH_SHORT).show();
            }
        });

        sel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selecionado: Campo 2",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<String> Dados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Antonio");
        dados.add("Bruno");
        dados.add("Wallesson Cavalcante");
        dados.add("José Francisco");
        dados.add("João Marcos");
        return dados;
    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent(this,ActCadClientes.class);
        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
