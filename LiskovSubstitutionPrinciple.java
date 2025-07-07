// Liskov Substitution Principle :
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
// Subtypes must be substitutable for their base types without altering the correctness of the program.
// In this example, we have a Notification class and its subclasses TextNotification and WpNotification.

class Notification{
    public void sendNotification() {
        System.out.println("Email Notification" );
    }
}
class TextNotification extends Notification {
    @Override
    public void sendNotification() {
        System.out.println("Text Notification" );
    }
}

class WpNotification extends Notification {
    @Override
    public void sendNotification() {
        System.out.println("Wp Notification" );
    }
}

public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {
        Notification emailNotification = new Notification();
        emailNotification.sendNotification();
        Notification textNotification = new TextNotification();
        textNotification.sendNotification();
        Notification wpNotification = new WpNotification();
        wpNotification.sendNotification();
        // The code above adheres to the Liskov Substitution Principle
        // because we can replace the parent class with any of its subclasses
    }
}