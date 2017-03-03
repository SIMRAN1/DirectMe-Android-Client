package in.silive.directme.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import in.silive.directme.NetworkUtils;
import in.silive.directme.R;
import in.silive.directme.adapter.DataUserSelectAdapter;
import in.silive.directme.application.DirectMe;
import in.silive.directme.listeners.AsyncResponse;
import in.silive.directme.model.UserDetailsList;
import in.silive.directme.network.FetchData;
import in.silive.directme.utils.API_URL_LIST;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * Created by simran on 2/24/2017.
 */

public class UserDetailsActivity extends AppCompatActivity {
    public final String user_names[]=new String[10] ;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    private boolean network_available;
    FetchData apicalling;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_userselect);

        sharedPreferences=DirectMe.getInstance().sharedPrefs;

        connect();

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 5);

        recyclerView.setLayoutManager(layoutManager);

        ArrayList<UserDetailsList> user_details = prepareData();
        DataUserSelectAdapter adapter = new DataUserSelectAdapter(getApplicationContext(), user_details);
        recyclerView.setAdapter(adapter);



    }
    String post_data;
    void connect() {
        final String token = sharedPreferences.getString("Authorization_Token", "");
        network_available = NetworkUtils.isNetConnected();
        if (network_available) {
            apicalling = new FetchData(new AsyncResponse() {
                @Override
                public void processFinish(String output) {
                    try {

                        // Extract JSON array from the response
                        JSONArray arr = new JSONArray(output);
                        // If no of array elements is not zero
                        if (arr.length() != 0) {

                            // Loop through each array element, get JSON object which has userid and username
                            for (int i = 0; i < arr.length(); i++) {
                                // Get JSON object
                                JSONObject obj = (JSONObject) arr.get(i);
                                user_names[i] = obj.get("name").toString();
                                initViews();


                            }
                        }
                    }
                        catch(JSONException e)
                        {
                            e.printStackTrace();
                        }
                }
            });
            String post_data = "";
            try {
                post_data = URLEncoder.encode("island_id", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            apicalling.setArgs(API_URL_LIST.GET_USER_LIST, token,post_data);
            apicalling.execute();

        }
    }

    private ArrayList<UserDetailsList> prepareData() {

        ArrayList<UserDetailsList> user_details = new ArrayList<>();
        for (int i = 0; i < user_names.length; i++) {
            UserDetailsList userDetailsList = new UserDetailsList();
            Toast.makeText(getApplicationContext(),user_names[i],Toast.LENGTH_LONG).show();

            userDetailsList.setUser_image_url("simran");
            user_details.add(userDetailsList);
        }
        return user_details;
    }
}
