package pl.academy.code;

import pl.academy.code.data.BookRepository;
import pl.academy.code.exceptions.IdiotBugException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.gui.Menu;
import pl.academy.code.model.Book;

public class Main {
    public static void main(String[] args) {
        Menu.helloMenu();
        try{
            Book book = new Book("", 234, 44);

        }catch (IdiotBugException | NotEnoughPagesException e){
            System.out.println(e.getMessage());
        }
        /*BookRepository bookRepository = BookRepository.getBookRepositoryInstance();
        bookRepository.addBook(new Book("ABS", 25, 12));
        bookRepository.printBooks();
        bookRepository.sortBooksByPages();
        bookRepository.printBooks();
        bookRepository.sortBooksByPrice();
        bookRepository.printBooks();
        bookRepository.sortBooksByTitle();
        bookRepository.printBooks();*/



    }
}
