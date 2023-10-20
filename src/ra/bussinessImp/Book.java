package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Comparator;

import static ra.run.BookManagement.sc;

public class Book implements IBook, Comparable<Book> {


    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;
    public Book(){};
    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportprice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportprice;
        this.interest = interest;
        this.bookStatus = bookStatus;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public  void inputData() {
        System.out.println("Nhập id Sách");
        this.bookId =Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên Sách");
        this.bookName =sc.nextLine().trim();

        System.out.println("Nhập vào tiêu đề Sách");
        this.title =sc.nextLine().trim();

        System.out.println("Nhập số trang Sách");
        this.numberOfPages =Integer.parseInt(sc.nextLine());

        System.out.println("Nhập giá nhập Sách");
        this.importPrice =Float.parseFloat(sc.nextLine());

        System.out.println("Nhập giá xuất Sách");
        this.exportPrice =Float.parseFloat(sc.nextLine());
// Tính lời nhuận = tiền xuất - tiền nhập
        this.interest = this.exportPrice - this.importPrice;

        // Nhập trạng thái sach
        System.out.println("Nhập vào trạng thái sách [true : Còn Sách/false : Hết Sách]: ");
        this.bookStatus = Boolean.parseBoolean(sc.nextLine());
    }
    @Override
    public void displayData() {
        System.out.printf("Mã sách: %d - Tên sách: %s - Tiêu đề: %s - Số trang: %d\n", this.bookId, this.bookName, this.title, this.numberOfPages);
        System.out.printf("Giá nhập: %.2f - Giá xuất: %.2f - Lợi nhuận: %.2f  \n", this.importPrice, this.exportPrice, this.interest);
        System.out.println("Tình trạng:"+(this.bookStatus? " Còn Sách" : " Hết Sách "));
    }


    @Override
    public int compareTo(Book o) {
        return -Float.compare(this.interest, o.interest);
    }
}
