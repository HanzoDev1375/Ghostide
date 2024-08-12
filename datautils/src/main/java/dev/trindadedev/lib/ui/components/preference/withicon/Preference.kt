package dev.trindadedev.lib.ui.components.preference.withicon

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import androidx.annotation.DrawableRes

import dev.trindadedev.lib.ui.components.R

class Preference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    public val preferenceTitle: TextView
    public val preferenceDescription: TextView
    public val preferenceIcon: ImageView
    public val preference: View

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_preference_withicon, this, true)

        preferenceTitle = findViewById(R.id.preference_title)
        preferenceDescription = findViewById(R.id.preference_description)
        preferenceIcon = findViewById(R.id.preference_icon)
        preference = findViewById(R.id.preference)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Preference,
            0, 0
        ).apply {
            try {
                val title = getString(R.styleable.Preference_preferenceTitle) ?: ""
                val description = getString(R.styleable.Preference_preferenceDescription) ?: ""
                val iconResId = getResourceId(R.styleable.Preference_preferenceIcon, 0)

                preferenceTitle.text = title
                preferenceDescription.text = description

                if (iconResId != 0) {
                    preferenceIcon.setImageResource(iconResId)
                } else {
                    preferenceIcon.visibility = View.GONE
                }
            } finally {
                recycle()
            }
        }
    }

    fun setPreferenceClickListener(listenerClick: View.OnClickListener) {
        preference.setOnClickListener(listenerClick)
    }

    fun setTitle(value: String) {
        preferenceTitle.text = value
    }

    fun setDescription(value: String) {
        preferenceDescription.text = value
    }

    fun setIcon(@DrawableRes resId: Int) {
        if (resId != 0) {
            preferenceIcon.setImageResource(resId)
            preferenceIcon.visibility = View.VISIBLE
        } else {
            preferenceIcon.visibility = View.GONE
        }
    }
}