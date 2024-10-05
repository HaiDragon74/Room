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
import com.example.bai30rom.databinding.FragmentAddBinding
import com.example.bai30rom.emtity.User
import com.example.bai30rom.userViewModel.UserViewModel

@Suppress("UNREACHABLE_CODE")
class AddFragment : Fragment() {
    private lateinit var user: User
    private lateinit var binding: FragmentAddBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Tạo hoặc nhận một ViewModel liên quan đến Activity hoặc Fragment hiện tại.
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //insert database
        binding.btnAdd.setOnClickListener {
            insertdatabasedata()

        }
    }
    private fun insertdatabasedata() {

        val fistName = binding.editFistName.text.toString()
        val lastName = binding.editLastName.text.toString()
        val age = binding.editAge.text.toString()

        if (fistName.isNotEmpty() && lastName.isNotEmpty() && age.isNotEmpty()) {
            val user = User(fistName =  fistName, lastName =  lastName, age =  age)
            // Thêm đối tượng User vào ViewModel.
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Them thanh cong", Toast.LENGTH_SHORT).show()
            // Điều hướng người dùng đến một Fragment khác.
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        } else
            Toast.makeText(requireContext(), "Them that bai", Toast.LENGTH_SHORT).show()
    }
}