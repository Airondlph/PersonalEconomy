package com.airondlph.economy;

import java.util.Arrays;

/**
 * 
 * @author 
 * 
 */
public class Id {
    private byte[] id;
    
    public Id(byte[] id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if ((id == null) && (obj == null)) return true;
        if (id == null) return false;
        if (obj == null) return false;
        if (!(obj instanceof Id)) return false;
        
        Id other = (Id)obj;
        
        if (this.id.length != other.id.length) return false;
        
        for (int i = 0; i < this.id.length; i++) {
            if (this.id[i] != other.id[i]) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Arrays.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return new String(this.id);
    }
    
}
