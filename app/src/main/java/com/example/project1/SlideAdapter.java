package com.example.project1;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    //list of images
    public int[] list_images={
            R.drawable.pudding,
            R.drawable.lollipop,
            R.drawable.chocolate,
    };

    //list of titles
    public String[] list_title={
      "Pudding",
      "Lollipop",
      "Chocolate"
    };

    //list of descriptions
    public String[] list_descruption = {
    "A drawn Pudding",
    "A drawn lollipop",
    "A drawn chocolate"
    };

    //list of background colors
    public int[] list_backgroundcolor={
            Color.rgb(1,188,212),
            Color.rgb(220,20,60),
            Color.rgb(0,100,0)
    };


    public SlideAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return list_title.length;
    }


    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return (view==(LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide=(LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle=(TextView) view.findViewById(R.id.txttitle);
        TextView description=(TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(list_backgroundcolor[position]);
        imgslide.setImageResource(list_images[position]);
        txttitle.setText(list_title[position]);
        description.setText(list_descruption[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
