package com.marcadolivro.tools

import com.marcadolivro.model.Book
import com.marcadolivro.model.Customer
import com.marcadolivro.model.dto.request.PostBookRequest
import com.marcadolivro.model.dto.request.PostCustomerRequest
import com.marcadolivro.model.dto.request.PutBookRequest
import com.marcadolivro.model.dto.request.PutCustomerRequest
import com.marcadolivro.model.dto.response.BookResponse
import com.marcadolivro.model.dto.response.CustomerResponse
import com.marcadolivro.model.enums.BookStatus
import com.marcadolivro.model.enums.CustomerStatus

fun PostCustomerRequest.toCustomer():Customer{
    return Customer(name= this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomer(previousValue: Customer):Customer{
    return Customer(
        id= previousValue.id,
        name= this.name,
        email = this.email,
        status = previousValue.status
    )
}

fun PostBookRequest.toBook(customer: Customer):Book{
    return Book(name= this.name, price = this.price, status = BookStatus.ATIVO, customer = customer)
}

fun PutBookRequest.toBook(previousValue: Book):Book{
    return Book(
        id= previousValue.id,
        name= this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer

    )
}

fun Customer.toResponse(): CustomerResponse{
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status,
    )
}

fun Book.toResponse(): BookResponse{
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer= this.customer,
        status = this.status,
    )
}

