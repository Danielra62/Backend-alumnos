package com.fisiunmsm.ayudadoc.alumno.presentation.config.error;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fisiunmsm.ayudadoc.shared.error.ApiException;

public class CredencialesInvalidasException extends ApiException {

    public CredencialesInvalidasException(MessageSource mensajes) {
        super(
            mensajes.getMessage("auth.err.credenciales.tit", null, LocaleContextHolder.getLocale()),
            mensajes.getMessage("auth.err.credenciales.desc", null, LocaleContextHolder.getLocale())
        );
    }
}