package com.fisiunmsm.ayudadoc.alumno.application.error;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fisiunmsm.ayudadoc.shared.error.ApiException;

public class UsuarioNoEncontradoException extends ApiException {

    public UsuarioNoEncontradoException(MessageSource mensajes, String username) {
        super(
            mensajes.getMessage("auth.err.no_encontrado.tit", null, LocaleContextHolder.getLocale()),
            mensajes.getMessage("auth.err.no_encontrado.desc", new String[]{username}, LocaleContextHolder.getLocale())
        );
    }
    
    public UsuarioNoEncontradoException(String message) {
        super("Autenticación fallida", message);
    }
}