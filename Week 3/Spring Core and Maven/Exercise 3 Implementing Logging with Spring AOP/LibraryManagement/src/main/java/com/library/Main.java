package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = (BookService) context.getBean("bookService");

//        service.fetchBooks();
        System.out.println("Method Output\n----------------------------------------");
        service.addBook("Atomic Habits");
//        System.out.println("Method Output\n----------------------------------------");
//        service.addBook("Song of Ice and Fire");
        System.out.println("Method Output\n----------------------------------------");
        service.fetchBooks();
    }
}