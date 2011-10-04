package org.jimhopp.learningandroid.model;

import java.util.Iterator;
import java.util.LinkedList;

import android.graphics.Color;

public class Dots {
	public interface DotsChangeListener {
		void onDotsChange(Dots dots);
	} 
		
	private LinkedList<Dot> dots = new LinkedList<Dot>();
	private DotsChangeListener dotsChangeListener;
	
	public void generateDots() {
		addDot(new Dot((float)50, (float)50, Color.BLUE, 10));
	}
	
	public void addDot(Dot dot) {
		dots.add(dot);
	    if (dotsChangeListener != null)	{
	    	dotsChangeListener.onDotsChange(this);
	    }
	}
	
	public Dot getLastDot() {
		return dots.getLast();
	}
	
	public Iterator<Dot> getDots() {
		return dots.iterator();
	}

	public void setDotsChangeListener(DotsChangeListener l){
		dotsChangeListener = l;
	}
}
