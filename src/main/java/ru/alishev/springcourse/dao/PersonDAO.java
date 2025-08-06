//package ru.alishev.springcourse.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Component;
//import ru.alishev.springcourse.models.Book;
//import ru.alishev.springcourse.models.Person;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//@Transactional
//public class PersonDAO {
//
//    private final SessionFactory sessionFactory;
//
//    public PersonDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public List<Person> index(){
//        Session session =  sessionFactory.getCurrentSession();
//        List<Person> people = session.createQuery("select p from Person p")
//                .getResultList();
//        return people;
//    }
//
//    public Person show(int id){
//        Session session = sessionFactory.getCurrentSession();
//        Person person = session.get(Person.class, id);
//        return person;
//    }
//
//    public void save(Person person){
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(person);
//    }
//
//    public void update(Person updatedPerson, int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Person personToBeUpdated = session.get(Person.class, id);
//        if (personToBeUpdated != null) {
//            personToBeUpdated.setFullName(updatedPerson.getFullName());
//            personToBeUpdated.setYearOfBirth(updatedPerson.getYearOfBirth());
//            personToBeUpdated.setEmail(updatedPerson.getEmail());
//            session.update(personToBeUpdated);
//        }
//    }
//
//    public void delete(int id){
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(session.get(Person.class, id));
//    }
//
//    public Optional<Person> getPersonByFullName(String fullName){
//        Session session = sessionFactory.getCurrentSession();
//        Person person = session.get(Person.class, fullName);
//        return Optional.ofNullable(person);
//    }
//
//    public List<Book> getBooksByPersonId(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        List<Book> books = session.createQuery("select b from Book b where b.owner.id = :personId", Book.class)
//                .setParameter("personId", id)
//                .getResultList();
//        return books;
//    }
//
//
//}
