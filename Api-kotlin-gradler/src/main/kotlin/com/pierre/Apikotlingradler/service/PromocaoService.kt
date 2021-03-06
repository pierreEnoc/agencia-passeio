package com.pierre.Apikotlingradler.service

import com.pierre.Apikotlingradler.model.Promocao
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component


interface PromocaoService {
    fun create(promocao: Promocao)
    fun getById(id: Long): Promocao?
    fun delete(id: Long)
    fun update(id: Long, promocao:Promocao)
    fun searchByLocal(local: String): List<Promocao>
    //fun getAll(start: Int, size: Int): List<Promocao>
    fun findAll( pageable: Pageable): Page<Promocao>
    fun count(): Long
    fun getAllSortedByLocal(): List<Promocao>
}