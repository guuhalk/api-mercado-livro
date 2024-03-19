package com.marcadolivro.controllers

import com.marcadolivro.model.Book
import com.marcadolivro.model.Customer
import com.marcadolivro.model.dto.PostBookRequest
import com.marcadolivro.model.dto.PostCustomerRequest
import com.marcadolivro.model.dto.PutBookRequest
import com.marcadolivro.model.dto.PutCustomerRequest
import com.marcadolivro.model.enums.BookStatus
import com.marcadolivro.service.BookService
import com.marcadolivro.service.CustomerService
import com.marcadolivro.tools.toBook
import com.marcadolivro.tools.toCustomer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (
   val bookService: BookService,
   val customerService: CustomerService
) {

    @GetMapping
    fun findAllBooks(@RequestParam name: String?): List<Book>
            = bookService.findAllbooks(name)

    @GetMapping("/active")
    fun findAllBooksStatusActive(): List<Book>
            = bookService.findAllbooksStatusActive()

    @GetMapping("/{id}")
    fun findBookById(@PathVariable id: Int): Book
            = bookService.findBookById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody book: PostBookRequest){
        val customer = customerService.findCustomerById(book.customerId)
        bookService.createBook(book.toBook(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@PathVariable id: Int,@RequestBody book: PutBookRequest)
        = bookService.updateBook(book.toBook(bookService.findBookById(id)))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int)
            = bookService.deleteBook(id)

}