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
import org.inso.pam.proyectocampus.Entitys.Sesion;
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
public class WSSesion implements WSCliente {
    private String Rest_URL = "inso.pam.ws.sesion";

    @Override
    public List findAllMethod() {
        ArrayList<Sesion> sesions = new ArrayList<Sesion>();

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
                    jsonArray = jsonObject.getJSONArray("sesion");
                }
                catch (JSONException e) {
                    jsonO = jsonObject.getJSONObject("sesion");
                }

                int id, horario, estado;
                String titulo, fecha;

                if(jsonArray == null) {
                    id = jsonO.getInt("NSesId");
                    horario = jsonO.getJSONObject("NHorId").getInt("NHorId");
                    fecha = jsonO.getString("CSesFechaProgramada");
                    titulo = jsonO.getString("CSesTitulo");
                    estado = jsonO.getInt("NSesEstado");

                    sesions.add(new Sesion(id, horario, fecha, titulo, estado));
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        jsonO = jsonArray.getJSONObject(i);

                        id = jsonO.getInt("NSesId");
                        horario = jsonO.getJSONObject("NHorId").getInt("NHorId");
                        fecha = jsonO.getString("CSesFechaProgramada");
                        titulo = jsonO.getString("CSesTitulo");
                        estado = jsonO.getInt("NSesEstado");

                        sesions.add(new Sesion(id, horario, fecha, titulo, estado));
                    }
                }
            }
            else {
                Log.i("STATUS CODE = ", String.valueOf(statusLine.getStatusCode()));
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR CLIENT PROTOCOL", e.getMessage());
            sesions = null;
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
            sesions = null;
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
            sesions = null;
        }

        return sesions;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object sesion) {
        boolean re;

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpPost httpPost = new HttpPost(URLServer + Rest_URL);
        httpPost.setHeader("content-type", "application/json");

        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("NHorId", new JSONObject().put("NHorId", ((Sesion) sesion).getnHorId()));
            jsonObject.put("CSesFechaProgramada", ((Sesion) sesion).getcSesFechaProgramada());
            jsonObject.put("CSesTitulo", ((Sesion) sesion).getcSesTítulo());
            jsonObject.put("NSesEstado", ((Sesion) sesion).getnSesEstado());

            StringEntity entity = new StringEntity(jsonObject.toString());
            httpPost.setEntity(entity);

            HttpResponse response = client.execute(httpPost, httpContext);
            StatusLine statusLine = response.getStatusLine();

            if(statusLine.getStatusCode() == 204) {
                Log.i("STATUS", "INSERTADO CORRECTAMENTE");
                re = true;
            }
            else {
                Log.i("STATUS CODE = ", String.valueOf(statusLine.getStatusCode()));
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
    public boolean updateMethod(Object sesion) {
        boolean re;

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpPut httpPut = new HttpPut(URLServer + Rest_URL);
        httpPut.setHeader("content-type", "application/json");

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("NSesId", ((Sesion) sesion).getnSesId());
            jsonObject.put("NHorId", new JSONObject().put("NHorId", ((Sesion) sesion).getnHorId()));
            jsonObject.put("CSesFechaProgramada", ((Sesion) sesion).getcSesFechaProgramada());
            jsonObject.put("CSesTitulo", ((Sesion) sesion).getcSesTítulo());
            jsonObject.put("NSesEstado", ((Sesion) sesion).getnSesEstado());

            StringEntity entity = new StringEntity(jsonObject.toString());
            httpPut.setEntity(entity);

            HttpResponse httpResponse = client.execute(httpPut, httpContext);
            StatusLine statusLine = httpResponse.getStatusLine();

            if(statusLine.getStatusCode() == 204) {
                Log.i("STATUS", "INSERTADO CORRECTAMENTE");
                re = true;
            }
            else {
                Log.i("STATUS CODE = ", String.valueOf(statusLine.getStatusCode()));
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
}
