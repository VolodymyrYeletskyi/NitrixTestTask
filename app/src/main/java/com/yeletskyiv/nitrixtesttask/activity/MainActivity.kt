package com.yeletskyiv.nitrixtesttask.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeletskyiv.nitrixtesttask.R
import com.yeletskyiv.nitrixtesttask.recyclerview.DrinkAdapter
import com.yeletskyiv.nitrixtesttask.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private val drinkAdapter by lazy { DrinkAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModels()

        recycler_view.adapter = drinkAdapter
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        add_button.setOnClickListener {
            mainViewModel.getRandomDrink()
        }
        remove_button.setOnClickListener {
            drinkAdapter.removeDrink {
                Toast.makeText(this, getString(R.string.empty_list), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initViewModels() {
        mainViewModel.randomDrinkLiveData.observe(this, {
            drinkAdapter.addDrink(it)
        })
    }
}