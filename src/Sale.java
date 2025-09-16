public class Sale {
    private static final double PRICE_BASE = 30.0;

    private double ticketValue;
    private double totalValue;
    private int age;
    private int quantity;
    private int kindOfTicket;
    private String category;

    public Sale(int age, int quantity, int kindOfTicket) {
        this.age = age;
        this.quantity = quantity;
        this.kindOfTicket = kindOfTicket;
        valueCalculation();
    }

    private void valueCalculation() {
        if (age < 5) {
            ticketValue = 0.0;
            category = "Grátis";
            totalValue = 0.0;
        } else {
            if (kindOfTicket == 1) {
                ticketValue = PRICE_BASE;
                category = "Inteira";
            } else if (kindOfTicket == 2) {
                ticketValue = PRICE_BASE * 0.5;
                category = "Meia";
            } else if (kindOfTicket == 3) {
                ticketValue = PRICE_BASE * 0.7;
                category = "Promocional";
            } else {
                ticketValue = PRICE_BASE;
                category = "Inteira";
            }
            totalValue = ticketValue * quantity;
        }
    }

    public double getTotalValue() {
        return totalValue;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity; }
}