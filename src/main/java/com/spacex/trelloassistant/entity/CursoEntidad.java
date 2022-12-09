package com.spacex.trelloassistant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CURSO")
public class CursoEntidad {
    @Id
    @SequenceGenerator(name = "CURSO_SEQ", sequenceName = "CURSO_SEQ",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "CURSO_SEQ")
    @Column(name = "CURSO_ID")
    private Long cursoId;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "CARGA_ARCHIVO_ID", nullable = false)
    private CargaArchivoEntidad archivo;

    @Column(name = "DESCRIPTION_ERROR")
    private String descriptionError;

    @Column(name = "SINCRONIZADO_SERVICIO")
    private boolean sincronizado_servicio;

    @Column(name="TITULO_SEO_ES")
    private String tituloSEOES;

    @Column(name="TITULO_SEO_EN")
    private String titleSEOEN;

    @Column(name="METADESCRIPTION_SEO_ES")
    private String metadescriptionSEOES;

    @Column(name="METADESCRIPTION_SEO_EN")
    private String metadescriptionSEOEN;

    @Column(name="REL_CANONICAL")
    private String relCanonical;

    @Column(name="SLUG_ES")
    private String slugES;

    @Column(name="SLUG_EN")
    private String slugEN;

    @Column(name="KEYWORDS_ES")
    private String keywordsES;

    @Column(name="KEYWORDS_EN")
    private String keywordsEN;

    @Column(name="BREDCRUMB1_ES")
    private String bredcrumb1ES;

    @Column(name="TITULO_PAGINA_ES")
    private String tituloPaginaES;

    @Column(name="TITULO_PAGINA_EN")
    private String tituloPaginaEN;

    @Column(name="TITULO_CURSO_ES")
    private String tituloCursoES;

    @Column(name="TITULO_CURSO_EN")
    private String tituloCursoEN;

    @Column(name="TIPO_CURSO_ES")
    private String tipoCursoES;

    @Column(name="TIPO_CURSO_EN")
    private String tipoCursoEN;

    @Column(name="ID_ASSER_iMAGEN_BIG_CARD")
    private String IDAssetImagenBigCard;

    @Column(name="ID_IMG_CURSO_DESKTOP")
    private String IDIMGCursoDesktop;

    @Column(name="ID_IMG_CURSO_MOBILE")
    private String IDIMGCursoMobile;

    @Column(name="DESCRIPCION_ES")
    private String descripciónES;

    @Column(name="DESCRIPCION_EN")
    private String descripciónEN;

    @Column(name="CODIGO_EVENTO_CON_COSTO")
    private String codigoEventoConCosto;

    @Column(name="ENLACE_INSCRIPCION_SIN_COSTO")
    private String enlaceInscripciónSinCosto;

    @Column(name="RUTA_CURSO_TARJETA_SABER_MAS_ES")
    private String rutaCursoTarjetaSabeMasES;

    @Column(name="RUTA_CURSO_TARJETA_SABER_MAS_EN")
    private String rutaCursoTarjetaSabeMasEN;

    @Column(name="AREA_ES")
    private String areaES;

    @Column(name="AREA_EN")
    private String areaEN;

    @Column(name="MODALIDAD_ES")
    private String modalidadES;

    @Column(name="MODALIDAD_EN")
    private String modalidadEN;

    @Column(name="SECTOR_ES")
    private String sectorES;

    @Column(name="SECTOR_EN")
    private String sectorEN;

    @Column(name="LUGAR_ES")
    private String lugarES;

    @Column(name="LUGAR_EN")
    private String lugarEN;

    @Column(name="FECHA_INICIO_ES")
    private String fechaInicioES;

    @Column(name="FECHA_INICIO_EN")
    private String fechaInicioEN;

    @Column(name="FECHA_FINALIZACION_ES")
    private String fechaFinalizaciónES;

    @Column(name="FECHA_FINALIZACION_ES")
    private String fechaFinalizaciónEN;

    @Column(name="HORARIO_ES")
    private String horarioES;

    @Column(name="HORARIO_EN")
    private String horarioEN;

    @Column(name="COSTO_ES")
    private String costoES;

    @Column(name="PRECIO")
    private String precio;

    @Column(name="MOSTRAR_LIKES")
    private String mostrarLikes;

    @Column(name="MOSTRAR_COMPARTIR")
    private String mostrarCompartir;

    @Column(name="MOSTRAR_INSCRIPTOS")
    private String mostrarInscriptos;

    @Column(name="SELECCIONAR_COMO_BIG_CARD")
    private String seleccionarComoBigCard;

    @Column(name="MOSTRAR_EN_INICIO")
    private String mostrarEnInicio;

    @Column(name="MOSTRAR_NUEVO_LANZAMIENTO")
    private String mostrarNuevoLanzamiento;

    @Column(name="METODOLOGIA_ES")
    private String metodologiaES;

    @Column(name="METODOLOGIA_EN")
    private String metodologiaEN;

    @Column(name="CONTENIDO_ES")
    private String contenidoES;

    @Column(name="CONTENIDO_EN")
    private String contendioEN;

    @Column(name="CIERRE_INSCRIPCION_ES")
    private String cierreInscripcionES;

    @Column(name="REQUISITOS_EN")
    private String requisitosEN;

    @Column(name="REQUISITOS_ES")
    private String requisitosES;

    @Column(name="DIRIGIDO_EN")
    private String dirigidoEN;

    @Column(name="DIRIGIDO_ES")
    private String dirigidoES;

    @Column(name="CERTIFICACION_ES")
    private String certificacionES;

    @Column(name="CERTIFICACION_EN")
    private String certificacionEN;

    @Column(name="SESIONES_ES")
    private String sesionesES;

    @Column(name="SESIONES_EN")
    private String sesionesEN;


}