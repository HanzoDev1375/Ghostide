package dev.trindadedev.lib.ui.components.preference

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView

import dev.trindadedev.lib.ui.components.R

class PreferencePopup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    public val preferenceTitle: TextView
    public val preferenceDescription: TextView
    public val preference: View
    val popupMenu: PopupMenu = PopupMenu(context, this)

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_preference, this, true)

        preferenceTitle = findViewById(R.id.preference_title)
        preferenceDescription = findViewById(R.id.preference_description)
        preference = findViewById(R.id.preference)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PreferencePopup,
            0, 0
        ).apply {
            try {
                val title = getString(R.styleable.PreferencePopup_preferencePopupTitle) ?: ""
                val description = getString(R.styleable.PreferencePopup_preferencePopupDescription) ?: ""
                preferenceTitle.text = title
                preferenceDescription.text = description
            } finally {
                recycle()
            }
        }

        preference.setOnClickListener { popupMenu.show() }
    }

    fun addPopupMenuItem(itemTitle: String) {
        popupMenu.menu.add(itemTitle)
    }

    fun setMenuListener(listener: PopupMenu.OnMenuItemClickListener) {
        popupMenu.setOnMenuItemClickListener(listener)
    }
}