/*Utwórz klasę Book przechowującą informacje o książce:
- Tytuł
- Ilość stron
- Cena
Następnie utwórz listę książek i posortuj je po tytle. Wypisz
posortowane książki. Następnie napisz dwa osobne komparatory do
sortowania po ilości stron oraz po cenie. Uruchom metodę sortującą z
wykorzystaniem tych komparatorów, wypisując każdorazowo
posortowaną listę.*/

package pl.academy.code.model;

import pl.academy.code.exceptions.IdiotBugException;
import pl.academy.code.exceptions.NotEnoughPagesException;

public class Book {
    private String title;
    private int pages;
    private double price;

    public Book(String title, int pages, double price) throws IdiotBugException, NotEnoughPagesException {
        if (title.equals("")) {
            throw new IdiotBugException();
        }
        if (pages < 4) {
            throw new NotEnoughPagesException();
        }
        this.title = title;
        this.pages = pages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}

