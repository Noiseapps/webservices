package com.noiseapps.wsp.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tomasz on 27.11.14.
 */
public class BookStore {

    private Map<Integer, Book> books;

    public BookStore() {
        books = new HashMap<>();

        books.put(1, new Book(1, "Andrzej Sapkowski", "Wiedźmin"));
        books.put(2, new Book(2, "Dmitry Glukhovsky", "Metro2033"));
        books.put(3, new Book(3, "Tom Clancy", "Czas Patriotów"));
    }

    public Collection<Book> getAllBooks(){
        return books.values();
    }

    public Book getOneBook(int id){
        return books.get(id);
    }

    public void addOrUpdate(Book book){
        if(book == null || book.getId() == null){
            throw new NullPointerException("Book or book id cannot be null");
        }
        books.put(book.getId(),book);
    }

    public Book delete(int id){
        return books.remove(id);
    }

}
