package com.zoltanlorinczi.project_retrofit.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zoltanlorinczi.project_retorfit.R
import com.zoltanlorinczi.project_retrofit.adapter.MarketDataAdapter
import com.zoltanlorinczi.project_retrofit.api.MarketPlaceRepository
import com.zoltanlorinczi.project_retrofit.api.model.ProductResponse
import com.zoltanlorinczi.project_retrofit.viewmodel.ListViewModel
import com.zoltanlorinczi.project_retrofit.viewmodel.ListViewModelFactory

/**
 * Author:  Zoltan Lorinczi
 * Date:    12/2/2021
 */
class ListFragment : Fragment(R.layout.fragment_list), MarketDataAdapter.OnItemClickListener, MarketDataAdapter.OnItemLongClickListener {

    companion object {
        private val TAG: String? = ListFragment::class.java.canonicalName
    }

    private var listViewModel: ListViewModel? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MarketDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = ListViewModelFactory(MarketPlaceRepository())
        listViewModel = ViewModelProvider(this, factory)[ListViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_list, container, false).apply {
            initViews(this)
        }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view)
        adapter = MarketDataAdapter(ArrayList(), this, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.setHasFixedSize(true)


        listViewModel?.products?.observe(viewLifecycleOwner) {
            adapter.updateData(listViewModel?.products?.value as ArrayList<ProductResponse>)
        }
    }

    override fun onItemClick(position: Int) {
        Log.d(TAG, "onItemClick called on position: $position")
    }

    override fun onItemLongClick(position: Int) {
        Log.d(TAG, "onItemLongClick called on position: $position")
    }
}