package org.inso.pam.proyectocampus.Servs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.inso.pam.proyectocampus.Entitys.Asistencia;
import org.inso.pam.proyectocampus.Handlers.AsistenciaHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 17/11/13.
 */
public class AsistenciaServ {

    private AsistenciaHandler handler;

    public AsistenciaServ(Context context){
        this.handler = new AsistenciaHandler(context);
    }

    public List<Asistencia> find(){
        ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();

        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { AsistenciaHandler.ASISTENCIA_ID, AsistenciaHandler.ASISTENCIA_MAT_ID, AsistenciaHandler.ASISTENCIA_SES_ID, AsistenciaHandler.ASISTENCIA_FECHA, AsistenciaHandler.ASISTENCIA_VALOR };
        Cursor cursor = sqlite.query(AsistenciaHandler.TABLE_ASISTENCIA, columns, null, null, null, null, null);

        while (cursor.moveToNext()){
            Asistencia asi = new Asistencia();
            asi.setnAsiId(cursor.getInt(0));
            asi.setnMatId(cursor.getInt(1));
            asi.setnSesId(cursor.getInt(2));
            asi.setcAsiFecha(cursor.getString(3));
            asi.setcAsiValor(cursor.getString(4));
            asistencias.add(asi);
        }
        sqlite.close();

        return asistencias;
    }

    public Asistencia find(int idSes, int idMat){
        Asistencia asi = new Asistencia();
        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { AsistenciaHandler.ASISTENCIA_ID, AsistenciaHandler.ASISTENCIA_MAT_ID, AsistenciaHandler.ASISTENCIA_SES_ID, AsistenciaHandler.ASISTENCIA_FECHA, AsistenciaHandler.ASISTENCIA_VALOR };
        String where = "nSesId = ? AND nMatId = ?";
        String[] whereArgs = { "" + idSes, "" + idMat};
        Cursor cursor = sqlite.query(AsistenciaHandler.TABLE_ASISTENCIA, columns, where, whereArgs, null, null, null);

        while (cursor.moveToNext()){
            asi.setnAsiId(cursor.getInt(0));
            asi.setnMatId(cursor.getInt(1));
            asi.setnSesId(cursor.getInt(2));
            asi.setcAsiFecha(cursor.getString(3));
            asi.setcAsiValor(cursor.getString(4));
        }
        sqlite.close();
        return asi;
    }

    public void insert(Asistencia asistencia){
        SQLiteDatabase sqlite = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AsistenciaHandler.ASISTENCIA_MAT_ID, asistencia.getnMatId());
        values.put(AsistenciaHandler.ASISTENCIA_SES_ID, asistencia.getnSesId());
        values.put(AsistenciaHandler.ASISTENCIA_FECHA, asistencia.getcAsiFecha());
        values.put(AsistenciaHandler.ASISTENCIA_VALOR, asistencia.getcAsiValor());
        long id = sqlite.insert(AsistenciaHandler.TABLE_ASISTENCIA, null, values);
        asistencia.setnAsiId((int)id);
        sqlite.close();
    }

    public void update(Asistencia asistencia){
        SQLiteDatabase sqlite = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AsistenciaHandler.ASISTENCIA_VALOR, asistencia.getcAsiValor());
        String where = AsistenciaHandler.ASISTENCIA_SES_ID + " = ? AND " + AsistenciaHandler.ASISTENCIA_MAT_ID + " = ?";
        String[] whereArgs = { "" + asistencia.getnSesId(), "" + asistencia.getnMatId()};
        sqlite.update(AsistenciaHandler.TABLE_ASISTENCIA, values, where, whereArgs);
        sqlite.close();
    }

}
