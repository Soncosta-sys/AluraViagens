package br.com.estudo.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.List;

import br.com.estudo.aluraviagens.R;
import br.com.estudo.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){

        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {

        return pacotes.size();
    }

    @Override
    public Object getItem(int posicao) {

        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = ResourcesCompat.getDrawable(resources, idDoDrawable, null);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = "";
        int quantidadeDeDias = pacote.getDias();

        if(quantidadeDeDias > 1){
            diasEmTexto = quantidadeDeDias + " dias";
        } else {
            diasEmTexto = quantidadeDeDias + " dia";
        }

        dias.setText(diasEmTexto);

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        preco.setText(pacote.getPreco().toString());


        return viewCriada;
    }
}
