package com.airondlph.economy.bank;

import com.airondlph.economy.Id;
import com.airondlph.economy.money.Money;
import java.util.Calendar;

/**
 * 
 * @author Airondlph
 * 
 */
public class Operation {    
    private Id id;
    private OperationType type;
    private Money money;
    private Calendar date;

    public Operation() {
    
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

}
