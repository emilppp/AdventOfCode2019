package day1

import java.io.File

object Day1 {
    fun calculateMass(input: Int): Int = input / 3 - 2

    fun calculateFuel(input: Int): Int {
        var b = input
        var total = 0
        while(calculateMass(b) > 0) {
            total += calculateMass(b)
            b = calculateMass(b)
        }
        return total
    }

    fun calculateFuels(input: Int) =
        generateSequence(calculateMass(input), Day1::calculateMass)
            .takeWhile { it > 0 }
            .sum()



    fun star1(): Int {
        val nums = File("./src/main/java/day1/day1.input").readLines()

        val sum = nums
            .map { it.toInt() }
            .map { calculateMass(it) }
            .sum();

        return sum
    }

    fun star2(): Int {
        val nums = File("./src/main/java/day1/day1.input").readLines()
        val sum = nums
            .map { it.toInt() }
            .map { calculateFuel(it) }

       return sum.sum()

    }

    fun star2_hax(): Int {
        val nums = File("./src/main/java/day1/day1.input").readLines()
        return nums.sumBy { Day1.calculateFuels(it.toInt()) }
    }


}
fun main(args: Array<String>) {
    println(Day1.star2_hax())
    println(Day1.star2())


}