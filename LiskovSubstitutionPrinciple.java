class Notitification{
    public void sendNotification() {
        System.out.println("Email Notification" );
    }
}
class TextNotitification extends Notitification {
    @Override
    public void sendNotification() {
        System.out.println("Text Notification" );
    }
}

class WpNotitification extends Notitification {
    @Override
    public void sendNotification() {
        System.out.println("Wp Notification" );
    }
}

public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {
        Notitification emailNotification = new Notitification();
        emailNotification.sendNotification();
        Notitification textNotification = new TextNotitification();
        textNotification.sendNotification();
        Notitification wpNotification = new WpNotitification();
        wpNotification.sendNotification();
        // The code above adheres to the Liskov Substitution Principle
        // because we can replace the parent class with any of its subclasses
    }
}