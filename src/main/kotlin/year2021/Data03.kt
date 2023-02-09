package year2021

import utils.pow

class Data03 {
    companion object {
        @JvmStatic
        fun answerQuestion(data: List<String>) {

            val gammaRate:String
            val epsilonRate:String
            val array = IntArray(data[0].length)

            for (line in data){
                line.forEachIndexed{ k,v -> array[k]+= v.toMyInt() }
            }
//part1
            gammaRate = toBinaryNumber(array,"g", data.size)
            epsilonRate = toBinaryNumber(array, "e", data.size)

            println("gammaRate: $gammaRate\nepsilonRate: $epsilonRate\npowerConsumption = ${toDecimal(gammaRate)*toDecimal(epsilonRate)}")
            println("-----------")
//part2
            val oxygenGeneratorRating = findRating(data,"o",0)
            val co2ScrubberRating = findRating(data,"c",0)
            println("$oxygenGeneratorRating\n$co2ScrubberRating\n${toDecimal(oxygenGeneratorRating[0])*toDecimal(co2ScrubberRating[0])}")
        }

        private fun findRating(data: List<String>, typeOfRating: String, i: Int): List<String> {

            val filteredList:List<String>

            var sum =0
            data.forEach { sum += it[i].toMyInt() }

            filteredList = if (sum <(data.size).toDouble()/2) {
                data.filter { it[i] == if(typeOfRating=="o") '0' else '1'}
            } else data.filter { it[i] == if(typeOfRating=="o") '1' else '0'}

            return if (filteredList.size == 1) return filteredList else findRating(filteredList, typeOfRating, i + 1)

        }

        private fun toBinaryNumber(array: IntArray, s: String, size: Int):String {//TODO: how to simplify the if on '<' or '>'?
            return if(s=="g") array.map { if (it<size/2) "1" else "0" }.joinToString(separator = "")
                else array.map { if (it>size/2) "1" else "0" }.joinToString(separator = "")
        }

        fun toDecimal(binaryNumber : String) : Int {
            var sum = 0
            binaryNumber.reversed().forEachIndexed {
                    k, v -> sum += v.toString().toInt() * pow(2, k)
            }
            return sum
        }

        /*fun toBinary(decimalNumber: Int, binaryString: String = "") : String {
            while (decimalNumber > 0) {
                val temp = "${binaryString}${decimalNumber%2}"
                return toBinary(decimalNumber/2, temp)
            }
            return binaryString.reversed()
        }*/


    }
}

private fun Char.toMyInt(): Int {//Todo how to make simpler?
var int=0
    when(this){
    '1' -> int = 1
}
    return int
}
/*
--- Day 3: Binary Diagnostic ---
The submarine has been making some odd creaking noises, so you ask it to produce a diagnostic report just in case.

The diagnostic report (your puzzle input) consists of a list of binary numbers which, when decoded properly, can tell you many useful things about the conditions of the submarine. The first parameter to check is the power consumption.

You need to use the binary numbers in the diagnostic report to generate two new binary numbers (called the gamma rate and the epsilon rate). The power consumption can then be found by multiplying the gamma rate by the epsilon rate.

Each bit in the gamma rate can be determined by finding the most common bit in the corresponding position of all numbers in the diagnostic report. For example, given the following diagnostic report:

00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010
Considering only the first bit of each number, there are five 0 bits and seven 1 bits. Since the most common bit is 1, the first bit of the gamma rate is 1.

The most common second bit of the numbers in the diagnostic report is 0, so the second bit of the gamma rate is 0.

The most common value of the third, fourth, and fifth bits are 1, 1, and 0, respectively, and so the final three bits of the gamma rate are 110.

So, the gamma rate is the binary number 10110, or 22 in decimal.

The epsilon rate is calculated in a similar way; rather than use the most common bit, the least common bit from each position is used. So, the epsilon rate is 01001, or 9 in decimal. Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.

Use the binary numbers in your diagnostic report to calculate the gamma rate and epsilon rate, then multiply them together. What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)

Your puzzle answer was 775304.
 */