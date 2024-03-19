package com.marcadolivro.service

import com.marcadolivro.model.Book
import com.marcadolivro.model.enums.BookStatus
import com.marcadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun findAllbooks(name: String?): List<Book> {
        name?.let {
            return bookRepository.findByNameContaining(name)
        }
        return bookRepository.findAll()
    }

    fun findAllbooksStatusActive(): List<Book> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }
    fun findBookById(id: Int): Book {
        return bookRepository.findById(id).orElseThrow()
    }

    fun createBook(book: Book){
        bookRepository.save(book)
    }

    fun updateBook(book: Book){
        if(!bookRepository.existsById(book.id!!))
            throw Exception()

        bookRepository.save(book)
    }

    fun deleteBook(id: Int){
        val book = bookRepository.findById(id).get()
        book.status = BookStatus.CANCELADO
        bookRepository.save(book)
    }
}
