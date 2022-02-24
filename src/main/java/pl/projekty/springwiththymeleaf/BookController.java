package pl.projekty.springwiththymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        return "gui";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateBook(@ModelAttribute Book changedBook) {
        bookService.updateBook(changedBook);
        return "redirect:/";
    }


}
