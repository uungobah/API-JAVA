package com.akbar.api.serviceimpl;

import com.akbar.api.dao.BookDao;
import com.akbar.api.model.Book;
import com.akbar.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public Book get(Serializable var1) {
        return bookDao.get(var1);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Transactional
    public void save(Book var1) {
        bookDao.save(var1);
    }

    @Transactional
    public void update(Book var1) {
        bookDao.update(var1);
    }

    @Transactional
    public void delete(Book var1) {
        bookDao.delete(var1);
    }
}
