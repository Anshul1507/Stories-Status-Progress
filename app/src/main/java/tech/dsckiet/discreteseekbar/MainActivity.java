package tech.dsckiet.discreteseekbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import static tech.dsckiet.discreteseekbar.R.color.colorAccent;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    int height,width,numberOfSections;
    LinearLayout layoutViews;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findviews
        layoutViews = findViewById(R.id.layout_views);

        //for getting dimensions of screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        //suppose we have to cut section into 4 parts
        numberOfSections = 10;
        width -= (16 + 16*numberOfSections);
        width /= numberOfSections;
        for(int i=0;i<numberOfSections;i++){
            View v = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, 10);
            params.setMargins(16,0,0,0);
            v.setLayoutParams(params);

            v.setBackgroundColor(getResources().getColor(colorAccent));
            layoutViews.addView(v);
        }
    }
}
