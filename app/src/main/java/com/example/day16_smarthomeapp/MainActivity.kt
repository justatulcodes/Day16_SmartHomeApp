package com.example.day16_smarthomeapp

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day16_smarthomeapp.databinding.ActivityMainBinding


//https://dribbble.com/shots/21043698-Smart-Home-App

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStatusBarColorAndAppearance("#000000", false)

        setCategoryRecyclerView(binding)


        var isLightOn = false
        binding.llLightBox.setOnClickListener {
            if (!isLightOn) {
                binding.llLightBox.setBackgroundTintList(AppCompatResources.getColorStateList(this, R.color.white))
                binding.tvOfficeLight.setTextColor(Color.parseColor("#000000"))
                binding.tvOfficeLightOffOn.setTextColor(Color.parseColor("#000000"))
                binding.tvOfficeLightOffOn.text = "On • Soft Mode"
                isLightOn = true
            }else{
                binding.tvOfficeLight.setTextColor(Color.parseColor("#FFFFFF"))
                binding.tvOfficeLightOffOn.setTextColor(Color.parseColor("#FFFFFF"))
                binding.tvOfficeLightOffOn.text = "Off"
                binding.llLightBox.setBackgroundTintList(AppCompatResources.getColorStateList(this, R.color.primary_surface))
                isLightOn = false
            }
        }


    }
    fun setCategoryRecyclerView(binding: ActivityMainBinding) {
        val rowCategory = listOf("Living Room", "Kitchen", "Downstairs Bathroom", "Patio", "Godown",
            "Bedroom", "Toilet", "Drawing Room", "Guest Room")
        val adapter = CategoryAdapter(rowCategory)
        binding.lvApplianceCategory.adapter = adapter

        val horizontalLayout = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)
        binding.lvApplianceCategory.layoutManager = horizontalLayout
    }

    fun Activity.setStatusBarColorAndAppearance(statusBarColor: String, isLight: Boolean ) {
        try {
            window.statusBarColor = (Color.parseColor(statusBarColor))// Or we can use from resource color:  ContextCompat.getColor(mContext, R.color.colorPrimary)
            WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLight
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}