package com.example.thooughtctl_app

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thooughtctl_app.RequestResponse.ImgurResponse
import com.example.thooughtctl_app.adpater.GalleryAdapter
import com.example.thooughtctl_app.network.RetrofitClient
import com.example.thooughtctl_app.utils.Constants.Companion.clientId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var SearchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GalleryAdapter
    private lateinit var searchCountText: TextView
    private lateinit var convertViewText: TextView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var FLAG : Boolean = true
    var pd : ProgressDialog? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrBlank() && newText.length >= 3) {
                    performSearch(newText)
                }
                return true
            }
        })

        convertViewText.setOnClickListener{
            if(FLAG){
                layoutManager = LinearLayoutManager(this)
                FLAG = false
            }else{
                layoutManager = GridLayoutManager(this, 2)
                FLAG = true
            }

            recyclerView.layoutManager = layoutManager
            adapter.notifyDataSetChanged()
        }

    }

    private fun performSearch(query: String) {
        Log.e("Search_query", query)
        val authorizationHeader = "Client-ID $clientId"
        val call = RetrofitClient.apiService.searchGallery(authorizationHeader, query)
        pd?.setTitle("Please wait...")
        pd?.setCancelable(false)
        pd?.show()
        call.enqueue(object : Callback<ImgurResponse> {
            override fun onResponse(call: Call<ImgurResponse>, response: Response<ImgurResponse>) {
                pd?.dismiss()
                if (response.isSuccessful) {
                    Log.e("Retrofit_Query_Response", response.message())
                    searchCountText.text = "Search Result found: "+response.body()!!.data.size
                    adapter = GalleryAdapter(applicationContext, response.body()!!.data)
                    recyclerView.adapter = adapter

                } else {
                    Log.e("Retrofit__Query_ResponseError", response.message())
                }
            }

            override fun onFailure(call: Call<ImgurResponse>, t: Throwable) {
                pd?.dismiss()
                Log.e("Retrofit__Query_Failure>>", "Something went wrong>>"+t.message)
            }
        })
    }

    private fun initView() {
        SearchView = findViewById(R.id.searchView)
        recyclerView = findViewById(R.id.recyclerView)
        searchCountText = findViewById(R.id.searchResultsTextView)
        convertViewText = findViewById(R.id.id_convert_layout_txt)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val authorizationHeader = "Client-ID $clientId"
        val call = RetrofitClient.apiService.getHotViralImages(authorizationHeader)

        pd = ProgressDialog(this@MainActivity)
        pd?.setTitle("Please wait...")
        pd?.setCancelable(false)
        pd?.show()

        call.enqueue(object : Callback<ImgurResponse> {
            override fun onResponse(call: Call<ImgurResponse>, response: Response<ImgurResponse>) {
                pd?.dismiss()
                if (response.isSuccessful) {
                    val imgurResponse = response.body()
                    // Process the imgurResponse data
                    Log.e("Retrofit_Response", response.message())
                    searchCountText.text = "Result found: "+response.body()!!.data.size
                    adapter = GalleryAdapter(applicationContext, response.body()!!.data)
                    recyclerView.adapter = adapter

                } else {
                    Log.e("Retrofit_ResponseError", response.message())
                }
            }

            override fun onFailure(call: Call<ImgurResponse>, t: Throwable) {
                pd?.dismiss()
                Log.e("Retrofit_Failure>>", "Something went wrong>>"+t.message)
            }
        })

    }
}