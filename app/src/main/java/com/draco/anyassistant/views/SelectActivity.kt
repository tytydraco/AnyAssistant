package com.draco.anyassistant.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.draco.anyassistant.R
import com.draco.anyassistant.recyclers.RecyclerEdgeEffectFactory
import com.draco.anyassistant.recyclers.SelectRecyclerAdapter
import com.draco.anyassistant.viewmodels.SelectActivityViewModel

class SelectActivity : AppCompatActivity() {
    private val viewModel: SelectActivityViewModel by viewModels()
    private lateinit var recycler: RecyclerView
    private lateinit var recyclerAdapter: SelectRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        recycler = findViewById(R.id.recycler)

        viewModel.appList.observe(this) {
            recyclerAdapter.appList = viewModel.appList.value!!
            recyclerAdapter.notifyDataSetChanged()
        }

        recyclerAdapter = SelectRecyclerAdapter(
            this,
            emptyList()
        ).apply {
            setHasStableIds(true)
        }

        with (findViewById<RecyclerView>(R.id.recycler)) {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
            edgeEffectFactory = RecyclerEdgeEffectFactory()
            setItemViewCacheSize(1000)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }
}