package com.example.subm1jetpackmovieskuy.movie

//import androidx.test.espresso.contrib.RecyclerViewActions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.subm1jetpackmovieskuy.MainActivity
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
class MovieDetailTest {
    var movieDummy = LocalMain().getMovies().get(0)

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
//        § Membuka MovieFragment
//        § Memastikan MovieFragment menampilkan RecyclerView
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))

//        § Memilih dan Membuka salahsatu item di RecyclerView Movie
//        onView(withId(R.id.rvMovie)).perform(actionOnItemAtPosition<MovieViewHolder>(0, click()))

//        § Memastikan berpindah activity ke Movie Detail Activity
        onView(withId(R.id.ivPosterMovieDetail)).check(matches(isDisplayed()))

//        § Memastikan Activity Movie Detail Menampilkan Detail yang sesuai dengan item yang dipilih
        onView(withId(R.id.tvTitleMovieDetail)).check(matches(withText(movieDummy.title)))
        onView(withId(R.id.tvOverviewMovieDetail)).check(matches(withText(" release : " + movieDummy.release_date + " \n" + movieDummy.overview)))
    }

}

