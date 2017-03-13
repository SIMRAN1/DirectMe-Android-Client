package in.silive.directme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import in.silive.directme.R;
import in.silive.directme.application.DirectMe;

/**
 * Created by simran on 3/12/2017.
 */

public class UserProfileFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_profile, container,
                false);

        return rootView;
    }

}
