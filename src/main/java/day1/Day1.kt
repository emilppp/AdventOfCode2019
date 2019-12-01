package day1

import java.io.File
import java.lang.Math.floor

class Day1 {
    fun calculateMass(input: Int) = floor(((input / 3).toDouble())) - 2
}

fun main(args: Array<String>) {
    val nums = File("/Users/emilpersson/Documents/AdventOfCode2019/src/main/java/day1/day1.input").readLines()
    val day1 = Day1()
    val sum = nums
        .map { it.toInt() }
        .map { day1.calculateMass(it) }
        .sum();

    println(sum)
}