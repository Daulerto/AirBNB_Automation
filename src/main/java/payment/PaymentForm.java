package payment;

public class PaymentForm {
    public class PaymentMethod {

        private String cardNumber;
        private String cardHolderName;
        private String expiryDate;
        private String cvv;
        private double balance;

        // Constructor to initialize the payment method details
        public PaymentMethod(String cardNumber, String cardHolderName, String expiryDate, String cvv, double balance) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
            this.expiryDate = expiryDate;
            this.cvv = cvv;
            this.balance = balance;
        }

        // Method to simulate processing a payment
        public boolean processPayment(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                return false;
            }

            if (amount > balance) {
                System.out.println("Insufficient funds. Payment failed.");
                return false;
            }

            balance -= amount;
            System.out.println("Payment of $" + amount + " successfully processed.");
            System.out.println("Remaining balance: $" + balance);
            return true;
        }

        // Method to check the available balance
        public double getBalance() {
            return balance;
        }

        // Method to display payment details (for debugging or testing purposes)
        public void displayPaymentDetails() {
            System.out.println("Cardholder Name: " + cardHolderName);
            System.out.println("Card Number: " + cardNumber);
            System.out.println("Expiry Date: " + expiryDate);
            System.out.println("CVV: " + cvv);
            System.out.println("Balance: $" + balance);
        }

        public static void main(String[] args) {
            // Create a PaymentMethod instance with sample data
            PaymentMethod payment = new PaymentMethod("1234 5678 9876 5432", "John Doe", "12/25", "123", 1000.00);

            // Display payment method details
            payment.displayPaymentDetails();

            // Try to process a payment
            payment.processPayment(200.00);  // Successful payment
            payment.processPayment(1000.00); // Insufficient funds
            payment.processPayment(-50.00);  // Invalid amount
        }
    }

}
