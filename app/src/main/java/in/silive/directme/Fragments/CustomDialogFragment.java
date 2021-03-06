package in.silive.directme.Fragments;

/**
 * Created by YESH AGNIHOTRI on 18-11-2016.
 */

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import in.silive.directme.R;


public class CustomDialogFragment extends android.support.v4.app.DialogFragment {
    String tvalue = "", banana_req = "", gold_req = "", wood_req = "", bamboo_req = "", coconut_req = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView1 = inflater.inflate(R.layout.dialog_fragment_layout, container,
                false);
        tvalue = "";
        banana_req = "";
        gold_req = "";
        wood_req = "";
        bamboo_req = "";
        coconut_req = "";

        String strtext = getArguments().getString("check");

        int c = 0, i;
        for (i = 0; i < strtext.length(); i++) {
            if (strtext.charAt(i) != ' ') {
                if (c == 0)
                    tvalue = tvalue + strtext.charAt(i);
                if (c == 1)
                    banana_req = banana_req + strtext.charAt(i);
                if (c == 2)
                    gold_req = gold_req + strtext.charAt(i);
                if (c == 3)
                    wood_req = wood_req + strtext.charAt(i);
                if (c == 4)
                    bamboo_req = bamboo_req + strtext.charAt(i);
                if (c == 5)
                    coconut_req = coconut_req + strtext.charAt(i);
            }
            if (strtext.charAt(i) == ' ')
                c++;
        }


        int choice = 1;

        final Dialog dialog = getDialog();
        dialog.setTitle(strtext);
        TextView message = (TextView) rootView1.findViewById(R.id.message);
        String msg = "";
        if (tvalue.equalsIgnoreCase("true"))
            choice = 2;
        else
            choice = 3;

        if (choice == 1) {
            msg = "You already own this vehicle.Please buy a new dock to buy more";
            message.setText(msg);
            Button button = (Button) rootView1.findViewById(R.id.ok1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            Button buttoncancel = (Button) rootView1.findViewById(R.id.cancel);
            buttoncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
        if (choice == 2) {
            msg = "Are you sure you want to buy this";
            message.setText(msg);
            Button button = (Button) rootView1.findViewById(R.id.ok1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            Button buttoncancel = (Button) rootView1.findViewById(R.id.cancel);
            buttoncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
        if (choice == 3) {
            msg = "You don't have enough money to buy this one";
            message.setText(msg);
            Button button = (Button) rootView1.findViewById(R.id.ok1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            Button buttoncancel = (Button) rootView1.findViewById(R.id.cancel);
            buttoncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }

        return rootView1;
    }

    public void seperate(String str) {
        int c = 0, i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (c == 0)
                    tvalue = tvalue + str.charAt(i);
                if (c == 1)
                    banana_req = banana_req + str.charAt(i);
                if (c == 2)
                    gold_req = gold_req + str.charAt(i);
                if (c == 3)
                    wood_req = wood_req + str.charAt(i);
                if (c == 4)
                    bamboo_req = bamboo_req + str.charAt(i);
                if (c == 5)
                    coconut_req = coconut_req + str.charAt(i);
            }
            if (str.charAt(i) == ' ')
                c++;
        }
    }
}

