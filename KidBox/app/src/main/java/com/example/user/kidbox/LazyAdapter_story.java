package com.example.user.kidbox;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.HashMap;

public class LazyAdapter_story extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;



    public LazyAdapter_story(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
        
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);
        
        // Setting all values in listview
        //String imgsrc = "R.drawable."+song.get(Story_video.KEY_THUMBNAIL);
        //int img = Integer.valueOf(imgsrc);
        //thumb_image.setImageResource(getDrawable(activity, song.get(Story_video.KEY_THUMBNAIL)));

        title.setText(song.get(Story_video.KEY_TITLE));
        artist.setText(song.get(Story_video.KEY_ARTIST));
        duration.setText(song.get(Story_video.KEY_DURATION));

        ContentResolver crThumb = activity.getContentResolver();
        BitmapFactory.Options options=new BitmapFactory.Options();
        int id = getDrawable(activity, song.get(Story_video.KEY_THUMBNAIL));
        options.inSampleSize = 1;
        Bitmap curThumb = MediaStore.Video.Thumbnails.getThumbnail(crThumb, id , MediaStore.Video
                .Thumbnails.MICRO_KIND, options);
        thumb_image.setImageBitmap(curThumb);
        imageLoader=new ImageLoader(activity.getApplicationContext());
        imageLoader.DisplayImage(song.get(Story_video.KEY_THUMB_URL), thumb_image, song.get(Story_video.KEY_THUMBNAIL), activity);
        return vi;
    }
    public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }

}