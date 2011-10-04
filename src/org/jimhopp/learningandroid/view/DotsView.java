package org.jimhopp.learningandroid.view;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

import org.jimhopp.learningandroid.model.Dots;
import org.jimhopp.learningandroid.model.Dot;

import java.util.Iterator;


public class DotsView extends View {

	private final Dots dots;
	
	public DotsView(Context context, Dots dots)
	{
		super(context);
		this.dots = dots;
		setMinimumWidth(180);
		setMinimumHeight(200);
		setFocusable(true);
	}
	@Override protected void onMeasure(int w, int h) {
		setMeasuredDimension(
				getSuggestedMinimumWidth(),
				getSuggestedMinimumHeight());
	}
	@Override protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		
		Paint paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(hasFocus() ? Color.BLUE : Color.GRAY);
		canvas.drawRect(0, 0, getWidth() -1, getHeight()-1, paint);
		
		paint.setStyle(Style.FILL);
		Iterator<Dot> dotIter = dots.getDots();
		while (dotIter.hasNext()) {
			Dot dot = dotIter.next();
			paint.setColor(dot.getColor());
			canvas.drawCircle(dot.getX(), dot.getY(), dot.getDiameter(), paint);
		}
		  

	}
}
