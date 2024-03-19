package com.marcadolivro.tools

import com.marcadolivro.model.Customer
import com.marcadolivro.model.request.PostCustomerRequest
import com.marcadolivro.model.request.PutCustomerRequest

fun PostCustomerRequest.toCustomer():Customer{
    return Customer(name= this.name, email = this.email)
}

fun PutCustomerRequest.toCustomer(id: String):Customer{
    return Customer(id= id, name= this.name, email = this.email)
}