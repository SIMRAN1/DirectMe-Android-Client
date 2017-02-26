package in.silive.directme.Utils;

import android.graphics.Bitmap;

/**
 * Created by simran on 2/23/2017.
 */

public class Spritesheet {
    private static  int FRAME_W ;
    // frame height
    private static  int FRAME_H ;
    // number of frames
    private static  int NB_FRAMES ;
    // nb of frames in x
    private static int COUNT_X ;
    // nb of frames in y
    private static int COUNT_Y ;

    // frame duration
    public static String spritesheet_name;

    // we can slow animation by changing frame duration
    private static final int FRAME_DURATION = 150; // in ms !

    // stores each frame
    private Bitmap[] bmps;
    public Spritesheet(int FRAME_H,int FRAME_W,int COUNT_X,int COUNT_Y,String spritesheet_name,int NB_FRAMES)
    {
        this.FRAME_H=FRAME_H;
        this.FRAME_W=FRAME_W;
        this.COUNT_X=COUNT_X;
        this.COUNT_Y=COUNT_Y;
        this.spritesheet_name=spritesheet_name;
        this.NB_FRAMES=NB_FRAMES;

    }
}
