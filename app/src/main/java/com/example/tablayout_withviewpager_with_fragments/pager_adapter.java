package com.example.tablayout_withviewpager_with_fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class pager_adapter extends PagerAdapter {
    int image[];
    String ary[];
    Context context;


    public pager_adapter(Context context, int[] image, String[] ary) {
        this.ary = ary;
        this.image = image;
        this.context = context;
    }


    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_pager_adapter,container,false);

        ImageView imageView = (ImageView)view.findViewById(R.id.contextimg);
        imageView.setImageResource(image[position]);

        ImageView imageView1 = (ImageView)view.findViewById(R.id.IMG);
        imageView1.setImageResource(image[position]);

        TextView textView = (TextView)view.findViewById(R.id.NAME);
        textView.setText(ary[position]);

        /*textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,recycler_view.class));
            }
        });*/

        /*
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( context, DetailActivity.class);

                intent.putExtra("NAME", ary[position]);
                // intent.putExtra("IMAGE", names.get(position).getImage());

                Bundle bundle=new Bundle();
                bundle.putInt("image",image[position]);
                intent.putExtras(bundle);

                context.startActivity(intent);

            }
        });


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( context, DetailActivity.class);

                intent.putExtra("NAME", ary[position]);
                // intent.putExtra("IMAGE", names.get(position).getImage());

                Bundle bundle=new Bundle();
                bundle.putInt("image",image[position]);
                intent.putExtras(bundle);

                context.startActivity(intent);

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( context, DetailActivity.class);

                intent.putExtra("NAME", ary[position]);
                // intent.putExtra("IMAGE", names.get(position).getImage());

                Bundle bundle=new Bundle();
                bundle.putInt("image",image[position]);
                intent.putExtras(bundle);

                context.startActivity(intent);

            }
        });*/

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
