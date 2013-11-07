package org.inso.pam.proyectocampus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christian on 30/10/13.
 */
public class CursoHandler extends SQLiteOpenHelper {
    private static final  String DB_NAME = "notaDB";
    private static final int DB_VERSION = 1;

    public static final String TABLA_NOTA = "nota";
    public static final String NOTA_ID = "id";
    public static final String NOTA_TITULO = "titulo";
    public static final String NOTA_MENSAJE = "mensaje";
    public static final String NOTA_FECHA = "fecha";

    public CursoHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE "+TABLA_NOTA +
                "(" + NOTA_ID + " INTEGER PRIMARY KEY, " +
                NOTA_TITULO + " TEXT, "+
                NOTA_MENSAJE + " TEXT, "+
                NOTA_FECHA + " TEXT)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_NOTA);
        onCreate(sqLiteDatabase);
    }
}
