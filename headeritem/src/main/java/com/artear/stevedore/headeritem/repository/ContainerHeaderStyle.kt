package com.artear.stevedore.headeritem.repository

import com.artear.stevedore.stevedoreitems.presentation.model.ArtearStyle
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleBackground
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleMargin
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleRound
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleText
import com.google.gson.annotations.JsonAdapter

@JsonAdapter(ContainerHeaderStyleDeserializer::class)
class ContainerHeaderStyle(
    val background: StyleBackground?,
    var title: StyleText?,
    var rounded: StyleRound?,
    var margin: StyleMargin
) : ArtearStyle()