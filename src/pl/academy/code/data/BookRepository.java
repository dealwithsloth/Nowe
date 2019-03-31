package pl.academy.code.data;

import pl.academy.code.exceptions.IdiotBugException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.model.Book;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//wzorzec projektowy singleton
public class BookRepository {
    private List<Book> bookRepository = new LinkedList<>();
    private static BookRepository repositoryInstance = null;

    private BookRepository() {
        try{
            this.bookRepository.add(new Book("Pan Tadeusz", 1000, 30.90));
            this.bookRepository.add(new Book("Ogniem i mieczem", 3000, 60.90));
            this.bookRepository.add(new Book("Gra o tron", 1200, 12.00));
            this.bookRepository.add(new Book("Blabla", 500, 15.15));
            this.bookRepository.add(new Book("Ksiazka", 100, 35.45));//lepszy sposob z 1 wywolaniem stosu - szybciej.
            // this.addBook(new Book("ksiazka2", 213, 49)); drugi sposob z wywolaniem 2 razy stosu-wolniej.
        }catch (IdiotBugException | NotEnoughPagesException e){
            System.out.println(e.getMessage());
        }

    }


    public void addBook(Book book) {
        this.bookRepository.add(book);//może dodac ksiazke.

    }

    public void printBooks() {
        System.out.println(this.bookRepository);
    }

    public static BookRepository getBookRepositoryInstance() {//to rozwiazanie jest niedobre przy wielowatk.
        if (BookRepository.repositoryInstance == null) {
            BookRepository.repositoryInstance = new BookRepository();
        }
        return BookRepository.repositoryInstance;
    }

    public void sortBooks(Comparator c) {
        this.bookRepository.sort(c);
    }

    public void sortBooksByPages() {//sortowanie po stronach
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                if (!(o2 instanceof Book)) {
                    return -1;
                }

                return ((Book) o1).getPages() - ((Book) o2).getPages();
            }
        };
        this.bookRepository.sort(c);
    }

    public void sortBooksByPrice() {//sortowanie po cenie
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                if (!(o2 instanceof Book)) {
                    return -1;
                }

                return (int) ((((Book) o1).getPrice() - ((Book) o2).getPrice()) * 100);
            }
        };
        this.bookRepository.sort(c);
    }

    public void sortBooksByTitle() {//sortowanie po tytule
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                if (!(o2 instanceof Book)) {
                    return -1;
                }

                return ((Book) o1).getTitle().compareTo(((Book) o2).getTitle());
            }
        };
        this.bookRepository.sort(c);

    }
}
