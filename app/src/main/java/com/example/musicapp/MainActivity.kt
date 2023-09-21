package com.example.musicapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var isPressed: Boolean = false

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPause: ImageButton = findViewById<ImageButton>(R.id.pauseButton)
        val buttonPlay: ImageButton = findViewById<ImageButton>(R.id.buttonPlay)


        buttonPause.setOnClickListener(){
            buttonPause.visibility = View.INVISIBLE
            buttonPlay.visibility = View.VISIBLE
            isPressed = true
        }
        buttonPlay.setOnClickListener() {
            buttonPause.visibility = View.VISIBLE
            buttonPlay.visibility = View.INVISIBLE
            isPressed = false
        }
    }

    override fun onResume(){
        super.onResume()
        Log.d("Debug","onResume")
        val buttonPause: ImageButton = findViewById<ImageButton>(R.id.pauseButton)
        val buttonPlay: ImageButton = findViewById<ImageButton>(R.id.buttonPlay)
        if (isPressed){
            buttonPause.visibility = View.INVISIBLE
            buttonPlay.visibility = View.VISIBLE
        }else {
            buttonPause.visibility = View.VISIBLE
            buttonPlay.visibility = View.INVISIBLE
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
// Save the user's current game state.
        outState?.run {
            putBoolean("isPressed", isPressed)
        }
// Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
// Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
// Restore state members from saved instance.
        savedInstanceState?.run {
            isPressed = savedInstanceState.getBoolean("isPressed")
        }
    }

}
//        boolean isPressed=false
//        button.setOnClickListener(buttonListener);
//
//        OnClickListener buttonListener= new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isPressed){
//                    button.setBackgroundResource(R.drawable.icon1);
//                }else{
//                    button.setBackgroundResource(R.drawable.icon2);
//                }
//                isPressed=!isPressed;
//            }};
