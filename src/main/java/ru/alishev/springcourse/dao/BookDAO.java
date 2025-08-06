//package ru.alishev.springcourse.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.alishev.springcourse.models.Book;
//import ru.alishev.springcourse.models.Person;
//
//import javax.persistence.Column;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Component
//@Transactional
//public class BookDAO {
//
//    private final SessionFactory sessionFactory;
//
//    public BookDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public List<Book> index(){
//        Session session = sessionFactory.getCurrentSession();
//        List<Book> books = session.createQuery("select b from Book b", Book.class)
//                .getResultList();
//
//        return books;
//    }
//
//    public Book show(int id){
//        Session session = sessionFactory.getCurrentSession();
//        Book book = session.get(Book.class, id);
//        return book;
//    }
//
//    public void save(Book book){
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(book);
//    }
//
//    public void update(Book updatedBook, int id){
//        Session session = sessionFactory.getCurrentSession();
//        Book bookToUpdate = session.get(Book.class, id);
//
//        bookToUpdate.setTitle(updatedBook.getTitle());
//        bookToUpdate.setAuthor(updatedBook.getAuthor());
//        bookToUpdate.setYear(updatedBook.getYear());
//
//
//    }
//
//    public void delete(int id){
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(session.get(Book.class, id));
//    }
//
//}
