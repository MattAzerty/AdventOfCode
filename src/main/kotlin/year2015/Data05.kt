package year2015

class Data05 {
    companion object {
        @JvmStatic
        fun answerQuestion(data: List<String>) {

            var howMuchStringNice = 0
            var howMuchStringNiceV2 = 0

            val forbiddenCharacters = setOf("ab","cd","pq","xy")

            for (line in data) {

                val check1 = countVowel(line) >=3
            val check2 = checkDouble(line)
            val check3 = !findMatch(line, forbiddenCharacters)
            val check4 = checkPair(line) >=1
            val check5 = checkRepeat(line)

            if (check1 && check2 && check3) howMuchStringNice++
            if (check4 && check5) howMuchStringNiceV2++

            }

            println("The number of 'nice string' with criteria V1 is: $howMuchStringNice")
            println("With criteria V2: $howMuchStringNiceV2")


        }//End of answer

        private fun checkRepeat(line: String): Boolean {
            for (i in 1..line.length-2){
                if(line[i-1]==line[i+1]) return true
            }
            return false
        }

        private fun checkPair(line: String): Int {

            var list = emptyList<String>()
            for (i in 0..line.length-2){
                if(!list.isEmpty()){
                    list = if(list.last()==line.substring(i,i+2)) list else list+line.substring(i,i+2)
                }else {list += line.substring(i,i+2)}

            }
            return ((list.count())-list.distinct().count())//There is X repetition of pair
        }

        private fun countVowel(line: String): Int {
            var count = 0
            for (char in line) {
                if (char.toString().any(setOf('a','e','i','o','u')::contains)) count++
            }
            return count
        }

        private fun checkDouble(line: String): Boolean {
            for (i in 0..line.length-2){
                if(line[i]==line[i+1]) return true
            }
            return false
        }

        private fun findMatch(s: String, strings: Set<String>): Boolean {
            return strings.any { s.contains(it) }
        }
    }//End of companion
}//End of Data05