package edufpaiva.com.br.monsters;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.http.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Request.RequestListener {
    private ArrayList<Monstro> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LOG","Achar JSON");
        Log.d("LOG",":3");
        Ocean.newRequest("http://gitlab.oceanmanaus.com/snippets/4/raw", this).get().send();


    }

    @Override
    public void onRequestOk(String s, JSONObject jsonObject, int code) {

        if (code == Request.NENHUM_ERROR) {
            lista = new ArrayList<Monstro>();
            Log.d("LOG","Status conexa NENHUM ERRO");

            if (s != null) {

                Log.d("LOG","Resposta Positiva");
                try {

                    JSONObject object = new JSONObject(s);

                    JSONArray monstros = object.getJSONArray("monstros");
                    Log.d("LOG","Achou Array");

                    for (int i = 0; i < monstros.length(); i++) {
                        JSONObject monstro = monstros.getJSONObject(i);

                        String nome = monstro.getString("nome");
                        String fraqueza = monstro.getString("fraqueza");
                        String forca = monstro.getString("forca");
                        String imagem = monstro.getString("imagem");
                        boolean imortal = monstro.getBoolean("imortal");

                        Monstro m = new Monstro(imagem, nome, imortal, fraqueza, forca);

                        lista.add(m);
                        Log.d("LOG","Monstro Adicionado a lista");

                    }
                    Log.d("lalal", "");
                    criarAdapter(lista);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }


    }


    public void criarAdapter(ArrayList lista) {
        MonsterAdapter adapter = new MonsterAdapter(this, lista);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lista);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d("LOG","Adapter Criado");
    }
}
