package in.silive.directme.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.silive.directme.fragments.ShowroomFragment;

/**
 * Created by Shobhit-pc on 3/3/2017.
 */

public class ShowroomAdapter extends FragmentStatePagerAdapter {

    JSONArray jArray;
    int count;


    public ShowroomAdapter(FragmentManager fm, JSONArray jsonArray, int c) {
        super(fm);
        count = c;
        jArray = jsonArray;
    }

    @Override
    public Fragment getItem(int position) {
        JSONObject json_send = null;
        if (jArray != null) {
            try {
                json_send = jArray.getJSONObject(position);

                Log.d("shipapi", json_send.toString());
                ShowroomFragment ships_fragment = new ShowroomFragment();
                Bundle args = new Bundle();
                args.putString("data", json_send.toString());
                // args.putInt("slot", slot);
                Log.d("args", args.toString());
                ships_fragment.setArguments(args);
                return ships_fragment;

            } catch (JSONException e) {
                e.printStackTrace();
                return null;

            }
        } else
            return null;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        if (position >= getCount()) {
            FragmentManager manager = ((Fragment) object).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove((Fragment) object);
            trans.commit();
        }
    }
}