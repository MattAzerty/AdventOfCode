import java.io.File

fun main() {

//----------------------------------------//https://adventofcode.com/2015

//CODE001
    val data01 = File("data/2015/data01.txt").readText()//limited for 2GB file size!
    println("-----DAY001-----")
    year2015.Data01.answerQuestion(data01)

//CODE002
    val data02 = File("data/2015/data02.txt").readLines()//limited for 2GB file size!
    println("-----DAY002-----")
    year2015.Data02.answerQuestion(data02)

//CODE003
    val data03 = File("data/2015/data03.txt").readText()
    println("-----DAY003-----")
    year2015.Data03.answerQuestion(data03)

//CODE004
    val data04 = "ckczppom"
    println("-----DAY004-----")
    year2015.Data04.answerQuestion(data04)

//CODE005
    val data05 = File("data/2015/data05.txt").readLines()
    println("-----DAY005-----")
    year2015.Data05.answerQuestion(data05)


//----------------------------------------//https://adventofcode.com/2021

//CODE001

}//End of main

