package Oop;
class Product {
    private int proid;
    private String name;
    private double price;

    public Product(int proid, String name, double price) {
        this.proid = Math.abs(proid);
        this.name = name;
        this.price = Math.abs(price);
    }
    public int getProid() {
        return proid;
    }
    public void setProid(int proid) {
        this.proid = Math.abs(proid);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPrice(double price) {
        this.price = Math.abs(price);
    }

    public double getPrice() {
        return price;
    }
}

class Elecprod extends Product {
    private String brand;
    private int warr;

    public Elecprod(int proid, String name, double price, String brand, int warr) {
        super(proid, name, price);
        this.brand = brand;
        this.warr = Math.abs(warr);
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarr() {
        return warr;
    }

    public void setWarr(int warr) {
        this.warr = Math.abs(warr);
    }
}

class Clothprod extends Product {
    private String size;
    private String fab;

    public Clothprod(int productId, String name, double price, String size, String fab) {
        super(productId, name, price);
        this.size = size;
        this.fab = fab;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFab() {
        return fab;
    }

    public void setFab(String fab) {
        this.fab = fab;
    }
}

class Bookprod extends Product {
    private String author;
    private String publi;

    public Bookprod(int proid, String name, double price, String author, String publi) {
        super(proid, name, price);
        this.author = author;
        this.publi = publi;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubli() {
        return publi;
    }

    public void setPubli(String publi) {
        this.publi = publi;
    }
}

class Cart {
    private int cusid;
    private int prod;
    private Product[] arr;

    public Cart(int cusid) {
        this.cusid = Math.abs(cusid);
        this.prod = 0;
        this.arr = new Product[10];
    }
    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = Math.abs(cusid);
    }

    public int getProd() {
        return prod;
    }

    public void setProd(int prod) {
        this.prod = Math.abs(prod);
    }

    public Product[] getArr() {
        return arr;
    }

    public void setArr(Product[] arr) {
        this.arr = arr;
    }

    public void addProd(Product brr) {
        if (prod < arr.length) {
            arr[prod++] = brr;
        } else {
            // Expand array size if needed
            Product[] temp = new Product[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            temp[prod++] = brr;
            arr = temp;
        }
    }



    public double calc() {
        double cntr = 0;
        for (int i = 0; i < prod; i++) {
            cntr += arr[i].getPrice();
        }
        return cntr;
    }

    public String gerord(String name, String address, double cntr) {
        StringBuilder s = new StringBuilder();
        s.append("Customer Name: ").append(name).append("\n");
        s.append("Customer ID: ").append(cusid).append("\n");
        s.append("Address: ").append(address).append("\n");
        s.append("Products:").append("\n");

        for (int i = 0; i < prod; i++) {
            Product brr = arr[i];
            s.append(brr.getName()).append(" - $").append(brr.getPrice()).append("\n");
        }

        s.append("Total Price: $").append(cntr);
        return s.toString();
    }
}
class Order {
    private int cusid;
    private int ordid;
    private Product[] arr;
    private double ans;
    public Order(int cusid, int ordid, Product[] arr,double ans) {
        this.cusid = Math.abs(cusid);
        this.ordid = Math.abs(ordid);
        this.ans=Math.abs(ans);
        this.arr = arr;
        this.ans = calc();
    }
    public int getCusid() {
        return cusid;
    }
    public void setCusid(int customerId) {
        this.cusid = Math.abs(customerId);
    }

    public int getOrdid() {
        return ordid;
    }
    public void setOrdid(int ordid) {
        this.ordid = Math.abs(ordid);
    }

    public Product[] getArr() {
        return arr;
    }
    public void setArr(Product[] arr) {
        this.arr = arr;
    }
    public double getAns() {
        return ans;
    }
    public void setAns(double ans) {
        this.ans = ans;
    }
    public double calc() {
        double cntr = 0;
        for (int i = 0; i < ordid; i++) {
            cntr += arr[i].getPrice();
        }
        return cntr;
    }
    public String getOrderSummary(String name, String address, double cntr) {
        StringBuilder s = new StringBuilder();
        s.append("Customer Name: ").append(name).append("\n");
        s.append("Customer ID: ").append(cusid).append("\n");
        s.append("Address: ").append(address).append("\n");
        s.append("Products:").append("\n");

        for (int i = 0; i < ordid; i++) {
            Product brr = arr[i];
            s.append(brr.getName()).append(" - $").append(brr.getPrice()).append("\n");
        }

        s.append("Total Price: $").append(cntr);
        return s.toString();
    }
}