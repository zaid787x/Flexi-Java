import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        void display() {
            System.out.println("Title: " + title + ", Author: " + author);
        }
    }

    static ArrayList<Book> library = new ArrayList<>();

    public static void addBook(String title, String author) {
        library.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public static void removeBook(String title) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).title.equalsIgnoreCase(title)) {
                library.remove(i);
                System.out.println("Book issued/removed successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public static void searchBook(String title) {
        for (Book b : library) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                b.display();
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        System.out.println("\nAvailable Books:");
        for (Book b : library) {
            b.display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue/Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    removeBook(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    searchBook(sc.nextLine());
                    break;

                case 4:
                    displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
