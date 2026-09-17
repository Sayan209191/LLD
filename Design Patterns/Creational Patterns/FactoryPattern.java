/**
 * ============================================================================
 * FACTORY PATTERN (Creational Design Pattern)
 * ============================================================================
 * 
 * 1. DEFINITION:
 *    The Factory Pattern provides an interface or a dedicated factory class for
 *    creating objects without specifying the exact class of object that will
 *    be created. It delegates the instantiation logic away from the client.
 * 
 * 2. WHY USE IT?
 *    - Loose Coupling: The client code does not depend directly on concrete classes
 *      (e.g., Road, Air, Train); it only relies on the abstract interface (`Logistics`).
 *    - Single Responsibility Principle (SRP): Centralizes object creation logic
 *      in one dedicated place (`LogisticsFactory`), simplifying maintenance.
 *    - Open/Closed Principle (OCP): New transport types can be introduced without
 *      modifying client-facing business logic.
 *    - Encapsulation: Hides complex construction, parameter selection, and initialization
 *      details from the consumer.
 * 
 * 3. KEY COMPONENTS IN THIS CODE:
 *    a) Product Interface (`Logistics`):
 *       Declares the common contract (`send()`) for all logistics modes.
 *    b) Concrete Products (`Road`, `Air`, `Train`):
 *       Implement the `Logistics` interface with transport-specific logic.
 *    c) Factory (`LogisticsFactory`):
 *       Contains the factory method `getLogistics(String mode)` that evaluates the
 *       input and instantiates the appropriate concrete product.
 *    d) Client (`LogisticsService` / `FactoryPattern.main`):
 *       Requests a `Logistics` instance from the factory and invokes operations
 *       without ever directly referencing the concrete classes.
 * ============================================================================
 */

interface Logistics{
    void send();
}
class Road implements Logistics{
    @Override
    public void send(){
        System.out.println("Sending via Road");
    }
}
class Air implements Logistics{
    @Override
    public void send(){
        System.out.println("Sending via Air");
    }
}
// Add new Service -- Maintain Single Responsibility Principle
class Train implements Logistics{
    @Override
    public void send(){
        System.out.println("Sending via Train");
    }
}
class LogisticsFactory{
    public static Logistics getLogistics(String mode){
        if(mode.toUpperCase().equals("AIR")){
            return new Air();
            
        }else if(mode.toUpperCase().equals("ROAD")){
            return new Road();
        }
        // Easy to maintain OCP
        else if(mode.toUpperCase().equals("TRAIN")){
            return new Train();
        }
        return null;
    }
}

class LogisticsService{
    public void send(String mode){
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        LogisticsService logisticsService = new LogisticsService();
        logisticsService.send("train");
    }
}
