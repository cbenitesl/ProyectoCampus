package org.inso.pam.proyectocampus.WSConection;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.inso.pam.proyectocampus.Entitys.Curso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 6/11/13.
 */
public class WSCurso implements WSCliente {

    private String Rest_URL = "inso.pam.es.curso";

    @Override
    public List findAllMethod() {
        ArrayList<org.inso.pam.proyectocampus.Entitys.Curso> cursos = new ArrayList<org.inso.pam.proyectocampus.Entitys.Curso>();

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpGet httpGet = new HttpGet(URLServer + Rest_URL);
        httpGet.setHeader("Accept", "application/json");

        try {
            HttpResponse response = client.execute(httpGet, httpContext);
            StatusLine statusLine = response.getStatusLine();

            if(statusLine.getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));

                String line;
                StringBuilder stringBuilder = new StringBuilder();

                while((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }

                JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                JSONArray jsonArray = null;
                JSONObject jsonO = null;

                try {
                    jsonArray = jsonObject.getJSONArray("curso");
                }
                catch (JSONException e) {
                    jsonO = jsonObject.getJSONObject("curso");
                }

                int nCurId, nCurEstado;
                String cCurNombre, cCurTipo;

                if(jsonArray == null) {
                    nCurId = jsonO.getInt("NAsiId");
                    cCurNombre = jsonO.getString("CCurNombre");
                    cCurTipo = jsonO.getString("CCurTipo");
                    nCurEstado = jsonO.getInt("NCurEstado");

                    cursos.add(new org.inso.pam.proyectocampus.Entitys.Curso(nCurId, cCurNombre, cCurTipo, nCurEstado));
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        jsonO = jsonArray.getJSONObject(i);
                        nCurId = jsonO.getInt("NAsiId");
                        cCurNombre = jsonO.getString("CCurNombre");
                        cCurTipo = jsonO.getString("CCurTipo");
                        nCurEstado = jsonO.getInt("NCurEstado");

                        cursos.add(new Curso(nCurId, cCurNombre, cCurTipo, nCurEstado));
                    }
                }
            }
            else {
                Log.i("STATUS = ", String.valueOf(statusLine.getStatusCode()));
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR ClienteProtocol", e.getMessage());
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
        }

        return null;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object curso) {
        return false;
    }

    @Override
    public boolean deleteMethod(int id) {
        return false;
    }

    @Override
    public boolean updateMethod(Object curso) {
        return false;
    }
}
