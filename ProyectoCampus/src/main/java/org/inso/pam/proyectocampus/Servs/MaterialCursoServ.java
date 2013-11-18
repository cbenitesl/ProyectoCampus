package org.inso.pam.proyectocampus.Servs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.inso.pam.proyectocampus.Entitys.MaterialCurso;
import org.inso.pam.proyectocampus.Entitys.Nota;
import org.inso.pam.proyectocampus.Handlers.MaterialCursoHandler;
import org.inso.pam.proyectocampus.Handlers.NotaHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 17/11/13.
 */
public class MaterialCursoServ {

    private MaterialCursoHandler handler;

    public MaterialCursoServ(Context context){
        this.handler = new MaterialCursoHandler(context);
    }

    public List<MaterialCurso> find(){
        ArrayList<MaterialCurso> materiales = new ArrayList<MaterialCurso>();

        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { MaterialCursoHandler.MATERIALCURSO_ID, MaterialCursoHandler.MATERIALCURSO_SES_ID, MaterialCursoHandler.MATERIALCURSO_TIPO, MaterialCursoHandler.MATERIALCURSO_UBICACION };
        Cursor cursor = sqlite.query(MaterialCursoHandler.TABLE_MATERIALCURSO, columns, null, null, null, null, null);

        while (cursor.moveToNext()){
            MaterialCurso mat = new MaterialCurso();
            mat.setnMcuId(cursor.getInt(0));
            mat.setnSesId(cursor.getInt(1));
            mat.setcMcuTipo(cursor.getString(2));
            mat.setcMcuUbicacion(cursor.getString(3));
            materiales.add(mat);
        }
        sqlite.close();

        return materiales;
    }

    public MaterialCurso find(int idSes){
        MaterialCurso mat = new MaterialCurso();
        SQLiteDatabase sqlite = handler.getReadableDatabase();
        String[] columns = { MaterialCursoHandler.MATERIALCURSO_ID, MaterialCursoHandler.MATERIALCURSO_SES_ID, MaterialCursoHandler.MATERIALCURSO_TIPO, MaterialCursoHandler.MATERIALCURSO_UBICACION };
        String where = "nSesId = ?";
        String[] whereArgs = { "" + idSes};
        Cursor cursor = sqlite.query(MaterialCursoHandler.TABLE_MATERIALCURSO, columns, where, whereArgs, null, null, null);

        while (cursor.moveToNext()){
            mat.setnMcuId(cursor.getInt(0));
            mat.setnSesId(cursor.getInt(1));
            mat.setcMcuTipo(cursor.getString(2));
            mat.setcMcuUbicacion(cursor.getString(3));
        }
        sqlite.close();
        return mat;
    }

}
