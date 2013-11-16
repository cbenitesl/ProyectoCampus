package org.inso.pam.proyectocampus.Handlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enzo on 15/11/13.
 */
public class MaterialCursoHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cipbdintegrada2";
    private static final int DB_VERSION = 1;

    public static final String TABLE_MATERIALCURSO = "material_curso";
    public static final String MATERIALCURSO_ID = "nMcuId";
    public static final String MATERIALCURSO_SES_ID = "nSesId";
    public static final String MATERIALCURSO_TIPO = "cMcuTipo";
    public static final String MATERIALCURSO_UBICACION = "cMcuUbicacion";

    public MaterialCursoHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE " + TABLE_MATERIALCURSO + " " +
                "(" + MATERIALCURSO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MATERIALCURSO_SES_ID + " INTEGER, " +
                MATERIALCURSO_TIPO + " TEXT, " +
                MATERIALCURSO_UBICACION + " TEXT)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_MATERIALCURSO);
        onCreate(sqLiteDatabase);
    }
}
