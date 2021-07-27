package ucf.assignments;

public class Items {

    private String name;
    private double price;
    private String serial;

    public Items(){
        this.name = "";
        this.price = 0;
        this.serial = "";
    }

    public Items(String name, double price, String serial){
        this.name = name;
        this.price = price;
        this. serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSerial() {
        return serial;
    }

    public void setQuantity(String serial) {
        this.serial = serial;
    }
}
