package org.zabalburu.ichueca.terminalUtils.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisorImagenes {
    /**
     * Si ancho y alto son null, Chafa decide automáticamente
     * el tamaño más adecuado para el terminal.
     */
    private Integer ancho;
    private Integer alto;

    private Alineacion alineacion;
    private boolean color;

    /**
     * Constructor por defecto.
     */
    public VisorImagenes() {
        this.alineacion = Alineacion.CENTRO;
        this.color = true;
    }

    /**
     * Constructor con configuración completa.
     */
    public VisorImagenes(
            Integer ancho,
            Integer alto,
            Alineacion alineacion,
            boolean color) {

        this.ancho = ancho;
        this.alto = alto;
        this.alineacion = alineacion;
        this.color = color;
    }

    // =====================
    // GETTERS
    // =====================

    public Integer getAncho() {
        return ancho;
    }

    public Integer getAlto() {
        return alto;
    }

    public Alineacion getAlineacion() {
        return alineacion;
    }

    public boolean isColor() {
        return color;
    }

    // =====================
    // SETTERS
    // =====================

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public void setAlineacion(Alineacion alineacion) {
        this.alineacion = alineacion;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    // =====================
    // MÉTODOS DE UTILIDAD
    // =====================

    public void centrar() {
        this.alineacion = Alineacion.CENTRO;
    }

    public void alinearIzquierda() {
        this.alineacion = Alineacion.IZQUIERDA;
    }

    public void alinearDerecha() {
        this.alineacion = Alineacion.DERECHA;
    }

    public void modoAscii() {
        this.color = false;
    }

    public void modoColor() {
        this.color = true;
    }

    /**
     * Vuelve al tamaño automático.
     */
    public void tamañoAutomatico() {
        this.ancho = null;
        this.alto = null;
    }

    /**
     * Configura el tamaño manualmente.
     */
    public void establecerTamaño(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * Muestra una imagen usando la configuración actual.
     */
    public void mostrar(String rutaImagen) {
        try {
            File archivo = new File(rutaImagen);
            if (!archivo.exists()) {
                System.out.println(
                        "❌ No existe la imagen: "
                                + rutaImagen);
                return;
            }
            List<String> comando = new ArrayList<>();
            comando.add("chafa");
            // Tamaño opcional
            if (ancho != null && alto != null) {
                comando.add(
                        "--size=" + ancho + "x" + alto
                );
            }
            // Alineación
            comando.add(
                    "--align="
                            + alineacion.getValorChafa()
            );
            // Color o ASCII
            if (!color) {
                comando.add("--colors=none");
                comando.add("--symbols=ascii");
            }
            comando.add(
                    archivo.getAbsolutePath()
            );
            ProcessBuilder pb =
                    new ProcessBuilder(comando);
            pb.inheritIO();
            Process proceso = pb.start();
            proceso.waitFor();
        } catch (IOException e) {
            System.out.println(
                    "❌ No se ha podido ejecutar Chafa."
            );
        } catch (InterruptedException e) {
            System.out.println(
                    "❌ El proceso fue interrumpido."
            );
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        String tamaño;
        if (ancho == null || alto == null) {
            tamaño = "automático";
        } else {
            tamaño = ancho + "x" + alto;
        }
        return "VisorImagenes{" +
                "tamaño=" + tamaño +
                ", alineacion=" + alineacion +
                ", color=" + color +
                '}';
    }
}
