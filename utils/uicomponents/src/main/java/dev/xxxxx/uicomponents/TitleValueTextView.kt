package dev.xxxxx.uicomponents

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import dev.xxxxx.uicomponents.databinding.TitleValueTextviewLayoutBinding

class TitleValueTextView: LinearLayout {
    constructor(context: Context): this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?): super(context, attributeSet, 0){
        setUp(attributeSet)
    }

    private fun setUp(attrs: AttributeSet?) {
        inflate(context, R.layout.title_value_textview_layout, this)

        val binding = TitleValueTextviewLayoutBinding.inflate(LayoutInflater.from(context), this, true)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TitleValueTextView)

        binding.tvTitle.text = attributes.getString(R.styleable.TitleValueTextView_titleText)
        binding.tvValue.text = attributes.getString(R.styleable.TitleValueTextView_valueText)

        attributes.recycle()
    }
}