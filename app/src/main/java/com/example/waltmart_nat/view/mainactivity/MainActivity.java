package com.example.waltmart_nat.view.mainactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.example.waltmart_nat.R;
import com.example.waltmart_nat.data.remote.WeatherDataHandler;
import com.example.waltmart_nat.model.ThreadObjectReturns;
import com.example.waltmart_nat.model.forecast.ForecastProfile;
import com.example.waltmart_nat.view.currentconditionsfragment.CurrentConditionsFragment;
import com.example.waltmart_nat.view.forecastfragment.ForecastFragment;

import io.fabric.sdk.android.Fabric;

import static com.example.waltmart_nat.data.local.Constants.CURRENT_CONDITIONS_FRAG_ID;
import static com.example.waltmart_nat.data.local.Constants.FORECAST_FRAG_ID;
import static com.example.waltmart_nat.data.local.Constants.PASS_ZIP_CODE_STRING;

public class MainActivity extends AppCompatActivity implements CurrentConditionsFragment.OnFragmentInteractionListener, ForecastFragment.OnFragmentInteractionListener {
    ThreadObjectReturns info;
    WeatherDataHandler wdh;
    ForecastProfile forecastProfile;
    FrameLayout currentConditionsFrame;
    FrameLayout forecastFrame;
    EditText etZipCode;
    String zipCode = "30315";
    MainActivityPresenter mainActivityPresenter = new MainActivityPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Answers());
        setContentView(R.layout.activity_main);
        etZipCode = (EditText)findViewById(R.id.etZipCode);
        wdh = new WeatherDataHandler();
       if(!(getIntent().getStringExtra(PASS_ZIP_CODE_STRING) == null)){
           zipCode = getIntent().getStringExtra(PASS_ZIP_CODE_STRING);
       }
        // TODO: Use your own attributes to track content views in your app
        Answers.getInstance().logContentView(new ContentViewEvent()
                .putContentName("Zip_Code")
                .putContentType("String")
                .putContentId(zipCode)
                .putCustomAttribute("Favorites Count", 20)
                .putCustomAttribute("Screen Orientation", "Landscape"));

        info = mainActivityPresenter.initInformation(zipCode);
        initFragmentsForActivity();
    }


    public void initFragmentsForActivity(){
        initForecastFragment();
        initCurrentConditionFragment();
    }
    public void initForecastFragment(){
        forecastFrame = (FrameLayout)findViewById(R.id.flForecast);
        ForecastFragment forecastFragment = ForecastFragment.newInstance(info.getForecastProfile());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flForecast,forecastFragment ,FORECAST_FRAG_ID)
                .commit();
    }
    public void initCurrentConditionFragment(){
        currentConditionsFrame = (FrameLayout)findViewById(R.id.flCurrentConditions);
        CurrentConditionsFragment currentConditionsFragment = CurrentConditionsFragment.newInstance(info.getWeatherProfile());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flCurrentConditions,currentConditionsFragment ,CURRENT_CONDITIONS_FRAG_ID)
                .commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onForecastInteraction(Uri uri) {}

    public void onClickSetZip(View view) {
        zipCode = etZipCode.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(PASS_ZIP_CODE_STRING, zipCode);
        startActivity(intent);
    }
}
