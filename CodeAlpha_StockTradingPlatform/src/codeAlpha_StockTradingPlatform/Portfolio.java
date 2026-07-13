package codeAlpha_StockTradingPlatform;



import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private HashMap<String, Integer> holdings = new HashMap<>();

    public void buyStock(String symbol, int quantity) {

        holdings.put(symbol,
                holdings.getOrDefault(symbol, 0) + quantity);

    }

    public boolean sellStock(String symbol, int quantity) {

        if (!holdings.containsKey(symbol)) {

            System.out.println("You don't own this stock.");
            return false;

        }

        int owned = holdings.get(symbol);

        if (quantity > owned) {

            System.out.println("Insufficient shares.");
            return false;

        }

        if (quantity == owned) {

            holdings.remove(symbol);

        } else {

            holdings.put(symbol, owned - quantity);

        }

        System.out.println(quantity + " shares sold successfully.");

        return true;

    }

    public void displayPortfolio() {

        if (holdings.isEmpty()) {

            System.out.println("\nPortfolio is empty.");
            return;

        }

        System.out.println("\n========== YOUR PORTFOLIO ==========");

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {

            System.out.println(entry.getKey() +
                    " | Shares : " +
                    entry.getValue());

        }

    }

    public HashMap<String, Integer> getHoldings() {
        return holdings;
    }

}