package com.infinixsoft.plora

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Federico Torres on 7/7/2017.
 */


fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).into(this)
}



fun View.visible(){
    this.visibility = View.VISIBLE
}


fun View.invisible(){
    this.visibility = View.INVISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}





fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}


    fun Context.showToast(stringResource : Int, duration : Int){
    if(duration != Toast.LENGTH_SHORT && duration != Toast.LENGTH_LONG){
        Log.e("ShowToast","Wrong duration parameter")
       return
    }
    Toast.makeText(this,getString(stringResource),duration).show()
}





fun View.isVisible():Boolean{
    return this.visibility == View.VISIBLE
}
