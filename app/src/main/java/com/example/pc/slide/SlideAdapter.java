package com.example.pc.slide;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public int[] listImages = {
            R.drawable.astoront,
            R.drawable.darkmoon,
            R.drawable.mars
    };

    public String[] listTitle = {

            "Cosmonaout",
            "DarkMoon",
            "Mars"
    };

    public int[] listBackground = {

            Color.rgb(55, 55, 55),
            Color.rgb(239, 85, 85),
            Color.rgb(110, 49, 89),
    };

    public SlideAdapter(Context context) {
        this.context = context;

    }


    @Override
    public int getCount() {
        return listTitle.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide, container, false);
        LinearLayout linearLayoutSlide = (LinearLayout) view.findViewById(R.id.lnrSlider);
        ImageView ımageViewSlide = (ImageView) view.findViewById(R.id.slideImageView);
        TextView txtBaslik = (TextView) view.findViewById(R.id.txtBaslik);
        TextView txtAciklama = (TextView) view.findViewById(R.id.txtBilgiAlani);
        ımageViewSlide.setImageResource(listImages[position]);
        linearLayoutSlide.setBackgroundColor(listBackground[position]);
        txtBaslik.setText(listTitle[position]);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }
}
