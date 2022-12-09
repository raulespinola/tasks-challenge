package com.spacex.trelloassistant.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SectorES {

    MULTISECTORIAL("multisectorial"), INDUSTRIAS_CREATIVAS_CULTURALES_GRAFICAS("industriasCreativasCulturalesGraficas"),
    AGROPECUARIO_AGRO_INDUSTRIAL("agropecuarioAgroIndustrial"), CONSTRUCCION_ENERGIA("construccionEnergia"),
    SALUD_QUIMICOS("saludQuimicos"), TIC("TIC"), TURISMO_GASTRONOMIA("turismoGastronomia"),
    MODA("moda"), SERVICIOS_EMPRESARIALES("serviciosEmpresariales");

        private String value;
    }
