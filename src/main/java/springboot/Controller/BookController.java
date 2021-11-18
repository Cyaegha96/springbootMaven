package springboot.Controller;


import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import springboot.Book;
import springboot.BookService;

@Controller
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books.html")
	public String all(Model model){
		model.addAttribute("books", bookService.findAll());
		return "books/list";
	}
	
	@GetMapping(value ="/books.html", params="isbn")
	public String get(@RequestParam("isbn") String isbn, Model model) {
		bookService.find(isbn).ifPresent(book -> model.addAttribute("book", book));
		return "books/details";		
	}
	
}	
