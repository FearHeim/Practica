package com.example.practicaexamengamer;

import com.orm.SugarRecord;

public class Book extends SugarRecord<Book> {
    String title;
    String edition;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(){

    }

    public String getEdition(){
        return edition;
    }

    public Book(String title, String edition) {
        this.title = title;
        this.edition = edition;
    }

    public void setEdition(String edition){
        this.edition=edition;
    }
}
