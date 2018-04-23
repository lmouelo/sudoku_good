package com.example.admin1.sudoku;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class monDessin extends View {


    public monDessin(Context context, AttributeSet attrs) {
        super(context, attrs);


    }


    @SuppressLint("WrongViewCast")
    @Override
    public void onDraw(Canvas canvas) {
        int compteur = 0;
        int compteur2 = 0;
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        Paint paint3 = new Paint();

        paint.setColor(Color.BLUE);
        paint2.setColor(Color.BLACK);
        paint3.setColor(Color.RED);
        paint2.setTextSize(40);
        canvas.getWidth();
        String tab[] = new String[11];

        int tab1[][] = new int[9][9];
        String num ="008203500 009670408 346050702 430010059 967005001 000496203 280034067 703500904 004107020";
        int tab2[][]=new int [10][10];
////////////déplacement//////////////////////////////////////
        final String TAG_LOG = "TouchActivity";
        final boolean LOG = true;
        FrameLayout mFrameLayout;
        mFrameLayout = (FrameLayout)findViewById(R.id.layout);
//        mFrameLayout.setOnTouchListener((OnTouchListener) this);
////////////////////////////////////////////////////////////

        String[] parts = num.split(" ");
        for(int y=0;y<9;y++) {
            String z = parts[y];
            String[] tmp = z.split("");
            for (int i = 0; i < 9; i++) {
                tab2[y][i] = Integer.parseInt(tmp[i+1]);
            }
        }

        for (int y = 0; y <10; y++) {
            for(int i= 0;i<10;i++){
                if(tab2[i][y]!=0) {
                    canvas.drawText("" + tab2[i][y], (canvas.getWidth() / 9) * i, (canvas.getWidth() / 9) * y, paint2);
                }
            }
        }



        for (int i = 0; i < canvas.getWidth(); i += canvas.getWidth()/9) {


                canvas.drawLine(0, i, canvas.getWidth(), i, paint);


                if ((compteur == 3) || (compteur == 6) || (compteur == 9)) {
                    canvas.drawLine(0, i, canvas.getWidth(), i, paint2);
                }

                compteur = compteur + 1;

        }
        for (int i = 0; i < canvas.getWidth(); i += canvas.getWidth()/9 ) {
            canvas.drawLine(i, 0, i,canvas.getWidth() , paint);
            if ((compteur2 == 3) || (compteur2 == 6) || (compteur2 == 9)) {
                canvas.drawLine(i, 0, i, canvas.getWidth(), paint2);
            }
            compteur2++;
        }


        for (int i = 1000; i < 1500; i += 100) {
            canvas.drawLine(0, i, 730, i, paint3);
            canvas.drawText("1",i,i,paint2);
        }

        int numero =1 ;
        for (int i = 0; i < 700; i += 80) {
            canvas.drawLine(i, 1000, i, 1100, paint3);
            canvas.drawText(""+numero,i,1050,paint2);
            numero++;
        }
    }
////////////déplacement//////////////////////////////////////

    public boolean onTouch(View v, MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG", "touched down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("TAG", "moving: (" + x + ", " + y + ")");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("TAG", "touched up");
                break;
        }

        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }

//////////////////////////////////////////////////////////////
}

