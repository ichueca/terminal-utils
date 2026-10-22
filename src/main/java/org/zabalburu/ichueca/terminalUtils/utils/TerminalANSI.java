package org.zabalburu.ichueca.terminalUtils.utils;

package org.zabalburu.util;

public final class TerminalANSI {

    // Constructor privado para evitar que se instancie la clase
    private Terminal() {}

    // ==========================================
    // 1. CONTROL DE PANTALLA Y BORRADO
    // ==========================================
    public static final String RESET = "\u001B[0m";
    public static final String CLEAR_SCREEN = "\u001B[2J";
    public static final String CLEAR_SCREEN_DOWN = "\u001B[0J"; // Borra desde el cursor hasta el final de la pantalla
    public static final String CLEAR_SCREEN_UP = "\u001B[1J";   // Borra desde el cursor hasta el inicio de la pantalla
    public static final String GO_HOME = "\u001B[H";
    public static final String CLEAR_LINE = "\u001B[2K";        // Borra la línea entera actual
    public static final String CLEAR_LINE_RIGHT = "\u001B[K";   // Borra desde el cursor hasta el final de la línea
    public static final String CLEAR_LINE_LEFT = "\u001B[1K";  // Borra desde el cursor hasta el inicio de la línea

    // ==========================================
    // 2. MODIFICADORES DE ESTILO
    // ==========================================
    public static final String BOLD = "\u001B[1m";
    public static final String DIM = "\u001B[2m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String INVERT = "\u001B[7m";
    public static final String HIDDEN = "\u001B[8m";            // Oculta el texto (útil para passwords manuales)
    public static final String STRIKETHROUGH = "\u001B[9m";

    // ==========================================
    // 3. COLORES DE TEXTO (ESTÁNDAR)
    // ==========================================
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // ==========================================
    // 4. COLORES DE TEXTO (BRILLANTES)
    // ==========================================
    public static final String BRIGHT_BLACK = "\u001B[90m"; // Gris oscuro
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // ==========================================
    // 5. COLORES DE FONDO
    // ==========================================
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_MAGENTA = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    // ==========================================
    // 6. MEMORIA DEL CURSOR
    // ==========================================
    public static final String SAVE_CURSOR = "\u001B[s";
    public static final String RESTORE_CURSOR = "\u001B[u";

    // ==========================================
    // 7. MÉTODOS DE UTILIDAD (DINÁMICOS)
    // ==========================================

    /** Genera el código ANSI para color de texto RGB */
    public static String rgbText(int r, int g, int b) {
        return "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
    }

    /** Genera el código ANSI para color de fondo RGB */
    public static String rgbBg(int r, int g, int b) {
        return "\u001B[48;2;" + r + ";" + g + ";" + b + "m";
    }

    /** Mueve el cursor N líneas hacia ARRIBA */
    public static String moveUp(int lines) { return "\u001B[" + lines + "A"; }

    /** Mueve el cursor N líneas hacia ABAJO */
    public static String moveDown(int lines) { return "\u001B[" + lines + "B"; }

    /** Mueve el cursor N columnas hacia la DERECHA */
    public static String moveRight(int columns) { return "\u001B[" + columns + "C"; }

    /** Mueve el cursor N columnas hacia la IZQUIERDA */
    public static String moveLeft(int columns) { return "\u001B[" + columns + "D"; }

    /** Mueve el cursor a una posición absoluta exacta (Fila, Columna) 
     *  Nota: La esquina superior izquierda es (1, 1) */
    public static String goTo(int row, int column) {
        return "\u001B[" + row + ";" + column + "H";
    }
}
