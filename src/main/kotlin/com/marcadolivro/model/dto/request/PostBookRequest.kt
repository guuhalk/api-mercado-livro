package com.marcadolivro.model.dto.request

import com.fasterxml.jackson.annotation.JsonAlias
import com.marcadolivro.model.enums.BookStatus
import java.math.BigDecimal

data class PostBookRequest (

    var name: String,
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int

)
