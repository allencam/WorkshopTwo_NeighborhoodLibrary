package com.ps;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Book> catalog = new ArrayList<>();

    public static void main(String[] args) {
        getBooks();

        // ========== Main Menu ========== \\
        byte mainMenuCommand;
        do {
            System.out.println("Welcome to Tales and Tomes! How can we help you today?");
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
        } while (mainMenuCommand != 0);
    }
    public static void showAvailableBooks() {
        int listNumber = 1;
        for( Book book : catalog ) {
            if(!book.isCheckedOut()) {
                System.out.println(listNumber + " - " + book);
                listNumber++;
            }
        }
    }
    public static void booksCheckedOut() {
        for (Book book : catalog) {
            if(book.isCheckedOut()) {
                System.out.println("Book: " + book.getTitle() + ", Checked out by: " + book.getCheckedOutTo());
            }
        }
    }
    public static void checkOut() {
        
    }
    public static void checkIn() {

        boolean validId = false;
        while(!validId) {
            System.out.print("Enter the ID number a book to check in (or enter 0 to return to the main menu): ");
            int checkInBookId = scan.nextInt();
            if (checkInBookId == 0) {
                // Returns to main menu
                validId = true;
                break;
            }
            for(Book book : catalog) {
                if (checkInBookId == book.getId()) {
                    System.out.println(book.getTitle() + " has been checked in.");
                    book.setCheckedOutTo("");
                    book.setCheckedOut(false);
                    validId = true;
                }
            }
            if(validId = false) {
                System.out.println("Invalid ID, please try again.");
            }
        }
    }

    public static void getBooks() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("books.csv"));
            String header = bufferedReader.readLine();
            String input;

            while((input = bufferedReader.readLine()) != null) {
                String[] bookArray = input.split("\\|");
                int id = Integer.parseInt(bookArray[0]);
                String isbn = bookArray[1];
                String title = bookArray[2];
                boolean isCheckedOut = Boolean.parseBoolean(bookArray[3]);
                String checkedOutTo = bookArray[4];

                Book book = new Book(id,isbn,title,isCheckedOut,checkedOutTo);
                catalog.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}