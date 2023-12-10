
    import java.util.ArrayList;
import java.util.Scanner;

    class Author {
        int id;
        String name;

        public Author(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    class Book {
        int id;
        String title;
        Author author;

        public Book(int id, String title, Author author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }
    }

    public class LibraryManagementSystem {
        static ArrayList<Author> authors = new ArrayList<>();
        static ArrayList<Book> books = new ArrayList<>();
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                System.out.println("Menu chính");
                System.out.println("1. Quản lý tác giả");
                System.out.println("2. Quản lý sách");
                System.out.println("3. Thoát");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        manageAuthors();
                        break;
                    case 2:
                        manageBooks();
                        break;
                    case 3:
                        System.out.println("Thoát chương trình.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }

        static void manageAuthors() {
            while (true) {
                System.out.println("Menu quản lý tác giả");
                System.out.println("1. Thêm tác giả");
                System.out.println("2. Hiển thị tác giả");
                System.out.println("3. Cập nhật thông tin tác giả (theo id)");
                System.out.println("4. Xóa tác giả (Không xóa tác giả có sách)");
                System.out.println("5. Quay lại");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addAuthor();
                        break;
                    case 2:
                        displayAuthors();
                        break;
                    case 3:
                        updateAuthor();
                        break;
                    case 4:
                        deleteAuthor();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }

        static void addAuthor() {
            System.out.println("Nhập id tác giả:");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume the newline character
            System.out.println("Nhập tên tác giả:");
            String name = scanner.nextLine();

            Author author = new Author(id, name);
            authors.add(author);

            System.out.println("Tác giả đã được thêm thành công.");
        }

        static void displayAuthors() {
            System.out.println("Danh sách tác giả:");
            for (Author author : authors) {
                System.out.println("ID: " + author.id + ", Tên: " + author.name);
            }
        }

        static void updateAuthor() {
            System.out.println("Nhập ID tác giả cần cập nhật:");
            int id = scanner.nextInt();
            Author foundAuthor = findAuthorById(id);

            if (foundAuthor != null) {
                System.out.println("Nhập tên mới cho tác giả:");
                scanner.nextLine();  // consume the newline character
                String newName = scanner.nextLine();
                foundAuthor.name = newName;

                System.out.println("Thông tin tác giả đã được cập nhật.");
            } else {
                System.out.println("Không tìm thấy tác giả với ID đã nhập.");
            }
        }

        static void deleteAuthor() {
            System.out.println("Nhập ID tác giả cần xóa:");
            int id = scanner.nextInt();
            Author foundAuthor = findAuthorById(id);

            if (foundAuthor != null) {
                // Check if the author has books
                if (hasBooks(foundAuthor)) {
                    System.out.println("Không thể xóa tác giả vì có sách liên quan.");
                } else {
                    authors.remove(foundAuthor);
                    System.out.println("Tác giả đã được xóa thành công.");
                }
            } else {
                System.out.println("Không tìm thấy tác giả với ID đã nhập.");
            }
        }

        static boolean hasBooks(Author author) {
            for (Book book : books) {
                if (book.author.id == author.id) {
                    return true;
                }
            }
            return false;
        }

        static Author findAuthorById(int id) {
            for (Author author : authors) {
                if (author.id == id) {
                    return author;
                }
            }
            return null;
        }

        static void manageBooks() {
            while (true) {
                System.out.println("Menu quản lý sách");
                System.out.println("1. Thêm sách");
                System.out.println("2. Tìm kiếm sách theo tiêu đề");
                System.out.println("3. Tìm kiếm sách theo tên tác giả");
                System.out.println("4. Cập nhật sách (theo id)");
                System.out.println("5. Quay lại");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        searchBookByTitle();
                        break;
                    case 3:
                        searchBookByAuthor();
                        break;
                    case 4:
                        updateBook();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }

        static void addBook() {
            System.out.println("Nhập id sách:");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume the newline character
            System.out.println("Nhập tiêu đề sách:");
            String title = scanner.nextLine();
            System.out.println("Nhập id tác giả:");
            int authorId = scanner.nextInt();

            Author author = findAuthorById(authorId);
            if (author != null) {
                Book book = new Book(id, title, author);
                books.add(book);
                System.out.println("Sách đã được thêm thành công.");
            } else {
                System.out.println("Không tìm thấy tác giả với ID đã nhập.");
            }
        }

        static void searchBookByTitle() {
            System.out.println("Nhập tiêu đề sách cần tìm:");
            scanner.nextLine();  // consume the newline character
            String title = scanner.nextLine();

            System.out.println("Kết quả tìm kiếm:");
            for (Book book : books) {
                if (book.title.toLowerCase().contains(title.toLowerCase())) {
                    System.out.println("ID: " + book.id + ", Tiêu đề: " + book.title + ", Tác giả: " + book.author.name);
                }
            }
        }

        static void searchBookByAuthor() {
            System.out.println("Nhập tên tác giả cần tìm:");
            scanner.nextLine();  // consume the newline character
            String authorName = scanner.nextLine();

            System.out.println("Kết quả tìm kiếm:");
            for (Book book : books) {
                if (book.author.name.toLowerCase().contains(authorName.toLowerCase())) {
                    System.out.println("ID: " + book.id + ", Tiêu đề: " + book.title + ", Tác giả: " + book.author.name);
                }
            }
        }

        static void updateBook() {
            System.out.println("Nhập ID sách cần cập nhật:");
            int id = scanner.nextInt();
            Book foundBook = findBookById(id);

            if (foundBook != null) {
                System.out.println("Nhập tiêu đề mới cho sách:");
                scanner.nextLine();  // consume the newline character
                String newTitle = scanner.nextLine();
                foundBook.title = newTitle;

                System.out.println("Thông tin sách đã được cập nhật.");
            } else {
                System.out.println("Không tìm thấy sách với ID đã nhập.");
            }
        }

        static Book findBookById(int id) {
            for (Book book : books) {
                if (book.id == id) {
                    return book;
                }
            }
            return null;
        }
    }

