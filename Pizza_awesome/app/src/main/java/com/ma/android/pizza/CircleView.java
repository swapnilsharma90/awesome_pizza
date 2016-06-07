package com.ma.android.pizza;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by swapsharma on 6/6/16.
 */
public class CircleView extends View {


    private int slices;
    private Paint circlePaint;
    private Paint circleStrokePaint;
    private Paint circleRedPaint;

    private Paint circleGreenPaint;

    private RectF circleArc;

    private Paint circleDividerPaint;


    // Attrs
    private int circleRadius;
    private int circleFillColor;
    private int circleStrokeColor;
    private int circleStartAngle;
    private int circleEndAngle;


    private int fillColor;

    public CircleView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(attrs); // Read all attributes

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);
        circleStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circleStrokePaint.setStyle(Paint.Style.STROKE);
        circleStrokePaint.setStrokeWidth(40);
        circleStrokePaint.setColor(circleStrokeColor);


        circleDividerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circleDividerPaint.setStyle(Paint.Style.STROKE);
        circleDividerPaint.setStrokeWidth(.5f);
        circleDividerPaint.setColor(circleStrokeColor);


        circleRedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circleRedPaint.setStyle(Paint.Style.STROKE);
        circleRedPaint.setStrokeWidth(10);
        circleRedPaint.setColor(getResources().getColor(R.color.colorAccent));


        circleGreenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circleGreenPaint.setStyle(Paint.Style.FILL);
        circleGreenPaint.setStrokeWidth(10);
        circleGreenPaint.setColor(getResources().getColor(R.color.green));

    }

    public void init(AttributeSet attrs) {
        // Go through all custom attrs.
        TypedArray attrsArray = getContext().obtainStyledAttributes(attrs, R.styleable.circleview);
        circleRadius = attrsArray.getInteger(R.styleable.circleview_cRadius, 0);
        circleFillColor = attrsArray.getColor(R.styleable.circleview_cFillColor, 16777215);
        circleStrokeColor = attrsArray.getColor(R.styleable.circleview_cStrokeColor, -1);
        circleStartAngle = attrsArray.getInteger(R.styleable.circleview_cAngleStart, 0);
        circleEndAngle = attrsArray.getInteger(R.styleable.circleview_cAngleEnd, 360);
        // Google tells us to call recycle.
        attrsArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Move canvas down and right 1 pixel.
        // Otherwise the stroke gets cut off.
        canvas.translate(1, 1);
        circlePaint.setColor(circleFillColor);
        canvas.drawArc(circleArc, circleStartAngle, circleEndAngle, true, circlePaint);
        canvas.drawArc(circleArc, circleStartAngle, circleEndAngle, true, circleStrokePaint);

        canvas.drawArc(circleArc, circleStartAngle, circleEndAngle, false, circleRedPaint);

        canvas.drawArc(circleArc, 0, 60, true, circleDividerPaint);
        canvas.drawArc(circleArc, 60, 120, true, circleDividerPaint);
        canvas.drawArc(circleArc, 120, 180, true, circleDividerPaint);
        canvas.drawArc(circleArc, 180, 240, true, circleDividerPaint);
        canvas.drawArc(circleArc, 240, 300, true, circleDividerPaint);
        circlePaint.setTextAlign(Paint.Align.CENTER);

        //draw jalapenos

//        canvas.drawCircle(95, 155, 10, circleGreenPaint);
//        canvas.drawCircle(105, 215, 10, circleGreenPaint);
//        canvas.drawCircle(260, 195, 10, circleGreenPaint);
//        canvas.drawCircle(190, 255, 10, circleGreenPaint);
//        canvas.drawCircle(220, 375, 10, circleGreenPaint);
//        canvas.drawCircle(295, 295, 10, circleGreenPaint);

        //draw chillies








    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int measuredWidth = measureWidth(widthMeasureSpec);
        if (circleRadius == 0) {
            // Check width size. Make radius half of available.
            circleRadius = measuredWidth / 2;
            int tempRadiusHeight = measureHeight(heightMeasureSpec) / 2;
            if (tempRadiusHeight < circleRadius)
                // Check height, if height is smaller than
                // width, then go half height as radius.
                circleRadius = tempRadiusHeight;
        }
        // Remove 2 pixels for the stroke.
        int circleDiameter = circleRadius * 2 - 50;
        // RectF(float left, float top, float right, float bottom)
        circleArc = new RectF(20, 20, circleDiameter, circleDiameter);

//        circleArc = new RectF(130, 40, circleDiameter, circleDiameter);

        int measuredHeight = measureHeight(heightMeasureSpec);
        setMeasuredDimension(measuredWidth, measuredHeight);
        Log.d("onMeasure() ::", "measuredHeight =>" + String.valueOf(measuredHeight) + "px measuredWidth => " + String.valueOf(measuredWidth) + "px");
    }

    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == View.MeasureSpec.AT_MOST) {
            result = circleRadius * 2;
        } else if (specMode == View.MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }

    private int measureWidth(int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        int result = 0;
        if (specMode == View.MeasureSpec.AT_MOST) {
            result = specSize;
        } else if (specMode == View.MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }


    public void setFillColor(int newColor) {
        fillColor = newColor;
    }


    public void setSlices(int slices) {
        slices = slices;
    }


    public void setCircleRadius(int radius)

    {
        circleRadius = radius;


    }
}

