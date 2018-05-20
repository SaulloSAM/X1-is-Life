package saulosinesio.x1_islife.fragmentos;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import saulosinesio.x1_islife.R;
import saulosinesio.x1_islife.classes.Singleton;

import static android.content.Context.MODE_PRIVATE;

public class DadosDosJogadores extends Fragment {

    private EditText etJogador01, etJogador02;
    private Button btnRegistrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dados_dos_jogadores, container, false);

        etJogador01 = view.findViewById(R.id.etJogador01);
        etJogador02 = view.findViewById(R.id.etJogador02);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jogador01 = etJogador01.getText().toString().trim();
                String jogador02 = etJogador02.getText().toString().trim();

                // Validando entrada do usuário.
                if(!jogador01.equals("") && !jogador02.equals("")){
                    // Criando Shared Preferences.
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("jogadoresMTG", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    // Salvando Jogadores.
                    editor.putString("jogador01", jogador01);
                    editor.putString("jogador02", jogador02);
                    editor.putInt("placar01", 0);
                    editor.putInt("placar02", 0);
                    editor.apply();

                    Singleton.getInstance().jogador01.setJogador(jogador01);
                    Singleton.getInstance().jogador02.setJogador(jogador02);
                    Singleton.getInstance().jogador01.setPlacar(0);
                    Singleton.getInstance().jogador02.setPlacar(0);

                    // Carregar Batalha
                    Batalha fragmento = new Batalha();
                    getFragmentManager().beginTransaction().replace(R.id.frameMain, fragmento).commit();
                } else {
                    // Erro
                    Toast toast = Toast.makeText(DadosDosJogadores.super.getContext(), "Atenção!!! Defina o nome de todos os jogadores.", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
            }
        };
        btnRegistrar.setOnClickListener(listener);
        return view;
    }

}
