package com.spacex.trelloassistant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AreaEN {
    MERCADEO_VENTAS("marketingSales"), PRODUCTION_QUALITY("productionQuality"),
    LEGAL_REGULATORY("LegalRegulatory"), FINANCIAL_FINANCING("FinancialFinancing"),
    HUMAN_MANAGEMENT("humanManagement"),INNOVAIION(" innovation"),
    INTERNACIONALIZATION("Internacionalitación"), DISPUTE_RESOLUTION ("disputeResolution"),
    SECTOR_ENVIRONMENT ("sectorEnvironment");

    private String value;
}









