package tech.dsckiet.discreteseekbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static tech.dsckiet.discreteseekbar.R.color.colorAccent;
import static tech.dsckiet.discreteseekbar.R.color.colorPrimaryDark;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    Button mButton;
    int x=0,height,width,numberOfSections;
    LinearLayout layoutViews;
    ArrayList<View> viewsList =new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findviews
        layoutViews = findViewById(R.id.layout_views);
        mButton = (Button) findViewById(R.id.button);

        //for getting dimensions of screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        //suppose we have to cut section into 4 parts
        numberOfSections = 10;
        width -= (16 + 16*numberOfSections);    //reducing length of layout by 16dp from left and right and in between 16dp {in between*number of sections)
        width /= numberOfSections;
        for(int i=0;i<numberOfSections;i++){
            View v = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, 10);
            params.setMargins(16,0,0,0);    //giving 16dp internal margin between two views
            v.setLayoutParams(params);
            viewsList.add(v);   //adding views in array list for changing color on click of button

            v.setBackgroundColor(getResources().getColor(colorAccent));
            layoutViews.addView(v);
        }
        //button onclick function
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    buttonClick();
            }
        });
    }

    public void buttonClick(){
       viewsList.get(x).setBackgroundColor(getResources().getColor(colorPrimaryDark));
       x++;
    }
}
