package saulosinesio.x1_islife.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import saulosinesio.x1_islife.R;
import saulosinesio.x1_islife.classes.Singleton;


public class Batalha extends Fragment {

    private TextView tvJ1, tvJ2, tvV1, tvV2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.batalha, container, false);

        tvJ1 = view.findViewById(R.id.tvJ1);
        tvJ2 = view.findViewById(R.id.tvJ2);
        tvV1 = view.findViewById(R.id.tvV1);
        tvV2 = view.findViewById(R.id.tvV2);

        tvJ1.setText(Singleton.getInstance().jogador01.getJogador());
        tvV1.setText(Integer.toString(Singleton.getInstance().jogador01.getPlacar()));

        tvJ2.setText(Singleton.getInstance().jogador02.getJogador());
        tvV2.setText(Integer.toString(Singleton.getInstance().jogador02.getPlacar()));

        return view;
    }
}
