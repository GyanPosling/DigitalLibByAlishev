package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDAO {

    private final SessionFactory sessionFactory;

    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> index(){
        Session session =  sessionFactory.getCurrentSession();
        List<Person> people = session.createQuery("select p from Person p")
                .getResultList();
        return people;
    }

    public Person show(int id){
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        return person;
    }

    public void update(Person updatedPerson, int id){
        Session session = sessionFactory.getCurrentSession();
        Person personToBeUpdated = session.get(Person.class, id);
        personToBeUpdated.setFullName(updatedPerson.getFullName());
        personToBeUpdated.setYearOfBirth(updatedPerson.getYearOfBirth());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        Person personToBeDeleted = session.get(Person.class, id);
    }
}
