package fr.lacombe.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzTest {
    @Test
    fun `Given one number then return the number`() {
        //TODO Parameterized test
        assertThat(fizzbuzz(1)).isEqualTo("1")
    }

    @Test
    fun `Given a number divisable by 3 then return 3`() {
        assertThat(fizzbuzz(3)).isEqualTo("fizz")
    }

    @Test
    fun `Given a number divisable by 5 then return 5`() {
        assertThat(fizzbuzz(5)).isEqualTo("buzz")
    }

    private fun fizzbuzz(value: Int): String {
        if (value % 3 == 0) {
            return "fizz"
        }
        if (value % 5 == 0) {
            return "buzz"
        }
        return Integer.toString(value)
    }
}
