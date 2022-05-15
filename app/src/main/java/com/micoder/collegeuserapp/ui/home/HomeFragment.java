package com.micoder.collegeuserapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.micoder.collegeuserapp.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    SliderView sliderView;
    ArrayList<Integer> arrayList=new ArrayList<>();
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView=view.findViewById(R.id.sliderView);
        arrayList.add(R.drawable.slider1);
        arrayList.add(R.drawable.slider2);
        arrayList.add(R.drawable.slider3);
        arrayList.add(R.drawable.slider4);
        arrayList.add(R.drawable.slider5);

        ImageSlider imageSlider=new ImageSlider(getContext(),arrayList);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEOUTDEPTHTRANSFORMATION);
        sliderView.setSliderAdapter(imageSlider);
        sliderView.startAutoCycle();

        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }

            private void openMap() {
                Uri uri=Uri.parse("geo:0, 0?q=Periyar University Salem");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        return view;
    }
}