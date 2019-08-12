package com.artear.stevedore.headeritem

import com.artear.stevedore.headeritem.repository.ContainerHeader
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import timber.log.Timber


class ContainerHeaderTest {


    private lateinit var gson: Gson
    private lateinit var okContainerHeaderResponse: ResponseBody
    private lateinit var withoutTitleContainerHeaderResponse: ResponseBody

    @Before
    fun setUp() {

        Timber.plant(Mockito.mock(Timber.Tree::class.java))

        val loader = javaClass.classLoader!!
        val okContainerHeader = TestUtils().loadJSONFromAsset(loader, "header", "container_header_ok")
        val withoutTitleContainerHeader = TestUtils().loadJSONFromAsset(loader, "header", "container_header_without_title")

        val mediaType = MediaType.parse("application/json")

        okContainerHeaderResponse = ResponseBody.create(mediaType, okContainerHeader!!)
        withoutTitleContainerHeaderResponse = ResponseBody.create(mediaType, withoutTitleContainerHeader!!)

        gson = Gson()
    }

    @Test
    fun testBoxStyleComplete() {
        val containerHeader = gson.fromJson(okContainerHeaderResponse.string(), ContainerHeader::class.java)
        Assert.assertEquals("Esto es un Header", containerHeader.title)
    }

    @Test(expected = JsonSyntaxException::class)
    fun testBoxStyleWithoutWeight() {
        gson.fromJson(withoutTitleContainerHeaderResponse.string(), ContainerHeader::class.java)
    }

}