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

    // Getter for bunType
    public String getBunType() {
        return bunType;
    }

    // Getter for patty
    public String getPatty() {
        return patty;
    }

    // Private Constructuor
    private BurgerMeal(BurgerBuilder builder) {
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasChees = builder.hasChees;
        this.toopings = builder.toopings;
        this.side = builder.side;
        this.drink = builder.drink;
    }

    // Getter for hasChees
    public boolean hasChees() {
        return hasChees;
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

        CartServices cartServices = new CartServices.CartBuilder()
            .productName("White Sneekers")
            .quantity(1)
            .price(7000)
            .companyName("Puma")
            .build();
        cartServices.getCartDetails();
    }
}
// Using Lomok Builder Annotation
// @Builder
class CartServices {
    // Required
    private final int quantity;
    private final long price;
    private final String productName;
    private final String companyName;

    // Optional 
    private final long discountedPrice;
    private final boolean saveForLater;
    private final String colour;
    private final String size;

    private CartServices(CartBuilder builder) {
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.productName = builder.productName;
        this.companyName = builder.companyName;
        this.discountedPrice = builder.discountedPrice;
        this.saveForLater = builder.saveForLater;
        this.colour = builder.colour;
        this.size = builder.size;
    }

    public static class CartBuilder {
        // Required
        private int quantity;
        private long price;
        private String productName;
        private String companyName;

        // Optional 
        private long discountedPrice;
        private boolean saveForLater;
        private String colour;
        private String size;

        public CartBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public CartBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartBuilder price(long price) {
            this.price = price;
            return this;
        }

        public CartBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public CartBuilder discountedPrice(long discountedPrice) {
            this.discountedPrice = discountedPrice;
            return this;
        }

        public CartBuilder saveForLater(boolean saveForLater) {
            this.saveForLater = saveForLater;
            return this;
        }

        public CartBuilder colour(String colour) {
            this.colour = colour;
            return this;
        }

        public CartBuilder size(String size) {
            this.size = size;
            return this;
        }

        public CartServices build() {
            return new CartServices(this);
        }
    }

    public void getCartDetails() {
        System.out.println(productName + " From " + companyName + " " + quantity + " Pieces" + "\nWith Total Price " + price);
    }
}