package com.hsb.mvvm_rooomdb.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hsb.mvvm_rooomdb.Model.userNode
import com.hsb.mvvm_rooomdb.ViewModel.MainViewModel
import com.hsb.mvvm_rooomdb.databinding.ActivityEditNodeBinding
import org.koin.android.ext.android.inject

class EditNode : AppCompatActivity() {
    lateinit var binding: ActivityEditNodeBinding
    private lateinit var viewModel: MainViewModel
    private val vmComponent: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vmComponent.readall()
        val bundle: Bundle? = intent.extras
        val id = bundle?.getInt("id")
        val fname = bundle?.getString("fname")
        val lname = bundle?.getString("lname")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        with(binding) {
            idtxt.text = id.toString()
            fnametxt.setText(fname.toString())
            lnametxt.setText(lname.toString())
            savebtn.setOnClickListener {
                viewModel.update_node(
                    userNode(
                        id.toString().toInt(),
                        fnametxt.text.toString().trim(),
                        lnametxt.text.toString().trim()
                    )
                )
                finish()
            }
        }


    }
}