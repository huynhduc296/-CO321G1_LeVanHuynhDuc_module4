package com.example.controller;

import com.example.BookException;
import com.example.model.entity.Book;
import com.example.model.entity.Borrow;
import com.example.model.service.BookService;
import com.example.model.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = {"", "/books"})
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BorrowService borrowService;

    @GetMapping(value = "")
    public String goHome(Model model) {
        model.addAttribute("books", this.bookService.findAll());
        return "home";
    }

    @GetMapping(value = "/show")
    public String showInfo(@RequestParam Long id, Model model) {
        model.addAttribute("book", this.bookService.findById(id).get());
        return "show";
    }

    @GetMapping(value = "/borrow")
    public String borrowBook(@RequestParam Long id, Model model) throws BookException {
        Optional<Book> book = this.bookService.findById(id);
        int quantity = book.get().getQuantity();
        if (quantity >= 1) {
            quantity--;
            book.get().setQuantity(quantity);
        } else {
            throw new BookException();
        }
        this.bookService.save(book.get());
        model.addAttribute("book", book.get());
        return "show";
    }

    @GetMapping(value = "/pay")
    public String payBook(@RequestParam Long code, RedirectAttributes redirectAttributes) throws BookException {
        Borrow borrow = this.borrowService.findById(code).get();
        if (borrow == null) {
            throw new BookException();
        }
        Long id = borrow.getBook().getId();
        Book book = this.bookService.findById(id).get();
        book.setQuantity(book.getQuantity() + 1);
        this.bookService.save(book);
        this.borrowService.remove(code);
        redirectAttributes.addFlashAttribute("msg", "Pay successfully");
        return "redirect:/books";
    }

    @ExceptionHandler(BookException.class)
    public String bookException() {
        return "error";
    }

}
