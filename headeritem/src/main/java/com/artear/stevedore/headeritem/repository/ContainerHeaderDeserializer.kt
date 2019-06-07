package com.artear.stevedore.headeritem.repository

import com.artear.stevedore.stevedoreitems.repository.getModelObject
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ContainerHeaderDeserializer : JsonDeserializer<ContainerHeader> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): ContainerHeader {

        val title = json.asJsonObject.get("title").asString
        val style = json.getModelObject("style", context, ContainerHeaderStyle::class.java)

        return ContainerHeader(title, style)
    }

}
