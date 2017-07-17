package textitei.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by liuwei on 17-7-17.
 */

public class Book extends DataSupport{
    private int id;
    private String Author;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
