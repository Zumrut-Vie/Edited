import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner userInput = new Scanner(System.in);

    public static void createInitialData(Shop shop) {
        Product product1 = new Product("T-shirt", "Very nice and soft T-shirt", 10.99, ProductCategory.CLOTHING, 10);
        Product product2 = new Product("Backpack", "Laptop backpack", 55.99, ProductCategory.ACCESSORIES, 15);
        Product product3 = new Product("Keyboard", "Cool keyboard", 20.00, ProductCategory.ACCESSORIES, 6);
        Product product4 = new Product("Monitor", "LCD Monitor", 150.00, ProductCategory.ELECTRONICS, 0);
        Product product5 = new Product("Wine", "from 2017", 16.20, ProductCategory.GROCERIES,12);

        addProductToShop(product1, shop);
        addProductToShop(product2, shop);
        addProductToShop(product3, shop);
        addProductToShop(product4, shop);
        addProductToShop(product5, shop);


        HashMap <Integer, User> users = new HashMap <>();
        User user1 = new User("Tom", "Tompson", "tom@gmail.com", "Some street", "0102", 4654654);
        User user2 = new User ("Sandy", "Adana", "adana@sandy.com", "Ben Street", "2345", 8979087);
        User user3 = new User ("Seal", "Sunset", "sunset@seal", "Harper Exit", "1234", 3457890);

        shop.registerUser(user1);
        shop.registerUser(user2);
        shop.registerUser(user3);

        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(),user3);

        performPurchase(shop, user1, product1);
        performPurchase(shop, user2, product3);
        performPurchase(shop, user3, product4);
        performPurchase(shop, user3, product1);
        performPurchase(shop,user3,product5);



        System.out.println(user1.getFirstName() + " adding " + " 5 items to: " + product1.getProductName());
        product1.setStock(product1.getStock() + 5);
        try {
            shop.addProduct(product1);
        } catch (Exception ex) {
            displayError(ex.getMessage());
        }


        System.out.println(user3.getFirstName() + " adding " + " 5 items to: " + product2.getProductName());
        product1.setStock(product2.getStock() + 5);
        try {
            shop.addProduct(product2);
        } catch (Exception ex) {
            displayError(ex.getMessage());
        }

    }

    private static void performPurchase(Shop shop, User user, Product product) {
        try {
            boolean result = shop.sellProductToUser(user, product);
            if (result == true) {
                System.out.println(" ***** Purchase successful *****");
                System.out.println("User " + user.getFirstName() + " " + user.getLastName() + " has purchased " + product.toString());
                System.out.println("----------------------------------------------------------------------------------------");
            } else {
                System.out.println(" XXXXX Purchase declined XXXXX");
                displayError("The product '" + product.getProductName() + "' is out of stock!");
                System.out.println("----------------------------------------------------------------------------------------");
            }
        } catch (Exception ex) {
            displayError(ex.getMessage());
        }
    }

    public static void displayGreeting() {
        System.out.println("------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|              Welcome to the shop              |");
        System.out.println("|                                               |");
        System.out.println("------------------------------------------------");
    }

    public static void displayError(String message) {
        //System.out.println("------------------------------------------------");
        //System.out.println("                                                ");
        System.out.println(" Message: " + message + "                      ");
        System.out.println("------------------------------------------------");

    }

    public static int printMenu() {
        System.out.println();
        System.out.println("Make a selection: ");
        System.out.println("Press 1 to display all products");
        System.out.println("Press 2 to display all products of category X");
        System.out.println("Press 3 to display all products where stock < 5");
        System.out.println("Press 4 to display all products out of stock");
        System.out.println("Press 5 to see all shop users");
        System.out.println("Press 0 to exit");

        System.out.print("Enter your choice: --> ");
        try {
            int userChoice = userInput.nextInt();
            System.out.println();
            return userChoice;

        } catch (Exception ex) {
            userInput.nextLine();
            displayError(ex.getMessage());
            return -1;
        }

    }

    public static void addProductToShop(Product product, Shop shop) {
        shop.getProducts().put(product.getProductId(), product);
    }

    private static void displayProductsForCategory(Shop shop) {
        System.out.print("Which category would you like to display the products for? --> ");
        for (ProductCategory productCategory : ProductCategory.values()) {
            System.out.print(productCategory + " ");
        }
        System.out.println();
        boolean categoryExists = false;
        String category = userInput.next();
        for (ProductCategory productCategory : ProductCategory.values()) {
            if (category.equalsIgnoreCase(productCategory.toString())) {
                shop.displayAllForCategory(productCategory);
                categoryExists = true;
                break;
            }
        }
       if(categoryExists != true){
           displayError("Category you inputted doesn't exist in the shop!");
       }
    }


    public static void main(String[] args) {

        displayGreeting();
        int pickedOption = -1;
        Shop shop = new Shop("Some shop", "Some address");
        createInitialData(shop);
        do {
            pickedOption = printMenu();
            switch (pickedOption) {
                case 1:
                    shop.displayAllProducts();
                    break;
                case 2:
                    displayProductsForCategory(shop);
                    break;
                case 3:
                    shop.displayStockLessThanFive();
                    break;
                case 4:
                    shop.displayOutOfStockProducts();
                    break;
                case 5:
                    shop.displayAllUsers();
                    break;
                case 0:
                    System.out.println("Logging out of the system...");
                    break;

                default:
                    System.out.println("Invalid menu option! Try again, please!");
                    break;
            }
        }

        while (pickedOption != 0);
    }
}
