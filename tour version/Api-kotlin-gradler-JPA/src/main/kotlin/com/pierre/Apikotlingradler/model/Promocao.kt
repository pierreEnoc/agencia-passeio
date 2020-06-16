package com.pierre.Apikotlingradler.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Promocao (
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long=1,
        val descricao: String="",
        val local :String="",
        val isAllInclusive: Boolean=false,
        val qtDias: Int=1,
        val preco: Double=0.0
) //{
    //constructor(){
    
    //}
//}