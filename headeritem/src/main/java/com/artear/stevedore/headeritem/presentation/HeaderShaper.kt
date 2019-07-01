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
package com.artear.stevedore.headeritem.presentation

import com.artear.domain.coroutine.DataShaper
import com.artear.stevedore.headeritem.repository.ContainerHeader
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearItem
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearItemDecoration


class HeaderShaper : DataShaper<ContainerHeader, ArtearItem> {

    override suspend fun transform(input: ContainerHeader): ArtearItem {

        val data = HeaderData(
                input.title,
                input.style)

        return ArtearItem(data, ArtearItemDecoration())
    }


}
