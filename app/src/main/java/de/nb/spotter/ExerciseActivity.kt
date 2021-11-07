package de.nb.spotter

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.BitmapFactory
import android.os.AsyncTask.execute

import android.widget.ImageView
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.Executors


class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val imageView = findViewById<ImageView>(R.id.imageView)

        val executorService = Executors.newSingleThreadExecutor()
        val future = executorService.submit(DownloaderTask(imageView))

        val bitmap = future.get()
        imageView.setImageBitmap(bitmap)
    }

    private class DownloaderTask(var imageView: ImageView) : Callable<Bitmap> {

        override fun call(): Bitmap? {
            val url = URL("https://i.redd.it/lnv8jufdf5v71.jpg")
            val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            return bmp
        }

    }
}