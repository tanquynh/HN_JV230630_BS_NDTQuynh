package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    public static List<Book> books = new ArrayList<>();

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("**************************JAVA-HACKATHON-05-BASIC-MENU**************************");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBook();
                    break;
                case 3:
                    sortBooksInDescendingOrderByInterest();
                    break;
                case 4:
                    deleteBookById();
                    break;
                case 5:
                    searchBooksByBookName();
                    break;
                case 6:
                    changeBookStatusByBookId();
                    break;
                case 7:
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Vui lòng nhập từ 1-7");

            }
        } while (true);
    }

    //Nhập sách
    private static void addBook() {
        // nhập số ;lượng sách nhập và nhập thông tin sách
        System.out.println("Nhập số lượng sách thêm mới");
        int numberBookOfBookToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberBookOfBookToAdd; i++) {
            Book newBook = new Book();
            newBook.inputData();
            books.add(newBook);
        }
        System.out.println("Đã hoàn tất việc thêm sách");
    }

// Hiển thị thông tin sách
    private static void showBook() {
        System.out.println("**************************BOOK-STORE**************************");
        if (!books.isEmpty()) {
            for (Book book : books) {
                book.displayData();
            }
        } else {
            System.out.println("Danh sách hiện tại đang trống");
        }
    }

    // Sắp xếpsacschs theo lơợi nhuận giảm dần
    private static void sortBooksInDescendingOrderByInterest() {
    Collections.sort(books);
        for (Book book: books) {
            book.displayData();
        }
        System.out.println("Đã hoàn tất sắp xếp theo thứ tự");
    }

    // Xóa sách theo mã sách
    private static void deleteBookById() {
        System.out.println("Nhập mã sách muốn xóa :");
        int bookDeleteId = Integer.parseInt(sc.nextLine());
        Book bookToDelete = new Book();
        for (Book book : books) {
            // Tìm kiếm id sách cần xóa xem có trong mang mảng sách không
            if(book.getBookId() == bookDeleteId) {
                bookToDelete = book;
                break;
            }
        }
        if (bookToDelete != null) {
            books.remove(bookToDelete);
            System.out.println("Sách đã được xóa thành công!");
        } else {
            System.err.println("Không tìm thấy mã sách vừa nhập!");
        }

    }

    // Tìm kiếm sách theo tên
    private static void searchBooksByBookName() {
        System.out.println("Nhập vào tên sách để tìm kiếm");
        String bookName = sc.nextLine();
        boolean isNothingMatched = true;
        for (Book book : books) {
            // chuyển key tìm kiếm sang chữ thường, và bookName chuyển sang chữ thường để so sánh
            if (book.getBookName().toLowerCase().contains(bookName.trim().toLowerCase())) {
                isNothingMatched = false;
                book.displayData();
            }
        }
        if (isNothingMatched) {
            System.err.println("Không tìm thấy kết quả phù hợp:");
        }
    }

// Thay đôit trạng thái sách theo mã
    private static void changeBookStatusByBookId() {
        System.out.print("Nhập vào mã sách để thay đổi trạng thái: ");
        int bookIdToChangeStatus = Integer.parseInt(sc.nextLine());

        for (Book book : books) {
            if (book.getBookId() == bookIdToChangeStatus) {
                if (book.isBookStatus()) {
                    book.setBookStatus(false);
                    System.out.println("Trạng thái của mã sách từ true thành " + book.isBookStatus());
                } else {
                    book.setBookStatus(true);
                    System.out.println("Trạng thái của mã sách từ false thành " + book.isBookStatus());

                }
            } else {
                System.err.println("Không tìm thấy id sách phù hợp");
            }

        }
    }

}
