package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static Book[] catalog = new Book[20];

    public static void main(String[] args) {
        // ========== Books ========== \\
        Book book1 = new Book(101001, "9781234567891", "Grimoire of Ancient Spells", true, "Isolde Starfire");
        Book book2 = new Book(101002, "9781234567892", "The Enchanted Forest Chronicles", false, "");
        Book book3 = new Book(101003, "9781234567893", "Tales of the Forgotten Fairies", false, "");
        Book book4 = new Book(101004, "9781234567894", "The Sorcerer's Handbook", false, "");
        Book book5 = new Book(101005, "9781234567895", "Fables of the Feywild", true, "Elowen Windwalker");
        Book book6 = new Book(101006, "9781234567896", "The Witch's Compendium", false, "");
        Book book7 = new Book(101007, "9781234567897", "The Book of Shadows", true, "Thorne Darkbriar");
        Book book8 = new Book(101008, "9781234567898", "Legends of the Dragonkin", false, "");
        Book book9 = new Book(101009, "9781234567899", "The Fairy Queen's Saga", false, "");
        Book book10 = new Book(101010, "9781234567800", "Arcane Mysteries Unveiled", false, "");
        Book book11 = new Book(101011, "9781234567801", "Chronicles of the Faerie Court", false, "");
        Book book12 = new Book(101012, "9781234567802", "The Wizard's Grimoire", false, "");
        Book book13 = new Book(101013, "9781234567803", "The Lost Tales of Avalon", false, "");
        Book book14 = new Book(101014, "9781234567804", "The Tome of Elemental Magic", false, "");
        Book book15 = new Book(101015, "9781234567805", "Myths of the Enchanted Lands", true, "Seraphina Moonshadow");
        Book book16 = new Book(101016, "9781234567806", "The Faerie Godmother's Spellbook", false, "");
        Book book17 = new Book(101017, "9781234567807", "The Cursed Chronicles", false, "");
        Book book18 = new Book(101018, "9781234567808", "Wands and Whispers: A Wizard’s Guide", false, "");
        Book book19 = new Book(101019, "9781234567809", "The Fairy Tales of Olde", false, "");
        Book book20 = new Book(101020, "9781234567810", "The Crown of Karsus", true, "Enver Gortash");

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
}

