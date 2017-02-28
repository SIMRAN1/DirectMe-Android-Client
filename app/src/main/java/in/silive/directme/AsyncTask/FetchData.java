package in.silive.directme.AsyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import in.silive.directme.Interface.AsyncResponse;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Lenovo on 19-Jan-17.
 */

public class FetchData extends AsyncTask<String, String, String> {

    String token=null;
    private AsyncResponse delegate = null;//Call back interface
    private String post_data=null;
    private String url="";

    public FetchData(AsyncResponse asyncResponse) {
        delegate = asyncResponse;//Assigning call back interfacethrough constructor
    }

    @Override
    protected void onPreExecute() {
        Log.d("debugging", "pre execute : " + url);
        super.onPreExecute();

    }

    public void setArgs(String url, String token, String post_data){
        this.url = url;
        this.token = token;
        this.post_data = post_data;
    }

    @Override
    public String doInBackground(String... args) {
        String result = "";
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
//            String s = args[0];
            connection.addRequestProperty("Authorization", "Token " + token);
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder("");
                String line = "";

                while ((line = in.readLine()) != null) {

                    sb.append(line);
                    break;
                }

                in.close();
                result = sb.toString();
            } else {
                Toast.makeText(getApplicationContext(), responseCode,
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    protected void onPostExecute(String result) {
        Log.d("debugging", "post execute : " + result);
        delegate.processFinish(result);
        super.onPostExecute(result);
    }
}