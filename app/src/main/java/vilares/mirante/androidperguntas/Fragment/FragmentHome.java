package vilares.mirante.androidperguntas.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import vilares.mirante.androidperguntas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    RecyclerView rv;
    View v;
    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        rv = v.findViewById(R.id.rv_jogos);

        rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("jogo1");
        strings.add("jogo2");
        strings.add("jogo3");

        rv.setAdapter(new AAJogo(strings));



        return v;
    }


    public class AAJogo extends RecyclerView.Adapter<AAJogo.VHJogo>{

        ArrayList<String> strings;

        public AAJogo(ArrayList<String> strings) {
            this.strings = strings;
        }

        @NonNull
        @Override
        public VHJogo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.cv_jogo,parent,false);
            return new VHJogo(v);
        }

        @Override
        public void onBindViewHolder(@NonNull VHJogo holder, int position) {

        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        public class VHJogo extends RecyclerView.ViewHolder{


            public VHJogo(View itemView) {
                super(itemView);
            }
        }
    }

}
