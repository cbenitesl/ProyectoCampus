package org.inso.pam.proyectocampus.WSConection;

import java.util.List;

/**
 * Created by Christian on 6/11/13.
 */
public interface WSCliente {

    public String URLServer = "http://192.168.0.15:8084/PAMProject/webresources/";

    public abstract List findAllMethod();

    public abstract List searchByMethod(String parameter, String value);

    public abstract boolean insertMethod(Object object);

    public abstract boolean deleteMethod(int id);

    public abstract boolean updateMethod(Object object);
}
