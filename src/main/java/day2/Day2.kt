package day2

import java.io.File

object Day2 {

    fun calculate(numbs: List<Int>, nums: MutableList<Int>) {
        if (numbs.size < 4) return
        val opcode = numbs[0]
        val inputA = numbs[1]
        val inputB = numbs[2]
        val storePos = numbs[3]


        when(opcode) {
            99 -> return
            1 -> handleAdd(inputA, inputB, storePos, nums) // add
            2 -> handleMul(inputA, inputB, storePos, nums) // mult
        }
    }

    fun handleAdd(a: Int, b: Int, pos: Int, nums: MutableList<Int>) {
  //     println("adding   "  + a + " and " + b + " in pos" + pos)
        nums[pos] = nums[a] + nums[b]
    }

    fun handleMul(a: Int, b: Int, pos: Int, nums: MutableList<Int>) {
     //   println("mulling   "  + a + " and " + b + " in pos" + pos)
        nums[pos] = nums[a] * nums[b]
    }

}

fun main(args: Array<String>) {
    val nums = //mutableListOf<Int>(1,0,0,0,99)
        File("./src/main/java/day2/day2.input").readText().split(",").map { it.toInt() }.toMutableList()


    println(nums)
    val numbs = nums.chunked(4)
    for (chunk in numbs) {
        Day2.calculate(chunk, nums)
    }

    println(nums)

}