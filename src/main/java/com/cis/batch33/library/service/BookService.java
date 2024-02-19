package com.cis.batch33.library.service;

import com.cis.batch33.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class BookService {

    private Map<Long, Book> bookMap = new HashMap<>();

    public Book createBook(Book book) {

        // call the database
        Long bookId = new Random().nextLong();
        book.setBookId(bookId);
        bookMap.put(bookId, book);
        return book;
    }

    public Book updateBook(Book book){
        Long bookId = book.getBookId();

        bookMap.put(bookId,book);

        return book;
    }

    public ArrayList<Book> getBooks(){
        ArrayList<Book> al = new ArrayList<>();

        for (Long key : bookMap.keySet()) {
            al.add(bookMap.get(key));
        }

        return al;
    }

    public Book deleteBook(Long bookId){
        Book book = bookMap.remove(bookId);
        return book;
    }

}