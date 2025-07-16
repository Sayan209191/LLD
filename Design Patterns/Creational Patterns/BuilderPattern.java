// Builder Pattern :  The Builder Pattern is a creational design pattern that allows for the step-by-step construction of complex objects.
// It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
import java.util.*;
// import lombok.Builder;

// Bun
// patty
// 

// Optional
// sides
// topings
// cheese

// class BurgerMeal{
//     private String bun;
//     private String patty;

//     public BurgerMeal(String bun, String patty) {
//         this.bun = bun;
//         this.patty = patty;
//     }

// }

class BurgerMeal{
    // Required
    private final String bunType;
    private final String patty;

    // Optional
    private final boolean hasChees;
    private final List<String> toopings;
    private final String side;
    private final String drink;

    // Private Constructuor
    private BurgerMeal(BurgerBuilder builder) {
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasChees = builder.hasChees;
        this.toopings = builder.toopings;
        this.side = builder.side;
        this.drink = builder.drink;
    }

    public static class BurgerBuilder{
        // Required
        private final String bunType;
        private final String patty;

        // Optional
        private boolean hasChees;
        private List<String> toopings;
        private String side;
        private String drink;

        public BurgerBuilder(String bunType, String patty){
            this.bunType = bunType;
            this.patty = patty;
        }

        public BurgerBuilder withChees(boolean hasChees){
            this.hasChees = hasChees;
            return this;
        }
        public BurgerBuilder withToopings(List<String> toopings){
            this.toopings = toopings;
            return this;
        }
        public BurgerBuilder withSide(String side){
            this.side = side;
            return this;
        }
        public BurgerBuilder withDrink(String drink){
            this.drink = drink;
            return this;
        }
        public BurgerMeal build(){
            return new BurgerMeal(this);
        }
    }

}

public class BuilderPattern {
    public static void main(String[] args) {
        // BurgerMeal burgerMeal = new BurgerMeal("Wheet", "veg");

        BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder("Wheet", "veg").build();
        BurgerMeal burgerMealWithChees = new BurgerMeal.BurgerBuilder("Wheet", "veg").withChees(true).build();
        BurgerMeal burgerMealWithCheesWithSide = new BurgerMeal.BurgerBuilder("Wheet", "veg").withChees(true).withSide("fries").build();

        // CartServices cartServices = CartServices.builder()
        //                             .productName("White Sneekers")
        //                             .quantity(1).price(7000)
        //                             .companyName("Puma").build();
        
        // cartServices.getCartDetails();
    }
}
// Using Lomok Builder Annotation
// @Builder
// class CartServices{
//     // Required
//     private int quantity;
//     private long price;
//     private String productName;
//     private String companyName;

//     // optional 
//     private long discountedPrice;
//     private boolean saveForLater;
//     private String colour;
//     private String Size;

//     public void getCartDetails(){
//         System.out.println(productName + " From " + companyName + quantity + " Pices" + "\n With Total Price " + price );
//     }
    

// }