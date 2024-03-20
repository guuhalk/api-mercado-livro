package com.marcadolivro.controllers

import com.marcadolivro.model.dto.request.PostBookRequest
import com.marcadolivro.model.dto.request.PutBookRequest
import com.marcadolivro.model.dto.response.BookResponse
import com.marcadolivro.service.BookService
import com.marcadolivro.service.CustomerService
import com.marcadolivro.tools.toBook
import com.marcadolivro.tools.toResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (
   val bookService: BookService,
   val customerService: CustomerService
) {

    @GetMapping
    fun findAllBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse>
            = bookService.findAllbooks(pageable).map { it.toResponse() }

    @GetMapping("/active")
    fun findAllBooksStatusActive(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse>
            = bookService.findAllbooksStatusActive(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun findBookById(@PathVariable id: Int): BookResponse
            = bookService.findBookById(id).toResponse()

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