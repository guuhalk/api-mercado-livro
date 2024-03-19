package com.marcadolivro.repository

import com.marcadolivro.model.Book
import com.marcadolivro.model.enums.BookStatus
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int> {

    fun findByNameContaining(name: String) : List<Book>

    fun findByStatus(status: BookStatus) : List<Book>
}
