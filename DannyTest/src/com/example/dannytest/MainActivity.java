package com.example.dannytest;


import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scv = new ScrollView(this); // Erzeugung eines ScrollViews, mit dem "gescrollt" werden kann
        CanvasTest cv = new CanvasTest(this); // Erzeugung des Canvas (Definition siehe unten)
        cv.setMinimumHeight(800); // Festlegung der H�he des Canvas
        scv.addView(cv);  // Canvas wird in der ScrollView eingef�gt: Ist also "scrollable".
        setContentView(scv);  // Anzeige des ScrollViews mit dem darin eingebetteten Canvas
    }
}

class CanvasTest extends View{
	
	private ScaleGestureDetector mScaleDetector;  // Detector f�r Skalierungsgesten
	private float mScaleFactor = 1.f;  // aktueller Skalierungsfaktor f�r das Icon

	public CanvasTest(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	 private Paint myPaint;
	 
	 
	 protected void onDraw(android.graphics.Canvas canvas) { 
	 
	 myPaint = new Paint();  
	 myPaint.setAntiAlias(true); 
	 myPaint.setStyle(Paint.Style.FILL); 
	 myPaint.setColor(Color.GREEN);
	 
	 
			 
	 canvas.drawColor(Color.WHITE);
	// BitmapFactory.Options options = new BitmapFactory.Options();
	 canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.fewo_grundriss), 0, 0, null);
	 canvas.scale(mScaleFactor, mScaleFactor);
	 canvas.drawCircle(200.0f, 200.0f, 10.0f, myPaint); 
	 canvas.drawCircle(200.0f, 450.0f, 10.0f, myPaint);
	 canvas.drawCircle(400.0f, 550.0f, 10.0f, myPaint);
	 canvas.drawLine(200.0f, 200.0f, 200.0f, 450.0f, myPaint);
	 canvas.drawLine(200.0f, 450.0f, 400.0f, 550.0f, myPaint);
	 
	 
	 
	 }
	
	 private class ExampleScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
         // automatische Ausf�hrung, wenn eine Skalierungsgeste entdeckt wurde
           public boolean onScale(ScaleGestureDetector detector) {
                 // Anpassung des Skalierungsfaktors gem�� der erkannten Geste
                   mScaleFactor *= detector.getScaleFactor();  
                   mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
                   invalidate();
                   return true;
           }
   }
	
	
}
