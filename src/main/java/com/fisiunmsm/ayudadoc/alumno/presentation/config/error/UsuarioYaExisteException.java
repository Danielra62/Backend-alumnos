package com.fisiunmsm.ayudadoc.alumno.presentation.config.error;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fisiunmsm.ayudadoc.shared.error.ApiException;

public class UsuarioYaExisteException extends ApiException {

    public UsuarioYaExisteException(MessageSource mensajes, String username) {
        super(
            mensajes.getMessage("auth.err.registro.tit", null, LocaleContextHolder.getLocale()),
            mensajes.getMessage("auth.err.registro.desc", new String[]{username}, LocaleContextHolder.getLocale())
        );
    }
    
    public UsuarioYaExisteException(String message) {
        super("Error en registro", message);
    }
}