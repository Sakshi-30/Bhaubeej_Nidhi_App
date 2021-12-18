package com.example.myapplication_nav.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication_nav.R;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageSlider imageSlider=v.findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.mksss_banner_01_1,"Sampada Bakery"));//sampada bakery
        slideModels.add(new SlideModel(R.drawable.mksss_banner_03,"Vocational training institute"));//vocational training institute
        slideModels.add(new SlideModel(R.drawable.mksss_banner_04,"Cummins College Of Engineering For Women, Nagpur"));//cummins nagpur
        slideModels.add(new SlideModel(R.drawable.mksss_banner_05,"Dr Bhanuben Nanavati College Of Architecture For Women, Pune"));//Architecture bnca
        slideModels.add(new SlideModel(R.drawable.mahilashram_high_school,"Mahilashram high school"));
        imageSlider.setImageList(slideModels,true);

        Button btn = (Button)v.findViewById(R.id.joinus);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://forms.gle/S1hGHMA7gjyCJG6Z8";
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
//https://youtu.be/YNmOexlPTrE
        //<iframe width="560" height="315" src="https://www.youtube.com/embed/YNmOexlPTrE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        WebView youtubeWebView = v.findViewById(R.id.youtube_web_view); //todo find or bind web view
        String myVideoYoutubeId = "YNmOexlPTrE";

        youtubeWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        WebSettings webSettings = youtubeWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        youtubeWebView.loadUrl("https://www.youtube.com/embed/" + myVideoYoutubeId);

        return v;

    }


}