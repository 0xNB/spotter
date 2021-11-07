package de.nb.spotter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.BitmapFactory

import android.widget.ImageView
import java.net.URL


class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val imageView = findViewById<ImageView>(R.id.imageView)

        val url = URL("https://i.redd.it/lnv8jufdf5v71.jpg")
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        imageView.setImageBitmap(bmp)
    }
}