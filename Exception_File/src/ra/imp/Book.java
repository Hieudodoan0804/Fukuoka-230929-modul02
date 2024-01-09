package ra.imp;

import ra.IBook;
import ra.run.BookRun;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book implements IBook {
    private int bookId;
    private String bookName;
    private Float importPrice;
    private Float exportPrice;
   private String author;
   private String created;
   private String descriptions;

    public Book() {
    }

    public Book(int bookId, String bookName, Float importPrice,Float exportPrice, String author, String created, String descriptions) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.created = created;
        this.descriptions = descriptions;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Float importPrice) {
        this.importPrice = importPrice;
    }

    public Float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(Float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public void inputData(Scanner scanner) {
        inputBookId(scanner);
        inputBookName(scanner);
        inputExportPrice(scanner);
        inputImportPrice(scanner);
        inputAuthor(scanner);
        inputCreatDate();
        inputDescription(scanner);

    }
    public void inputBookId(Scanner scanner){
        System.out.println("Nhập vào mã sách:");
        do {
            this.bookId = Integer.parseInt(scanner.nextLine());
            if (BookRun.books.size()==0){
                System.out.println("Không có sách trong danh sách");
                this.bookId = 1;
            }else {
                int max = BookRun.books.get(0).getBookId();
                for (Book book : BookRun.books){
                    if (book.getBookId()>max){
                        max = book.getBookId();
                    }
                }
                this.bookId = max+1;
            }
        }while (true);
    }
    public void inputBookName(Scanner scanner){
        System.out.println("Nhập vào tên sách:");
        do {
            this.bookName = scanner.nextLine();
            if (this.bookName.length()==4 && this.bookName.startsWith("B")){
                break;
            }else {
                System.out.println("Tên sách gồm 4 ký tự bắt đầu là B, vui lòng nhập lại!");
            }
        }while (true);
    }
    public void inputImportPrice(Scanner scanner){
        System.out.println("Nhập vào giá sách nhập khẩu:");
        do {
            this.importPrice = Float.parseFloat(scanner.nextLine());
            if (this.importPrice>0){
                break;
            }else {
                System.out.println("Giá nhập khẩu phải lớn hơn 0.vui lòng nhập lại!");
            }
        }while (true);
    }
    public void inputExportPrice(Scanner scanner){
        System.out.println("Nhập vào giá sách xuất khẩu:");
        do {
            this.exportPrice = Float.parseFloat(scanner.nextLine());
            if (this.exportPrice>this.importPrice){
                break;
            }else {
                System.out.println("Giá xuất khẩu phải lớn hơn giá nhập khẩu .vui lòng nhập lại!");
            }
        }while (true);
    }
    public void inputAuthor(Scanner scanner){
        System.out.println("Nhập vào tác giảc của sách: ");
        String author;
        do {
            author = scanner.nextLine();
            if (author.length()<6||author.length()>50){
                System.out.println("Author có từ 6-50 ký tự, vui lòng nhập lại");
            }else {
                this.author=author;
                break;
            }
        }while (true);
    }
    public void inputCreatDate(){
        Date myDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        this.created = formatDate.format(myDate);
    }
    public void inputDescription(Scanner scanner){
        System.out.println("Nhập mô tả của sách:");
        String description = scanner.nextLine();
        do {
            if(description.length()>500){
                System.out.println("Mô tả của sách tối đa 500 ký tự, vui lòng nhập lại");
            }
            else {
                this.descriptions = description;
                break;
            }
        }while (true);

    }

    @Override
    public void displayData() {
        System.out.printf("Id: %d - Name: %s - ImportPrice:%f - ExportPrice: %f -Author: %s - Creat: %s - Description: %s ",
                this.bookId,this.bookName,this.importPrice,this.exportPrice,this.author,this.created,this.descriptions);
    }
}
