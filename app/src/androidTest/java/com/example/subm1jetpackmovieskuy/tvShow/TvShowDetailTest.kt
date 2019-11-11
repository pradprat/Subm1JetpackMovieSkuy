package com.example.subm1jetpackmovieskuy.tvShow

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.example.subm1jetpackmovieskuy.MainActivity
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.tvShow.ui.TvShowViewHolder
import org.junit.Before

import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
public class TvShowDetailTest {

    var tvShowDummy = TvShow(
            R.drawable.poster_arrow,
            "Arrow",
            "October 10, 2012",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
    )

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        activityTestRule.activity
                .fragmentManager.beginTransaction()
    }

    @Test
    fun TvShowFragment() {
//        § Menekan Tombol navigasi TvShow
        onView(withId(R.id.navigation_tv_show)).perform(click())

//        § Membuka TvShowFragment

//        § Memastikan TvShowFragment menampilkan RecyclerView
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))

//        § Memilih dan Membuka salahsatu item di RecyclerView TvShow
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<TvShowViewHolder>(0, click()));

//        § Memastikan berpindah activity ke Activity TvShow Detail
        onView(withId(R.id.ivPosterTvShowDetail)).check(matches(isDisplayed()));

//        § Memastikan Activity TvShow Detail Menampilkan Detail yang sesuai dengan item yang dipilih
        onView(withId(R.id.tvNameTvShowDetail)).check(matches(ViewMatchers.withText(tvShowDummy.name)))
        onView(withId(R.id.tvReleaseTvShowDetail)).check(matches(ViewMatchers.withText(tvShowDummy.firstAirDate)))
        onView(withId(R.id.tvOverviewTvShowDetail)).check(matches(ViewMatchers.withText(tvShowDummy.overview)))
    }
}