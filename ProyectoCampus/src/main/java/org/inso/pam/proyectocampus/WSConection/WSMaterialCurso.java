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
import org.inso.pam.proyectocampus.Entitys.MaterialCurso;
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
public class WSMaterialCurso implements WSCliente {

    private String Rest_URL = "inso.pam.ws.materialcurso";

    @Override
    public List findAllMethod() {
        ArrayList<MaterialCurso> files = new ArrayList<MaterialCurso>();


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

                String result = stringBuilder.toString();

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = null;
                JSONObject jsonO = null;

                try {
                    jsonArray = jsonObject.getJSONArray("materialcurso");
                }
                catch (JSONException e) {
                    jsonO = jsonObject.getJSONObject("materialcurso");
                }

                int id, sesion;
                String tipo, ubicacion;

                if(jsonArray == null) {
                    id = jsonO.getInt("NMcuId");
                    sesion = jsonO.getJSONObject("NSesId").getInt("NSesId");
                    tipo = jsonO.getString("CMcuTipo");
                    ubicacion = jsonO.getString("CMcuUbicacion");
                    files.add(new MaterialCurso(id,sesion,tipo,ubicacion));
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        jsonO = jsonArray.getJSONObject(i);

                        id = jsonO.getInt("NMcuId");
                        sesion = jsonO.getJSONObject("NSesId").getInt("NSesId");
                        tipo = jsonO.getString("CMcuTipo");
                        ubicacion = jsonO.getString("CMcuUbicacion");

                        files.add(new MaterialCurso(id, sesion,tipo,ubicacion));
                    }
                }
            }
            else {
                Log.i("STATUS = ", String.valueOf(statusLine.getStatusCode()));
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR CLIENT PROTOCOL", e.getMessage());
            files = null;
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
            files = null;
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
            files = null;
        }

        return files;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object file) {
        return false;
    }

    @Override
    public boolean deleteMethod(int id) {
        return false;
    }

    @Override
    public boolean updateMethod(Object file) {
        return false;
    }
}
