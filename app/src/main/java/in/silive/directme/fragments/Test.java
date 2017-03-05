package in.silive.directme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.silive.directme.R;

/**
 * Created by simran on 3/5/2017.
 */

public class Test extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.showroom_fragment, container,
                false);
        return  rootView;
    }

}
