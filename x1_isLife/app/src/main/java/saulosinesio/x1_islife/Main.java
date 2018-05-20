package saulosinesio.x1_islife;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import saulosinesio.x1_islife.classes.Singleton;
import saulosinesio.x1_islife.fragmentos.Batalha;
import saulosinesio.x1_islife.fragmentos.DadosDosJogadores;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Criando Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences("jogadoresMTG", MODE_PRIVATE);

        // Verificando se já existe jogadores no APP.
        String temJodadore01 = sharedPreferences.getString("jogador01", null);
        String temJodadore02 = sharedPreferences.getString("jogador02", null);
        int temPlacar01 = sharedPreferences.getInt("placar01", 0);
        int temPlacar02 = sharedPreferences.getInt("placar02", 0);


        if(temJodadore01 != null && temJodadore02 != null){
            Singleton.getInstance().jogador01.setJogador(temJodadore01);
            Singleton.getInstance().jogador02.setJogador(temJodadore02);
            Singleton.getInstance().jogador01.setPlacar(temPlacar01);
            Singleton.getInstance().jogador02.setPlacar(temPlacar02);

            // Carregar Batalha
            Batalha fragmento = new Batalha();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, fragmento).commit();
        } else {
            DadosDosJogadores fragmento = new DadosDosJogadores();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, fragmento).commit();
        }
    }
}
