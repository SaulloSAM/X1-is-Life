package saulosinesio.x1_islife;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import saulosinesio.x1_islife.classes.Singleton;
import saulosinesio.x1_islife.fragmentos.Batalha;
import saulosinesio.x1_islife.fragmentos.Configuracao;
import saulosinesio.x1_islife.fragmentos.DadosDoUsuario;
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

        sharedPreferences = getSharedPreferences("isLife", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String nome = sharedPreferences.getString("planeswlaker", "");

        if(nome.equals("")) {
            // Trocando o Fragmetno -> Dados do Usuário
            DadosDoUsuario fragmento = new DadosDoUsuario();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, fragmento).commit();
            return;
        } else {
            iniciandoSinglenton();
            // Trocando o Fragmetno -> Batalha
            Batalha fragmento = new Batalha();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, fragmento).commit();
            return;
        }
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mini_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.acao_deletar){
            Configuracao frag = new Configuracao();
            getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, frag).commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void iniciandoSinglenton () {
        // Pegando Dados dos Adiversários.
        String planeswlaker = sharedPreferences.getString("planeswlaker", "Jogador");
        int placar01_P = sharedPreferences.getInt("placar01_p", 0);
        int placar02_P = sharedPreferences.getInt("placar02_p", 0);
        int placar03_P = sharedPreferences.getInt("placar03_p", 0);

        String adversario01 = sharedPreferences.getString("jogador01", "Adversário 01");
        int placar01 = sharedPreferences.getInt("placar01", 0);

        String adversario02 = sharedPreferences.getString("jogador02", "Adversário 02");
        int placar02 = sharedPreferences.getInt("placar02", 0);

        String adversario03 = sharedPreferences.getString("jogador03", "Adversário 03");
        int placar03 = sharedPreferences.getInt("placar03", 0);

        // Criando Singleton.
        Singleton.getInstance().planeswlaker.setJogador(planeswlaker);
        Singleton.getInstance().planeswlaker.setPlacar(placar01_P);
        Singleton.getInstance().planeswlaker.setPlacar02(placar02_P);
        Singleton.getInstance().planeswlaker.setPlacar03(placar03_P);

        Singleton.getInstance().jogador01.setJogador(adversario01);
        Singleton.getInstance().jogador01.setPlacar(placar01);

        Singleton.getInstance().jogador02.setJogador(adversario02);
        Singleton.getInstance().jogador02.setPlacar(placar02);

        Singleton.getInstance().jogador03.setJogador(adversario03);
        Singleton.getInstance().jogador03.setPlacar(placar03);
    }
}
