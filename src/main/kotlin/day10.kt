class Day10 {

    private val sampleNumber = readLine()!!.toString()
    //    private val sampleNumber = "8484481"

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                "Hello, we are playing here with look and say numbers. " +
                        "The problem of Day-10 in AOC-2015 ask us to print the length " +
                        "of look & say numbers applied till 40 (part 1) or 50 (part 2)" +
                        " times. So, please enter a number-"
            )

            val result = Day10()
            println(result.part2())


        }
    }


    fun part1(): Int {
        val sequence = createSequence(40)
        println("For 40 times-")
        return sequence.length
    }

    fun part2(): Int {
        val sequence = createSequence(50)
        println("For 50 times-")
        return sequence.length
    }

    private fun createSequence(numberOfTimes: Int): String {
        var n = sampleNumber
        for (i in 0 until numberOfTimes) {
            n = createSecondSequence(n)
        }
        return n
    }

    private fun createSecondSequence(sn: String): String {
        val sf = StringBuffer()
        var i = 0
        while (i < sn.length) {
            var copy = 1
            for (j in i + 1 until sn.length) {
                if (sn[j] == sn[i]) {
                    copy++
                } else {
                    break
                }
            }
            i += copy - 1
            sf.append(copy).append(sn[i])
            i++
        }
        return sf.toString()
    }


}