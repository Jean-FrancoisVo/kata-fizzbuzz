package fr.lacombe.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzTest {
    @Test
    fun `when number then return the number`() {
        assertThat(fizzbuzz(1)).isEqualTo("1")
    }

    private fun fizzbuzz(value: Int): String {
        return Integer.toString(value)
    }
}
