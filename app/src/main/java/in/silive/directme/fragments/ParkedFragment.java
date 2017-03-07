package in.silive.directme.fragments;

/**
 * Created by Lenovo on 09-Nov-16.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.silive.directme.Controller;
import in.silive.directme.fragments.ParkingDetailsFragment;
import in.silive.directme.fragments.UserDetailsFragment;
import in.silive.directme.utils.Constants;
import in.silive.directme.utils.NetworkUtils;
import in.silive.directme.R;
import in.silive.directme.application.DirectMe;
import in.silive.directme.database.DatabaseHandler;
import in.silive.directme.database.UserModel;
import in.silive.directme.listeners.AsyncResponse;
import in.silive.directme.network.FetchData;
import in.silive.directme.utils.API_URL_LIST;

import static android.R.attr.fragment;


public class ParkedFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.parkingport1)
    ImageView parkingport1;
    @BindView(R.id.parkingport2)
    ImageView parkingport2;
    @BindView(R.id.nonparkingport3)
    ImageView nonparkingport3;
    @BindView(R.id.nonparkingport4)
    ImageView nonparkingport4;
    @BindView(R.id.nonparkingport5)
    ImageView nonparkingport5;
    SharedPreferences sharedpreference;
    // String token;
    String type;
    String id;
    JSONObject jsonObject;
    FetchData apiCalling;
    boolean network_available;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ParkingDetailsFragment fragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.parkonmine, container,
                false);
        ButterKnife.bind(this,rootView);
        sharedpreference = DirectMe.getInstance().sharedPrefs;
        parkedDetail("0");
        parkingport1.setOnClickListener(this);
        parkingport2.setOnClickListener(this);
        nonparkingport3.setOnClickListener(this);
        nonparkingport4.setOnClickListener(this);
        nonparkingport5.setOnClickListener(this);
        return  rootView;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.parkingport1:

                parkedDetail("0");


                if(jsonObject!=null) {
                    fragmentInitialise();

                }




                break;
            case R.id.parkingport2:
                parkedDetail("1");
                if(jsonObject!=null) {
                    fragmentInitialise();

                }




                break;
            case R.id.nonparkingport3:
                parkedDetail("2");

                if(jsonObject!=null) {
                    fragmentInitialise();

                }




                break;
            case R.id.nonparkingport4:
                parkedDetail("3");

                if(jsonObject!=null) {
                    fragmentInitialise();

                }



                break;
            case R.id.nonparkingport5:
                parkedDetail("4");
                if(jsonObject!=null) {
                    fragmentInitialise();

                }



                break;

        }

    }
    public void parkedDetail(final String parking_no) {
        final String token = sharedpreference.getString(Constants.AUTH_TOKEN, "");
        final String user_id=sharedpreference.getString(Constants.USER_ID,"");
        network_available = NetworkUtils.isNetConnected();
        if (network_available) {

            apiCalling = new FetchData(new AsyncResponse() {
                @Override
                public void processStart() {

                }

                @Override
                public void processFinish(String output) {
                    try {
                        JSONArray user = new JSONArray(output);

                        jsonObject = user.getJSONObject(Integer.parseInt(parking_no));
                        type = jsonObject.get("type").toString();
                        id=jsonObject.get("id").toString();
                        JSONArray logs=jsonObject.getJSONArray("logs");
                        if(logs.length()>0)
                        {

                        }
                        else
                        {

                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            apiCalling.setArgs(API_URL_LIST.PORTS_URL+user_id+"/", token, "");
            apiCalling.execute();


        }
    }
    Bundle args;
    void fragmentInitialise()
    {
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,
                R.anim.exit_to_left);
        args = new Bundle();
        args.putString("data", jsonObject.toString());



        fragment = new ParkingDetailsFragment();
        fragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_container, fragment);

        fragmentTransaction.commit();

    }


}

