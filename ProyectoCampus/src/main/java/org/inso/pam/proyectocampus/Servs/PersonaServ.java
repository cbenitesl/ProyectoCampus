package org.inso.pam.proyectocampus.Servs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.inso.pam.proyectocampus.Entitys.MaterialCurso;
import org.inso.pam.proyectocampus.Entitys.Persona;
import org.inso.pam.proyectocampus.Handlers.MaterialCursoHandler;
import org.inso.pam.proyectocampus.Handlers.PersonaHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 17/11/13.
 */
public class PersonaServ {

    private PersonaHandler handler;

    public PersonaServ(Context context){
        this.handler = new PersonaHandler(context);
    }

}
