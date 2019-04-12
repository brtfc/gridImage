package com.example.gridimage;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //image to display

    Integer[] imageIds = { R.drawable.bear, R.drawable.eagle, R.drawable.dog, R.drawable.lion, R.drawable.panda, R.drawable.panther};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView mGridViewImage = (GridView) findViewById(R.id.myGridview);
        mGridViewImage.setAdapter(new ImageAdapter(this));

        mGridViewImage.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "pic " + (position + 1) + " was selected", Toast.LENGTH_LONG).show();
            }
        });
    }


    class ImageAdapter extends BaseAdapter {

        private Context context;

        public ImageAdapter(Context context) {
            this.context = context;
        }


        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ImageView imageview;

            if(view == null) {
                imageview = new ImageView(context);
                imageview.setLayoutParams(new GridView.LayoutParams(350,350));
                imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageview.setPadding(10,10,10,10);

            } else {
                imageview = (ImageView) view;
            }

            imageview.setImageResource(imageIds[i]);

            return imageview;
        }
    }

}
