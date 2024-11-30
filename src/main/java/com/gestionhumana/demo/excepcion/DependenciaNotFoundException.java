package com.gestionhumana.demo.excepcion;

public class DependenciaNotFoundException  extends RuntimeException{
    public DependenciaNotFoundException(String message) {
        super(message);
    }
}
