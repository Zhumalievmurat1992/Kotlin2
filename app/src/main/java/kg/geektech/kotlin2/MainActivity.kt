package kg.geektech.kotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kg.geektech.kotlin2.databinding.ActivityMainBinding
import kg.geektech.kotlin2.extension.showToast
import kg.geektech.kotlin2.extension.urlValidation
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imageList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImage()
        startJob()
    }

    private fun loadImage() {
        imageList.add(getString(R.string.url_1))
        imageList.add(getString(R.string.url_2))
        imageList.add(getString(R.string.url_3))
        imageList.add(getString(R.string.url_4))
        imageList.add(getString(R.string.url_5))
        imageList.add(getString(R.string.url_6))
        imageList.add(getString(R.string.url_7))
        imageList.add(getString(R.string.url_8))
        imageList.add(getString(R.string.url_9))
        imageList.add(getString(R.string.url_10))
    }

    private fun startJob() {
        binding.randomButton.setOnClickListener {
            random()
        }
        binding.submit.setOnClickListener {
            if (urlValidation(binding.et.text.toString())) {
                println("-------------------------")
                setImage(binding.et.text.toString())
                imageList.add(binding.et.text.toString())
            } else {

                showToast("Error")
            }
            binding.et.setText("")
        }
    }

    private fun random() {
        val random = Random
        val index = random.nextInt(imageList.size)
        setImage(imageList[index])
    }

    private fun setImage(index: String) {
        Glide.with(this).load(index).centerCrop().into(binding.image)
    }
}