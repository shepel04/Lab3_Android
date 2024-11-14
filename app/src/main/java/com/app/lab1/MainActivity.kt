package com.app.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = DogAdapter()
    private val imageIdList = listOf(
        R.drawable.beagle,
        R.drawable.corgy,
        R.drawable.dachshund,
        R.drawable.german_shepherd,
        R.drawable.golden_retriever,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 4) index = 0
                val dog = Dog(imageIdList[index], "Dog $index")
                adapter.addDog(dog)
                index++
            }
        }
    }
}
