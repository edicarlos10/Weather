package com.example.domain

import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

abstract class BaseTest {
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        initialize()
    }

    @After
    fun shutdown() {
        unmockkAll()
        finish()
    }

    open fun initialize() {}

    open fun finish() {}

    val mockErrorResponse = Throwable("Error response")
    val appid = BuildConfig.API_KEY
}