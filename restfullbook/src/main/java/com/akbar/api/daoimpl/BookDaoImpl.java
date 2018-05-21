package com.akbar.api.daoimpl;


import com.akbar.api.dao.BookDao;
import com.akbar.api.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    SessionFactory sessionFactory;

    public Book get(Serializable var1) {
        return sessionFactory.getCurrentSession().get(Book.class, var1);
    }

    public List<Book> getAll() {
        return (List<Book>) sessionFactory.getCurrentSession().createCriteria(Book.class).list();

    }

    public void save(Book var1) {
        sessionFactory.getCurrentSession().save(var1);
    }

    public void update(Book var1) {
        sessionFactory.getCurrentSession().update(var1);
    }

    public void delete(Book var1) {
        sessionFactory.getCurrentSession().delete(var1);
    }

}
