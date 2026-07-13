package codeAlpha_StockTradingPlatform;



public class Transaction {

    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;

    public Transaction(String type, String stockSymbol, int quantity, double price) {

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;

    }

    public String getType() {
        return type;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {

        return type + " | " +
                stockSymbol + " | Qty: " +
                quantity + " | ₹" +
                price;

    }

}