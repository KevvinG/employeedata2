package com.example.employeedata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.employeedata2.databinding.FragmentInputBinding
import com.example.employeedata2.model.EmployeeModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)

        binding.btnSubmit.setOnClickListener{
            submit()
        }

        return binding.root
    }

    private fun submit() {
        val name = binding.inpName.text.toString()
        val trained = binding.chkTrained.isChecked
        val certified = binding.chkCertified.isChecked

        send(EmployeeModel(name,trained,certified))
    }

    private fun send(model: EmployeeModel) {
        if (model.employeeName == "" || model.employeeName == "Name") {
            Toast.makeText(context, "Please enter a name", Toast.LENGTH_LONG).show()
        } else {
            val arguments = Bundle()
            arguments.putSerializable("data", model)
            findNavController().navigate(R.id.action_input_to_output, arguments)
        }//else
    }//send
}