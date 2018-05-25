package fr.lacombe.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Baby steps, Parameterized tests")
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

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(
            "1, '1'",
            "2, '2'",
            "4, '4'",
            "7, '7'",
            "8, '8'",
            "11, '11'"
    )
    fun `Given numbers not divisable by 3 nor 5 then return the number`(value: Int, expected: String) {
        assertThat(fizzbuzz(value)).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} -> 'fizz'")
    @ValueSource(ints = [3, 6, 9, 12, 18, 21, 24, 27])
    fun `Given numbers divisable by 3 then return fizz`(value: Int) {
        assertThat(fizzbuzz(value)).isEqualTo("fizz")
    }

    @ParameterizedTest(name = "{0} -> 'buzz'")
    @ValueSource(ints = [5, 10, 20, 25, 35])
    fun `Given numbers divisable by 5 then return buzz`(value: Int) {
        assertThat(fizzbuzz(value)).isEqualTo("buzz")
    }

    @ParameterizedTest(name = "{0} -> 'fizzbuzz'")
    @ValueSource(ints = [15, 30, 55])
    fun `Given numbers divisable by 3 and 5 then return fizzbuzz`() {
        assertThat(fizzbuzz(15)).isEqualTo("fizzbuzz")
    }
}

fun fizzbuzz(value: Int): String {
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
