package com.marcadolivro.repository

import com.marcadolivro.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Int> {

    fun findByNameContaining(name: String) : List<Customer>

}