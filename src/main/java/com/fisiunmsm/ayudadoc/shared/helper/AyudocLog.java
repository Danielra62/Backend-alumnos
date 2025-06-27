package com.fisiunmsm.ayudadoc.shared.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * AyudocLog: Logger centralizado usando patrón Singleton.
 * Loguea en consola y archivo (según configuración log4j2.xml).
 */
public class AyudocLog {

    // Instancia única
    private static AyudocLog instancia;

    // Logger asociado al nombre del paquete configurado en log4j2.xml
    private static final Logger logger = LogManager.getLogger("com.fisiunmsm.ayudadoc.alumno");

    // Constructor privado
    private AyudocLog() {}

    // Singleton getInstance
    public static synchronized AyudocLog getInstance() {
        if (instancia == null) {
            instancia = new AyudocLog();
        }
        return instancia;
    }

    // Métodos por nivel
    public void debug(String mensaje) {
        logger.debug(mensaje);
    }

    public void info(String mensaje) {
        logger.info(mensaje);
    }

    public void warn(String mensaje) {
        logger.warn(mensaje);
    }

    public void error(String mensaje) {
        logger.error(mensaje);
    }

    public void fatal(String mensaje) {
        logger.fatal(mensaje);
    }

    // Método general
    public void log(String level, String mensaje) {
        switch (level.toLowerCase()) {
            case "debug":
                debug(mensaje);
                break;
            case "info":
                info(mensaje);
                break;
            case "warn":
                warn(mensaje);
                break;
            case "error":
                error(mensaje);
                break;
            case "fatal":
                fatal(mensaje);
                break;
            default:
                info(mensaje);
                break;
        }
    }
}
