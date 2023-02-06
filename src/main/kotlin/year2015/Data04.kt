package year2015

import java.math.BigInteger
import java.security.MessageDigest

class Data04 {
    companion object {
        @JvmStatic
        fun answerQuestion(data: String) {

            var answer5 = data.md5()
            var answer6 = data.md5()
            var increment=0
            var increment2=0

            while(answer5.md5().substring(0,5)!="00000"){
                increment++
                answer5= "$data$increment"
            }

            while(answer6.md5().substring(0,6)!="000000"){
                increment2++
                answer6= "$data$increment2"
            }

            println("AdventCoins: $increment")
            println("AdventCoinsV2: $increment2")

        }//End of answer

    }//End of companion

}//End of Data04

private fun String.md5(): String {//Get MD5 hash of the string (of length 32, with leading zeros)
    val crypt = MessageDigest.getInstance("MD5");
    crypt.update(this.toByteArray());
    val digest = BigInteger(1, crypt.digest()).toString(16).padStart(32, '0')
    return digest
}
/*
--- Day 4: The Ideal Stocking Stuffer ---
Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.
To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.
For example:
If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest such number to do so.
If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
Your puzzle answer was 117946.
--- Part Two ---
Now find one that starts with six zeroes.
Your puzzle answer was 3938038.
*/