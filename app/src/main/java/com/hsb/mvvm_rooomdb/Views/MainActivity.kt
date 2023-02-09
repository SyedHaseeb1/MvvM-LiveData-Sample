package com.hsb.mvvm_rooomdb.Views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hsb.mvvm_rooomdb.Adapter.CustomAdapter
import com.hsb.mvvm_rooomdb.Model.userNode
import com.hsb.mvvm_rooomdb.ViewModel.MainViewModel
import com.hsb.mvvm_rooomdb.container.Component
import com.hsb.mvvm_rooomdb.databinding.ActivityMainBinding
import com.hsb.mvvm_rooomdb.demo.Car
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.inject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fname: String
    private lateinit var lname: String
    private lateinit var list: ArrayList<userNode>
    private lateinit var adapter: CustomAdapter
    private val vmComponent: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        load()
        //KOIN
//        koinFun()
        //KOIN


    }

    fun load() {
        with(binding) {
            recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
            list = ArrayList()
            adduserbtn.setOnClickListener {
                fname = fnametxt.text.toString().trim()
                lname = lnametxt.text.toString().trim()
                if (fname.isNotEmpty() && lname.isNotEmpty()) {
                    val user = userNode(0, fname, lname)
                    vmComponent.insert(user)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Data missing in the field/s",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            deletealltxt.setOnClickListener {
                delete_all()
            }
        }

        vmComponent.readall().observe(this, Observer {
            list.clear()
            for (item in it) {
                list.add(item)
            }
            adapter.update_adapter(list)
            binding.recyclerview.adapter = adapter
            Log.e("Observe", "$list")
        })
        adapter = CustomAdapter(list)
        adapter.deleteOnclick = {
            Toast.makeText(applicationContext, "deleted $it", Toast.LENGTH_SHORT).show()
            delete_node(it)
        }
        adapter.editOnClick = {
            val intent = Intent(this@MainActivity, EditNode::class.java)
            intent.apply {
                putExtra("id", it.id.toString().toInt())
                putExtra("fname", it.firstname)
                putExtra("lname", it.lastname)
            }
            startActivity(intent)
        }
        binding.recyclerview.adapter = adapter

    }

    fun delete_all() {
        Toast.makeText(applicationContext, "List cleared", Toast.LENGTH_SHORT).show()
        vmComponent.delete_all()
    }

    fun delete_node(node: userNode) {
        vmComponent.delete_node(node)
    }

    fun koinFun() {
//        val component = Component()
//        component.car.getCar()
//        component.main.getDemo()
//        component.dbComponent.readall()
        //vmComponent.readall()

    }
}