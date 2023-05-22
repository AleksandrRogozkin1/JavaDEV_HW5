package org.example.select;

public class ProjectPrice {
    private String nane;
    private double price;

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "nane='" + nane + '\'' +
                ", price=" + price +
                '}';
    }
}
