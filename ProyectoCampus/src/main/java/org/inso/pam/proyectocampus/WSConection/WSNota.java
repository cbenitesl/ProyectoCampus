package org.inso.pam.proyectocampus.WSConection;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.inso.pam.proyectocampus.Entitys.Nota;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 9/11/13.
 */
public class WSNota implements WSCliente {

    private String Rest_URL = "inso.pam.ws.nota";

    @Override
    public List findAllMethod() {
        ArrayList<Nota> notas = new ArrayList<Nota>();

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

                Log.i("Resultado", result);

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = null;
                JSONObject jsonO = null;

                try {
                    jsonArray = jsonObject.getJSONArray("nota");
                }
                catch (JSONException e) {
                    jsonO = jsonObject.getJSONObject("nota");
                }

                if(jsonArray == null) {
                    int nNotId = jsonO.getInt("NNnotId");
                    int nMatId = jsonO.getJSONObject("NMatId").getInt("nMatId");
                    int nSesId = jsonO.getJSONObject("NSesId").getInt("NSesId");
                    String cNotFecha = jsonO.getString("CNotFecha");
                    String cNotValor = jsonO.getString("CNotValor");
                    notas.add(new Nota(nNotId, nMatId, nSesId, cNotFecha, cNotValor));
                    Log.i("Nota", jsonO.toString());
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);
                        int nMatId = item.getJSONObject("NMatId").getInt("NMatId");
                        int nSesId = item.getJSONObject("NSesId").getInt("NSesId");
                        int nNotId = item.getInt("NNotId");
                        String cNotFecha = item.getString("CNotFecha");
                        String cNotValor = item.getString("CNotValor");

                        Nota not = new Nota(nNotId, nMatId, nSesId, cNotFecha, cNotValor);
                        Log.i("Nota"+(i+1), not.toString());
                        notas.add(not);
                    }
                }
            }
            else {
                Log.i("STATUS = ", String.valueOf(statusLine.getStatusCode()));
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR Client Protocol", e.getMessage());
        }
        catch (JSONException e) {
            Log.e("ERROR JSONObject", e.getMessage());
        }
        catch (IOException e) {
            Log.e("ERROR IOException", e.getMessage());
        }

        return notas;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object nota) {
        boolean re;
        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpPost httpPost = new HttpPost(URLServer + Rest_URL);
        httpPost.setHeader("content-type","application/json");

        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("NMatId", new JSONObject().put("NMatId", ((Nota) nota).getnMatId()));
            jsonObject.put("NSesId", new JSONObject().put("NSesId", ((Nota) nota).getnSesId()));
            jsonObject.put("CNotFecha", ((Nota) nota).getcNotFecha());
            jsonObject.put("CNotValor", ((Nota) nota).getcNotValor());

            Log.i("JSONOBJECT", "{\"WSNota\":["+jsonObject.toString()+"]}");

            StringEntity entity = new StringEntity(jsonObject.toString());
            httpPost.setEntity(entity);

            Log.i("Entity", "Finish");

            HttpResponse httpResponse = client.execute(httpPost, httpContext);
            StatusLine statusLine = httpResponse.getStatusLine();

            Log.i("Response", "Complete");

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
            Log.e("ERROR ClientProtocol", e.getMessage());
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
        boolean re;

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpDelete httpDelete = new HttpDelete(URLServer + Rest_URL + "/" + id);
        httpDelete.setHeader("content-type", "application/json");

        try {
            HttpResponse httpResponse = client.execute(httpDelete, httpContext);
            StatusLine statusLine = httpResponse.getStatusLine();

            if(statusLine.getStatusCode() == 204) {
                Log.i("STATUS", "SUCCESSFUL DELETE");
                re = true;
            }
            else {
                Log.i("STATUS =", String.valueOf(statusLine.getStatusCode()));
                re = false;
            }
        }
        catch(ClientProtocolException e) {
            Log.e("ERROR de ClientProtocol", e.getMessage());
            re = false;
        }
        catch(IOException e) {
            Log.e("ERROR de I/O", e.getMessage());
            re = false;
        }

        return re;
    }

    @Override
    public boolean updateMethod(Object nota) {
        boolean re;

        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpPut httpPut = new HttpPut(URLServer + Rest_URL);
        httpPut.setHeader("content-type","application/json");

        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("NNotId", ((Nota) nota).getnNotaId());
            jsonObject.put("NMatId", new JSONObject().put("NMatId", ((Nota) nota).getnMatId()));
            jsonObject.put("NSesId", new JSONObject().put("NSesId", ((Nota) nota).getnSesId()));
            jsonObject.put("CNotFecha", ((Nota) nota).getcNotFecha());
            jsonObject.put("CNotValor", ((Nota) nota).getcNotValor());

            StringEntity entity = new StringEntity(jsonObject.toString());
            httpPut.setEntity(entity);

            HttpResponse response = client.execute(httpPut, httpContext);
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == 204) {
                Log.i("STATUS", "SUCCESSFUL UPDATE");
                re = true;
            }
            else {
                Log.i("STATUS =", String.valueOf(statusLine.getStatusCode()));
                re = false;
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR de ClientProtocol", e.getMessage());
            re = false;
        }
        catch(IOException e) {
            Log.e("ERROR de IO", e.getMessage());
            re = false;
        }
        catch (JSONException e) {
            Log.e("ERROR de JSON", e.getMessage());
            re = false;
        }

        return re;
    }
}
