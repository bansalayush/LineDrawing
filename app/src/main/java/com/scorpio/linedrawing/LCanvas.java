package com.scorpio.linedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ayush Bansal on 10-01-2017.
 */

public class LCanvas extends View {

    private Paint vcPaint;
    private Context c;
    float [] pX = new float[4];
    float [] pY = new float[4];
    int count = 0;

    private void init(Context context){
        vcPaint = new Paint();
        vcPaint.setColor(Color.BLACK);
        vcPaint.setStyle(Paint.Style.STROKE);
        vcPaint.setStrokeJoin(Paint.Join.ROUND);
        vcPaint.setStrokeCap(Paint.Cap.ROUND);
        vcPaint.setStrokeWidth(12);
        c = context;
    }

    public LCanvas(Context context) {
        super(context);
        init(context);
    }

    public LCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("MYLOG","onDraw() called");

        switch(count){

            case 1 :
                canvas.drawPoint(pX[count-1],pY[count-1],vcPaint);
                break;

            case 2 :
                canvas.drawPoint(pX[count-2],pY[count-2],vcPaint);
                canvas.drawLine(pX[count-2],pY[count-2],pX[count-1],pY[count-1],vcPaint);
                break;

            case 3 :
                canvas.drawPoint(pX[count-3],pY[count-3],vcPaint);
                canvas.drawLine(pX[count-3],pY[count-3],pX[count-2],pY[count-2],vcPaint);

                canvas.drawPoint(pX[count-1],pY[count-1],vcPaint);
                break;

            case 4 :
                canvas.drawPoint(pX[count-4],pY[count-4],vcPaint);
                canvas.drawPoint(pX[count-3],pY[count-3],vcPaint);
                canvas.drawLine(pX[count-4],pY[count-4],pX[count-3],pY[count-3],vcPaint);

                canvas.drawPoint(pX[count-2],pY[count-2],vcPaint);
                canvas.drawPoint(pX[count-1],pY[count-1],vcPaint);
                canvas.drawLine(pX[count-2],pY[count-2],pX[count-1],pY[count-1],vcPaint);
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.i("MYLOG","onTouchEvent() called");
        if(e.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(count < 4)
            {
                pX[count] = (int) e.getX();
                pY[count] = (int) e.getY();
                System.out.println("pX=" + pX[count] + "pY=" + pY[count]);
                ++count;
                invalidate();
            }
            else{
                this.invalidate();
                count=0;
            }
        }
        return false;
    }


}
