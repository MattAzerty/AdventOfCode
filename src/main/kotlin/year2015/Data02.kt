package year2015

class Data02 {
    companion object {
        @JvmStatic
        fun answerQuestion(data: List<String>) {

            var surfaceOfPaperToOrder = 0
            var lengthOfRibbonToOrder = 0

            for (line in data){
                surfaceOfPaperToOrder += surfaceForOneBox(line.split("x").map { it.toInt() })
                lengthOfRibbonToOrder += ribbonForOneBox(line.split("x").map { it.toInt() })
            }

            //println("length, width, height ${data[0].split("x")}")
            println("Surface = $surfaceOfPaperToOrder [sq.ft]")
            println("Length = $lengthOfRibbonToOrder [ft]")

        } //End of answer

        private fun surfaceForOneBox(intArray: List<Int>): Int {

           val a = 2*intArray[0]*intArray[1]
           val b =+2*intArray[1]*intArray[2]
           val c= 2*intArray[2]*intArray[0]
           val min = minOf(a,b,c)//TODO how to make accessible?

           return (a+b+c)+(min/2)
        }

        private fun ribbonForOneBox(intArray: List<Int>): Int {

            var out = 0

            val l = intArray[0]
            val w = intArray[1]
            val h=  intArray[2]

            val (shortest, max) = listOf(l,w,h).partition { it < maxOf(l,w,h) }

            when(shortest.size){
                0 -> out = 4*(max[0])+(l*w*h)
                1 -> out = 2*(shortest[0]+ max[0])+(l*w*h)
                2 -> out = 2*shortest.sum()+(l*w*h)

            }

            return out

        }

    }//End of companion

}//End of Data02