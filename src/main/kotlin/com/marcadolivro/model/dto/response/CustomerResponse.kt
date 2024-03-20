package com.marcadolivro.model.dto.response

import com.marcadolivro.model.enums.CustomerStatus

data class CustomerResponse (

    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus

)