package in.silive.directme.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;

import in.silive.directme.NetworkUtils;
import in.silive.directme.R;
import in.silive.directme.adapter.BoatPagerAdapter;
import in.silive.directme.application.DirectMe;
import in.silive.directme.listeners.AsyncResponse;
import in.silive.directme.network.FetchData;
import in.silive.directme.utils.API_URL_LIST;
import in.silive.directme.utils.Constants;


/**
 * Created by Lenovo on 01-Dec-16.
 */

public class ParkingActivity extends AppCompatActivity {
    ViewPager mViewPager;
    boolean network_available;
    FetchData fetchData;
    int count = 1;
    JSONArray user;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkingmain_viewpager);
        mViewPager = (ViewPager) findViewById(R.id.pagerr);
        sharedpreferences = DirectMe.getInstance().sharedPrefs;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        connect();
    }

    void startFragments(JSONArray user) {
        mViewPager.setAdapter(new BoatPagerAdapter(user, getSupportFragmentManager()));
    }

    void connect() {
        final String token = sharedpreferences.getString(Constants.AUTH_TOKEN, "");
        network_available = NetworkUtils.isNetConnected();
        if (network_available) {
            fetchData = new FetchData(new AsyncResponse() {
                @Override
                public void processFinish(String output) {
                    try {
                        user = new JSONArray(output);
                        count = user.length();
                        startFragments(user);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            fetchData.setArgs(API_URL_LIST.PARKED_URL, token, "");
            fetchData.execute();

        }
    }


}
