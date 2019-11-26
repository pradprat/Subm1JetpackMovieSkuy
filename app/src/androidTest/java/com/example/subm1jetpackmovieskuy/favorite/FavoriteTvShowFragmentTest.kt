package com.example.subm1jetpackmovieskuy.favorite

import RecyclerViewItemCountAssertion
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.example.subm1jetpackmovieskuy.MainActivity
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.source.room.RoomDb
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteTvShowFragmentTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)
    var count:Int = 0

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource)

        activityTestRule.activity
                .fragmentManager.beginTransaction()


        val roomDb = RoomDb.getInstance(androidx.test.InstrumentationRegistry.getContext())
        count = roomDb.roomDao().countFavoriteTvShows
    }
    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource)
    }

    @Test
    fun favoriteTvShowFragment(){

//        Menekan Tombol navigasi FavoriteTvShow
        Espresso.onView(ViewMatchers.withId(R.id.navigation_tv_show_favorite)).perform(ViewActions.click())

//
//        Membuka FavoriteTvShowFragment
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        Memastikan FavoriteTvShowFragment menampilkan RecyclerView
//
//        Memastikan RecyclerView menampilkan jumlah item yang sesuai dengan yang diharapkan
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).check((RecyclerViewItemCountAssertion(count)))

    }
}