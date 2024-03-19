package com.marcadolivro.model.dto

import java.math.BigDecimal

data class PutBookRequest (
    var name: String?,
    var price: BigDecimal?,
)
