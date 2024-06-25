package com.mcal.webview

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

open class BaseActivity : AppCompatActivity() {
    fun setupToolbar(
        id: Int,
        title: Int,
        subtitle: String? = null,
        icon: Drawable? = null,
        back: Boolean = false
    ) {
        setupToolbar(id, getString(title), subtitle, icon, back)
    }

    fun setupToolbar(
        id: Int,
        title: String? = null,
        subtitle: String? = null,
        icon: Drawable? = null,
        back: Boolean = false
    ) {
        val toolbar = findViewById<MaterialToolbar>(id)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title?.let {
                this.title = it
            }
            subtitle?.let {
                this.subtitle = it
            }
            icon?.let {
                this.setIcon(it)
            }
            if (back) {
                this.setDisplayHomeAsUpEnabled(true)
                this.setDisplayShowHomeEnabled(true)
            }
        }
    }

}