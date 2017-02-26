package in.silive.directme.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import in.silive.directme.R;
import in.silive.directme.adapter.DataAdapter;
import in.silive.directme.rest.User_details;

/**
 * Created by simran on 2/24/2017.
 */

public class User_details_Activity extends AppCompatActivity {
    private final String user_names[] = {
            "si",
            "si",
            "si",
            "si",
            "si",
            "si",
            "si",
            "si",
            "si",
            "si"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        initViews();
    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),5);

        recyclerView.setLayoutManager(layoutManager);

        ArrayList<User_details> user_details = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),user_details);
        recyclerView.setAdapter(adapter);


    }
    private ArrayList<User_details> prepareData(){

        ArrayList<User_details> user_details = new ArrayList<>();
        for(int i=0;i<user_names.length;i++){
            User_details userDetails = new User_details();
            userDetails.setUser_name(user_names[i]);
            userDetails.setUser_image_url("simran");
            user_details.add(userDetails);
        }
        return user_details;
    }
}
