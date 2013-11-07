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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Christian on 6/11/13.
 */
public class horario implements WSCliente {

    private String Rest_URL = "tables.horario";

    @Override
    public boolean GetMethod() {
        HttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();

        HttpGet httpGet = new HttpGet(URLServer + Rest_URL);
        httpGet.setHeader("Accept", "application/json");

        try {
            HttpResponse response = client.execute(httpGet,httpContext);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            if(statusCode == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));

                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }

                String result = builder.toString();

                Log.e("RESULTADO", result);

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = null;
                JSONObject jsonObject1 = null;

                try {
                    jsonArray = jsonObject.getJSONArray("horario");
                }
                catch (JSONException e) {
                    jsonObject1 = jsonObject.getJSONObject("horario");
                }
            }
        }
        catch (ClientProtocolException e) {
            Log.e("ERROR ClientProtocol", e.getMessage());
        }
        catch (IOException e) {
            Log.e("ERROR IO", e.getMessage());
        }
        catch (JSONException e) {
            Log.e("ERROR JSON", e.getMessage());
        }

        return false;
    }

    @Override
    public List FindAllMethod() {
        return null;
    }

    @Override
    public List FindMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean InsertMethod() {
        return false;
    }

    @Override
    public boolean DeleteMethod() {
        return false;
    }
}
