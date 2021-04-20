package com.example.hondanaoyuki.myapplication

import android.view.animation.Animation
import android.view.animation.Transformation

class AnimationArc internal constructor(arc: Arc, newAngle: Int) : Animation() {
    private val arc: Arc

    // アニメーション角度
    private val mOldAngle: Float
    private val mNewAngle: Float
    override fun applyTransformation(
        interpolatedTime: Float, transformation: Transformation
    ) {
        val angle = mOldAngle + (mNewAngle - mOldAngle) * interpolatedTime
        arc.setAngle(angle)
        arc.requestLayout()
    }

    init {
        mOldAngle = arc.getAngle()
        this.mNewAngle = newAngle.toFloat()
        this.arc = arc
    }
}