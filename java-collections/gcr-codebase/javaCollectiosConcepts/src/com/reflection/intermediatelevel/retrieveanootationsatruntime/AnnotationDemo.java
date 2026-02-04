package com.reflection.intermediatelevel.retrieveanootationsatruntime;

public class AnnotationDemo {

    public static void main(String[] args) {

        Class<Book> cls = Book.class;

        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        }
    }
}