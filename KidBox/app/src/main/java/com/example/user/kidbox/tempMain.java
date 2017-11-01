package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by USER on 10/18/2017.
 */

public class tempMain extends AppCompatActivity {
    //LinearLayout activityMain;
    int flag = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activityMain = (LinearLayout) findViewById(R.id.activity_main);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("OnDoubleTapListener", "onDoubleTap");
                initiatePopupWindow();
                return true;
            }
        });
        ImageButton story = (ImageButton) findViewById(R.id.story);
        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                Intent Image = new Intent(getApplicationContext() , Story_video.class);
                Image.putExtra("flag", str);//EXTRA_MESSAGE
                startActivity(Image);
            }
        });
        ImageButton rhymes = (ImageButton) findViewById(R.id.rhyme);
        rhymes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                Intent Image = new Intent(getApplicationContext() , Rhymes_video.class);
                Image.putExtra("flag", str);//EXTRA_MESSAGE
                startActivity(Image);
            }
        });
        ImageButton craft = (ImageButton) findViewById(R.id.craft);
        craft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                Intent Image = new Intent(getApplicationContext() , Craft_video.class);
                Image.putExtra("flag", str);//EXTRA_MESSAGE
                startActivity(Image);
            }
        });
        ImageButton cartoon = (ImageButton) findViewById(R.id.cartoon);
        cartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                Intent Image = new Intent(getApplicationContext() , Cartoon_video.class);
                Image.putExtra("flag", str);//EXTRA_MESSAGE
                startActivity(Image);
            }
        });

        ImageButton gk = (ImageButton) findViewById(R.id.gk);
        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                Intent Image = new Intent(getApplicationContext() , gk.class);
                startActivity(Image);
            }
        });
        ImageButton todolist = (ImageButton) findViewById(R.id.todolist);
        todolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(flag);
                //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                Intent Image = new Intent(getApplicationContext() , ToDoActivity.class);
                Image.putExtra("flag", str);
                startActivity(Image);
            }
        });
    }

    PopupWindow pwindo;
    private void initiatePopupWindow() {
        try {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.logout,(ViewGroup) findViewById(R.id.popup_logout));
            //layout.getBackground().setAlpha(100);
            pwindo = new PopupWindow(layout, 300, 370,true);

            pwindo.setOutsideTouchable(true);
            pwindo.setTouchable(true);
            pwindo.setBackgroundDrawable(new BitmapDrawable(
                    getApplicationContext().getResources(),
                    Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
            ));
            //pwindo.setTouchInterceptor();

            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

            Button log_ = (Button) layout.findViewById(R.id.logOut);
            log_.setOnClickListener(cancel_button);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private View.OnClickListener cancel_button = new View.OnClickListener() {
        public void onClick(View v) {
            //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
            Log.d("OnDoubleTapListener", "onDoubleTap");
            Intent Image = new Intent(getApplicationContext() , MainActivity.class);
            startActivity(Image);
            //pwindo.setBackgroundDrawable(new BitmapDrawable(getResources()));
            pwindo.dismiss();
        }
    };
}
