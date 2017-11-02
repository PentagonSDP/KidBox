package com.example.rumaly.project1;

/**
 * Created by hosneara on 11/16/16.
 */

public class AdminController {
    private newBook book;
    private AdminView adminView;
    AdminController(newBook book, AdminView adminView)
    {
        this.book = book;
        this.adminView = adminView;
    }

    public String getBookName()
    {
        return book.getName();
    }
    public String getBookAuthor()
    {
        return book.getAuthor();
    }
    public String getBookType()
    {
        return book.getYear();
    }
    public String getBookEdition()
    {
        return book.getEdition();
    }
    public void setBookName(String bookName)
    {
        book.setName(bookName);
    }
    public void setBookAuthor(String bookAuthor)
    {
        book.setAuthor(bookAuthor);
    }
    public void setBookType(String bookType)
    {
        book.setType(bookType);
    }
    public void setBookEdition(String bookEdition)
    {
        book.setEdition(bookEdition);
    }
    public void updateBook()
    {
        adminView.setBookEnvironvent(book.getName(), book.getAuthor(), book.getEdition(), book.getYear());
        adminView.BookEntry();
    }
    public void deleteBook()
    {
        adminView.setBookEnvironvent(book.getName());
        adminView.BookDelete();
    }

}
