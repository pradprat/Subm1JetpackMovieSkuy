package com.example.subm1jetpackmovieskuy.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.subm1jetpackmovieskuy.MainActivity
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.Movie
import org.junit.Before

import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
public class MovieDetailTest {
    var movieDummy = Movie(R.drawable.poster_a_start_is_born,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "2018")

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        activityTestRule.activity
                .fragmentManager.beginTransaction()
    }

    @Test
    fun MovieRecyclerViewTest() {
//        § Membuka MovieFragment
//        § Memastikan MovieFragment menampilkan RecyclerView
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))

//        § Memilih dan Membuka salahsatu item di RecyclerView Movie
        onView(withId(R.id.rvMovie)).perform(actionOnItemAtPosition<MovieViewHolder>(0, click()));

//        § Memastikan berpindah activity ke Movie Detail Activity
        onView(withId(R.id.ivPosterMovieDetail)).check(matches(isDisplayed()));

//        § Memastikan Activity Movie Detail Menampilkan Detail yang sesuai dengan item yang dipilih
        onView(withId(R.id.tvTitleMovieDetail)).check(matches(withText(movieDummy.title + " (" + movieDummy.releaseDate + ")")));
        onView(withId(R.id.tvOverviewMovieDetail)).check(matches(withText(movieDummy.overview)));
    }

}

