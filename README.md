# Terminal Utils

Pequeña biblioteca Java para crear aplicaciones de terminal más visuales y divertidas.

Pensada especialmente para estudiantes de DAM/DAW que estén aprendiendo:

- Programación orientada a objetos
- Clases y objetos
- Encapsulación
- Enumeraciones
- Librerías externas
- Maven
- Aplicaciones de consola

## Características

✅ Colores ANSI para la consola

✅ Visualización de imágenes en terminal mediante Chafa

✅ API sencilla y fácil de aprender

✅ Compatible con proyectos Maven

---

# Instalación

## 1. Añadir el repositorio JitPack

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

## 2. Añadir la dependencia

```xml
<dependency>
    <groupId>com.github.inigochueca</groupId>
    <artifactId>terminal-utils</artifactId>
    <version>v1.0.0</version>
</dependency>
```

---

# Requisitos

La clase `VisorImagenes` utiliza la herramienta externa **Chafa**.

Instalación en Linux (Debian / Ubuntu):

```bash
sudo apt install chafa
```

Arch Linux:

```bash
sudo pacman -S chafa
```

MacOS:

```bash
brew install chafa
```

Comprobar instalación:

```bash
chafa --version
```

---

# Uso de TerminalANSI

Mostrar texto con colores.

```java
System.out.println(
        TerminalANSI.ROJO +
        "¡PELIGRO!" +
        TerminalANSI.RESET
);
```

Ejemplo:

```java
System.out.println(
        TerminalANSI.VERDE +
        "Has ganado la partida." +
        TerminalANSI.RESET
);
```

---

# Uso de VisorImagenes

## Mostrar una imagen

```java
VisorImagenes visor = new VisorImagenes();

visor.mostrar("imagenes/zombie.png");
```

---

## Centrar una imagen

```java
VisorImagenes visor = new VisorImagenes();

visor.centrar();

visor.mostrar("imagenes/zombie.png");
```

---

## Mostrar una imagen en ASCII

```java
VisorImagenes visor = new VisorImagenes();

visor.modoAscii();

visor.mostrar("imagenes/dragon.png");
```

---

## Configurar tamaño

```java
VisorImagenes visor = new VisorImagenes();

visor.establecerTamaño(40, 20);

visor.mostrar("imagenes/castillo.png");
```

---

## Volver al tamaño automático

```java
visor.tamañoAutomatico();
```

---

# Ejemplo completo

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                TerminalANSI.CYAN +
                "=== ZOMBIE RPG ===" +
                TerminalANSI.RESET
        );

        VisorImagenes visor = new VisorImagenes();

        visor.centrar();

        visor.mostrar("imagenes/zombie.png");
    }
}
```

---

# Buenas prácticas

Se recomienda:

- Mantener las imágenes en una carpeta `imagenes`.
- Utilizar rutas relativas.
- Comprobar que Chafa está instalado antes de ejecutar la aplicación.
- Crear una única instancia de `VisorImagenes` y reutilizarla.

---

# Licencia

Proyecto educativo destinado al aprendizaje de Java y programación orientada a objetos.

Uso libre para fines docentes y formativos.