package org.inso.pam.proyectocampus.Handlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enzo on 16/11/13.
 */
public class MatriculaHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cipbdintegrada2";
    private static final int DB_VERSION = 1;

    public static final String TABLE_MATRICULA = "matricula";
    public static final String MATRICULA_ID = "nMatId";
    public static final String MATRICULA_HOR_ID = "nHorId";
    public static final String MATRICULA_PER_ID = "nPerId";
    public static final String MATRICULA_ESTADO = "nMatEstado";
    public static final String MATRICULA_TIPO = "nMatTipo";
    public static final String MATRICULA_FECHA = "cMatFecha";

    public MatriculaHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE " + TABLE_MATRICULA + " " +
                "(" + MATRICULA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MATRICULA_HOR_ID + " INTEGER, " +
                MATRICULA_PER_ID + " INTEGER, " +
                MATRICULA_ESTADO + " INTEGER, " +
                MATRICULA_TIPO + " INTEGER, " +
                MATRICULA_FECHA + " TEXT)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_MATRICULA);
        onCreate(sqLiteDatabase);
    }
}
