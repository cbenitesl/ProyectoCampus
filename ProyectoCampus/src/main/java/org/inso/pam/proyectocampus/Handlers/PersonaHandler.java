package org.inso.pam.proyectocampus.Handlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enzo on 16/11/13.
 */
public class PersonaHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cipbdintegrada2";
    private static final int DB_VERSION = 1;

    public static final String TABLE_PERSONA = "persona";
    public static final String PERSONA_ID = "nPerId";
    public static final String PERSONA_APELLIDO_PATERNO = "cPerApellidoPaterno";
    public static final String PERSONA_APELLIDO_MATERNO = "cPerApellidoMaterno";
    public static final String PERSONA_NOMBRES = "cPerNombres";
    public static final String PERSONA_TIPO = "cPerTipo";

    public PersonaHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE " + TABLE_PERSONA + " " +
                "(" + PERSONA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PERSONA_APELLIDO_PATERNO + " TEXT, " +
                PERSONA_APELLIDO_MATERNO + " TEXT, " +
                PERSONA_NOMBRES + " TEXT, " +
                PERSONA_TIPO + " TEXT)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PERSONA);
        onCreate(sqLiteDatabase);
    }
}
