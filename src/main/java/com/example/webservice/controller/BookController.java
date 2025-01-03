
package com.example.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.webservice.model.Book;
import com.example.webservice.service.BookClientService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookClientService bookClientService; // Correct service to interact with Management API

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookClientService.getAllBooks());
        return "book/list"; // Correctly references "book/list.html"
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add"; // Correctly references "book/add.html"
    }

    @PostMapping("/add")
    public String saveBook(@ModelAttribute Book book) {
        bookClientService.addBook(book); // Correct service for adding a book
        return "redirect:/books"; // Redirect to list of books after saving
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookClientService.getBookById(id)); // Use bookClientService for fetching the book
        return "book/edit"; // Correctly references "book/edit.html"
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookClientService.updateBook(id, book); // Correct service for updating the book
        return "redirect:/books"; // Redirect to list of books after updating
    }

    @GetMapping("/delete/{id}")
    public String deleteBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookClientService.getBookById(id)); // Use bookClientService for fetching the book
        return "book/delete"; // Correctly references "book/delete.html"
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bookClientService.deleteBook(id);
            redirectAttributes.addFlashAttribute("message", "Book deleted successfully!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete book: " + e.getMessage());
        }
        return "redirect:/books";
    }

}



