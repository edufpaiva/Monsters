package edufpaiva.com.br.monsters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.glide.GlideRequest;

import java.util.ArrayList;

import static edufpaiva.com.br.monsters.R.id.forca;

/**
 * Created by pc on 16/10/2016.
 */

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.ViewHolder> {


    private final Context context;
    private ArrayList<Monstro> lista;

    public MonsterAdapter(Context context, ArrayList<Monstro> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.monstros, null);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Monstro monstro = lista.get(position);

        holder.
                setFraqueza(monstro.getFraqueza()).
                setImgMostro(monstro.getImgCapa()).
                setNome(monstro.getNome()).
                setImortal(monstro.isImortal()).
                setForca(monstro.getForca());


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMostro;
        private TextView nome;
        private TextView fraqueza;
        private TextView imortal;
        private TextView forca;

        public ViewHolder(View itemView) {
            super(itemView);

            imgMostro = (ImageView) itemView.findViewById(R.id.imagem_monstro);
            nome = (TextView) itemView.findViewById(R.id.nome);
            fraqueza = (TextView) itemView.findViewById(R.id.fraqueza);
            imortal = (TextView) itemView.findViewById(R.id.imortal);
            forca = (TextView) itemView.findViewById(R.id.forca);

        }

        public ViewHolder setImgMostro(String imagem) {
            if (imgMostro == null) return this;
            Ocean.glide(context).load(imagem).build(GlideRequest.BITMAP).resize(150, 150).into(imgMostro);
            return this;
        }

        public ViewHolder setNome(String nome) {
            if (this.nome == null) return this;
            this.nome.setText("Nome:\t"+nome);
            return this;

        }

        public ViewHolder setFraqueza(String fraqueza) {
            if (this.fraqueza == null) return this;
            this.fraqueza.setText("Fraqueza:\t"+fraqueza);
            return this;

        }

        public ViewHolder setImortal(boolean imortal) {
            if (this.imortal == null) return this;
            if (imortal) {
                this.imortal.setText("Imortal:\tSim");

            } else {

                this.imortal.setText("Imortal:\tNão");
            }
            return this;

        }

        public ViewHolder setForca(String forca) {
            if (this.fraqueza == null) return this;
            this.forca.setText("Forca:\t"+forca);
            return this;

        }


    }
}



