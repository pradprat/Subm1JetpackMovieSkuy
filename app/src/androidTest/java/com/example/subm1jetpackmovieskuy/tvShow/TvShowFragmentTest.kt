package com.example.subm1jetpackmovieskuy.tvShow

import RecyclerViewItemCountAssertion
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.subm1jetpackmovieskuy.MainActivity
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
public class TvShowFragmentTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource)

        activityTestRule.activity
                .fragmentManager.beginTransaction()
    }
    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource)
    }

    @Test
    fun TvShowFragment() {
//        § Menekan Tombol navigasi TvShow
        onView(withId(R.id.navigation_tv_show)).perform(click())

//        § Membuka TvShowFragment

//        § Memastikan TvShowFragment menampilkan RecyclerView
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))

//        § Memastikan RecyclerView menampilkan jumlah item yang sesuai dengan yang diharapkan
        onView(withId(R.id.rvTvShow)).check((RecyclerViewItemCountAssertion(20)));
    }
}