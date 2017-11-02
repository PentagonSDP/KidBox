package com.example.rumaly.project1;

import android.content.Context;
import android.content.Intent;

/**
 * Created by hosneara on 11/4/16.
 */

public class Book implements AbstractBook{

    private static Context mcontext;
    public static final int TRAY_ID = 23786484;
    private static int i = 0;
    private static int flag = 0;
    private String uID;
    private String id;

    private String bookname;
    private String submit;
    protected SubmissionCheck submissionCheck;
    Book(SubmissionCheck submissionCheck)
    {
        this.submissionCheck = submissionCheck;
        this.submissionCheck.attachBook(this);
    }
    public String getName()
    {
        return this.bookname;
    }

    @Override
    public void setBook(String uid, String id, String bookname, String submit)
    {
        this.id = id;
        this.bookname = bookname;
        this.submit = submit;
        uID = uid;
    }
    public String getSubmissionTime()
    {
        return this.submit;
    }
    public static Context getContext()
    {
        return mcontext;
    }

    @Override
    public void update()
    {
        mcontext = submissionCheck.getContext();
        Intent intent = new Intent(mcontext, MyIntentService.class);
        intent.putExtra("bookname",this.bookname);
        intent.putExtra("bookid",this.id);
        intent.putExtra("uid",this.uID);
        intent.putExtra("submit", this.submit);
        mcontext.startService(intent);
    }

}
