package com.kenant42.kotlincardviewrecyclerviewstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kenant42.kotlincardviewrecyclerviewstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryList: ArrayList<Country>
    private lateinit var adapter: RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

        val c1 = Country(1, "Türkiye")
        val c2 = Country(1, "Bulgaristan")
        val c3 = Country(3, "Macaristan")
        val c4 = Country(4, "Hırvatistan")
        val c5 = Country(5, "Sırbistan")
        val c6 = Country(6, "Letonya")
        val c7 = Country(7, "Estonya")

        countryList = ArrayList<Country>()
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c1)
        countryList.add(c2)
        countryList.add(c3)
        countryList.add(c4)
        countryList.add(c5)
        countryList.add(c6)
        countryList.add(c7)
        countryList.add(c7)
        countryList.add(c7)
        countryList.add(c7)
        countryList.add(c7)
        countryList.add(c7)
        countryList.add(c7)

        adapter = RVAdapter(this, countryList)
        binding.rv.adapter = adapter


        binding.materialToolbar.title = "Toolbar Menu"
        setSupportActionBar(binding.materialToolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val item = menu?.findItem(R.id.action_search)
        val searchView = item!!.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.action_search -> {
                binding.materialToolbar.title = ""
                Toast.makeText(applicationContext, "SEARCH CLICKED ", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.action_info -> {
                Toast.makeText(applicationContext, "INFO CLICKED ", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.action_add -> {
                Toast.makeText(applicationContext, "ADD CLICKED ", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.action_settings -> {
                Toast.makeText(applicationContext, "SETTINGS CLICKED ", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.action_exit -> {
                Toast.makeText(applicationContext, "EXIT CLICKED ", Toast.LENGTH_LONG).show()
                return true
            }


            else -> return super.onOptionsItemSelected(item)
        }


    }

    override fun onQueryTextChange(newText: String?): Boolean {

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }
}


