package com.hsb.mvvm_rooomdb.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hsb.mvvm_rooomdb.Model.userNode
import com.hsb.mvvm_rooomdb.R
import com.hsb.mvvm_rooomdb.databinding.RecyclerviewLayoutBinding


class CustomAdapter(private var mList: List<userNode>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var deleteOnclick: ((userNode) -> Unit)? = null
    var editOnClick: ((userNode) -> Unit)? = null
    private lateinit var binding: RecyclerviewLayoutBinding
    private var edit_c = 0

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_layout, parent, false)
        binding = RecyclerviewLayoutBinding.bind(view)
        return ViewHolder(binding.root)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ItemsViewModel = mList[position]
        with(binding) {
            with(ItemsViewModel) {
                idtxt.text = "ID:\t$id"
                fnametxt.apply {
                    isEnabled = false
                    setText("F.N:\t$firstname")
                }
                lnametxt.apply {
                    isEnabled = false
                    setText("L.N:\t$lastname")
                }
            }
            deleteimg.setOnClickListener {
                deleteOnclick?.invoke(ItemsViewModel)
                Log.e("Node to delete", "${ItemsViewModel.firstname} ")
            }
            editimg.setBackgroundResource(android.R.drawable.ic_menu_edit)
            editimg.setOnClickListener {
                editOnClick?.invoke(ItemsViewModel)
            }
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun update_adapter(node: List<userNode>) {
        Log.e("Observe_adapter", "$node")
        this.mList = node
        notifyDataSetChanged()
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        var idtxt: TextView = itemView.findViewById(R.id.idtxt)
//        var fnametxt: TextView = itemView.findViewById(R.id.fnametxt)
//        var lnametxt: TextView = itemView.findViewById(R.id.lnametxt)
//        var deleteimg: ImageView = itemView.findViewById(R.id.deleteimg)
//        var editimg: ImageView = itemView.findViewById(R.id.editimg)

    }
}