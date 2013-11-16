package org.inso.pam.proyectocampus.Handlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enzo on 15/11/13.
 */
public class NotaHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cipbdintegrada2";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NOTA = "nota";
    public static final String NOTA_ID = "nNotId";
    public static final String NOTA_MAT_ID = "nMatId";
    public static final String NOTA_SES_ID = "nSesId";
    public static final String NOTA_FECHA = "cNotFecha";
    public static final String NOTA_VALOR = "cNotValor";

    public NotaHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE " + TABLE_NOTA + " " +
                "(" + NOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOTA_MAT_ID + " INTEGER, " +
                NOTA_SES_ID + " INTEGER, " +
                NOTA_FECHA + " TEXT, " +
                NOTA_VALOR + " TEXT)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NOTA);
        onCreate(sqLiteDatabase);
    }
}
