package cn.sbtp.model;

import java.util.Date;

public class SubmitBookInfo {
    private int id;
    private int bookId;
    private int type;
    private double price;
    private Date submitTime;
    private int userId;
    private String bookName;
    private String author;
    private String description;
    private String category;

    public void set(SubmitBookRecord record, Book book){
        id = record.getId();
        bookId = record.getBookId();
        type = record.getType();
        price = record.getPrice();
        submitTime = record.getSubmitTime();
        userId = record.getUserId();
        bookName = book.getBookName();
        author = book.getAuthor();
        description = book.getDescription();
        category = book.getCategory();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
