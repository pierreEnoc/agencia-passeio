package com.pierre.Apikotlingradler.repository

import com.pierre.Apikotlingradler.model.Promocao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PromocaoRepository: CrudRepository<Promocao, Long> {

}