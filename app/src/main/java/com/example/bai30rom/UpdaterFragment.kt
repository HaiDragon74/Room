package com.example.bai30rom

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bai30rom.databinding.FragmentUpdaterBinding
import com.example.bai30rom.emtity.User
import com.example.bai30rom.userViewModel.UserViewModel

class UpdaterFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: FragmentUpdaterBinding
    private var setid:String?=null
    private var setlastName :String?=null
    private var setfistName :String?=null
    private var setage :String?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        userViewModel= ViewModelProvider(this)[UserViewModel::class.java]
        // Inflate the layout for this fragment
        binding =FragmentUpdaterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //nhan du lieu tu listFrament
         data()
        //updater
        binding.btnAddUpdater.setOnClickListener {
            updaterdata()
        }
        //delete
        binding.btnDelete.setOnClickListener {
            dialogDelete()
        }


    }
    private fun dialogDelete() {
        val data=UpdaterFragmentArgs.fromBundle(arguments!!) //lay dulieu
        setid= data.id.toString()
        val id=setid?.toInt()
        setlastName=data.lastname
        setfistName=data.fistname
        setage=data.age
        val user=User(id!!,setfistName!!,setlastName!!,setage!!)
        val dialog= AlertDialog.Builder(requireContext())
        dialog.apply {
            setTitle("DLETE")
            setMessage("ban co muon xoa khong")
            setNegativeButton("co") { dialogInterface: DialogInterface, i: Int ->

                userViewModel.deleteUser(user)
                Toast.makeText(requireContext(),"xoa thanh cong roi em", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updaterFragment_to_listFragment)

            }
            setPositiveButton("khong"){ dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }

        }.show()
    }

    private fun updaterdata() {
        val id=setid?.toInt()
        val editFistNameUpdater=binding.editFistNameUpdater.text.toString()
        val editLastNameUpdater=binding.editLastNameUpdater.text.toString()
        val edtAge=binding.editAgeUpdater.text.toString()
        if (editFistNameUpdater.isNotEmpty()&&editLastNameUpdater.isNotEmpty()&&edtAge.isNotEmpty())
        {
            val updaterUser=User(id!!,editFistNameUpdater,editLastNameUpdater,edtAge)
            userViewModel.updaterUser(updaterUser)

            findNavController().navigate(R.id.action_updaterFragment_to_listFragment)
        }

    }


    private fun data() {

        val data=UpdaterFragmentArgs.fromBundle(arguments!!)

         setid= data.id.toString()
         setlastName=data.lastname
         setfistName=data.fistname
         setage=data.age

        binding.editFistNameUpdater.setText(setfistName)
        binding.editLastNameUpdater.setText(setlastName)
        binding.editAgeUpdater.setText(setage)


    }
}