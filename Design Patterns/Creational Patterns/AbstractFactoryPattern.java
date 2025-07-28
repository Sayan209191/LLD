interface PaymentGateWay{
    void processPayment(double amount);
}
class RazorPayGateWay implements PaymentGateWay{
    @Override
    public void processPayment(double amount){
        System.out.println("Payment of " + amount + " processed through RazorPay.");
    }
}

class PayUGateWay implements PaymentGateWay{
    @Override
    public void processPayment(double amount){
        System.out.println("Payment of " + amount + " processed through PayU.");
    }
}

class StripeGateWay implements PaymentGateWay{
    @Override
    public void processPayment(double amount){
        System.out.println("Payment of " + amount + "$ processed through Stripe.");
    }
}

class PayPalGateWay implements PaymentGateWay{
    @Override
    public void processPayment(double amount){
        System.out.println("Payment of " + amount + "$ processed through Paypal.");
    }

}



interface InvoiceService{
    void generateInvoice();
}

class GSTInvoiceService implements InvoiceService{
    @Override
    public void generateInvoice(){
        System.out.println("GST Invoice generated.");
    }
}

class USInvoiceService implements InvoiceService{
    @Override
    public void generateInvoice(){
        System.out.println("US Invoice generated.");
    }
}


interface RegionFactory{
    PaymentGateWay createPaymentGateWay(String gatewayType);
    InvoiceService createInvoice();
}

class IndiaFactory implements RegionFactory{
    public PaymentGateWay createPaymentGateWay(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "razorpay":
                return new RazorPayGateWay();
            case "payu":
                return new PayUGateWay();
        
            default:
                throw new IllegalArgumentException("Unsupported Payment Gateway In India");
        }
    }

    public InvoiceService createInvoice(){
        return new GSTInvoiceService();
    } 
}

class USFactory implements RegionFactory{
    public PaymentGateWay createPaymentGateWay(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "stripe":
                return new StripeGateWay();
            case "paypal":
                return new PayPalGateWay();
        
            default:
                throw new IllegalArgumentException("Unsupported Payment Gateway In India");
        }
    }

    public InvoiceService createInvoice(){
        return new USInvoiceService();
    } 
}

// class CheckOutService {
//     private String gatewayType;
//     public CheckOutService(String gatewayType) {
//         this.gatewayType = gatewayType;
//     }

//     public void checkOut(double ammount) {
//         PaymentGateWay paymentGateWay = IndiaFactory.createPaymentGateWay(gatewayType);
//         paymentGateWay.processPayment(ammount);

//         InvoiceService invoiceService = IndiaFactory.creatInvoice();
//         invoiceService.generateInvoice();
//     }

// }


class CheckOutService{
    private PaymentGateWay paymentGateWay;
    private InvoiceService invoice;
    private String gatewayType;

    public CheckOutService(RegionFactory factory, String gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateWay = factory.createPaymentGateWay(gatewayType);
        this.invoice = factory.createInvoice();
    }
    public void completeOrder(double amount) {
        paymentGateWay.processPayment(amount);
        invoice.generateInvoice();
    }
}



public class AbstractFactoryPattern {
    public static void main(String[] args) {
        
        CheckOutService checkOutService = new CheckOutService(new IndiaFactory(), "razorpay");
        checkOutService.completeOrder(1500);

        CheckOutService checkOutService2 = new CheckOutService(new USFactory(), "paypal");
        checkOutService2.completeOrder(200);
    }
}
