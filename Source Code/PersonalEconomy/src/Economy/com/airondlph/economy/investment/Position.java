package com.airondlph.economy.investment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author Airondlph
 * 
 */
public class Position {
    public static final short ID_LENGTH = 32;
    
    private byte[] id;
    private String name;
    private PositionType type;

    public Position() {
        this(PositionType.GENERIC);
    }
    
    protected Position(PositionType type) {
        this.type = type;
        generateId();
    }
    
    protected final void generateId() {
        int offset = 0;
        SimpleDateFormat dtf;
        String format = "yyyyMMddHHmmssS";
        short dateSize;
        
        // ID
        id = new byte[ID_LENGTH];
        
        // TYPE
        System.arraycopy(type.getId(), 0, id, offset, PositionType.ID_LENGTH);
        offset += PositionType.ID_LENGTH;
        
        // DATE
        dtf = new SimpleDateFormat(format);
        dtf.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateSize = (short)format.length();
        System.arraycopy(dtf.format(new Date()).getBytes(), 0, id, offset, dateSize);
        offset += dateSize;
        
        // ZEROS
        while (offset < ID_LENGTH) {
            id[offset++] = '0';
        }
    }

    public byte[] getId() {
        return id;
    }

    public void setId(byte[] id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PositionType getType() {
        return type;
    }

    public void setType(PositionType type) {
        this.type = type;
    }
    
}
