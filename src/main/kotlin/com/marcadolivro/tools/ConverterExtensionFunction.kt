package com.marcadolivro.tools

import com.marcadolivro.model.Book
import com.marcadolivro.model.Customer
import com.marcadolivro.model.dto.PostBookRequest
import com.marcadolivro.model.dto.PostCustomerRequest
import com.marcadolivro.model.dto.PutBookRequest
import com.marcadolivro.model.dto.PutCustomerRequest
import com.marcadolivro.model.enums.BookStatus

fun PostCustomerRequest.toCustomer():Customer{
    return Customer(name= this.name, email = this.email)
}

fun PostBookRequest.toBook(customer: Customer):Book{
    return Book(name= this.name, price = this.price, status = BookStatus.ATIVO, customer = customer)
}

fun PutCustomerRequest.toCustomer(id: Int):Customer{
    return Customer(id= id, name= this.name, email = this.email)
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

