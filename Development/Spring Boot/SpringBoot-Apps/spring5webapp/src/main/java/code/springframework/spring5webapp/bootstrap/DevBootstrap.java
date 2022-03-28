package code.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import code.springframework.spring5webapp.model.Author;
import code.springframework.spring5webapp.model.Book;
import code.springframework.spring5webapp.model.Publisher;
import code.springframework.spring5webapp.repositories.AuthorRepository;
import code.springframework.spring5webapp.repositories.BookRepository;
import code.springframework.spring5webapp.repositories.PublishRepository;

/* This class is managed as a spring bean in the spring context and wired up.
	and then when this event get throws that context the event gets thrown 
	our repository interface is going to catch those transactions and actually populate
	out of the database and hibernate for us
*/

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublishRepository publishRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publishRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publishRepository = publishRepository;
	}
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher("foo", "India");
		publishRepository.save(publisher);
		
		// Ashish
		Author ashish = new Author("Ashish", "Kumar");
		Book javaBook = new Book("Java Book", "1234", publisher);
		ashish.getBooks().add(javaBook);
		
		authorRepository.save(ashish);
		bookRepository.save(javaBook);
		
		Author manish = new Author("Manish", "Kumar");
		Book adaBook = new Book("Ada Book", "4567", publisher);
		manish.getBooks().add(adaBook);
		
		authorRepository.save(manish);
		bookRepository.save(adaBook); 
		
		
		
	}

}
