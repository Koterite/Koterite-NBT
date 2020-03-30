package br.com.gamemods.nbtmanipulator

import kotlin.test.Test
import kotlin.test.assertTrue

class KotlinUsage {
    @Test
    fun testUsage() {
        val list = listOf(2,3,4,5,6).toNbtList()
        list += 7
        assertTrue(7 in list)
        list -= 7
        assertTrue(7 !in list)
    }
}
