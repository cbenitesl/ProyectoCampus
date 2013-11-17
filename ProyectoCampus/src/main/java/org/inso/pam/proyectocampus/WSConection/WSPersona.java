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
import org.inso.pam.proyectocampus.Entitys.Persona;
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
public class WSPersona implements WSCliente {

    private String Rest_URL = "inso.pam.ws.persona";

    @Override
    public List findAllMethod() {
        ArrayList<Persona> personas = new ArrayList<Persona>();

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

                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = null;
                JSONObject jsonO = null;

                try {
                    jsonArray = jsonObject.getJSONArray("persona");
                }
                catch (JSONException e) {
                    jsonO = jsonObject.getJSONObject("persona");
                }

                int id;
                String apePat, apeMat, nom, tipo;

                if(jsonArray == null) {
                    id = jsonO.getInt("NPerId");
                    apePat = jsonO.getString("CPerApellidoPaterno");
                    apeMat = jsonO.getString("CPerApellidoMaterno");
                    nom = jsonO.getString("CPerNombres");
                    tipo = jsonO.getString("CPetTipo");

                    personas.add(new Persona(id, apePat, apeMat, nom, tipo));
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        jsonO = jsonArray.getJSONObject(i);

                        id = jsonO.getInt("NPerId");
                        apePat = jsonO.getString("CPerApellidoPaterno");
                        apeMat = jsonO.getString("CPerApellidoMaterno");
                        nom = jsonO.getString("CPerNombres");
                        tipo = jsonO.getString("CPetTipo");

                        personas.add(new Persona(id, apePat, apeMat, nom, tipo));
                    }
                }
            }
            else {
                Log.i("STATUS CODE = ", String.valueOf(statusLine.getStatusCode()));
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR CLIENT PROTOCOL", e.getMessage());
            personas = null;
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
            personas = null;
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
            personas = null;
        }

        return personas;
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
