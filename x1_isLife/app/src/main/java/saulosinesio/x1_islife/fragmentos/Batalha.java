package saulosinesio.x1_islife.fragmentos;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import saulosinesio.x1_islife.R;
import saulosinesio.x1_islife.classes.Singleton;

import static android.content.Context.MODE_PRIVATE;


public class Batalha extends Fragment {

    // Globais
    private TextView tvJ1, tvJ2, tvV1, tvV2, tvPlacarJ1, tvPlacarJ2, tvPlacarV1, tvPlacarV2;
    private Button btnVitoria, btnDerrota, btnMaisJ1, btnMenosJ1, btnMais5J1, btnMenos5J1, btnMaisJ2, btnMenosJ2, btnMais5J2, btnMenos5J2;
    private int placar01, placar02;

    // Criando Shared Preferences.
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.batalha, container, false);

        binding(view); // Binding XML

        sharedPreferences = getActivity().getSharedPreferences("isLife", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        placar01 = sharedPreferences.getInt("placar01_P", 0);
        placar02 = sharedPreferences.getInt("placar01", 0);

        // Iniciando Batalha
        tvJ1.setText(Singleton.getInstance().planeswlaker.getJogador());
        tvPlacarJ1.setText(Singleton.getInstance().planeswlaker.getJogador());
        tvV1.setText("20");
        tvPlacarV1.setText(Integer.toString(placar01));

        tvJ2.setText(Singleton.getInstance().jogador01.getJogador());
        tvPlacarJ2.setText(Singleton.getInstance().jogador01.getJogador());
        tvV2.setText("20");
        tvPlacarV2.setText(Integer.toString(placar02));

        // Ações dos Botões
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) { btnOnClick(v.getId()); }
        };

        // Listener Botão Ação
        btnVitoria.setOnClickListener(listener);
        btnDerrota.setOnClickListener(listener);

        // Listener Jogador
        btnMaisJ1.setOnClickListener(listener);
        btnMais5J1.setOnClickListener(listener);
        btnMenosJ1.setOnClickListener(listener);
        btnMenos5J1.setOnClickListener(listener);

        // Listener Adversário
        btnMaisJ2.setOnClickListener(listener);
        btnMais5J2.setOnClickListener(listener);
        btnMenosJ2.setOnClickListener(listener);
        btnMenos5J2.setOnClickListener(listener);
        return view;
    }

    /**
     * Fazer um Bind do XML
     * @param view
     */
    private void binding (View view) {
        // Botão App
        btnVitoria = view.findViewById(R.id.btnVitoria);
        btnDerrota = view.findViewById(R.id.btnDerrota);

        // Jogador
        tvJ1 = view.findViewById(R.id.tvJ1);
        tvV1 = view.findViewById(R.id.tvV1);
        tvPlacarJ1 = view.findViewById(R.id.tvPlacarJ1);
        tvPlacarV1 = view.findViewById(R.id.tvPlacarV1);
        btnMaisJ1 = view.findViewById(R.id.btnMaisJ1);
        btnMais5J1 = view.findViewById(R.id.btnMais5J1);
        btnMenosJ1 = view.findViewById(R.id.btnMenosJ1);
        btnMenos5J1 = view.findViewById(R.id.btnMenos5J1);

        // Adversário
        tvJ2 = view.findViewById(R.id.tvJ2);
        tvV2 = view.findViewById(R.id.tvV2);
        tvPlacarJ2 = view.findViewById(R.id.tvPlacarJ2);
        tvPlacarV2 = view.findViewById(R.id.tvPlacarV2);
        btnMaisJ2 = view.findViewById(R.id.btnMaisJ2);
        btnMais5J2 = view.findViewById(R.id.btnMais5J2);
        btnMenosJ2 = view.findViewById(R.id.btnMenosJ2);
        btnMenos5J2 = view.findViewById(R.id.btnMenos5J2);
    }

    /**
     * Efetuar uma ação referente ao id do botão.
     * @param id
     */
    private void btnOnClick (int id) {
        // Ações do Jogador
        if(id == btnMaisJ1.getId()){
            int vidaAtual = Integer.parseInt(tvV1.getText().toString());
            tvV1.setText(Integer.toString( vidaAtual + 1 ));
            return;
        }

        if(id == btnMais5J1.getId()){
            int vidaAtual = Integer.parseInt(tvV1.getText().toString());
            tvV1.setText(Integer.toString( vidaAtual + 5 ));
            return;
        }

        if(id == btnMenosJ1.getId()){
            int vidaAtual = Integer.parseInt(tvV1.getText().toString());
            tvV1.setText(Integer.toString( vidaAtual - 1 ));
            return;
        }

        if(id == btnMenos5J1.getId()){
            int vidaAtual = Integer.parseInt(tvV1.getText().toString());
            tvV1.setText(Integer.toString( vidaAtual - 5 ));
            return;
        }

        // Ações do Adiversário
        if(id == btnMaisJ2.getId()){
            int vidaAtual = Integer.parseInt(tvV2.getText().toString());
            tvV2.setText(Integer.toString( vidaAtual + 1 ));
            return;
        }

        if(id == btnMais5J2.getId()){
            int vidaAtual = Integer.parseInt(tvV2.getText().toString());
            tvV2.setText(Integer.toString( vidaAtual + 5 ));
            return;
        }

        if(id == btnMenosJ2.getId()){
            int vidaAtual = Integer.parseInt(tvV2.getText().toString());
            tvV2.setText(Integer.toString( vidaAtual - 1 ));
            return;
        }

        if(id == btnMenos5J2.getId()){
            int vidaAtual = Integer.parseInt(tvV2.getText().toString());
            tvV2.setText(Integer.toString( vidaAtual - 5 ));
            return;
        }

        // Ações Botões
        if(id == btnVitoria.getId()){
            placar01 += 1;
            editor.putInt("placar01_P", placar01);
            editor.apply();
            tvPlacarV1.setText(Integer.toString(placar01));
            tvV1.setText(Integer.toString(20));
            tvV2.setText(Integer.toString(20));
            return;
        }

        if(id == btnDerrota.getId()){
            placar02 += 1;
            editor.putInt("placar02", placar02);
            editor.apply();
            tvPlacarV2.setText(Integer.toString(placar02));
            tvV1.setText(Integer.toString(20));
            tvV2.setText(Integer.toString(20));
            return;
        }
    }
}
