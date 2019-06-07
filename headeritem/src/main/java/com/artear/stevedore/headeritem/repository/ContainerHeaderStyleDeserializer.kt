package com.artear.stevedore.headeritem.repository

import com.artear.stevedore.stevedoreitems.repository.getModelObject
import com.artear.stevedore.stevedoreitems.repository.getSafeModelObject
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleBackground
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleMargin
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleRound
import com.artear.stevedore.stevedoreitems.repository.model.style.StyleText
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type


class ContainerHeaderStyleDeserializer : JsonDeserializer<ContainerHeaderStyle> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): ContainerHeaderStyle {

        val background = json.getSafeModelObject("background", context, StyleBackground::class.java)
        val title = json.getSafeModelObject("title", context, StyleText::class.java)
        val rounded = json.getSafeModelObject("rounded", context, StyleRound::class.java)
        val margin = json.getModelObject("margin", context, StyleMargin::class.java)

        return ContainerHeaderStyle(background, title, rounded, margin)
    }

}