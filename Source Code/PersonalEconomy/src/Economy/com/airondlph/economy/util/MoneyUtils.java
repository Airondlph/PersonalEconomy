package com.airondlph.economy.util;

import com.airondlph.economy.money.MoneyUnit;
import java.util.Calendar;

/**
 * 
 * @author 
 * 
 */
public class MoneyUtils {
    
    public static Double parse(MoneyUnit from, MoneyUnit to, Double value) {
        if (value == null) return 0D;
        if (value == 0D) return 0D;
        if (from == null) return value;
        if (to == null) return value;
        if (from.equals(to)) return value;
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static Double parse(MoneyUnit from, MoneyUnit to, Calendar when, Double value) {
        if (when == null) return parse(from, to, value);
        if (value == null) return 0D;
        if (value == 0D) return 0D;
        if (from == null) return value;
        if (to == null) return value;
        if (from.equals(to)) return value;
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
