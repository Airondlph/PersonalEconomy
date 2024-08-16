package com.airondlph.economy.investment;

/**
 *
 * @author Airondlph
 * 
 */
public enum PositionType {
    GENERIC(""),
    STOCK("STOCK"),
    STOCK_CFD("CDF"),
    INDEX("IDX"),
    ETF("ETF"),
    GOODS("GDS"),
    
    ;
    
    public static final short ID_LENGTH = 4;
    private byte[] id = new byte[ID_LENGTH];
    
    private PositionType(String idStr) {
        int offset = 0;
        
        for (byte b : idStr.getBytes()) {
            if (offset >= ID_LENGTH) return;
            id[offset++] = b;
        }
        
        while (offset < ID_LENGTH) {
            id[offset++] = '0';
        }
    }

    public byte[] getId() {
        return id;
    }
}
