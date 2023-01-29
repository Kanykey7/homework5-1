package com.geektech.homework51

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.homework51.databinding.ActivityMainBinding
import com.geektech.homework51.presenter.Presenter
import com.geektech.homework51.view.View

class MainActivity : AppCompatActivity(), View {
    lateinit var binding: ActivityMainBinding
    var counter = 0
    val presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding){
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener{
                presenter.decrement()
            }
        }
    }

    override fun changeCount(count: Int) {
        binding.resultTv.text = count.toString()
    }

    override fun showToastInc() {
        Toast.makeText(this, "мы увеличили до 10", Toast.LENGTH_SHORT).show()
    }

    override fun showToastDec() {
        Toast.makeText(this, "мы уменьшили до -10",  Toast.LENGTH_SHORT).show()
    }

    override fun setColour() {
        binding.resultTv.setBackgroundColor(Color.GREEN)
    }
}