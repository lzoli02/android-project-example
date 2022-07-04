package com.zoltanlorinczi.project_retrofit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zoltanlorinczi.project_retorfit.R
import com.zoltanlorinczi.project_retorfit.databinding.FragmentListBinding
import com.zoltanlorinczi.project_retrofit.adapter.ListAdapter
import com.zoltanlorinczi.project_retrofit.api.model.ListItem

/**
 * Author:  Zoltan Lorinczi
 * Date:    12/2/2021
 */
class ListFragment : Fragment() {

    companion object {
        private val TAG: String? = ListFragment::class.java.canonicalName
    }

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        FragmentListBinding.inflate(inflater).apply {
            binding = this
            initViews()
        }.root

    private fun initViews() {
        val recyclerView = binding.recyclerView
        val adapter = ListAdapter(getListItems())

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
    }

    private fun getListItems() = arrayListOf(
        ListItem(R.drawable.ic_launcher_foreground, "Item 1"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 2"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 3"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 4"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 5"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 6"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 7"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 8"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 9"),
        ListItem(R.drawable.ic_launcher_foreground, "Item 10")
    )
}