package com.example.employeedata2.model

import java.io.Serializable

data class EmployeeModel(val employeeName: String, val trained: Boolean, val certified: Boolean) : Serializable