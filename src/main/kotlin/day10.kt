
fun main(){

    fun lookAndSay(userInput: String, timesInput: Int) : String{

        val regex = "(\\d)\\1*".toRegex()

        val seq = generateSequence(userInput) {
            buildString {
                regex.findAll(it).forEach { m ->
                    append(m.value.length)
                    append(m.value[0])
                }
            }
        }
        val result = seq.elementAt(timesInput).length

        return result.toString()
    }

    println("Hello, we are playing here with look and say numbers. The problem of Day-10 in AOC-2015 ask us to print the length of look & say numbers applied till 40 (part 1) or 50 (part 2) times. So, please enter a number-")
     val sampleNumber = readLine()!!.toString()

    println("How many times 40 or 50?")
    val timesNumber = readLine()!!.toInt()

    val answer = lookAndSay(sampleNumber, timesNumber)
    println(answer)

}






