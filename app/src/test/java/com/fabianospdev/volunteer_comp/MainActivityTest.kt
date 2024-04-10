package com.fabianospdev.volunteer_comp

import androidx.navigation.NavHostController
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class MainActivityTest {
    private lateinit var mainActivity: MainActivity
    private lateinit var navController: NavHostController

    @Before
    fun setUp() {
        mainActivity = MainActivity()
        navController = mock(NavHostController::class.java)
        // mainActivity.setNavController(navController)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun onCreate() {

    }

}