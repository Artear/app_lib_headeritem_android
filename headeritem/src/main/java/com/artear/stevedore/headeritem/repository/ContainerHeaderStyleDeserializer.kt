/*
 * Copyright 2019 Artear S.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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