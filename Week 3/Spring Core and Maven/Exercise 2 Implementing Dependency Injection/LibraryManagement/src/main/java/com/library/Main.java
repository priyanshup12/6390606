package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = (BookService) context.getBean("bookService");

        service.fetchBooks();
        System.out.println("--------------------------------------------------");
        service.addBook("Atomic Habits");
        System.out.println("--------------------------------------------------");
        service.addBook("Song of Ice and Fire");
        System.out.println("--------------------------------------------------");
        service.fetchBooks();
    }
}