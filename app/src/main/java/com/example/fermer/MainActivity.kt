package com.example.fermer

import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fermer.databinding.ActivityMainBinding
import com.google.android.material.shape.MaterialShapeDrawable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastSelectedButtonLayout: LinearLayout? = null
    private var lastSelectedButtonId: Int? = null
    private var lastSelectedTextId: Int? = null
    private var lastSelectedIconResId: Int? = null

    private lateinit var navController: NavController

    private val buttonConfigs = listOf(
        ButtonConfig(R.id.home_button_layout, R.id.home_ib, R.id.home_tv, R.drawable.home, R.drawable.home_selector_vectors, R.id.homeFragment),
        ButtonConfig(R.id.catalog_button_layout, R.id.catalog_ib, R.id.catalog_tv, R.drawable.ic_catalog, R.drawable.ic_catalog_vector, R.id.catalogFragment),
        ButtonConfig(R.id.chosen_button_layout, R.id.chosen_ib, R.id.chosen_tv, R.drawable.chosen, R.drawable.chosen_selector_vectors, R.id.chosenFragment),
        ButtonConfig(R.id.profile_button_layout, R.id.profile_ib, R.id.profile_tv, R.drawable.profile, R.drawable.profile_selector_vectors, R.id.profileFragment)
    )

    data class ButtonConfig(
        val layoutId: Int,
        val buttonId: Int,
        val textId: Int,
        val newIconResId: Int,
        val defaultIconResId: Int,
        val fragmentId: Int
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomAppBarCornerRadius()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        buttonConfigs.forEach { config ->
            setupButtonClickListener(config)
        }

        selectInitialButton(buttonConfigs[0])
    }

    private fun setupBottomAppBarCornerRadius() {
        val radius = resources.getDimension(R.dimen.corner_radius)
        val bottomBarBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel = bottomBarBackground.shapeAppearanceModel.toBuilder()
            .setAllCornerSizes(radius)
            .build()
    }

    private fun setupButtonClickListener(config: ButtonConfig) {
        findViewById<LinearLayout>(config.layoutId).setOnClickListener {
            //it.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha))
            resetLastSelectedButton()
            lastSelectedIconResId = config.defaultIconResId
            changeButtonIconAndTextColor(config.buttonId, config.textId, config.newIconResId)
            lastSelectedButtonLayout = findViewById(config.layoutId)
            lastSelectedButtonId = config.buttonId
            lastSelectedTextId = config.textId
            navController.navigate(config.fragmentId)
    }
    }

    private fun selectInitialButton(config: ButtonConfig) {
        changeButtonIconAndTextColor(config.buttonId, config.textId, config.newIconResId)
        lastSelectedButtonLayout = findViewById(config.layoutId)
        lastSelectedButtonId = config.buttonId
        lastSelectedTextId = config.textId
        lastSelectedIconResId = config.defaultIconResId
    }

    private fun resetLastSelectedButton() {
        lastSelectedButtonLayout.let {
            findViewById<ImageButton>(lastSelectedButtonId!!).setImageDrawable(
                ContextCompat.getDrawable(this, lastSelectedIconResId!!)
            )
            findViewById<TextView>(lastSelectedTextId!!).setTextColor(
                ContextCompat.getColor(this, R.color.gray)
            )
        }
    }

    private fun changeButtonIconAndTextColor(buttonId: Int, textId: Int, newIconResId: Int) {
        findViewById<ImageButton>(buttonId).setImageDrawable(
            ContextCompat.getDrawable(this, newIconResId)
        )
        findViewById<TextView>(textId).setTextColor(
            ContextCompat.getColor(this, R.color.white)
        )
    }

}