package com.marcadolivro.controllers

import com.marcadolivro.model.Customer
import com.marcadolivro.model.request.PostCustomerRequest
import com.marcadolivro.model.request.PutCustomerRequest
import com.marcadolivro.service.CustomerService
import com.marcadolivro.tools.toCustomer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun findAllCustomer(@RequestParam name: String?): List<Customer>
        = customerService.findAllCustomer(name)

    @GetMapping("/{id}")
    fun findCustomerById(@PathVariable id: String): Customer
        = customerService.findCustomerById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest): MutableList<Customer>
        = customerService.createCustomer(customer.toCustomer())

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String,@RequestBody customer: PutCustomerRequest )
        = customerService.updateCustomer(customer.toCustomer(id))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String)
        = customerService.deleteCustomer(id)

}