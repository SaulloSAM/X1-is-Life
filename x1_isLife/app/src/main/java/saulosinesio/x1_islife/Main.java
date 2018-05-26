package saulosinesio.x1_islife;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import saulosinesio.x1_islife.classes.Singleton;
import saulosinesio.x1_islife.fragmentos.Batalha;
import saulosinesio.x1_islife.fragmentos.DadosDosJogadores;

public class Main extends AppCompatActivity {

    // Criando Shared Preferences
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Manter a tela ligada.
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        sharedPreferences = getSharedPreferences("jogadoresMTG", MODE_PRIVATE);
        editor = sharedPreferences.edit();

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

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mini_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.acao_deletar){
            // Salvando Jogadores.
            editor.putString("jogador01", null);
            editor.putString("jogador02", null);
            editor.putInt("placar01", 0);
            editor.putInt("placar02", 0);
            editor.apply();

            DadosDosJogadores fragmento = new DadosDosJogadores();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, fragmento).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
