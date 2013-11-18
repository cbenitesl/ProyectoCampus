package org.inso.pam.proyectocampus.Servs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.inso.pam.proyectocampus.Entitys.Nota;
import org.inso.pam.proyectocampus.Entitys.Sesion;
import org.inso.pam.proyectocampus.Handlers.NotaHandler;
import org.inso.pam.proyectocampus.Handlers.SesionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 17/11/13.
 */
public class SesionServ {

    private SesionHandler handler;

    public SesionServ(Context context){
        this.handler = new SesionHandler(context);
    }

    public List<Sesion> find(){
        ArrayList<Sesion> sesiones = new ArrayList<Sesion>();

        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { SesionHandler.SESION_ID, SesionHandler.SESION_HOR_ID, SesionHandler.SESION_FECHA_PROGRAMADA, SesionHandler.SESION_TITULO, SesionHandler.SESION_ESTADO };
        Cursor cursor = sqlite.query(SesionHandler.TABLE_SESION, columns, null, null, null, null, null);

        while (cursor.moveToNext()){
            Sesion ses = new Sesion();
            ses.setnSesId(cursor.getInt(0));
            ses.setnHorId(cursor.getInt(1));
            ses.setcSesFechaProgramada(cursor.getString(2));
            ses.setcSesTítulo(cursor.getString(3));
            ses.setnSesEstado(cursor.getInt(4));
            sesiones.add(ses);
        }
        sqlite.close();

        return sesiones;
    }

    public Sesion find(int idSes){
        Sesion ses = new Sesion();
        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { SesionHandler.SESION_ID, SesionHandler.SESION_HOR_ID, SesionHandler.SESION_FECHA_PROGRAMADA, SesionHandler.SESION_TITULO, SesionHandler.SESION_ESTADO };
        String where = "nSesId = ?";
        String[] whereArgs = { "" + idSes};
        Cursor cursor = sqlite.query(SesionHandler.TABLE_SESION, columns, where, whereArgs, null, null, null);

        while (cursor.moveToNext()){
            ses.setnSesId(cursor.getInt(0));
            ses.setnHorId(cursor.getInt(1));
            ses.setcSesFechaProgramada(cursor.getString(2));
            ses.setcSesTítulo(cursor.getString(3));
            ses.setnSesEstado(cursor.getInt(4));
        }
        sqlite.close();
        return ses;
    }

}
