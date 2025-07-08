// Open-Closed Principle (OCP) is one of the SOLID principles of object-oriented design.
// It states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
// This means that the behavior of a module can be extended without modifying its source code.
// Bad Code

// class TaxCalculator {
//     public double calculateAmountAfterTax(double amount, String country) {
//         if (country.equals("INDIA")) {
//             return amount + (amount * 0.18);
//         } else if (country.equals("USA")) {
//             return amount + (amount * 0.07);
//         } else if (country.equals("UK")) {
//             return amount + (amount * 0.2);
//         } 
//         return amount;
//     }
// }

// class InvoiceGenerator {
//     TaxCalculator taxCalculator = new TaxCalculator();
//     public double generateInvoice(double amount, String country) {
//         return taxCalculator.calculateAmountAfterTax(amount, country);
//     }
// }

// Good Code


// Tax strategy Interface
interface TaxCalculator {
    double calculateTax(double amount);
}

// Implementing Region-Specific Tax Calculators
class IndiaTaxCalculator implements TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.18; 
    }
}
class USTaxCalculator implements TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.08; 
    }
}
class UKTaxCalculator implements TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.12; 
    }
}

// Using dependency Injection
class Invoice {
    private double amount;
    private TaxCalculator taxCalculator;

    public Invoice(double amount, TaxCalculator taxCalculator) {
        this.amount = amount;
        this.taxCalculator = taxCalculator;
    }

    public double getTotalAmount() {
        return amount + taxCalculator.calculateTax(amount);
    }
}


public class OpenClosedPrinciple{
    public static void main(String[] args) {
        double amount = 1000.0;

        Invoice indiaInvoice = new Invoice(amount, new IndiaTaxCalculator());
        System.out.println("Total (India): ₹" + indiaInvoice.getTotalAmount());

        Invoice usInvoice = new Invoice(amount, new USTaxCalculator());
        System.out.println("Total (US): $" + usInvoice.getTotalAmount());

        Invoice ukInvoice = new Invoice(amount, new UKTaxCalculator());
        System.out.println("Total (UK): £" + ukInvoice.getTotalAmount());
    }
}