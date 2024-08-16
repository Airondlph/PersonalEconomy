package com.airondlph.economy.money;

/**
 *
 * @author Airondlph
 * 
 */
public enum MoneyUnit {
    EURO ("EUR", "�"),
    DOLLAR ("DLR", "$")
    
    ;
    
    
    private String shortName;
    private String symbol;
    private MoneyUnit(String shortName, String symbol) {
        this.shortName = shortName;
        this.symbol = symbol;
    }

    public String getShortName() {
        return shortName;
    }

    public String getSymbol() {
        return symbol;
    }
}
