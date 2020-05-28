package com.akin.adsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Banner Ads");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView = findViewById(R.id.adView);
        mAdView.loadAd(adRequest);
        findViewById(R.id.btnFullPageShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFullPageAds();
            }
        });
        findViewById(R.id.btnVideoAdsShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRewardedVideoAdActivity();
            }
        });
    }

    private void showFullPageAds() {
        startActivity(new Intent(this, InterstitialAdActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }

    private void showRewardedVideoAdActivity() {
        startActivity(new Intent(this, RewardedVideoAdActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }
}
