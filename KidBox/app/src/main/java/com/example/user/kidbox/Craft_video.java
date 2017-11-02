package com.example.user.kidbox;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

//import org.apache.commons.io.IOUtils;

public class Craft_video extends Activity {
    // All static variables
    static final String URL = "http://api.androidhive.info/music/music.xml";
    String[] stories = {"hare_tortoise", "dove_ant"};
    String[] stories_thumb = {"tortoise_and_the_hare", "ant_dove"};


    String youtube = "http://www.youtube.com";

    // XML node keys
    static final String KEY_SONG = "song"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_TITLE = "title";
    static final String KEY_ARTIST = "artist";
    static final String KEY_DURATION = "duration";
    static final String KEY_THUMB_URL = "thumb_url";
    static final String KEY_THUMBNAIL = "thumbpic";


    final ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

    ListView list;
    LazyAdapter_story adapter;

    void addData(String response)
    {
        ArrayList<String> finalData = new ArrayList<String>();
        response = response.replaceAll("\"", "");
        response = response.replaceAll("\\{", "");
        response = response.replaceAll("\\}","");
        String[] tempData = response.split(",");
        //tempData[0].replaceAll("\\{","===");
        Log.d("ENTERED ", tempData[0]);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(KEY_ID, "7");

        for(String str : tempData)
        {
            if(str.startsWith("title"))
            {
                map.put(KEY_TITLE, str.substring(6));
            }
            else if(str.startsWith("author_name"))
            {
                map.put(KEY_ARTIST, str.substring(12));
                map.put(KEY_DURATION, "04:00 minutes");
            }
            else if(str.startsWith("thumbnail_url"))
            {
                map.put(KEY_THUMB_URL, "https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            }
        }

        songsList.add(map);
        adapter.notifyDataSetChanged();

        Log.d("SONGLIST ", map.toString());
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("flag");
        //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();

        int idCounter = 0;


        HashMap<String, String> map = new HashMap<String, String>();
        // adding each child node to HashMap key => value
        map.put(KEY_ID, Integer.toString(idCounter));
        map.put(KEY_TITLE, "Baby Bath Time");
        map.put(KEY_ARTIST, " - ");
        map.put(KEY_DURATION, "04:00 mins");
        map.put(KEY_THUMB_URL, stories[idCounter]);
        map.put(KEY_THUMBNAIL, stories_thumb[idCounter]);

        songsList.add(map);

        idCounter++;

        map = new HashMap<String, String>();
        map.put(KEY_ID, Integer.toString(idCounter));
        map.put(KEY_TITLE, "Dove Ant");
        map.put(KEY_ARTIST, " - ");
        map.put(KEY_DURATION, "04:00 mins");
        map.put(KEY_THUMB_URL, stories[idCounter]);
        map.put(KEY_THUMBNAIL, stories_thumb[idCounter]);

        songsList.add(map);

        list=(ListView)findViewById(R.id.list1);

        // Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter_story(this, songsList);
        list.setAdapter(adapter);

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.d("inside", "testing");
                adapter.notifyDataSetChanged();
            }
        };

        this.runOnUiThread(run);

        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String url = "---";

                for(int i=0; i<songsList.size(); i++)
                {
                    if(songsList.get(i).get(KEY_ID).equals(Long.toString(id)))
                    {
                        url = songsList.get(i).get(KEY_THUMB_URL);
                        //url = url.replaceAll("\\s+","");
                        Toast.makeText(getApplicationContext(), "Testing  --- "+url,
                                Toast.LENGTH_SHORT).show();

                        Intent video = new Intent(getApplicationContext() , VideoPlayer.class);
                        video.putExtra("flag", stories[i]);//EXTRA_MESSAGE
                        startActivity(video);

                        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                        //Log.i("Video", "Video Playing....");
                        break;
                    }
                }
            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.addVideo);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Pressing", "getdata");
                //getData();
                //adapter=new LazyAdapter(this, songsList);
                list.setAdapter(adapter);
                //list.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        int m = Integer.valueOf(str);
        //Toast.makeText(getApplicationContext(), String.valueOf(m) , Toast.LENGTH_LONG).show();

        if(m == 0) {
            imageButton.setVisibility(View.INVISIBLE);
        }
        else
        {
            imageButton.setVisibility(View.VISIBLE);
        }



    }
}