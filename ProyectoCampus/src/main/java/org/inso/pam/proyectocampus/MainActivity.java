package org.inso.pam.proyectocampus;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.inso.pam.proyectocampus.Entitys.Nota;
import org.inso.pam.proyectocampus.WSConection.WSHorario;
import org.inso.pam.proyectocampus.WSConection.WSNota;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    Button login;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        login = (Button) findViewById(R.id.btn_logIn);

        /*
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                token = loginToken();
                Intent principal = new Intent(getBaseContext(), PrincipalLandingActivity.class);
                principal.putExtra("token",token);
                startActivity(principal);
                String i;
            }
        });
        */

        /*
        FindAllTask test = new FindAllTask();
        test.execute();*/

        /*
        InsertTask insert = new InsertTask();
        insert.execute();*/

        /*
        UpdateTask update = new UpdateTask();
        update.execute();*/

        DeleteTask delete = new DeleteTask();
        delete.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    private String loginToken() {
        return "1234";
    }

    class FindAllTask extends AsyncTask<Void, Void, ArrayList> {
        @Override
        protected ArrayList doInBackground(Void... voids) {
            WSHorario hor = new WSHorario();
            WSNota not = new WSNota();

            Log.i("Start", "Testing");
            //hor.findAllMethod();
            not.findAllMethod();
            return null;
        }
    }

    class InsertTask extends AsyncTask<Void, Void, ArrayList> {
        @Override
        protected ArrayList doInBackground(Void... voids) {
            WSHorario hor = new WSHorario();
            WSNota not = new WSNota();
            //boolean resp = hor.insertMethod(new Horario(13,3,"Viernes", "09:00", "2013/11/08","Laboratorio1", "2013/11/08","14:00"));
            boolean resp = not.insertMethod(new Nota(1,5,"2013/11/09", "15"));
            Context context = getApplicationContext();
            String mensaje;
            if(resp) {
                mensaje = "Insertado";
                Log.i("Funciono", "Yeahhhhhhhhhh");
            }
            else {
                Log.e("Error", "¿?");
                mensaje = "Error";
            }
            //Toast toast = Toast.makeText(context, mensaje, Toast.LENGTH_LONG);
            //toast.show();
            return null;
        }
    }

    class UpdateTask extends AsyncTask<Void, Void, ArrayList> {

        @Override
        protected ArrayList doInBackground(Void... voids) {
            WSNota not = new WSNota();
            boolean resp = not.updateMethod(new Nota(3,1,5,"2013/11/10", "20"));
            if(resp) {
                Log.i("It Wotks!", "XD!");
            }
            else {
                Log.e("Error", "¿?");
            }

            return null;
        }
    }

    class DeleteTask extends AsyncTask<Void, Void, ArrayList> {

        @Override
        protected ArrayList doInBackground(Void... voids) {
            WSNota not = new WSNota();
            boolean resp = not.deleteMethod(3);

            if(resp) {
                Log.i("It Wotks!", "XD!");
            }
            else {
                Log.e("Error", "¿?");
            }
            return null;
        }
    }
}