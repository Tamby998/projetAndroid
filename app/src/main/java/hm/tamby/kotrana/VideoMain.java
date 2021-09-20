package hm.tamby.kotrana;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoMain extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_main);

        videoView = (VideoView)findViewById(R.id.videoViews);
        String str = "https://firebasestorage.googleapis.com/v0/b/kotrana-94699.appspot.com/o/video.webm?alt=media&token=337a3726-eeaa-4dda-925b-5d962e957579";
        Uri uri = Uri.parse(str);

        videoView.setVideoURI(uri);
    }
    @Override
    protected void onResume(){
        super.onResume();
        videoView.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        videoView.suspend();
    }
}