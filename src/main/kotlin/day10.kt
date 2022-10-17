
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

    val answer = lookAndSay(9644489995, 40)
    println(answer)

}






