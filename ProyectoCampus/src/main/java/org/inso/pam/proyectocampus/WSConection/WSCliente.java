package org.inso.pam.proyectocampus.WSConection;

import java.util.List;

/**
 * Created by Christian on 6/11/13.
 */
public interface WSCliente {

    public String URLServer = "http://192.168.0.15:8084/PAMProyecto/webresources/";

    public abstract boolean GetMethod();

    public abstract List FindAllMethod();

    public abstract List FindMethod(String parameter, String value);

    public abstract boolean InsertMethod();

    public abstract boolean DeleteMethod();
}
