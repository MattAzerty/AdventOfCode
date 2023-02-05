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

/*
--- Day 2: I Was Told There Would Be No Math ---
The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.

Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for each present: the area of the smallest side.

For example:

A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.
All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?

Your puzzle answer was 1606483.

The first half of this puzzle is complete! It provides one gold star: *

--- Part Two ---
The elves are also running low on ribbon. Ribbon is all the same width, so they only have to worry about the length they need to order, which they would again like to be exact.

The ribbon required to wrap a present is the shortest distance around its sides, or the smallest perimeter of any one face. Each present also requires a bow made out of ribbon as well; the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present. Don't ask how they tie the bow, though; they'll never tell.

For example:

A present with dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap the present plus 2*3*4 = 24 feet of ribbon for the bow, for a total of 34 feet.
A present with dimensions 1x1x10 requires 1+1+1+1 = 4 feet of ribbon to wrap the present plus 1*1*10 = 10 feet of ribbon for the bow, for a total of 14 feet.
How many total feet of ribbon should they order?

Your puzzle answer was 3842356.

 */