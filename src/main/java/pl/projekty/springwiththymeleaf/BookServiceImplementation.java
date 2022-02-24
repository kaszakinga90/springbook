package pl.projekty.springwiththymeleaf;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImplementation  implements BookService {

    private final List<Book> books;

    public BookServiceImplementation() {
        this.books = new ArrayList<>();

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Lord of the rings");
        book.setAuthor("J.R.R. Tolkien");
        book.setPublicationDate(LocalDate.of(1980,12,19));
        book.setPrice(BigDecimal.valueOf(200));

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Harry Potter and Death Hollow");
        book2.setAuthor("J.K. Rowling");
        book2.setPublicationDate(LocalDate.of(2007,5,4));
        book2.setPrice(BigDecimal.valueOf(126));

        books.add(book);
        books.add(book2);

    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void saveBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(Long id) {
        books.removeIf(element -> element.getId().equals(id));
    }

    @Override
    public void updateBook(Book changedBook) {
        Book bookToChange = books.stream().filter(element -> element.getId().equals(changedBook.getId())).findFirst().get();
        int index = books.indexOf(bookToChange);
        books.set(index, changedBook);
    }
}
