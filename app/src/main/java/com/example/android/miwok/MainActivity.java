package com.example.android.miwok;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_category);

        ViewPager viewPager = findViewById(R.id.pager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryPageAdapter adapter = new CategoryPageAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);



//        // Find the View that shows the numbers category
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//
//        // Set a click listener on that View
//        numbers.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the numbers category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link NumbersActivity}
//                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//
//                // Start the new activity
//                startActivity(numbersIntent);
//            }
//        });
//
//        // Find the View that shows the family category
//        TextView family = (TextView) findViewById(R.id.family);
//
//        // Set a click listener on that View
//        family.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the family category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link FamilyActivity}
//                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
//
//                // Start the new activity
//                startActivity(familyIntent);
//            }
//        });
//
//        // Find the View that shows the colors category
//        TextView colors = (TextView) findViewById(R.id.colors);
//
//        // Set a click listener on that View
//        colors.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the colors category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link ColorsActivity}
//                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
//
//                // Start the new activity
//                startActivity(colorsIntent);
//            }
//        });
//
//        // Find the View that shows the phrases category
//        TextView phrases = (TextView) findViewById(R.id.phrases);
//
//        // Set a click listener on that View
//        phrases.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the phrases category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link PhrasesActivity}
//                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
//
//                // Start the new activity
//                startActivity(phrasesIntent);
//            }
//        });
    }
}
