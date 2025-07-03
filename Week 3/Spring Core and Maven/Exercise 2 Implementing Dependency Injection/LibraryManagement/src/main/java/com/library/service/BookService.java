package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(String BookName){
        bookRepository.saveBook(BookName);
    }

    public void fetchBooks(){
        System.out.println("Total Books: " + bookRepository.countBooks());
    }
}
