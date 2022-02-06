package id.abypraya.challange02;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class Utility {
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }).start();
    }
}
