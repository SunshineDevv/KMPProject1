package com.example.kmpproject1.data.mappers

import com.example.kmpproject1.data.model.PersonEntity
import com.example.kmpproject1.presentation.model.PersonUI

fun PersonEntity.toUI(): PersonUI {
    return PersonUI(
        id = this.id,
        name = this.name,
        result = this.result
    )
}

fun PersonUI.toEntity(): PersonEntity {
    return PersonEntity(
        id = this.id ?: 0,
        name = this.name,
        result = this.result
    )
}

fun List<PersonEntity>.toUI(): List<PersonUI> = this.map { it.toUI() }