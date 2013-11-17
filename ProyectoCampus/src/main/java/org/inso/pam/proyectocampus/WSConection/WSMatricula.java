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
import org.inso.pam.proyectocampus.Entitys.Matricula;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 10/11/13.
 */
public class WSMatricula implements WSCliente {

    private String Rest_URL = "inso.pam.es.matricula";

    @Override
    public List findAllMethod() {
        ArrayList<Matricula> matriculas = new ArrayList<Matricula>();

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpGet httpGet = new HttpGet(URLServer + Rest_URL);
        httpGet.setHeader("Accept", "application/json");

        try {
            HttpResponse httpResponse = client.execute(httpGet, httpContext);
            StatusLine statusLine = httpResponse.getStatusLine();

            if(statusLine.getStatusCode() == 200) {
                HttpEntity entity = httpResponse.getEntity();
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));

                String line;
                StringBuilder builder = new StringBuilder();

                while((line = br.readLine()) != null) {
                    builder.append(line);
                }
                String response = builder.toString();

                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray jsonArray = null;
                JSONObject jsonO = null;

                try {
                    jsonArray = jsonObject.getJSONArray("matricula");
                }
                catch (JSONException e) {
                    jsonO = jsonObject.getJSONObject("matricula");
                }

                int id, horario, persona, tipo, estado;
                String fecha;

                if(jsonArray == null) {
                    id = jsonO.getInt("NMatId");
                    horario = jsonO.getJSONObject("NHorId").getInt("NHorId");
                    persona = jsonO.getJSONObject("NPerId").getInt("NPerId");
                    tipo = jsonO.getInt("NMatTipo");
                    estado = jsonO.getInt("NMatEstado");
                    fecha = jsonO.getString("fecha");
                    matriculas.add(new Matricula(id, horario, persona, estado,tipo, fecha));
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        jsonO = jsonArray.getJSONObject(i);

                        id = jsonO.getInt("NMatId");
                        horario = jsonO.getJSONObject("NHorId").getInt("NHorId");
                        persona = jsonO.getJSONObject("NPerId").getInt("NPerId");
                        tipo = jsonO.getInt("NMatTipo");
                        estado = jsonO.getInt("NMatEstado");
                        fecha = jsonO.getString("fecha");

                        matriculas.add(new Matricula(id, horario, persona, estado,tipo, fecha));
                    }
                }
            }
            else {
                Log.i("STATUS CODE = ", String.valueOf(statusLine.getStatusCode()));
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR CLIENT PROTOCOL", e.getMessage());
            matriculas = null;
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
            matriculas = null;
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
            matriculas = null;
        }

        return null;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object object) {
        return false;
    }

    @Override
    public boolean deleteMethod(int id) {
        return false;
    }

    @Override
    public boolean updateMethod(Object object) {
        return false;
    }
}
