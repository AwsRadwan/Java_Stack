package com.aws.edit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aws.edit.models.Book;
import com.aws.edit.services.BookService;

@Controller
public class BooksController {

	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/books";
	}

	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/index.jsp";
	}

	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/new.jsp";
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping(value="/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/show.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            bookService.updateBook(book);
            Long id = book.getId();
            return "redirect:/books/"+id;
        }
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
