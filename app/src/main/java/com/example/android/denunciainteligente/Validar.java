package com.example.android.denunciainteligente;

import android.app.Application;

/**
 * Created by roman on 10/06/2017.
 */

public class Validar extends Application {
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
