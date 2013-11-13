package org.inso.pam.proyectocampus.WSConection;

import org.inso.pam.proyectocampus.Entitys.MaterialCurso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 10/11/13.
 */
public class WSMaterialCurso implements WSCliente {

    @Override
    public List findAllMethod() {
        ArrayList<MaterialCurso> files = new ArrayList<MaterialCurso>();

        return null;
    }

    @Override
    public List searchByMethod(String parameter, String value) {
        return null;
    }

    @Override
    public boolean insertMethod(Object file) {
        return false;
    }

    @Override
    public boolean deleteMethod(int id) {
        return false;
    }

    @Override
    public boolean updateMethod(Object file) {
        return false;
    }
}
