package com.example.subm1jetpackmovieskuy

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

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
    fun MovieRecyclerViewTest() {

//        Membuka Aplikasi
//
//        Membuka MovieFragment
//
//        Memastikan MovieFragment menampilkan RecyclerView
        Espresso.onView(ViewMatchers.withId(R.id.rvMovie)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        Menekan Tombol navigasi TvShow
        onView(withId(R.id.navigation_tv_show)).perform(click())

//        Membuka TvShowFragment

//        Memastikan TvShowFragment menampilkan RecyclerView
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        Menekan Tombol navigasi FavoriteMovie
        onView(withId(R.id.navigation_movie_favorite)).perform(click())

//        Membuka FavoriteMovieFragment
//
//        Memastikan FavoriteMovieFragment menampilkan RecyclerView
        Espresso.onView(ViewMatchers.withId(R.id.rvMovie)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        Menekan Tombol navigasi FavoriteTvShow
        onView(withId(R.id.navigation_tv_show_favorite)).perform(click())

//        Membuka FavoriteTvShowFragment
//
//        Memastikan FavoriteTvShowFragment menampilkan RecyclerView
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}