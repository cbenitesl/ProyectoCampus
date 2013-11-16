package org.inso.pam.proyectocampus.Handlers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enzo on 16/11/13.
 */
public class HorarioHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cipbdintegrada2";
    private static final int DB_VERSION = 1;

    public static final String TABLE_HORARIO = "horario";
    public static final String HORARIO_ID = "nHorId";
    public static final String HORARIO_PER_ID = "nPerId";
    public static final String HORARIO_CUR_ID = "nCurId";
    public static final String HORARIO_FECHA_INICIO = "cHorFechaInicio";
    public static final String HORARIO_DIA = "cHorDia";
    public static final String HORARIO_HORA_INICIO = "cHorHoraIncio";
    public static final String HORARIO_AMBIENTE = "cHorAmbiente";
    public static final String HORARIO_FECHA_FIN = "cHorFechaFin";
    public static final String HORARIO_HORA_FIN = "cHorHoraFin";
    public static final String HORARIO_FECHAS = "cHorFechas";
    public static final String HORARIO_ESTADO = "nHorEstado";
    public static final String HORARIO_FECHA_FIN_PRORROGA = "cHorFechaFinProrroga";

    public HorarioHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sentencia = "CREATE TABLE " + TABLE_HORARIO + " " +
                "(" + HORARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HORARIO_PER_ID + " INTEGER, " +
                HORARIO_CUR_ID + " INTEGER, " +
                HORARIO_FECHA_INICIO + " TEXT, " +
                HORARIO_DIA + " TEXT, " +
                HORARIO_HORA_INICIO + " TEXT, " +
                HORARIO_AMBIENTE + " TEXT, " +
                HORARIO_FECHA_FIN + " TEXT, " +
                HORARIO_HORA_FIN + " TEXT, " +
                HORARIO_FECHAS + " TEXT, " +
                HORARIO_ESTADO + " INTEGER, " +
                HORARIO_FECHA_FIN_PRORROGA + " TEXT)";
        sqLiteDatabase.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_HORARIO);
        onCreate(sqLiteDatabase);
    }
}
