package com.marcadolivro.model.dto.response

import com.marcadolivro.model.Customer
import com.marcadolivro.model.enums.BookStatus
import java.math.BigDecimal

data class BookResponse (

    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: Customer? = null,
    var status: BookStatus? = null
)