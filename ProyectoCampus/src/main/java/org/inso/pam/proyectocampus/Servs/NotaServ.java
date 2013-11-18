package org.inso.pam.proyectocampus.Servs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.inso.pam.proyectocampus.Entitys.Asistencia;
import org.inso.pam.proyectocampus.Entitys.Nota;
import org.inso.pam.proyectocampus.Handlers.AsistenciaHandler;
import org.inso.pam.proyectocampus.Handlers.NotaHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 17/11/13.
 */
public class NotaServ {

    private NotaHandler handler;

    public NotaServ(Context context){
        this.handler = new NotaHandler(context);
    }

    public List<Nota> find(){
        ArrayList<Nota> notas = new ArrayList<Nota>();

        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { NotaHandler.NOTA_ID, NotaHandler.NOTA_MAT_ID, NotaHandler.NOTA_SES_ID, NotaHandler.NOTA_FECHA, NotaHandler.NOTA_VALOR };
        Cursor cursor = sqlite.query(NotaHandler.TABLE_NOTA, columns, null, null, null, null, null);

        while (cursor.moveToNext()){
            Nota not = new Nota();
            not.setnNotaId(cursor.getInt(0));
            not.setnMatId(cursor.getInt(1));
            not.setnSesId(cursor.getInt(2));
            not.setcNotFecha(cursor.getString(3));
            not.setcNotValor(cursor.getString(4));
            notas.add(not);
        }
        sqlite.close();

        return notas;
    }

    public Nota find(int idSes, int idMat){
        Nota not = new Nota();
        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { NotaHandler.NOTA_ID, NotaHandler.NOTA_MAT_ID, NotaHandler.NOTA_SES_ID, NotaHandler.NOTA_FECHA, NotaHandler.NOTA_VALOR };
        String where = "nSesId = ? AND nMatId = ?";
        String[] whereArgs = { "" + idSes, "" + idMat};
        Cursor cursor = sqlite.query(NotaHandler.TABLE_NOTA, columns, where, whereArgs, null, null, null);

        while (cursor.moveToNext()){
            not.setnNotaId(cursor.getInt(0));
            not.setnMatId(cursor.getInt(1));
            not.setnSesId(cursor.getInt(2));
            not.setcNotFecha(cursor.getString(3));
            not.setcNotValor(cursor.getString(4));
        }
        sqlite.close();
        return not;
    }

    public void insert(Nota nota){
        SQLiteDatabase sqlite = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NotaHandler.NOTA_MAT_ID, nota.getnMatId());
        values.put(NotaHandler.NOTA_SES_ID, nota.getnSesId());
        values.put(NotaHandler.NOTA_FECHA, nota.getcNotFecha());
        values.put(NotaHandler.NOTA_VALOR, nota.getcNotValor());
        long id = sqlite.insert(NotaHandler.TABLE_NOTA, null, values);
        nota.setnNotaId((int)id);
        sqlite.close();
    }

    public void update(Nota nota){
        SQLiteDatabase sqlite = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NotaHandler.NOTA_VALOR, nota.getcNotValor());
        String where = NotaHandler.NOTA_SES_ID + " = ? AND " + NotaHandler.NOTA_MAT_ID + " = ?";
        String[] whereArgs = { "" + nota.getnSesId(), "" + nota.getnMatId()};
        sqlite.update(NotaHandler.TABLE_NOTA, values, where, whereArgs);
        sqlite.close();
    }

}
