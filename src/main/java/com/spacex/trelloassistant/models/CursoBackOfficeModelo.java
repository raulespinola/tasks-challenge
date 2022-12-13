package com.spacex.trelloassistant.models;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoBackOfficeModelo {
    private Long id;
    private String tituloSEOES;
    private String tituloSEOEN;
    private String metadescriptionSEOES;
    private String metadescriptionSEOEN;
    private String relCanonical;
    private String slugEs;
    private String slugEN;
    private String keywordsES;
    private String keywordsEN;
    private String bredcrumb1ES;
    private String tituloPaginaES;
    private String tituloPaginaEn;
    private String tituloCursoES;
    private String tituloCursoEN;
    private String tipoCursoES;
    private String tipoCursoEN;
    private String IDAssetImagenBigCard;
    private String IDIMGCursoDesktop;
    private String IDIMGCursoMobile;
    private String descripcionES;
    private String descripciónEN;
    private String codigoEventoConCosto;
    private String enlaceInscripciónSinCosto;
    private String rutaCursoTarjetaSabeMasES;
    private String rutaCursoTarjetaSabeMasEN;
    private String areaES;
    private String areaEN;
    private String modalidadES;
    private String modalidadEN;
    private String sectorES;
    private String sectorEN;
    private String lugarES;
    private String lugarEN;
    private String fechaInicioES;
    private String fechaInicioEN;
    private String fechaFinalizaciónES;
    private String fechaFinalizaciónEN;
    private String horarioES;
    private String horarioEN;
    private String costoES;
    private String precio;
    private String mostrarLikes;
    private String mostrarCompartir;
    private String mostrarInscriptos;
    private String seleccionarComoBigCard;
    private String mostrarEnInicio;
    private String mostrarNuevoLanzamiento;
    private String metodologiaES;
    private String metodologiaEN;
    private String contenidoES;
    private String contenidoEN;
    private String cierreInscripcionES;
    private String requisitosEN;
    private String requisitosES;
    private String dirigidoEN;
    private String dirigidoES;
    private String certificacionES;
    private String certificacionEN;
    private String sesionesES;
    private String sesionesEN;

}
