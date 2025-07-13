// FactoryPattern : Rather than instantiating objects directly, a factory method is used to create objects.

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
