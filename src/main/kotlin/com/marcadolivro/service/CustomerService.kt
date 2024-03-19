package com.marcadolivro.service

import com.marcadolivro.model.Customer
import com.marcadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    fun findAllCustomer(name: String?): List<Customer> {
        name?.let {
            return customerRepository.findByNameContaining(name)
        }
        return customerRepository.findAll()
    }

    fun findCustomerById(id: Int): Customer {
        return customerRepository.findById(id).get()
    }

    fun createCustomer(customer: Customer){
        customerRepository.save(customer)
    }

    fun updateCustomer(customer: Customer){
        if(!customerRepository.existsById(customer.id!!))
            throw Exception()

        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int){
        if(!customerRepository.existsById(id))
            throw Exception()

        customerRepository.deleteById(id)
    }
}