package fr.lacombe.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

//TODO Parameterized test
class FizzBuzzTest {
    @Test
    fun `Given one number then return the number`() {
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

    @Test
    fun `Given a number divisable by 3 and 5 then return fizzbuzz`() {
        assertThat(fizzbuzz(15)).isEqualTo("fizzbuzz")
    }

    private fun fizzbuzz(value: Int): String {
        val divisableBy3 = value % 3 == 0
        val divisableBy5 = value % 5 == 0
        if (divisableBy3 && divisableBy5) {
            return "fizzbuzz"
        }
        if (divisableBy3) {
            return "fizz"
        }
        if (divisableBy5) {
            return "buzz"
        }
        return Integer.toString(value)
    }
}
