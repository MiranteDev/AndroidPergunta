package vilares.mirante.androidperguntas.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vilares.mirante.androidperguntas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPergunta extends Fragment {


    public FragmentPergunta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_pergunta, container, false);
    }

}
