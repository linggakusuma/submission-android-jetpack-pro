package com.example.submissionandroidjetpack

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.submissionandroidjetpack.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InstrumentationTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovie() {
        Espresso.onView(withId(R.id.recyclerViewMovie)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withText("Movie")).perform(click())
        Espresso.onView(withId(R.id.recyclerViewMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(withId(R.id.textDetailTitle)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textDetailDate)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textDetailOverview)).check(matches(isDisplayed()))

    }

    @Test
    fun loadTv() {
        Espresso.onView(withText("Tv Show")).perform(click())
        Espresso.onView(withId(R.id.recyclerViewTv)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTv() {
        Espresso.onView(withText("Tv Show")).perform(click())
        Espresso.onView(withId(R.id.recyclerViewTv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(withId(R.id.textDetailTitle)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textDetailDate)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textDetailOverview)).check(matches(isDisplayed()))
    }
}