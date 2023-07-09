package com.yihantaiduo.myapplicationrtc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    val imageUrl = "https://img-blog.csdnimg.cn/c43c2bd179034b22b9ee54095391846e.png"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var image:ImageView = findViewById(R.id.image_view)
        var loadImage =LoadImage(this,imageUrl,image)
        loadImage.showNetworkImage()
    }


}