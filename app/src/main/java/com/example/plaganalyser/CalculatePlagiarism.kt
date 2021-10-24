package com.example.plaganalyser

class CalculatePlagiarism(text1: String, text2: String) {
    private val t1: String = text1
    private val t2: String = text2

    private fun getWordList(text: String): List<String> {
        val unfiltered_list: List<String> = text.split(" ")
        val filtered_list: List<String> = unfiltered_list.filter { it1 -> it1.filter {
            it in 'A'..'Z' || it in 'a'..'z' || it in '0'..'9' }.length == it1.length && it1.isNotEmpty()
        }
        return filtered_list
    }

    private fun countFrequency(list: List<String>): HashMap<String, Int> {
        val hashMap = HashMap<String, Int>()
        for(word in list){
            if(hashMap[word] == null) hashMap[word] = 1
            else hashMap[word] = hashMap[word]!! + 1
        }
        return hashMap
    }

    fun onCalculatePlagiarism() {
        val word_list1 = getWordList(t1)
        val word_list2 = getWordList(t2)

        println(word_list1); println(word_list2); println()

        val hashMap1 = countFrequency(word_list1)
        println(hashMap1)
    }


}

fun main(){
    val text1: String = """Surya wants to play1 all day 10 nights
    
    							as of not giving up
                                dfg wants all
                                
                                package"""
    val text2: String = "surya does not wants to play1 all evenings 10 nights NIGHTS NiGhts"
    val calculatePlagiarism = CalculatePlagiarism(text1, text2)
    calculatePlagiarism.onCalculatePlagiarism()
}