package org.inso.pam.proyectocampus.WSConection;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.inso.pam.proyectocampus.Entitys.Asistencia;
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
public class WSAsistencia implements WSCliente {

    private String Rest_URL = "inso.pam.ws.asistencia";

    @Override
    public List findAllMethod() {
        ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();

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
                StringBuilder builder = new StringBuilder();

                while((line = br.readLine()) != null) {
                    builder.append(line);
                }

                String result = builder.toString();

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = null;
                JSONObject jsonO = null;

                try {
                    jsonArray = jsonObject.getJSONArray("asistencia");
                }
                catch (JSONException e) {
                    jsonO = jsonObject.getJSONObject("asistencia");
                }

                int nAsiId, nMatId, nSesId;
                String cAsiFecha, cAsiValor;

                if(jsonArray == null) {
                    nAsiId = jsonO.getInt("NAsiId");
                    nMatId = jsonO.getJSONObject("NMatId").getInt("NMatId");
                    nSesId = jsonO.getJSONObject("NSesId").getInt("NSesId");
                    cAsiFecha = jsonO.getString("CAsisFecha");
                    cAsiValor = jsonO.getString("CAsiValor");
                    asistencias.add(new Asistencia(nAsiId, nMatId, nSesId, cAsiFecha, cAsiValor));
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        jsonO = jsonArray.getJSONObject(i);

                        nAsiId = jsonO.getInt("NAsiId");
                        nMatId = jsonO.getJSONObject("NMatId").getInt("NMatId");
                        nSesId = jsonO.getJSONObject("NSesId").getInt("NSesId");
                        cAsiFecha = jsonO.getString("CAsiFecha");
                        cAsiValor = jsonO.getString("CAsiValor");

                        asistencias.add(new Asistencia(nAsiId,nMatId, nSesId, cAsiFecha, cAsiValor));
                    }
                }
            }
            else {
                Log.i("Status Code =", String.valueOf(statusLine.getStatusCode()));
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR CLIENT PROTOCOL", e.getMessage());
            asistencias = null;
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
            asistencias = null;
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
            asistencias = null;
        }

        return asistencias;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object asistencia) {
        boolean re;

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpPost httpPost = new HttpPost(URLServer + Rest_URL);
        httpPost.setHeader("content-type","application/json");

        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("NAsiId", ((Asistencia) asistencia).getnAsiId());
            jsonObject.put("NMatId", new JSONObject().put("NMatId", ((Asistencia) asistencia).getnMatId()));
            jsonObject.put("NSesId", new JSONObject().put("NSesId", ((Asistencia) asistencia).getnSesId()));
            jsonObject.put("CAsiFecha", ((Asistencia) asistencia).getcAsiFecha());
            jsonObject.put("CAsiValor", ((Asistencia) asistencia).getcAsiValor());

            StringEntity entity = new StringEntity(jsonObject.toString());
            httpPost.setEntity(entity);

            HttpResponse response = client.execute(httpPost, httpContext);
            StatusLine statusLine = response.getStatusLine();

            if(statusLine.getStatusCode() == 204) {
                Log.i("STATUS", "INSERTADO CORRECTAMENTE");
                re = true;
            }
            else {
                Log.i("STATUS = ", String.valueOf(statusLine.getStatusCode()));
                re = false;
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR Client Protocol", e.getMessage());
            re = false;
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
            re = false;
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
            re = false;
        }

        return re;
    }

    @Override
    public boolean deleteMethod(int id) {
        return false;
    }

    @Override
    public boolean updateMethod(Object asistencia) {
        boolean re;

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpPut httpPut = new HttpPut(URLServer + Rest_URL);
        httpPut.setHeader("content-type", "application/json");

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("NAsiId", ((Asistencia) asistencia).getnAsiId());
            jsonObject.put("NMatId", new JSONObject().put("NMatId", ((Asistencia) asistencia).getnMatId()));
            jsonObject.put("NSesId", new JSONObject().put("NSesId", ((Asistencia) asistencia).getnSesId()));
            jsonObject.put("NAsiFecha", ((Asistencia) asistencia).getcAsiFecha());
            jsonObject.put("NAsiValor", ((Asistencia) asistencia).getcAsiValor());

            StringEntity entity = new StringEntity(jsonObject.toString());
            httpPut.setEntity(entity);

            HttpResponse response = client.execute(httpPut, httpContext);
            StatusLine statusLine = response.getStatusLine();

            if(statusLine.getStatusCode() == 205) {
                Log.i("STATUS", "INSERTADO CORRECTAMENTE");
                re = true;
            }
            else {
                Log.i("STATUS)", String.valueOf(statusLine.getStatusCode()));
                re = false;
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR de ClienteProtocol", e.getMessage());
            re = false;
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
            re = false;
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
            re = false;
        }

        return re;
    }
}
