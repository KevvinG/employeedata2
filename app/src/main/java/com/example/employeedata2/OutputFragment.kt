package com.example.employeedata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.employeedata2.databinding.FragmentOutputBinding
import com.example.employeedata2.model.EmployeeModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOutputBinding.inflate(inflater, container, false)
        //Getting data from input
        val empData = arguments?.getSerializable("data") as EmployeeModel
        //Converting bool to string
        val trained = if (empData.trained) {
            "Is Trained"
        } else {
            "Is not Trained"
        }
        val certified = if (empData.certified) {
            "Is Certified"
        } else {
            "Is not Certified"
        }

        binding.apply {
            txtName.text = empData.employeeName + "\n"
            txtTrained.text = empData.employeeName + " " + trained + "\n"
            txtCertified.text = empData.employeeName + " " + certified + "\n"
            btnBack.setOnClickListener{
                findNavController().navigate(R.id.action_output_to_input)
            }
        }

        return(binding.root)
    }

}