package com.marcadolivro.controllers

import com.marcadolivro.model.dto.request.PostCustomerRequest
import com.marcadolivro.model.dto.request.PutCustomerRequest
import com.marcadolivro.model.dto.response.CustomerResponse
import com.marcadolivro.service.CustomerService
import com.marcadolivro.tools.toCustomer
import com.marcadolivro.tools.toResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun findAllCustomer(@RequestParam name: String?): List<CustomerResponse>
        = customerService.findAllCustomers(name).map{it.toResponse()}

    @GetMapping("/{id}")
    fun findCustomerById(@PathVariable id: Int): CustomerResponse
        = customerService.findCustomerById(id).toResponse()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest)
        = customerService.createCustomer(customer.toCustomer())

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int,@RequestBody customer: PutCustomerRequest){
        val customerSaved = customerService.findCustomerById(id)
        customerService.updateCustomer(customer.toCustomer(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int)
        = customerService.deleteCustomer(id)

}