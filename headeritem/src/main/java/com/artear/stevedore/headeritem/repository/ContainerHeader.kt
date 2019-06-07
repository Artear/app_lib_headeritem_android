package com.artear.stevedore.headeritem.repository

import com.google.gson.annotations.JsonAdapter

@JsonAdapter(ContainerHeaderDeserializer::class)
data class ContainerHeader(
    val title: String,
    val style: ContainerHeaderStyle
)