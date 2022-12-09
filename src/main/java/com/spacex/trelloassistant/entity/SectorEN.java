package com.spacex.trelloassistant.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SectorEN {
    MULTISECTORAL("Multisectoral"), CREATIVE_CULTURAL_GRAPHIC_INDUSTRIES("creativeCulturalGraphicIndustries"),
    AGRICULTURAL_AGRO_INSDUSTRIAL("agriculturalAgroIndustrial"), CONSTRUCTION_ENERGY("constructionEnergy"),
    HEALTH_CHEMICAL(" healthChemicals"), TIC("TIC"), TOURISM_GASTRONOMY("tourismGastronomy"), FASHION("fashion"),
    BUSINESS_SERVICES(" businesServices");

    private String value;
    }
