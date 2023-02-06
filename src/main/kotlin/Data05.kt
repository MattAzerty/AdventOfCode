class Data05 {
    companion object {
        @JvmStatic
        fun answerQuestion(data: List<String>) {

            var howMuchStringNice = 0
            var howMuchStringNiceV2 = 0

            val forbiddenCharacters = setOf("ab","cd","pq","xy")

            for (line in data) {
            //1
            val check1 = countVowel(line) >=3
            //2
            val check2 = checkDouble(line)
            //3
            val check3 = !findMatch(line, forbiddenCharacters)
            //4
            val check4 = checkPair(line) >=1
            //5
            val check5 = checkRepeat(line)

            if (check1 && check2 && check3) howMuchStringNice++
            if (check4 && check5) howMuchStringNiceV2++

            }

            println(howMuchStringNice);println(howMuchStringNiceV2)


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

/*
--- Day 5: Doesn't He Have Intern-Elves For This? ---
Santa needs help figuring out which strings in his text file are naughty or nice.

A nice string is one with all of the following properties:

It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
For example:

ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
jchzalrnumimnmhp is naughty because it has no double letter.
haegwjzuvuyypxyu is naughty because it contains the string xy.
dvszwmarrgswjxmb is naughty because it contains only one vowel.
How many strings are nice?

Your puzzle answer was 258.

--- Part Two ---
Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or nice. None of the old rules apply, as they are all clearly ridiculous.

Now, a nice string is one with all of the following properties:

It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.
For example:

qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly one letter between them (zxz).
xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though the letters used by each rule overlap.
uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears twice.
How many strings are nice under these new rules?

Your puzzle answer was 53.


*/