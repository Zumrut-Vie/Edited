public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private ProductCategory productCategory;
    private int stock;
    private static int count;

    public Product(String productName, String productDescription,
                   double productPrice, ProductCategory category, int stock){
        count++;
        this.productId = count;
        this.productName = productName;
        this.productCategory = category;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                ", name='" + productName + '\'' +
                ", description='" + productDescription + '\'' +
                ", price=" + productPrice +
                ", category=" + productCategory +
                ", stock=" + stock;
    }
}
