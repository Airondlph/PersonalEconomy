package com.airondlph.economy.money;

import com.airondlph.economy.util.MoneyUtils;
import java.util.Calendar;

/**
 * 
 * @author Airondlph
 * 
 */
public class Money {
    private Double value;
    private MoneyUnit units;

    public Money(Double value, MoneyUnit units) {
        this.value = value;
        this.units = units;
    }

    /**
     * Gets money value.
     * 
     * @return money value.
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets money value.
     * 
     * @param value money value.
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Gets money units.
     * 
     * @return money units.
     */
    public MoneyUnit getUnits() {
        return units;
    }

    /**
     * Sets money units.
     * 
     * @param units money units.
     */
    public void setUnits(MoneyUnit units) {
        this.units = units;
    }
    
    /**
     * Return the value of this money in other units.
     * 
     * @param units Units to parse this money.
     * 
     * @return this money value in specified units.
     */
    public Money parse(MoneyUnit units) {
        return new Money(MoneyUtils.parse(this.units, units, value), units);
    }
    
    /**
     * Return the value of this money in other units in a specific date.
     * 
     * @param units Units to parse this money.
     * @param date Date used to get the conversion coeficient.
     * 
     * @return this money value in specified units for a specific date.
     */
    public Money parse(MoneyUnit units, Calendar date) {
        return new Money(MoneyUtils.parse(this.units, units, date, value), units);
    }
    
    /**
     * Adds the money value given as parameter to this money, doing conversion 
     * with current conversion coeficient.
     * 
     * @param money Money to add.
     */
    public void add(Money money) {
        if (money.getUnits() == null) return;
        
        value += money.parse(units).getValue();
    }
    
    /**
     * Adds the money value given as parameter to this money, doing conversion 
     * with the conversion coeficient of the time specified.
     * 
     * @param money Money to add.
     * @param date Date to will be used to get conversion coeficient.
     */
    public void add(Money money, Calendar date) {
        if (money == null) return;
        if (money.getUnits() == null) return;
        if (units == null) return;
        
        value += money.parse(units, date).getValue();
    }
    
    /**
     * Subs the money value given as parameter to this money, doing conversion 
     * with current conversion coeficient.
     * 
     * @param money Money to sub.
     */
    public void sub(Money money) {
        if (money.getUnits() == null) return;
        
        value -= money.parse(units).getValue();
    }
    
    /**
     * Subs the money value given as parameter to this money, doing conversion 
     * with the conversion coeficient of the time specified.
     * 
     * @param money Money to sub.
     * @param date Date to will be used to get conversion coeficient.
     */
    public void sub(Money money, Calendar date) {
        if (money == null) return;
        if (money.getUnits() == null) return;
        if (units == null) return;
        
        value -= money.parse(units, date).getValue();
    }

    @Override
    public String toString() {
        StringBuilder str;
        
        str = new StringBuilder(value == null ? "-" : value.toString());
        str.append(" ");
        str.append(units.getShortName());
        
        return str.toString();
    }
    
}
