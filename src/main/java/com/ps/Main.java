package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static Book[] catalog = new Book[20];

    public static void main(String[] args) {
        // ========== Books ========== \\
        Book book1 = new Book(5887241, "9781838864835", "The Book of Five Rings", true, "Camron Allen");
        Book book2 = new Book(5887242, "9780140449266", "The Art of War", false, "");
        Book book3 = new Book(5887243, "9780553212419", "Moby Dick", false, "");
        Book book4 = new Book(5887244, "9780743273565", "The Great Gatsby", true, "Julius Caesar");
        Book book5 = new Book(5887245, "9781501124020", "The Catcher in the Rye", false, "");
        Book book6 = new Book(5887246, "9780061120084", "To Kill a Mockingbird", true, "John Doe");
        Book book7 = new Book(5887247, "9780451524935", "1984", false, "");
        Book book8 = new Book(5887248, "9780143039433", "Pride and Prejudice", false, "");
        Book book9 = new Book(5887249, "9780375826689", "Harry Potter and the Sorcerer's Stone", false, "");
        Book book10 = new Book(5887250, "9780747538493", "Harry Potter and the Chamber of Secrets", false, "");
        Book book11 = new Book(5887251, "9780553573428", "A Game of Thrones", true, "Jane Doe");
        Book book12 = new Book(5887252, "9780261103573", "The Fellowship of the Ring", false, "");
        Book book13 = new Book(5887253, "9780345339706", "The Hobbit", true, "Barack Obama");
        Book book14 = new Book(5887254, "9780307277671", "The Road", false, "");
        Book book15 = new Book(5887255, "9780743451796", "The Da Vinci Code", false, "");
        Book book16 = new Book(5887256, "9780316769488", "The Catcher in the Rye", false, "");
        Book book17 = new Book(5887257, "9781400078776", "The Kite Runner", false, "");
        Book book18 = new Book(5887258, "9780679783275", "The Old Man and The Sea", false, "");
        Book book19 = new Book(5887259, "9780060935467", "The Alchemist", false, "");
        Book book20 = new Book(5887260, "9780156027328", "Life of Pi", false, "");
        catalog[0] = book1;
        catalog[1] = book2;
        catalog[2] = book3;
        catalog[3] = book4;
        catalog[4] = book5;
        catalog[5] = book6;
        catalog[6] = book7;
        catalog[7] = book8;
        catalog[8] = book9;
        catalog[9] = book10;
        catalog[10] = book11;
        catalog[11] = book12;
        catalog[12] = book13;
        catalog[13] = book14;
        catalog[14] = book15;
        catalog[15] = book16;
        catalog[16] = book17;
        catalog[17] = book18;
        catalog[18] = book19;
        catalog[19] = book20;

        // ========== Main Menu ========== \\
        byte mainMenuCommand;
        do {
            System.out.println("Welcome to _! How can we help you today?");
            System.out.println("""
                    1 - Show available books
                    2 - Show checked out books
                    3 - Check in
                    0 - Exit
                    """);
            System.out.print("Your selection: ");
            mainMenuCommand = scan.nextByte();
            switch (mainMenuCommand) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    booksCheckedOut();
                    break;
                case 3:
                    checkIn();
                    break;
                case 0:
                    System.out.println("Exiting... Enjoy your day!");
                    break;
                default:
                    System.out.println("Command not found, try again.");
                    break;
            }
        } while (mainMenuCommand != 0) ;
    }
}
