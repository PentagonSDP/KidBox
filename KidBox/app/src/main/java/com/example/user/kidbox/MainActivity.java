package com.example.user.kidbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.id.custom;
import static android.R.id.message;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity{
    //LinearLayout activityMain;

    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
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
            View layout = inflater.inflate(R.layout.signup,(ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout, 700, 970,true);


            pwindo.setTouchable(true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pwindo.update();

            Button log_ = (Button) layout.findViewById(R.id.button_log);
            log_.setOnClickListener(cancel_button);

            Button creatAcc = (Button) findViewById(R.id.createAccount);
            //creatAcc.setOnClickListener(gotoSignUP);

            creatAcc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myFancyMethod(view);
                    Toast.makeText(getApplicationContext(),"Wrong mail id",Toast.LENGTH_SHORT).show();
                }
            });

            Button cancel = (Button) layout.findViewById(R.id.cancel);
            //cancel.setOnClickListener(refreshPage);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myFancyMethod1(view);
                    Toast.makeText(getApplicationContext(),"Canceled",Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void myFancyMethod1(View v) {
        Toast.makeText(getApplicationContext(),"Canceled",Toast.LENGTH_SHORT).show();
        Intent Image = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(Image);
        // does something very interesting
    }
    public void myFancyMethod(View v) {
        Toast.makeText(getApplicationContext(),"Wrong mail id",Toast.LENGTH_SHORT).show();
        Intent Image = new Intent(getApplicationContext() , signUpMain.class);
        startActivity(Image);
        // does something very interesting
    }
    private View.OnClickListener cancel_button = new View.OnClickListener() {
        public void onClick(View v) {
            Intent Image = new Intent(getApplicationContext() , tempMain.class);
            startActivity(Image);

        }
    };

}

        /*GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener());
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                Log.d("OnDoubleTapListener", "onDoubleTap");
                setContentView(R.layout.homepage);
                return true;
            }
            @Override
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }
        });*/
        /*final GestureDetector gd = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                //your action here for double tap e.g.
                Log.d("OnDoubleTapListener", "onDoubleTap");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }
            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                Log.d("OnTapListener", "onTap");
                return true;
            }
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }
        });*/
//setContentView(R.layout.homepage);