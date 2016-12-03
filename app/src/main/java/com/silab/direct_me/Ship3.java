package com.silab.direct_me;
/**
 * Created by yesha on 03-12-2016.
 */

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class Ship3 extends Fragment {
    TextView banana_req, gold_req, wood_req, bamboo_req, coconut_req;
    ImageView img;
    int banana_r = 0, gold_r = 0, bamboo_r = 0, wood_r = 0, coconut_r = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.raft_fragment, container,
                false);

        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", MODE_PRIVATE);


        banana_req = (TextView) rootView.findViewById(R.id.getbanana);
        bamboo_req = (TextView) rootView.findViewById(R.id.getbamboo);
        gold_req = (TextView) rootView.findViewById(R.id.getgold);
        wood_req = (TextView) rootView.findViewById(R.id.getwood);
        coconut_req = (TextView) rootView.findViewById(R.id.getcoconut);

        banana_req.setText(pref.getString("Ship3" + "Banana", null));
        gold_req.setText(pref.getString("Ship3" + "Gold", null));
        bamboo_req.setText(pref.getString("Ship3" + "Bamboo", null));
        wood_req.setText(pref.getString("Ship3" + "Timber", null));
        coconut_req.setText(pref.getString("Ship3" + "Coconut", null));





        return rootView;

    }

    public static final int DFRAGMENT = 1;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final DFragment dFragment = new DFragment();
        // TODO Auto-generated method stub
        // get the button view
        img = (ImageView) getView().findViewById(R.id.buy1);
        // set a onclick listener for when the button gets clicked
        img.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {


                checkPurchase cp = new checkPurchase(getContext());

                boolean result = cp.forpurchase(banana_r, bamboo_r, gold_r, coconut_r, wood_r);
                String sendres;

                if (result == true)
                    sendres = "true";
                else
                    sendres = "false";


                Bundle args = new Bundle();
                args.putString("check", sendres + " " + Integer.toString(banana_r) + " " + Integer.toString(gold_r) + " " + Integer.toString(gold_r) + " " + Integer.toString(bamboo_r) + " " + Integer.toString(coconut_r) + " ");
                dFragment.setArguments(args);
                // Show DialogFragment
                dFragment.show(getFragmentManager(), "Dialog Fragment");      // custom dialog
                Raft obj = new Raft();


            }
        });


    }


}