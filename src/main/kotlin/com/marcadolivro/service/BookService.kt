package com.marcadolivro.service

import com.marcadolivro.model.Book
import com.marcadolivro.model.Customer
import com.marcadolivro.model.enums.BookStatus
import com.marcadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun findAllbooks(pageable: Pageable): Page<Book> {
        return bookRepository.findAll(pageable)
    }

    fun findAllbooksStatusActive(pageable: Pageable): Page<Book> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
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

    fun deleteByCustumer(customer: Customer) {
        val books = bookRepository.findByCustomer(customer)
        for(book in books){
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }
}
