package com.marcadolivro.service

import com.marcadolivro.model.Customer
import com.marcadolivro.model.enums.CustomerStatus
import com.marcadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun findAllCustomers(name: String?): List<Customer> {
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
        var customer = findCustomerById(id)
        bookService.deleteByCustumer(customer)
        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }
}