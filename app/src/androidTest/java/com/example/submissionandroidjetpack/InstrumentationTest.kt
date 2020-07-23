package com.example.submissionandroidjetpack

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.submissionandroidjetpack.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class InstrumentationTest {
    private val dataDummy = DataDummy.generateDummyMovie()
    private val dataDummyTv = DataDummy.generateDummyTv()

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        Espresso.onView(withId(R.id.recyclerViewMovie)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataDummy.size))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.recyclerViewMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Espresso.onView(withId(R.id.textTitleDetail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textTitleDetail)).check(matches(withText(dataDummy[0].title)))
        Espresso.onView(withId(R.id.textReleaseDetail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textReleaseDetail)).check(matches(withText(dataDummy[0].date)))
        Espresso.onView(withId(R.id.textOverviewDetail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textOverviewDetail))
            .check(matches(withText(dataDummy[0].description)))
    }

    @Test
    fun loadTv() {
        Espresso.onView(withText("Tv Show")).perform(click())
        Espresso.onView(withId(R.id.recyclerViewTv)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.recyclerViewTv))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataDummyTv.size))
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
        Espresso.onView(withId(R.id.textTitleDetail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textTitleDetail)).check(matches(withText(dataDummyTv[0].title)))
        Espresso.onView(withId(R.id.textReleaseDetail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textReleaseDetail))
            .check(matches(withText(dataDummyTv[0].date)))
        Espresso.onView(withId(R.id.textOverviewDetail)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.textOverviewDetail))
            .check(matches(withText(dataDummyTv[0].description)))
    }
}