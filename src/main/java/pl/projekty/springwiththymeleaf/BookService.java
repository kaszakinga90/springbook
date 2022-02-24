package pl.projekty.springwiththymeleaf;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    void saveBook(Book book);
    void deleteBook(Long id);
    void updateBook(Book changedBook);
}
