package Book;

import Author.Author;

import java.util.Arrays;

public class Bookservice {
    private Book[] books;
    private final int defaultElement = 10;
    private  int index = 0;
    public Bookservice(){
        books = new Book[defaultElement];
    }

    public boolean addBook(Book book) {
        if (findId(book.getId()) == null){
            if (index==books.length){
                books= Arrays.copyOf(books,books.length+defaultElement);
            }
            books[index++] = book;
            return true;
        }
        return false;
    }

    public Book findId(int id){
        for (int i = 0; i < index; i++){
            /*if (books[i].getId().equals(id)){
                return books[i];
            }*/
        }
        return null;
    }
}
