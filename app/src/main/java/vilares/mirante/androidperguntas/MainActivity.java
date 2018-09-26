package vilares.mirante.androidperguntas;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.eunainter.r2std2oid.RequestR2D2;
import net.eunainter.r2std2oid.Skyrunner;

import java.util.List;

import vilares.mirante.androidperguntas.Fragment.FragmentHome;
import vilares.mirante.androidperguntas.Service.RestConnect;

public class MainActivity extends AppCompatActivity {


    FrameLayout frameLayout;

    RestConnect restConnect;

    FragmentHome fragmentHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentHome = new FragmentHome();

        setFragment(fragmentHome);

        restConnect = new RestConnect("", RequestR2D2.GET,null);



    }

    public class get extends AsyncTask<String,Integer,Integer> {
        @Override
        protected void onPreExecute(){
            //Codigo

            restConnect = new RestConnect("http://ip:porta/", RequestR2D2.POST,null);
        }
        @Override
        protected Integer doInBackground(String... params) {

            while (!restConnect.isFinish()){}
            return 1;
        }
        @Override
        protected void onPostExecute(Integer numero){
            if(numero==1){
                System.out.println(restConnect.getJsonArray().toString());
                incendioArrayList = new Gson().fromJson(restConnect.getJsonArray().toString(),new TypeToken<List<Incendio>>(){}.getType());
            }
            carregarmap();

            //Codigo
        }


    }


    private void setFragment(Fragment fragment){

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }
}
