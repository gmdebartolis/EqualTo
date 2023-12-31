package com.curso.android.app.practica.equalto.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.equalto.R

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_compararCadenas(){

        Espresso.onView(ViewMatchers.withId(R.id.inputUno)
        ).perform(ViewActions.typeText("Hola"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.inputDos)
        ).perform(ViewActions.typeText("Hola"))


        Espresso.onView(ViewMatchers.withId(R.id.botonComparar)
        ).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.textoResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas de texto son iguales")
            )
        )
    }
}