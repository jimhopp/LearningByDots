package org.jimhopp.learningandroid;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

import org.jimhopp.learningandroid.model.Dots;
import org.jimhopp.learningandroid.model.Dot;
import org.jimhopp.learningandroid.view.DotsView;

import java.util.Random;

public class LearningByDotsActivity extends Activity {
	private LinearLayout root;
	Random mRand = new Random();
	
	Dots model = new Dots();
	DotsView dotView;

	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.main);
        root = (LinearLayout) findViewById(R.id.root);
        dotView = new DotsView(this, model);
        root.addView(dotView, 0);
                
        final EditText tb1 = (EditText) findViewById(R.id.text1);
        final EditText tb2 = (EditText) findViewById(R.id.text2);
        
        model.setDotsChangeListener(new Dots.DotsChangeListener() {
			public void onDotsChange(Dots dots) {
				tb1.setText(String.valueOf(dots.getLastDot().getX()));
				tb2.setText(String.valueOf(dots.getLastDot().getY()));
				dotView.invalidate();
			}
		});
    
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	makeDot(model, Color.RED);
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	makeDot(model, Color.GREEN);
            }
        });
    }
	
	void makeDot(Dots model, int color) {
    	model.addDot(new Dot (mRand.nextFloat() * 200, mRand.nextFloat() * 200, color, 15));
	}
}