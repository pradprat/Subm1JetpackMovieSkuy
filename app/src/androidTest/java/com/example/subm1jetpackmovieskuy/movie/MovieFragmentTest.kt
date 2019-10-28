package com.example.subm1jetpackmovieskuy.movie

import RecyclerViewItemCountAssertion
import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.subm1jetpackmovieskuy.MainActivity
import com.example.subm1jetpackmovieskuy.R
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
public class MovieFragmentTest {

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

//        § Memastikan RecyclerView menampilkan jumlah item yang sesuai dengan yang diharapkan
        onView(withId(R.id.rvMovie)).check((RecyclerViewItemCountAssertion(10)));
    }
}