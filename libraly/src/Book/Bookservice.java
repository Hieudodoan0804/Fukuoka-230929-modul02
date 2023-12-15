package Book;

import Author.Author;

import java.util.Arrays;
import java.util.Objects;

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

    public boolean remove(Book book){
        if(index !=0){
            Book[] newBooks = new Book[index-1];
            if(findIndex(book.getId()) !=-1) {
                for (int i = 0,j=0; i <= index; i++) {
                    if (Objects.equals(books[i].getId(), book.getId())) {
                        continue;
                    }
                    newBooks[j++] = books[i];
                }
                books = newBooks;
                return true;
            }
        }
        return false;
    }

    public Book findId(int id){
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if (Objects.equals(books[i].getId(), id)) {
                    return books[i];
                }
            }
        }
        return null;
    }
    public Book findBytitle(String title){
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if (Objects.equals(books[i].getTitle().toUpperCase(),title.toUpperCase())) {
                    return books[i];
                }
            }
        }
        return null;
    }

    public int findIndex(int id){
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if(Objects.equals(books[i].getId(), id)){
                    return i;
                }
            }
        }
        return -1;
    }

    public Book[] findByAuthor(Author at){
        Book[] result = new Book[0];
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if (Objects.equals(books[i].getAuthor().getName().toUpperCase(), at.getName().toUpperCase())) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = books[i];
                }
            }
        }
        return result;
    }
    public int size(){
        return index;
    }

}
