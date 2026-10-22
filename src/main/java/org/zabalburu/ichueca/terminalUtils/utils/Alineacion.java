package org.zabalburu.ichueca.terminalUtils.utils;

public enum Alineacion {

    IZQUIERDA("left"),
    CENTRO("center"),
    DERECHA("right");

    private final String valorChafa;

    Alineacion(String valorChafa) {
        this.valorChafa = valorChafa;
    }

    public String getValorChafa() {
        return valorChafa;
    }
}