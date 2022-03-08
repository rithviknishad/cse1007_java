package Feb22;

import java.util.Scanner;

interface BookInfo {
    void readBookInfo();

    interface SalesInfo {
        void readSalesInfo();
    }
}

class Customer {
    String name;
    String phoneNumber;
}

class BookSales extends Customer implements BookInfo, BookInfo.SalesInfo {

    String name;
    int yearOfPublication;
    float cost;
    String language;

    int copiesSold;
    String storeName;

    @Override
    public void readBookInfo() {
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        yearOfPublication = scan.nextInt();
        cost = scan.nextFloat();
        language = scan.nextLine();
        scan.close();
    }

    @Override
    public void readSalesInfo() {
        Scanner scan = new Scanner(System.in);
        copiesSold = scan.nextInt();
        storeName = scan.nextLine();
        scan.close();
    }
}

public class Main4 {
    public static void main(String[] args) {

    }
}
