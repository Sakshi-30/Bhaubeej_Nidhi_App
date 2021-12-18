package com.example.myapplication_nav.ui.bhaubeej;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication_nav.R;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.myapplication_nav.ui.poems.poems_activity;

import android.content.Intent;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class bhaubeej extends Fragment {

    private BhaubeejViewModel mViewModel;

    public static bhaubeej newInstance() {
        return new bhaubeej();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.bhaubeej_fragment, container, false);

        ImageSlider imageSlider = v.findViewById(R.id.image_slider);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.anna_with_prime_minister_jawaharlal_nehru , "Anna with Prime minister Jawaharlal Nehru"));
        slideModels.add(new SlideModel(R.drawable.annas_jurny01_1, "Anna's Journey"));
        slideModels.add(new SlideModel(R.drawable.dr_karve_near_tulsi_vrundavan , "Dr. Karve near tulsi vrundavan"));
        slideModels.add(new SlideModel(R.drawable.honble_shrinivas_shastry_and_dr_karve , "Honble Shrinivas Shastry and Dr. Karve"));
        slideModels.add(new SlideModel(R.drawable.karve_attended_maharashtra_state_inauguration_function , "Karve attended Maharashtra state inauguration function"));
        slideModels.add(new SlideModel(R.drawable.karve_received_bharat_ratna_awrad_at_the_hands_of_president_dr_rajendra_prasad , "Karve received Bharat ratna award at the hands of president Dr. Rajendra Prasad"));




        imageSlider.setImageList(slideModels,true);

        Button btn1 = (Button)v.findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://maharshikarve.ac.in/donation/form.php";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        Button btn = (Button)v.findViewById(R.id.poems);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), poems_activity.class);
                startActivity(intent);
            }
        });

        WebView youtubeWebView = v.findViewById(R.id.youtube_web_view); //todo find or bind web view
        String myVideoYoutubeId = "v1IFv1dtzj8";

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BhaubeejViewModel.class);
        // TODO: Use the ViewModel
    }

}
