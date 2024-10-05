package com.example.bai30rom

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai30rom.databinding.FragmentListBinding
import com.example.bai30rom.emtity.User
import com.example.bai30rom.userViewModel.UserViewModel

class ListFragment : Fragment() {
    private lateinit var user: User
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: FragmentListBinding
    private lateinit var customAdapter: CustomAdapter
    private var id:String?=null
    private var fistName:String?=null
    private var lastName:String?=null
    private var age:String?=null
    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        customAdapter= CustomAdapter()
        userViewModel=ViewModelProvider(this)[UserViewModel::class.java]



        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

            binding.flbtnadd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)

        }
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        addRecyclerView()

        usermodel()

        //truyen dulieu sang updeter
        data()


        //deleteAll
        binding.btnDeleteAll.setOnClickListener {
            userViewModel.deleteAll()
        }








    }




    private fun data() {
        customAdapter.clickItem={user->
            val action=ListFragmentDirections.actionListFragmentToUpdaterFragment(
                id = user.id.toInt(),
                lastname = "${user.lastName}",
                fistname = "${user.fistName}",
                age="${user.age}"
            )
            //chuyen man hinh
            findNavController().navigate(action)

        }
    }

    private fun usermodel() {
        userViewModel.realAllData.observe(viewLifecycleOwner,Observer{it

            customAdapter.setUaer(list = it as List<User>)
            Log.d("AAAAA","$it")


        })
    }

    private fun addRecyclerView() {

        binding.rclThongTin.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rclThongTin.adapter=customAdapter
    }

}