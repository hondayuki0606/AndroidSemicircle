package com.example.hondanaoyuki.myapplication

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener
import android.widget.Button;
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mArc: Arc? = null
    private var mEndAngle = 0
    private val mAnimationPeriod = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mArc = findViewById(R.id.arc)

        val random = Random()
        val randomValue: Int = random.nextInt(180)
        mEndAngle = randomValue
        val animation = AnimationArc(mArc!!, mEndAngle)
        // アニメーションの起動期間を設定
        animation.duration = mAnimationPeriod.toLong()
        mArc!!.startAnimation(animation)

        val statusText: TextView = findViewById(R.id.status_text)
        if (randomValue >= 60) {

        } else if(randomValue >= 120) {

        } else {

        }
        val buttonStart: Button = findViewById(R.id.button_start)
        buttonStart.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                val random = Random()
                val randomValue: Int = random.nextInt(180)
                mEndAngle = randomValue
                val animation = AnimationArc(mArc!!, mEndAngle)
                // アニメーションの起動期間を設定
                animation.duration = mAnimationPeriod.toLong()
                mArc!!.startAnimation(animation)
            }
        })

        val buttonReset: Button = findViewById(R.id.button_reset)
        buttonReset.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                val animation = AnimationArc(mArc!!, 0)
                animation.duration = 0
                mArc!!.startAnimation(animation)
            }
        })
    }
}