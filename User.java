import java.util.ArrayList;

public class User {

    private int Id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String address;
    private String zip;
    private int phone;
    private ArrayList<Product>productHistory;
    private static int count;

    public User(String firstName, String lastName, String eMail, String address, String zip, int phone){
        count++;
        this.Id = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
        this.productHistory = new ArrayList<>();
    }

    public void addProductToPurchaseHistory(Product product){
        productHistory.add(product);
    }

    public void printAllProductsFromHistory(){
        for (Product product : productHistory){
            System.out.println(product.toString());
        }
    }

    public ArrayList <Product> getProductHistory(){
        return productHistory;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        Id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String geteMail(){
        return eMail;
    }

    public void seteMail(String eMail){
        this.eMail = eMail;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getZip(){
        return zip;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public int getPhone(){
        return phone;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public static int getCount(){
        return count;
    }

    public static void setCount(int count){
        User.count = count;
    }

    @Override
    public String toString(){
        return
                "Id=" + Id +
                        ", name='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", eMail='" + eMail + '\'' +
                        ", address='" + address + '\'' +
                        ", zip='" + zip + '\'' +
                        ", phone=" + phone;
    }
}
