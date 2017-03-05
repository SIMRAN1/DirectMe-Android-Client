package in.silive.directme.utils;

/**
 * Created by shobhit on 28/2/17.
 */

public class Constants {
    public static final String LOG = "debugging";
    public static final String SHARED_PREFS = "directme_prefs";
    public static final String AUTH_TOKEN = "Authorization_Token";
    public static final String Ship_Image_Url="Ship_Image_Url";
    public static final String Ship_id="Ship_id";
    public static final String Island_id="Island_id";
    public static final String User_id="User_id";
    public static final String Coconut_Island_id="1";
    public static final String Banana_Island_id="3";
    public static final String Timber_Island_id="2";
    public static final String Pirate_Island_id="5";
    public static final String Bamboo_Island_id="4";


    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;
}
