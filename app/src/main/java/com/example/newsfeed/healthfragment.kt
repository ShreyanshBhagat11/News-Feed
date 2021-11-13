package com.example.newsfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.ApiUtilites.apiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class healthfragment : Fragment() {
    var api = "31126acddf1443e5b8314f8e76c7a0c7"
    var modelClassArrayList: ArrayList<ModelClass>? = null
    var adapter: Adapter? = null
    var country = "in"
    private var recyclerViewofhealth: RecyclerView? = null
    private val categgory = "health"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.healthfragment, null)
        recyclerViewofhealth = v.findViewById(R.id.recylerviewofhealth)
        modelClassArrayList = ArrayList()
        recyclerViewofhealth?.setLayoutManager(LinearLayoutManager(context))
        adapter = Adapter(requireContext(), modelClassArrayList!!)
        recyclerViewofhealth?.setAdapter(adapter)
        findNews()
        return v
    }

    private fun findNews() {
        apiInterface.getCategoryNews(country, categgory, 100, api)!!
            .enqueue(object : Callback<mainNews> {
                override fun onResponse(call: Call<mainNews>, response: Response<mainNews>) {
                    if (response.isSuccessful) {
                        modelClassArrayList!!.addAll(response.body()!!.articles)
                        adapter!!.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<mainNews>, t: Throwable) {}
            })
    }
}