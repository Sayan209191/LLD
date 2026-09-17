/**
 * ============================================================================
 * PROTOTYPE PATTERN (Creational Design Pattern)
 * ============================================================================
 * 
 * 1. DEFINITION:
 *    The Prototype Pattern allows creating new objects by copying (cloning)
 *    an existing instance (the prototype) instead of creating them from scratch
 *    using constructors (`new` operator).
 * 
 * 2. WHY USE IT?
 *    - Expensive Object Creation: If creating an object involves heavy database
 *      queries, file I/O, network requests, or complex computations, cloning
 *      an existing in-memory object is significantly faster.
 *    - Template / Preset Customization: When objects share a common baseline
 *      configuration and only a few fields differ (e.g., email templates, game
 *      character presets, UI themes).
 *    - Decoupling: Client code gets clones without coupling to concrete classes.
 *    - Eliminates Subclassing: Avoids maintaining subclasses for every static preset.
 * 
 * 3. KEY COMPONENTS IN THIS CODE:
 *    a) Prototype Interface (`EmailTemplate`):
 *       Declares the cloning method (`clone()`). In Java, it extends `Cloneable`.
 *    b) Concrete Prototype (`WelcomeEmail`):
 *       Implements `clone()` using `super.clone()`. Contains default state
 *       (subject, content).
 *    c) Prototype Registry (`EmailTemplateRegistry`):
 *       Maintains a cache/map of pre-configured prototype objects. Clients request
 *       a template by key (e.g., "welcome"), and the registry returns a clone.
 *    d) Client (`PrototypePattern` / `main`):
 *       Calls `EmailTemplateRegistry.getTemplate(...)` to obtain an isolated clone
 *       and updates specific fields (`setContent(...)`) without affecting the original.
 * 
 * 4. SHALLOW COPY VS. DEEP COPY:
 *    - Shallow Copy: Copies primitive fields and object references. If the object
 *      contains mutable nested objects/collections, both original and clone share
 *      the same references (mutations affect both).
 *    - Deep Copy: Recursively clones all nested objects. The clone is fully
 *      independent. (Recommended when objects contain mutable reference fields).
 * ============================================================================
 */
import java.util.*;

interface EmailTemplate extends Cloneable{
    EmailTemplate clone(); // Deep Copy recomended
    void setContent(String content);
    void send(String to);
}


class WelcomeEmail implements EmailTemplate {
    private String subject;
    private String content;

    public WelcomeEmail() {
        this.subject = "Welcome to TUF+";
        this.content = "Hi there! Thanks for joining us.";
    }

    @Override
    public WelcomeEmail clone() {
        try {
            return (WelcomeEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
}

// Template Registry to store and provide clones
class EmailTemplateRegistry {
    private static final Map<String, EmailTemplate> templates = new HashMap<>();

    static {
        templates.put("welcome", new WelcomeEmail());
        // templates.put("discount", new DiscountEmail());
        // templates.put("feature-update", new FeatureUpdateEmail());
    }

    public static EmailTemplate getTemplate(String type) {
        return templates.get(type).clone(); // clone to avoid modifying original
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        EmailTemplate welcomeEmail1 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail1.setContent("Hi Alice, welcome to TUF Premium!");
        welcomeEmail1.send("alice@example.com");

        EmailTemplate welcomeEmail2 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail2.setContent("Hi Bob, thanks for joining!");
        welcomeEmail2.send("bob@example.com");
    }
}
