package codeAlpha_StockTradingPlatform;


import java.io.*;
import java.util.ArrayList;

public class StockMarket {

    private ArrayList<Stock> stocks = new ArrayList<>();
    private Portfolio portfolio = new Portfolio();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    // Load stock data from file
    public void loadStocks() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("data/stocks.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String symbol = data[0];
                String company = data[1];
                double price = Double.parseDouble(data[2]);

                stocks.add(new Stock(symbol, company, price));

            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error loading stocks.");
            e.printStackTrace();

        }

    }

    // Display all stocks
    public void displayStocks() {

        System.out.println("\n=========== MARKET DATA ===========");

        for (Stock stock : stocks) {

            System.out.println(stock);

        }

    }

    // Search stock by symbol
    public void searchStock(String symbol) {

        boolean found = false;

        for (Stock stock : stocks) {

            if (stock.getSymbol().equalsIgnoreCase(symbol)) {

                System.out.println("\nStock Found");
                System.out.println(stock);

                found = true;
                break;

            }

        }

        if (!found) {

            System.out.println("Stock not found.");

        }

    }

    // Find stock by symbol
    public Stock findStock(String symbol) {

        for (Stock stock : stocks) {

            if (stock.getSymbol().equalsIgnoreCase(symbol)) {

                return stock;

            }

        }

        return null;

    }

    // Buy stock
    public void buyStock(String symbol, int quantity) {

        Stock stock = findStock(symbol);

        if (stock == null) {

            System.out.println("Stock not found.");
            return;

        }

        portfolio.buyStock(symbol, quantity);

        transactions.add(new Transaction(
                "BUY",
                symbol,
                quantity,
                stock.getPrice()));

        savePortfolio();
        saveTransactions();

        System.out.println(quantity + " shares of "
                + symbol + " purchased successfully.");

    }

    // Sell stock
    public void sellStock(String symbol, int quantity) {

        Stock stock = findStock(symbol);

        if (stock == null) {

            System.out.println("Stock not found.");
            return;

        }

        boolean sold = portfolio.sellStock(symbol, quantity);

        if (sold) {

            transactions.add(new Transaction(
                    "SELL",
                    symbol,
                    quantity,
                    stock.getPrice()));

            savePortfolio();
            saveTransactions();

        }

    }

    // View Portfolio
    public void viewPortfolio() {

        portfolio.displayPortfolio();

    }

    // View Transaction History
    public void viewTransactions() {

        if (transactions.isEmpty()) {

            System.out.println("\nNo transactions found.");
            return;

        }

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        for (Transaction transaction : transactions) {

            System.out.println(transaction);

        }

    }

    // Calculate Portfolio Value
    public void calculatePortfolioValue() {

        double total = 0;

        for (String symbol : portfolio.getHoldings().keySet()) {

            Stock stock = findStock(symbol);

            if (stock != null) {

                total += stock.getPrice()
                        * portfolio.getHoldings().get(symbol);

            }

        }

        System.out.printf("\nCurrent Portfolio Value : ₹%.2f%n", total);

    }

    // Save Portfolio
    public void savePortfolio() {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("data/portfolio.txt"));

            for (String symbol : portfolio.getHoldings().keySet()) {

                bw.write(symbol + ","
                        + portfolio.getHoldings().get(symbol));

                bw.newLine();

            }

            bw.close();

        } catch (IOException e) {

            System.out.println("Error saving portfolio.");

        }

    }

    // Save Transactions
    public void saveTransactions() {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("data/transactions.txt"));

            for (Transaction transaction : transactions) {

                bw.write(transaction.getType() + ","
                        + transaction.getStockSymbol() + ","
                        + transaction.getQuantity() + ","
                        + transaction.getPrice());

                bw.newLine();

            }

            bw.close();

        } catch (IOException e) {

            System.out.println("Error saving transactions.");

        }

    }

}
