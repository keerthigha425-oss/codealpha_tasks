package codeAlpha_StockTradingPlatform;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockMarket market = new StockMarket();

        market.loadStocks();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     STOCK TRADING PLATFORM");
            System.out.println("=================================");
            System.out.println("1. View Market Data");
            System.out.println("2. Search Stock");
            System.out.println("3. Buy Stock");
            System.out.println("4. Sell Stock");
            System.out.println("5. View Portfolio");
            System.out.println("6. Transaction History");
            System.out.println("7. Portfolio Value");
            System.out.println("8. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    market.displayStocks();
                    break;

                case 2:

                    System.out.print("Enter Stock Symbol : ");
                    String searchSymbol = sc.next();

                    market.searchStock(searchSymbol);
                    break;

                case 3:

                    System.out.print("Enter Stock Symbol : ");
                    String buySymbol = sc.next();

                    System.out.print("Enter Quantity : ");
                    int buyQuantity = sc.nextInt();

                    market.buyStock(buySymbol, buyQuantity);
                    break;

                case 4:

                    System.out.print("Enter Stock Symbol : ");
                    String sellSymbol = sc.next();

                    System.out.print("Enter Quantity : ");
                    int sellQuantity = sc.nextInt();

                    market.sellStock(sellSymbol, sellQuantity);
                    break;

                case 5:

                    market.viewPortfolio();
                    break;

                case 6:

                    market.viewTransactions();
                    break;

                case 7:

                    market.calculatePortfolioValue();
                    break;

                case 8:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 8);

        sc.close();

    }

}
