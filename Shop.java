import java.util.ArrayList;
import java.util.HashMap;

public class Shop {

    private String name;
    private String address;
    private HashMap <Integer, Product> products;
    private ArrayList<User> users;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
        this.products = new HashMap <>();
        this.users = new ArrayList <>();
    }

    public void addProduct(Product product) throws StockLimitReachedException {
        if (product.getStock() < 15) {
            products.put(product.getProductId(), product);
        } else {
            throw new StockLimitReachedException("Stock limit reached on product '" + product.getProductName() + "', can't add new items!");
        }
    }

    private void decreaseStock(Product product) throws Exception {
        if (product.getStock() < 5) {
            throw new Exception("Stock for product '" + product.getProductName() + "' is less than 5!");
        } else {
            product.setStock(product.getStock() - 1);
        }
    }

    public void registerUser(User user){
        users.add(user);
    }

    public void displayAllUsers() {
        System.out.println(" ----- USERS: -----");
        for (User user : users){
            System.out.println(user.toString());
        }
    }

    public boolean sellProductToUser(User user, Product product) throws Exception {
        if (product.getStock() > 0) {
            user.addProductToPurchaseHistory(product);
            decreaseStock(product);
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public HashMap <Integer, Product> getProducts(){
        return products;
    }

    public void setProducts(HashMap <Integer, Product> products){
        this.products = products;
    }

    public void displayAllProducts(){
        int index = 1;
        for (Product product : products.values()) {
            System.out.println("Product " + (index) + ": " + product.toString());
            index++;
        }
    }

    public void displayAllForCategory(ProductCategory category){
        int index = 1;
        for (Product product : products.values()) {
            if (product.getProductCategory().equals(category)) {
                System.out.println("Product " + (index) + ": " + product.toString());
                index++;
            }
        }
    }

    public void displayStockLessThanFive(){
        int index = 1;
        for (Product product : products.values()){
            if (product.getStock() < 5) {
                System.out.println("Product " + (index) + ": " + product.toString());
                index++;
            }
        }
    }

    public void displayOutOfStockProducts(){
        int index = 1;
        for (Product product : products.values()) {
            if (product.getStock() == 0) {
                System.out.println("Product " + (index) + ": " + product.toString());
                index++;
            }
        }
    }
}
