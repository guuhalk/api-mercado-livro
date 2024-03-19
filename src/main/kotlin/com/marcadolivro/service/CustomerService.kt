package com.marcadolivro.service

import com.marcadolivro.model.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<Customer>()

    fun findAllCustomer(name: String?): List<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name,true) }
        }
        return customers
    }

    fun findCustomerById(id: String): Customer {
        return customers.filter { it.id == id }.first()
    }

    fun createCustomer(customer: Customer): MutableList<Customer> {
        val id = if (customers.isEmpty()) 1 else { customers.last().id!!.toInt() + 1 }.toString()
        customer.id = id
        customers.add(customer)
        return customers
    }

    fun updateCustomer(customer: Customer){
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: String){
        customers.removeIf{it.id == id}
    }
}