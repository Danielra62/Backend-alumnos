package com.fisiunmsm.ayudadoc.alumno.presentation.dto;

public class AlumnoCursoRequestDto {
    private Long alumnoId;
    private Integer cursoId;
    private Integer periodoId;
    private Long departamentoId;
    public Long getAlumnoId() {
        return alumnoId;
    }
    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }
    public Integer getCursoId() {
        return cursoId;
    }
    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }
    public Integer getPeriodoId() {
        return periodoId;
    }
    public void setPeriodoId(Integer periodoId) {
        this.periodoId = periodoId;
    }
    public Long getDepartamentoId() {
        return departamentoId;
    }
    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    // Getters y setters
}
