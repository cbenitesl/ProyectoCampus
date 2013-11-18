package org.inso.pam.proyectocampus.Servs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.inso.pam.proyectocampus.Entitys.Asistencia;
import org.inso.pam.proyectocampus.Entitys.Horario;
import org.inso.pam.proyectocampus.Handlers.AsistenciaHandler;
import org.inso.pam.proyectocampus.Handlers.HorarioHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 17/11/13.
 */
public class HorarioServ {

    private HorarioHandler handler;

    public HorarioServ(Context context){
        this.handler = new HorarioHandler(context);
    }



}
