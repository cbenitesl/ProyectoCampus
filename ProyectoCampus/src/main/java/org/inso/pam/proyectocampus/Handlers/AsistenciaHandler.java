package org.inso.pam.proyectocampus.Handlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enzo on 15/11/13.
 */
public class AsistenciaHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cipbdintegrada2";
    private static final int DB_VERSION = 1;

    public static final String TABLE_ASISTENCIA = "asistencia";
    public static final String ASISTENCIA_ID = "nAsiId";
    public static final String ASISTENCIA_MAT_ID = "nMatId";
    public static final String ASISTENCIA_SES_ID = "nSesId";
    public static final String ASISTENCIA_FECHA = "cAsiFecha";
    public static final String ASISTENCIA_VALOR = "cAsiValor";

    public AsistenciaHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE " + TABLE_ASISTENCIA + " " +
                "(" + ASISTENCIA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ASISTENCIA_MAT_ID + " INTEGER, " +
                ASISTENCIA_SES_ID + " INTEGER, " +
                ASISTENCIA_FECHA + " TEXT, " +
                ASISTENCIA_VALOR + " TEXT)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_ASISTENCIA);
        onCreate(sqLiteDatabase);
    }
}
