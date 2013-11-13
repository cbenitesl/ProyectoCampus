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
import org.inso.pam.proyectocampus.Entitys.Horario;
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
public class WSHorario implements WSCliente {

    private String Rest_URL = "inso.pam.ws.horario";

    @Override
    public List findAllMethod() {
        ArrayList<Horario> horarios = new ArrayList<Horario>();

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

                Log.i("RESULTADO", result);

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = null;
                JSONObject jsonObject1 = null;

                try {
                    jsonArray = jsonObject.getJSONArray("horario");
                }
                catch (JSONException e) {
                    jsonObject1 = jsonObject.getJSONObject("horario");
                }

                if(jsonArray == null) {
                    Log.i("Horario", jsonObject1.toString());
                }
                else {
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);
                        int nHorId = item.getInt("NHorId");
                        int nPerId = item.getJSONObject("NPerId").getInt("NPerId");
                        int nCurId = item.getJSONObject("NCurId").getInt("NCurId");
                        String cHorDias = item.getString("CHorDia");
                        String cHorHoraInicio = item.getString("CHorHoraInicio");
                        String cHorFechaInicio = item.getString("CHorFechaInicio");
                        String cHorAmbiente = item.getString("CHorAmbiente");
                        String cHorHoraFin = item.getString("CHorHoraFin");
                        String cHorFechaFin = item.getString("CHorFechaFin");

                        Horario horario = new Horario(nHorId,nPerId,nCurId,cHorDias,cHorHoraInicio,cHorFechaInicio,cHorAmbiente,cHorHoraFin,cHorFechaFin);
                        horarios.add(horario);
                        //Log.i("JSONOBJECT GET", item.toString());
                        Log.i("Horario" + i, horario.toString());
                    }

                }
            }
            else {
                Log.i("STATUS = ", String.valueOf(statusCode));
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

        return horarios;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object horario) {
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
