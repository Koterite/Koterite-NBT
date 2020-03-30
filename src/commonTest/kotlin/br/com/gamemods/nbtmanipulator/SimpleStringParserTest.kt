package br.com.gamemods.nbtmanipulator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SimpleStringParserTest {
    @Test
    fun testSimpleTags() {
        assertEquals(NbtByte((-128).toByte()), NbtByte("-128"))
        assertEquals(NbtByte(255), NbtByte.unsigned("255"))
        assertEquals(NbtShort(3232), NbtShort("3232"))
        assertEquals(NbtShort(-444), NbtShort("-444"))
        assertEquals(NbtInt(15151555), NbtInt("15151555"))
        assertEquals(NbtInt(-15151555), NbtInt("-15151555"))
        assertEquals(NbtInt(-15151555), NbtInt("-15151555"))
        assertEquals(NbtLong(5645464489787987894), NbtLong("5645464489787987894"))
        assertEquals(NbtLong(-5645464489787987894), NbtLong("-5645464489787987894"))
        assertEquals(NbtFloat(32e15F), NbtFloat("32e15"))
        assertEquals(NbtFloat(-32e-15F), NbtFloat("-32e-15"))
        assertEquals(NbtDouble(1247e143), NbtDouble("1247e143"))
        assertEquals(NbtDouble(-1247e143), NbtDouble("-1247e143"))
    }

    @Test
    fun testArrays() {
        assertEquals(NbtByteArray(byteArrayOf(32, 48, 127, -49)), NbtByteArray("[32, 48, 127, -49]"))
        assertEquals(NbtIntArray(intArrayOf(3225, 6484, -4891, 0, -415843255)), NbtIntArray("[3225, 6484, -4891, 0, -415843255]"))
        assertEquals(NbtLongArray(longArrayOf(15648489415618, 15648747841152218, -15648489745415, 0)),
            NbtLongArray("[15648489415618, 15648747841152218, -15648489745415, 0]"))
    }

    @Test
    fun testEmptyArrays() {
        assertEquals(NbtByteArray(), NbtByteArray("[]"))
        assertEquals(NbtIntArray(), NbtIntArray("[]"))
        assertEquals(NbtLongArray(), NbtLongArray("[]"))
    }

    @Test
    fun testIllegalArrays() {
        assertFailsWith(NumberFormatException::class) { NbtByteArray("[-130]") }
        assertFailsWith(IllegalArgumentException::class) { NbtIntArray("[5") }
        assertFailsWith(IllegalArgumentException::class) { NbtLongArray("[1,2,3]") }
    }

    @Test
    fun testByteRange() {
        assertFailsWith(NumberFormatException::class) { NbtByte(256) }
        assertFailsWith(NumberFormatException::class) { NbtByte("256") }
        assertFailsWith(NumberFormatException::class) { NbtByte(-1) }
        assertFailsWith(NumberFormatException::class) { NbtByte.unsigned("-1") }
    }
}
