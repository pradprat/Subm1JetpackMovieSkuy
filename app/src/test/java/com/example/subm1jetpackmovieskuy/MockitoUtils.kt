package com.example.subm1jetpackmovieskuy

import androidx.paging.PagedList
import org.mockito.Mockito

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)

fun <T> mockPagedList(list: List<T>): PagedList<T> {
    val pagedList = Mockito.mock(PagedList::class.java) as PagedList<T>
//    Mockito.`when`(pagedList.get(ArgumentMatchers.anyInt())).then { invocation ->
//        val index = invocation.arguments.first() as Int
//        list[index]
//    }
//    Mockito.`when`(pagedList.size).thenReturn(list.size)
    return pagedList
}