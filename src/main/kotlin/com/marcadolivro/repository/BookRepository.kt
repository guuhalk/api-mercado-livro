package com.marcadolivro.repository

import com.marcadolivro.model.Book
import com.marcadolivro.model.Customer
import com.marcadolivro.model.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int> {

    fun findByStatus(status: BookStatus, pageable: Pageable) : Page<Book>
    fun findByCustomer(customer: Customer): List<Book>
}
