package views;

public enum GraphicReportTitle {
    CULTIVATED_AND_HARVESTED_FISHES_PER_YEAR(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_ONE),
    HARVESTED_FISHES_PER_TOWN_PER_YEAR(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TWO),
    CULTIVATED_FISHES_SPECIES_PER_YEAR(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_THREE),
    TOWN_EARNINGS_PER_YEAR(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FOUR),
    FISHES_SPECIES_WEIGHT_PER_UNIT(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_FIVE),
    FISH_FOOD_USING(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SIX),
    WATER_TYPE_USING(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_SEVEN);

    private String propertyText;

    GraphicReportTitle(String propertyText) {
        this.propertyText = propertyText;
    }

    public String getPropertyText() {
        return propertyText;
    }
}