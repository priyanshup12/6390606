package com.library.repository;

public class BookRepository {

    private int totalBooks = 0;

    public int countBooks(){
        return totalBooks;
    }

    public void saveBook(String bookName){
        totalBooks++;
        System.out.println("Book No: " + (totalBooks));
        System.out.println("Book Name: " + bookName);
        System.out.println("Saved Successfully");
    }

}
