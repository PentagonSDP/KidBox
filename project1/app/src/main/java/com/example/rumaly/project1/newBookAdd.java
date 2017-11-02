package com.example.rumaly.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import static com.example.rumaly.project1.R.id.designation;

/**
 * Created by hosneara on 11/11/16.
 */

class newBook
{
    private static String name, author, edition, year;
    newBook() {}
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setEdition(String edition)
    {
        this.edition = edition;
    }
    public void setType(String year)
    {
        this.year = year;
    }

    public String getName() {return this.name;}

    public String getAuthor() {
        return this.author;
    }

    public String getEdition() {
        return this.edition;
    }
    public String getYear()
    {
        return this.year;
    }

}


public class newBookAdd extends AppCompatActivity{
   private String bookname, author, edition, year;

   private Button bt;
    private ArrayList<String> list;
    private Spinner dropdown;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.bookadd);

       bt = (Button)findViewById(R.id.done) ;
       list = new ArrayList<String>();   //make this as field atribute
       list.add("FirstYear");
       list.add("SecondYear");
       list.add("ThirdYear");
       list.add("MS");
       list.add("Others");

       dropdown = (Spinner)findViewById(designation);
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
       dropdown.setAdapter(adapter);

       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               newBook newEntry = bookEntry(); //model class
               AdminView adminView = new AdminView(); //view class

               AdminController adminController = new AdminController(newEntry, adminView);
               //controller class
               adminController.updateBook();
           }
       });
   }
    private newBook bookEntry() {

        bookname = ((EditText)findViewById(R.id.bookname)).getText().toString();
        author = ((EditText) findViewById(R.id.author)).getText().toString();
        year = dropdown.getSelectedItem().toString();
        //year = ((EditText) findViewById(R.id.year)).getText().toString();
        edition = ((EditText) findViewById(R.id.edition)).getText().toString();

        newBook book = new newBook();
        book.setName(bookname);
        book.setAuthor(author);
        book.setEdition(edition);
        book.setType(year);
        return  book;
    }
}
