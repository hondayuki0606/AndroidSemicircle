package com.example.hondanaoyuki.myapplication

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

class Arc(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var mContext: Context? = null
    private var mPaint: Paint? = null
    private var mRect: RectF? = null

    // Animation 開始地点をセット
    private val mAngleTarget = 180f

    // 初期 Angle
    private var mAngle = 180f

    fun Arc(context: Context?, attrs: AttributeSet?) {
        mContext = context

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Canvas 中心点
        val x = (width / 2).toFloat()
        val y = (height / 1.4).toFloat()
        // 半径
        val radius = (width / 4).toFloat()

        // Arcの幅
        val strokeWidth = 250
        mPaint = Paint()
//        if (mPaint == null) return
        mPaint!!.setAntiAlias(true)
        mPaint!!.setStyle(Paint.Style.STROKE)
        mPaint!!.setStrokeWidth(strokeWidth.toFloat())
        // Arcの色
        mPaint!!.setColor(Color.argb(65, 0, 0, 255))
        // Arcの範囲
        mRect = RectF()

        if (mRect == null) return
        // 円弧の領域設定
        mRect!![x - radius, y - radius, x + radius] = y + radius
        // 円弧の描画
        canvas.drawArc(mRect!!, mAngleTarget, mAngle, false, mPaint!!)

    }

    // AnimationAへ現在のangleを返す
    fun getAngle(): Float {
        return mAngle
    }

    // AnimationAから新しいangleが設定される
    fun setAngle(angle: Float) {
        this.mAngle = angle
    }
}