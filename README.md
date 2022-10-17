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
