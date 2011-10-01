package org.jimhopp.learningandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

import java.util.Random;

public class LearningByDotsActivity extends Activity {
	private LinearLayout root;
	Random mRand = new Random();

	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.main);
        root = (LinearLayout) findViewById(R.id.root);
        
        final EditText tb1 = (EditText) findViewById(R.id.text1);
        final EditText tb2 = (EditText) findViewById(R.id.text2);
    
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	tb1.setText(String.valueOf(mRand.nextInt(200)));
            	tb2.setText(String.valueOf(mRand.nextInt(200)));
            }
        });
    }
}