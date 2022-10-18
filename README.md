# Prabhjot-aoc-1
## Overview of the problem

For my Advent of Code assignment- 1 I decided to solve the  [Advent of Code- 2015, Day- 10th](https://adventofcode.com/2015/day/10) problem. In this problem I have to make the look and say numbers sequence, keep making these till 40 and 50 times and at the end printing the length of the result. Look and say numbers are the numbers which take turns making sequences by reading aloud the previous sequence and using that reading as the next sequence. For example, 211 is read as "one two, two ones", which becomes 1221 (1 2, 2 1s). To understand more about look and say numbers refer to this [video](https://www.youtube.com/watch?v=ea7lJkEhytA) Numberphile.

# First Solution

At first, I approached this problem in a lesser idiomatic way and coded it using for and while loops. 
Here we are generating a sequence by making a function named ```createSequence``` which has an integer parameter and string datatype. This method’s goal is to return the sample number or input number by running it through the loop and in the loop (until we reach number 40 or 50 i.e. number of times) we are assigning it to another function where we are the second sequence. In this method, we have nested loops of while and for loops to return our sequenced string. Finally, we created two methods ```part1``` (for 40 times) and ```part2``` (for 50 times) which return the length of the sequence which is our desired result. Below are the snippets of both of those methods, though you can check out the complete code in the previous [commit- Code Added](https://github.com/nic-dgl-204-fall-2022/Prabhjot-aoc-1/commit/17c132e9a52b48d2d9b68b67c34077e60ac4563f) .

    fun part1(): Int {
        val sequence = createSequence(40)
        println("For 40 times-")
        return sequence.length
    }
.
       
       fun part2(): Int {
        val sequence = createSequence(50)
        println("For 50 times-")
        return sequence.length
    }

I found that this solution is good but it has a lot of disadvantages compared to the new solution I found, to solve this question. One of the major flaws of this solution was- it was slow during the runtime and very messy or long code makes this less efficient. Further, we will also understand in detail by comparing both of the solutions. 

# Final Solution 

In the final solution, I used the [regex class](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/)  to solve this problem. In Kotlin, the Regex class is provided for the support of [Regular expressions](https://en.wikipedia.org/wiki/Regular_expression) which is used for string-matching purposes. Regular expression helps to check consecutive identical characters or numbers in a string and that’s what we require to solve this problem as we have to find the repeating numbers in the given input. 


 I referred to [this video](https://www.youtube.com/watch?v=sXQxhojSdZM) to understand regular expressions more deeply and also used [regexr.com](https://regexr.com/) & [Kotlin Regex documentation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/) to get insight into using the pattern ```\\d)\\1*``` by which every group of consecutive identical numbers matched. From the pattern, ```\d``` means we are matching a number under ```0-9``` and here we are taking a group to match any of the numbers.
 
 From the pattern, ```\1*``` means it matches the ```0``` or more of the increasing number. And we stored that pattern in the regex variable with the property to ```.toRegex()```. ```generateSequence``` work is to provide the ```seq``` string variable by which we will be accessing the length of the sequence and it will be our final result. To achieve this ```seq``` string variable we use a loop with ```regex.findAll(it)``` to create the string & length of the sequence, where ```m``` refers to the match result. Refer to the below code to understand how I used the regex class to solve this problem and for complete code please check the [final commit](https://github.com/nic-dgl-204-fall-2022/Prabhjot-aoc-1/commit/5e6f5b4f38e92838375c5f476be5e99ce30cc73a).
 
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


I added the [updated final solution code](https://github.com/nic-dgl-204-fall-2022/Prabhjot-aoc-1/blob/5e10735c3891d64dda04799900a5bd3a209cd813/src/main/kotlin/day10.kt) commit to make the code more appealing and user-friendly. Also, I added comments in the [final commit](https://github.com/nic-dgl-204-fall-2022/Prabhjot-aoc-1/blob/5e6f5b4f38e92838375c5f476be5e99ce30cc73a/src/main/kotlin/day10.kt) which made the code more readable. 

      // taking user input of the number.
    println("Hello, we are playing here with look and say numbers. The problem of Day-10 in AOC-2015 ask us to print the length of look & say numbers applied till 40 (part 1) or 50 (part 2) times. So, please enter a number-")
     val sampleNumber = readLine()!!.toString()

     // taking input from user about how many times to apply the process
    println("How many times 40 or 50?")
    val timesNumber = readLine()!!.toInt()

     // putting inputValues and printing the result
    val answer = lookAndSay(sampleNumber, timesNumber)
    println(answer)
    
   
   ## Reflection
    
The problem I choose was easy to understand initially because I was aware about these “Look and say” numbers but for the first time I faced a framed question related to these numbers. To do the first solution it took almost 30-40 minutes. My first approach was to only solve part 1 (with 40 times input) so I didn’t bother to make different functions because my aim was to get the logic first, that how I’ll be getting the length and when I understood the logic, I implemented the part 2 (for 50 times) and also put the code of taking the input from the user. Solving the problem with the second solution almost took 4-5 hours as I had to understand first what Regex class is, how patterns work in here, what are its properties, and what property can I use in my code ( I used ```findAll()```). I would mention again [regexr.com](https://regexr.com/) here because it was very helpful in all the terms related to regular expressions. 
    
Throughout, the assignment I had learnt a lot of new things and also practised some stuff which I would’ve forgotten till yet. For the first time, I interacted with AOC and wondered how they came up with new problems each year. Last year, I was introduced to regular expressions and learnt about some basic concepts related to them at that time but through this problem, I learnt a lot about regular expressions, especially about regex. Most of the references and resources I already mentioned above by which I able to solve this problem. Also, I tried using the proper commit process while updating the code still I feel that I have to learn more about it because at the time of uploading the first solution I directly uploaded the final execution on GitHub. Then during the second solution, I committed the code first then updated it and committed again with the changes. Although, I enjoyed a lot while learning all this new stuff and would love to continue solving one problem a week on AOC.

    
















































