package org.inso.pam.proyectocampus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Christian on 30/10/13.
 */
public class CursoAdapter extends ArrayAdapter<Curso> {

    private List<Curso> cursos;
    private LayoutInflater li;

    public CursoAdapter(Context context, List<Curso> cursos) {
        super(context, 0, cursos);

        this.cursos = cursos;
        li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CursoHolder cursoHolder;

        if(convertView == null) {
            convertView = li.inflate(R.layout.horario_item_view,parent,false);
            cursoHolder = new CursoHolder();
            cursoHolder.nombre = (TextView) convertView.findViewById(R.id.lbl_nombre);
            cursoHolder.dia = (TextView) convertView.findViewById(R.id.lbl_dia);
            cursoHolder.horaIF = (TextView) convertView.findViewById(R.id.lbl_horas);
            convertView.setTag(cursoHolder);
        }
        else {
            cursoHolder = (CursoHolder) convertView.getTag();
        }

        Curso curso = cursos.get(position);
        cursoHolder.nombre.setText(curso.getNombre());
        cursoHolder.dia.setText(curso.getDia());
        cursoHolder.horaIF.setText(curso.getHoraI() + "-" + curso.getHoraF());

        return convertView;
    }

    private class CursoHolder {
        TextView nombre;
        TextView dia;
        TextView horaIF;
    }
}
