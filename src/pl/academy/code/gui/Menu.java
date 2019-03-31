package pl.academy.code.gui;

import jdk.nashorn.internal.ir.IfNode;
import pl.academy.code.data.BookRepository;
import pl.academy.code.exceptions.IdiotBugException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.model.Book;

import java.util.Scanner;

public class Menu {

    public static void helloMenu() {
        do {
            System.out.println("1. Dodaj książkę");
            System.out.println("2. Wyświetl książki");
            System.out.println("3. Sortuj po nazwie");
            System.out.println("4. Sortuj po cenie");
            System.out.println("5. Sortuj po ilości stron");


            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    Menu.loadBook();
                    break;
                case 2:
                    BookRepository.getBookRepositoryInstance().printBooks();
                    break;
                case 3:
                    BookRepository.getBookRepositoryInstance().sortBooksByTitle();
                    break;
                case 4:
                    BookRepository.getBookRepositoryInstance().sortBooksByPrice();
                    break;
                case 5:
                    BookRepository.getBookRepositoryInstance().sortBooksByPages();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);

    }

    public static void loadBook() {
        System.out.println("Podaj tytuł:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("Podaj liczbę stron:");
        int pages = -1;
        boolean flag = true;
        while (flag) {
            try {

                pages = Integer.parseInt(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException numberFormatEx) {
                numberFormatEx.printStackTrace();
                System.out.println("Podaj liczbe stron(nieprawidlowa ilosc");

            }
        }
        System.out.println("Podaj cenę");

        double price = Double.parseDouble(scanner.nextLine());

        try {
            BookRepository.getBookRepositoryInstance()
                    .addBook(new Book(title, pages, price));
        } catch (IdiotBugException | NotEnoughPagesException e) {
            System.out.println(e.getMessage());
        }


    }
}
