package year2021

import java.lang.Math.abs

class Data05 {

    class Coordinates(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {
        constructor(coordinates: List<Int>) : this(coordinates[0], coordinates[1], coordinates[2], coordinates[3])
    }

    companion object {
        private val matrix: MutableMap<Pair<Int, Int>, Int> = mutableMapOf(Pair (0,0) to 0)
        @JvmStatic
        fun answerQuestion(data: List<String>) {

            for (line in data){
                val coordinates = Coordinates(line.split(" -> |,".toRegex()).map{it.toInt()})
                //addCoordinatesToMatrix(coordinates,true)
                addCoordinatesToMatrix(coordinates,false)
            }

            println(matrix.filter{it.component2()>=2}.size)

        }

        private fun addCoordinatesToMatrix(coordinates: Coordinates, selectOnlyHV: Boolean) {

            val x1 = coordinates.x1
            val y1 = coordinates.y1
            val x2 = coordinates.x2
            val y2 = coordinates.y2
            val marks = mutableSetOf<Pair<Int, Int>>()
            val startX:Int
            val endX:Int
            val startY:Int
            val endY:Int

            marks.add(Pair(x1,y1)) ; marks.add(Pair(x2,y2))

                if(x1==x2 || y1==y2){//V/H lines case
            //case x
                    if(x1<x2){ startX = x1 ; endX = x2 } else { startX = x2 ; endX = x1 }
                    for(i in startX until endX){marks.add(Pair(startX+(i-startX),y1))}
            //caseY
                    if(y1<y2){ startY = y1 ; endY = y2 } else { startY = y2 ; endY = y1 }
                    for(i in startY until endY){marks.add(Pair(x1,startY+(i-startY)))}
            //Add marks to matrix
                    for (pair in marks){
                        val line = matrix[pair] ?: 0
                        matrix[pair] = line+1
                    }

                }else{//diagonal lines case
                    if(!selectOnlyHV){

                        val goUp = y1-y2 < 0
                        val goLeft = x1-x2 >0
                        val howManyTime = kotlin.math.abs(y1 - y2)

                        for (i in 0..howManyTime) {
                            val x = x1 + (if (goLeft) -1 else 1)*i
                            val y = y1 + (if (goUp) 1 else -1)*i
                            marks.add(Pair(x,y))
                        }
                        //Add marks to matrix
                        for (pair in marks) {
                            val line = matrix[pair] ?: 0
                            matrix[pair] = line + 1
                        }
                    }
                }
        }

    }
}
/*
--- Day 5: Hydrothermal Venture ---
You come across a field of hydrothermal vents on the ocean floor! These vents constantly produce large, opaque clouds, so it would be best to avoid them if possible.

They tend to form in lines; the submarine helpfully produces a list of nearby lines of vents (your puzzle input) for you to review. For example:

0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2
Each line of vents is given as a line segment in the format x1,y1 -> x2,y2 where x1,y1 are the coordinates of one end the line segment and x2,y2 are the coordinates of the other end. These line segments include the points at both ends. In other words:

An entry like 1,1 -> 1,3 covers points 1,1, 1,2, and 1,3.
An entry like 9,7 -> 7,7 covers points 9,7, 8,7, and 7,7.
For now, only consider horizontal and vertical lines: lines where either x1 = x2 or y1 = y2.

So, the horizontal and vertical lines from the above list would produce the following diagram:

.......1..
..1....1..
..1....1..
.......1..
.112111211
..........
..........
..........
..........
222111....
In this diagram, the top left corner is 0,0 and the bottom right corner is 9,9. Each position is shown as the number of lines which cover that point or . if no line covers that point. The top-left pair of 1s, for example, comes from 2,2 -> 2,1; the very bottom row is formed by the overlapping lines 0,9 -> 5,9 and 0,9 -> 2,9.

To avoid the most dangerous areas, you need to determine the number of points where at least two lines overlap. In the above example, this is anywhere in the diagram with a 2 or larger - a total of 5 points.

Consider only horizontal and vertical lines. At how many points do at least two lines overlap?

Your puzzle answer was 4873.
 */