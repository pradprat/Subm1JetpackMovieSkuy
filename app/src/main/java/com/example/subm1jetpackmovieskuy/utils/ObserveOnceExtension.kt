package com.example.subm1jetpackmovieskuy.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import javax.xml.datatype.DatatypeConstants.SECONDS
import android.R.attr.countDown
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.annotation.Nullable
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}

@Throws(InterruptedException::class)
fun <T> LiveData<T>.getValue(): T {
    val data = arrayOfNulls<Any>(1)
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(@Nullable o: T) {
            data[0] = o
            latch.countDown()
            removeObserver(this)
        }
    }
    observeForever(observer)
    latch.await(2, TimeUnit.SECONDS)

    return data[0] as T
}