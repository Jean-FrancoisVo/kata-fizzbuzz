package fr.lacombe.kata

import net.jqwik.api.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Baby steps, Parameterized tests, Property based tests")
class FizzBuzzTest {
    @Test
    fun `Given one number then should return the number`() {
        assertThat(fizzbuzz(1)).isEqualTo("1")
    }

    @Test
    fun `Given a number divisible by 3 then should return 3`() {
        assertThat(fizzbuzz(3)).isEqualTo("fizz")
    }

    @Test
    fun `Given a number divisible by 5 then should return 5`() {
        assertThat(fizzbuzz(5)).isEqualTo("buzz")
    }

    @Test
    fun `Given a number divisible by 3 and 5 then should return fizzbuzz`() {
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
    fun `Given numbers not divisible by 3 nor 5 then should return the number`(value: Int, expected: String) {
        assertThat(fizzbuzz(value)).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} -> 'fizz'")
    @ValueSource(ints = [3, 6, 9, 12, 18, 21, 24, 27])
    fun `Given numbers divisible by 3 then should return fizz`(value: Int) {
        assertThat(fizzbuzz(value)).isEqualTo("fizz")
    }

    @ParameterizedTest(name = "{0} -> 'buzz'")
    @ValueSource(ints = [5, 10, 20, 25, 35])
    fun `Given numbers divisible by 5 then should return buzz`(value: Int) {
        assertThat(fizzbuzz(value)).isEqualTo("buzz")
    }

    @ParameterizedTest(name = "{0} -> 'fizzbuzz'")
    @ValueSource(ints = [15, 30, 55])
    fun `Given numbers divisible by 3 and 5 then should return fizzbuzz`() {
        assertThat(fizzbuzz(15)).isEqualTo("fizzbuzz")
    }

    @Property
    fun `All numbers divisible by 3 should contain fizz`(@ForAll("divisibleBy3") anInteger: Int): Boolean {
        return fizzbuzz(anInteger).contains("fizz")
    }

    @Provide
    fun divisibleBy3(): Arbitrary<Int> {
        return Arbitraries.integers().between(1, 500).filter { i -> i % 3 == 0 }
    }

    @Property
    fun `All numbers divisible by 5 should contain fizz`(@ForAll("divisibleBy5") anInteger: Int): Boolean {
        return fizzbuzz(anInteger).contains("buzz")
    }

    @Provide
    fun divisibleBy5(): Arbitrary<Int> {
        return Arbitraries.integers().between(1, 500).filter { i -> i % 5 == 0 }
    }

    @Property
    fun `All numbers divisible by 3 and 5 should contain fizzbuzz`(@ForAll("divisibleBy3And5") anInteger: Int): Boolean {
        return fizzbuzz(anInteger).contains("fizzbuzz")
    }

    @Provide
    fun divisibleBy3And5(): Arbitrary<Int> {
        return Arbitraries.integers().between(1, 500).filter { i -> i % 3 == 0 && i % 5 == 0 }
    }
}

fun fizzbuzz(value: Int): String {
    val divisibleBy3 = value % 3 == 0
    val divisibleBy5 = value % 5 == 0
    if (divisibleBy3 && divisibleBy5) {
        return "fizzbuzz"
    }
    if (divisibleBy3) {
        return "fizz"
    }
    if (divisibleBy5) {
        return "buzz"
    }
    return Integer.toString(value)
}
