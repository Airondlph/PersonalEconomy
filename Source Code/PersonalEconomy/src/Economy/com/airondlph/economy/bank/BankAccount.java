package com.airondlph.economy.bank;

import com.airondlph.economy.Id;
import com.airondlph.economy.Person;
import static com.airondlph.economy.bank.OperationType.IN;
import static com.airondlph.economy.bank.OperationType.OUT;
import com.airondlph.economy.money.Money;
import com.airondlph.economy.money.MoneyUnit;
import java.util.HashMap;

/**
 * 
 * @author Airondlph
 * 
 */
public class BankAccount {
    private Id id;
    private Person owner;
    private final HashMap<Id, Operation> operations;
    
    public BankAccount(Person owner) {
        this.owner = owner;
        this.operations = new HashMap<>();
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
    
    public Person getOwner() {
        return owner;
    }

    public HashMap<Id, Operation> getOperations() {
        return operations;
    }
    
    public boolean addOperation(Operation operation) {
        if (operation.getType() == null) return false;
        if (operation.getMoney() == null) return false;
        if (operation.getDate() == null) return false;
        if (operation.getId() == null) return false;
        
        operations.put(operation.getId(), operation);
        return true;
    }
    
    public Money getBalance(MoneyUnit units) {
        if (operations == null || operations.isEmpty()) return new Money(null, units);
        
        Money balance = new Money(0D, units);
        
        operations.values().forEach((operation) -> {
            switch (operation.getType()) {
                case IN:
                    balance.add(operation.getMoney(), operation.getDate());
                    break;
                case OUT:
                    balance.sub(operation.getMoney(), operation.getDate());
                    break;
                default:
                    break;
                    
            }
            
        });
        
        return balance;
    }
}
