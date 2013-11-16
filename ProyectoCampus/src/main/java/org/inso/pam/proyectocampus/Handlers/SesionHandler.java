package org.inso.pam.proyectocampus.Handlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enzo on 15/11/13.
 */
public class SesionHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cipbdintegrada2";
    private static final int DB_VERSION = 1;

    public static final String TABLE_SESION = "sesion";
    public static final String SESION_ID = "nSesId";
    public static final String SESION_HOR_ID = "nHorId";
    public static final String SESION_FECHA_PROGRAMADA = "cSesFechaProgramada";
    public static final String SESION_TITULO = "cSesTitulo";
    public static final String SESION_ESTADO = "nSesEstado";

    public SesionHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE " + TABLE_SESION + " " +
                "(" + SESION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SESION_HOR_ID + " INTEGER, " +
                SESION_FECHA_PROGRAMADA + " TEXT, " +
                SESION_TITULO + " TEXT, " +
                SESION_ESTADO + " INTEGER)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_SESION);
        onCreate(sqLiteDatabase);
    }
}
