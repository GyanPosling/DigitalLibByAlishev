package ru.alishev.springcourse.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.BooksRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional()
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(boolean sortByYear) {
        if (sortByYear) {
            return booksRepository.findAll(Sort.by("year"));
        }
        else{
            return booksRepository.findAll();
        }
    }

    public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear) {
        if (sortByYear) {
            return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year")))
                    .getContent();
        }
        else{
            return booksRepository.findAll(PageRequest.of(page, booksPerPage))
                    .getContent();
        }
    }

    public Book findOne(int id){
        Optional<Book> book = booksRepository.findById(id);
        return book.orElse(null);
    }

    public List<Book> searchByTitle(String title) {
        return booksRepository.findByTitleStartingWith(title);
    }

    public void save(Book book) {
        booksRepository.save(book);
    }

    public void update(Book updatedBook, int id) {
        Optional<Book> book = booksRepository.findById(id);

        updatedBook.setId(id);
        updatedBook.setTitle(updatedBook.getTitle());
        updatedBook.setAuthor(updatedBook.getAuthor());
        updatedBook.setYear(updatedBook.getYear());
        updatedBook.setOwner(updatedBook.getOwner());
        booksRepository.save(updatedBook);

    }

    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public Person getBookOwner(int id){
        return booksRepository.findById(id).map(Book::getOwner).orElse(null);
    }

    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(null);
                    book.setTakenAt(null);
                });
    }


    @Transactional
    public void assign(int id, Person selectedPerson) {
        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(selectedPerson);
                    book.setTakenAt(new Date()); // текущее время
                }
        );
    }
}
