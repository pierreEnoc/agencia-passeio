package com.pierre.Apikotlingradler.model

import javax.persistence.Entity

//@Entity
data class Promocao (
        
        val id: Long=1,
        val descricao: String="",
        val local :String="",
        val isAllInclusive: Boolean=false,
        val qtDias: Int=1,
        val preco: Double=0.0
)