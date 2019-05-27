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
package com.artear.headeritem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artear.cover.coveritem.presentation.contract.ArtearViewHolder
import com.artear.cover.coveritem.presentation.contract.ItemAdapter
import com.artear.cover.coveritem.presentation.model.ArtearItem
import com.artear.cover.coveritem.presentation.model.ArtearSection


class HeaderItemAdapter : ItemAdapter<HeaderData<*>> {

    override fun isForViewType(item: ArtearItem): Boolean {
        return item.model is HeaderData
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.header_view_holder, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolderBase(holder: ArtearViewHolder<HeaderData<*>>,
                                      model: HeaderData<*>, artearSection: ArtearSection) {
        holder.bind(model, artearSection)
    }
}