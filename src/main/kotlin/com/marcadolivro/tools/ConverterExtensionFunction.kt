package com.marcadolivro.tools

import com.marcadolivro.model.Customer
import com.marcadolivro.model.dto.PostCustomerRequest
import com.marcadolivro.model.dto.PutCustomerRequest

fun PostCustomerRequest.toCustomer():Customer{
    return Customer(name= this.name, email = this.email)
}

fun PutCustomerRequest.toCustomer(id: Int):Customer{
    return Customer(id= id, name= this.name, email = this.email)
}