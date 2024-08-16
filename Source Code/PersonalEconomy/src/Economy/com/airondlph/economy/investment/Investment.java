package com.airondlph.economy.investment;

import com.airondlph.economy.Id;
import com.airondlph.economy.bank.Operation;
import com.airondlph.economy.money.Money;
import com.airondlph.economy.money.MoneyUnit;
import java.util.HashMap;

/**
 * 
 * @author Airondlph
 * 
 */
public abstract class Investment {
    private final HashMap<Id,Operation> operations;
    private final Position position;
    
    public Investment(Position position) {
        operations = new HashMap<>();
        this.position = position;
    }
    
    public boolean addOperation(Operation operation) {
        if (operation.getType() == null) return false;
        if (operation.getMoney() == null) return false;
        if (operation.getDate() == null) return false;
        if (operation.getId() == null) return false;
        
        operations.put(operation.getId(), operation);
        return true;
    }
    
    public Money getInvertedMoney(MoneyUnit units) {
        if (operations == null || operations.isEmpty()) return new Money(null, units);
        
        Money inverted = new Money(0D, units);
        
        operations.values().forEach((operation) -> {
            switch (operation.getType()) {
                case IN:
                    inverted.add(operation.getMoney(), operation.getDate());
                    break;
                case OUT:
                    inverted.sub(operation.getMoney(), operation.getDate());
                    break;
                default:
                    break;
                    
            }
            
        });
        
        return inverted;
    }
    
}
