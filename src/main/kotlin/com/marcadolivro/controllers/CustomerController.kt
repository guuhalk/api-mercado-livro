package com.marcadolivro.controllers

import com.marcadolivro.model.Customer
import com.marcadolivro.model.dto.PostCustomerRequest
import com.marcadolivro.model.dto.PutCustomerRequest
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
    fun findCustomerById(@PathVariable id: Int): Customer
        = customerService.findCustomerById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest)
        = customerService.createCustomer(customer.toCustomer())

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int,@RequestBody customer: PutCustomerRequest )
        = customerService.updateCustomer(customer.toCustomer(id))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int)
        = customerService.deleteCustomer(id)

}