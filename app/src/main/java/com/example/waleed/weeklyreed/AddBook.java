package com.example.waleed.weeklyreed;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddBook extends AppCompatActivity {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    EditText bookName, pageNumber;
    ImageView bookImage;
    Long id;
    Pages pages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        init();
    }

    public void init(){
        setTitle(getString(R.string.add_activity_title));
        bookName = (EditText) findViewById(R.id.bookEditText);
        pageNumber = (EditText) findViewById(R.id.pageNumberEditText);
        bookImage = (ImageView)findViewById(R.id.editBookImageView);
        bookImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.book_detail_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_save:
                if(saveItem()){
                    finish();
                }
                break;
            case R.id.home:
                NavUtils.navigateUpFromSameTask(AddBook.this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    // save the the item to the database
    private boolean saveItem() {

        if(check()) {
            String bookNameString = bookName.getText().toString().trim();
            String pageNumberString = pageNumber.getText().toString().trim();

            pages = new Pages(bookNameString,pageNumberString);
            pages.save();

            return true;
        }
        return false;
    }
    //check if the EditField are empty or not
    public boolean check() {
        boolean flag = true;

        //list of check list for the field
        if (bookName.getText().toString().isEmpty()) {
            bookName.setError(getString(R.string.fieldRequired));
            flag = false;
        }
        if (pageNumber.getText().toString().isEmpty()) {
            pageNumber.setError(getString(R.string.fieldRequired));
            flag = false;
        }
        return flag;
    }
}
