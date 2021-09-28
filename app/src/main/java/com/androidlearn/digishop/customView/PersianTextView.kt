package com.androidlearn.digishop.customView

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class PersianTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        setFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setFont(context)
    }

    private fun setFont(context: Context) {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/BNAZANIN.TTF")
        setTypeface(typeface)
    }
}