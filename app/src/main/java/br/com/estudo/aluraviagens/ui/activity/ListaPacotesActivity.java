package br.com.estudo.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.estudo.aluraviagens.R;
import br.com.estudo.aluraviagens.dao.PacoteDAO;
import br.com.estudo.aluraviagens.model.Pacote;
import br.com.estudo.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();



        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}