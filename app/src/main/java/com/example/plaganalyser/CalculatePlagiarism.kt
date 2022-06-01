package com.example.plaganalyser

import kotlin.math.acos
import kotlin.math.sqrt

class CalculatePlagiarism(text1: String, text2: String) {
    private val maxRadian = 1.5707963267948966
    private val t1: String = text1
    private val t2: String = text2
    private val validCharSet = listOf('.', ',', '@', '-', '_')

    private fun countFrequency(list: List<String>): HashMap<String, Int> {
        val hashMap = HashMap<String, Int>()
        for (word in list) {
            if (hashMap[word] == null) hashMap[word] = 1
            else hashMap[word] = hashMap[word]!! + 1
        }
        return hashMap
    }

    private fun getWordList(text: String): List<String> {
        val unfilteredList: MutableList<String> = text.split(" ", "\n").toMutableList()
        val filteredList: MutableList<String> = unfilteredList.filter { it1 ->
            it1.filter {
                it in 'A'..'Z' || it in 'a'..'z' || it in '0'..'9' || it in validCharSet
            }.length == it1.length && it1.isNotEmpty()
        }.toMutableList()

        for(i in filteredList.indices){
            filteredList[i] = filteredList[i].trim( '.', ',', '@', '-', '_' ).lowercase()
        }

        return filteredList.toList()
    }

    private fun innerProduct(D1: HashMap<String, Int>, D2: HashMap<String, Int>): Double{
        var sum = 0.0
        for((key, value) in D1){
            if(D2.containsKey(key)){
                sum += D1[key]!! * D2[key]!!
            }
        }
        return sum
    }

    private fun vectorAngle(D1: HashMap<String, Int>, D2: HashMap<String, Int>): Double {
        /*  angle = acos( ⨊ (Ai x Bi) / √( ⨊(Ai^2) x ⨊(Bi^2) )
            Ai -> Frequency of word i from MAP A. (From Map of words)
            Bi -> Frequency of word i from MAP B. (From Map of words)   */
        val numerator = innerProduct(D1, D2)
        val denominator = sqrt( innerProduct(D1, D1) * innerProduct(D2, D2))
        return acos(numerator/denominator)
    }

    fun onCalculatePlagiarism(): Double {
        t1.trimIndent(); t2.trimIndent();

        val wordList1 = getWordList(t1)
        val wordList2 = getWordList(t2)

//        println(wordList1); println(wordList2); println()

        val hashMap1 = countFrequency(wordList1)
        val hashMap2 = countFrequency(wordList2)
//        println(hashMap1); println(hashMap2); println()

        var docDist = vectorAngle(hashMap1, hashMap2)
        // Converting Radians in range 0 to 1.5707963267948966
        //  to equivalent percentage.
        docDist = ((maxRadian - docDist)/maxRadian)*100
        println("$docDist %")
        return docDist
    }
}


fun main() {
    val text1 = """
        Surya wants to play1 all day 10 nights
        as of not giving up.

        ALthough it's not the fact that its pretty-obvious.

            Whereever you get the change all surya.
    """
    val text2 = "surya does not wants to play1 all evenings 10 nights NIGHTS NiGhts."
//    val text1 = """
//        i am not one of those who fall
//    """
//    val text2 = "i am not one of those who fall"
//    val text2 = "you are in two pass all"

    val calculatePlagiarism = CalculatePlagiarism(text1, text2)
    calculatePlagiarism.onCalculatePlagiarism()
}