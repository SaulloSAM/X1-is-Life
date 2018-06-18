package saulosinesio.x1_islife.fragmentos;

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

public class DadosDoUsuario extends Fragment {

    private EditText etPlaneswalker;
    private Button btnProximo, btnFechar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dados_do_usuario, container, false);

        // Binding XML
        etPlaneswalker = view.findViewById(R.id.etPlaneswalker);
        btnProximo = view.findViewById(R.id.btnProximo);
        btnFechar = view.findViewById(R.id.btnFechar);

        // Listener Botão Próximo.
        View.OnClickListener proximo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String nome = etPlaneswalker.getText().toString().trim();

            if(!nome.equals("")){
                // Criando Shared Preferences.
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("isLife", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // Salvando Jogadores.
                editor.putString("planeswlaker", nome);
                editor.putInt("placar01_P", 0);
                editor.putInt("placar02_P", 0);
                editor.putInt("placar03_P", 0);
                editor.apply();

                Singleton.getInstance().planeswlaker.setJogador(nome);
                Singleton.getInstance().planeswlaker.setPlacar(0);
                Singleton.getInstance().planeswlaker.setPlacar02(0);
                Singleton.getInstance().planeswlaker.setPlacar03(0);


                // Trocando Fragmento
                DadosDosJogadores fragmento = new DadosDosJogadores();
                getFragmentManager().beginTransaction().replace(R.id.frameMain, fragmento).commit();
            } else {
                Toast toast = Toast.makeText(DadosDoUsuario.super.getContext(), "O nome do Planeswalker não foi definido!", Toast.LENGTH_LONG);
                toast.show();
                return;
            }
            }
        };
        btnProximo.setOnClickListener(proximo);

        // Listener Botão Fechar.
        View.OnClickListener fechar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fechar aplicação
                getActivity().finish();
                return;
            }
        };
        btnFechar.setOnClickListener(fechar);

        return view;
    }
}
