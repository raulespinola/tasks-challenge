package com.spacex.trelloassistant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AreaES {
        MERCADEO_VENTAS("mercadeoVentas"), PRODUCCION_CALIDAD("producciónCalidad"),
        LEGAL_NORMATIVO("legalNormativo"), FINANCIERO_FINANCIAMIENTO("financierOFinanciamiento"),
        GESTION_HUMANA("gestiónHumana"),INNOVACION(" innovación"),
        INTERNACIONALIZACION("internacionalización"), SOLUCION_CONTROVERSIAS ("soluciónControversias"),
        ENTORNO_SECTORIAL ("entornoSectorial");

        private String value;
}

