package com.example.projettdm2

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun arraylist(){
        val media = ArrayList<String>()
        media.add("https://192.168.43.106:80000/")
        media.add("https://192.168.43.106:80000/")
        media.add("https://192.168.43.106:80000/")
        media.add("https://192.168.43.106:80000/")
        media.add("https://192.168.43.106:80000/")
        print(media.toString())
        assert(true)
    }
}
