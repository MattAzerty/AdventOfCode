package year2015

class Data03 {
    companion object {
        private val housesInfoWithHelpOfRobot: MutableMap<Pair<Int, Int>, Int> = mutableMapOf(Pair (1,1) to 2)
        @JvmStatic
        fun answerQuestion(data: String) {

            var houseXYCoordinates = Pair (1,1)//(x,y)
            val housesInfo: MutableMap<Pair<Int, Int>, Int> = mutableMapOf(Pair (1,1) to 1)

//CLASSIC SANTA
        for (char in data) {
            var x = houseXYCoordinates.first
            var y = houseXYCoordinates.second

            when(char){
                    '^' -> y += 1
                    'v' -> y += -1
                    '>' -> x += 1
                    '<' -> x += -1
            }
            houseXYCoordinates = Pair(x,y)

            val present = housesInfo[houseXYCoordinates] ?: 1
            housesInfo[houseXYCoordinates] = present+1
        }

//CLASSIC SANTA + Robot-SANTA
            var instructionForSanta=true
            var houseXYCoordinatesSanta = Pair (1,1)
            var houseXYCoordinatesRobotSanta = Pair (1,1)

            for (char in data) {
                if(instructionForSanta){
                    instructionForSanta=false
                    houseXYCoordinatesSanta = updateCoordinates(houseXYCoordinatesSanta, char)
                    addPresent(houseXYCoordinatesSanta)
                }else{
                    instructionForSanta=true
                    houseXYCoordinatesRobotSanta = updateCoordinates(houseXYCoordinatesRobotSanta, char)
                    addPresent(houseXYCoordinatesRobotSanta)
                }
            }

        println("With Santa work ${housesInfo.size} houses received at least one present!")
        println("This time with Robot-Santa help ${housesInfoWithHelpOfRobot.size} houses received at least one present!")

        }//End of answer

        private fun updateCoordinates(c: Pair<Int, Int>, char: Char): Pair<Int, Int> {
            var newXYCoordinates= c
            when(char){
                '^' -> newXYCoordinates = Pair(c.first,c.second+1)
                'v' -> newXYCoordinates = Pair(c.first,c.second-1)
                '>' -> newXYCoordinates = Pair(c.first+1,c.second)
                '<' -> newXYCoordinates = Pair(c.first-1,c.second)
            }
            return newXYCoordinates
        }

        private fun addPresent(hc: Pair<Int, Int>) {
            val present = housesInfoWithHelpOfRobot[hc] ?: 1
            housesInfoWithHelpOfRobot[hc] = present+1
        }


    }//End of companion

}//End of Data03