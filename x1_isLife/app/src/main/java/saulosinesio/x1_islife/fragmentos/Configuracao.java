package saulosinesio.x1_islife.fragmentos;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulosinesio.x1_islife.R;

public class Configuracao extends Fragment {

    // Criando Shared Preferences.
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.configuracao, container, false);


        return view;
    }
}
