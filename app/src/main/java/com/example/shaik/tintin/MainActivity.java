package com.example.shaik.tintin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int score=0;
    private ArrayList<String> array;
    private SwipeFlingAdapterView flingContainer;
    private ArrayAdapter<String> arrayAdapter;
    ArrayList<String> swap_right;
    ArrayList<String> swap_left;
    String removed_ques;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        textView=(TextView)findViewById(R.id.score);
        textView.setText("Score:"+score);



        array = new ArrayList<String>();


        //Questions for which the answer is correct when swapped right
        swap_right=new ArrayList<>();
        swap_right.add("is 2+2=4?");
        swap_right.add("Do we use Intent to go from one Activity to another in Android Studio?");

        //Questions for which the answer is correct when swapped left
        swap_left=new ArrayList<>();
        swap_left.add("Tajmahel was made by Aurangzeb?");
        swap_left.add("We can create Android Applications only using Android Studio?");

        array.addAll(swap_left);
        array.addAll(swap_right);


        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.helloText, array);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                textView.setText("Score:"+score);

                removed_ques=array.get(0);
                array.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //   Toast.makeText(MainActivity.this, "Left!", Toast.LENGTH_SHORT).show();



                if(swap_left.contains(removed_ques))
                {
                    score++;
                    textView.setText("Score:"+score);
                    Toast.makeText(MainActivity.this,"correct",Toast.LENGTH_SHORT).show();
                }
                else
                {


                    Toast.makeText(MainActivity.this,"wrong",Toast.LENGTH_SHORT).show();

                }

                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                //      Toast.makeText(MainActivity.this, "Right!", Toast.LENGTH_SHORT).show();

                if(swap_right.contains(removed_ques))
                {        score++;

                    textView.setText("Score:"+score);

                    Toast.makeText(MainActivity.this,"correct",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


    }
}
