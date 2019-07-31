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

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.artear.stevedore.headeritem.repository.ContainerHeaderStyle
import com.artear.stevedore.stevedoreitems.presentation.contract.ArtearViewHolder
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearItemDecoration
import kotlinx.android.synthetic.main.header_view_holder.view.*


class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        ArtearViewHolder<HeaderData<ContainerHeaderStyle>> {

    override fun bind(model: HeaderData<ContainerHeaderStyle>, artearItemDecoration: ArtearItemDecoration) {
        itemView.apply {
            headerTitle.text = model.title
            model.style.background?.color?.let {
                rootLayout.setBackgroundColor(Color.parseColor(it.light))
            }
            model.style.title?.underline?.color?.let {
                headerTitle.underlineEnabled = true
                headerTitle.underLineColor = Color.parseColor(it.light)
                headerTitle.underlineWidth = 8f
                headerTitle.underlineSeparation = -2f

            }
            model.style.title?.color?.let {
                headerTitle.setTextColor(Color.parseColor(it.light))
            }
        }
    }

}
