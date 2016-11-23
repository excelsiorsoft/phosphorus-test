# phosphorus-test

Coding Challenge
================

The effort to fully sequence the human genome, the Human Genome Project, began in 1990 and completed in 2000 at a cost of $2.7 billion. Gathering information from various scientists, one of the problems the project dealt with was assembling small pieces of DNA ("reads") into larger sequences. This problem is known as the "assembly problem".

Today the human genome can be sequenced for around $1000, and the cost continues to drop. But we still deal with the assembly problem today.


Part A
--------

Write a function, longestOverlap, that determines the length of the longest overlap between two lines of DNA. The suffix of one line has to overlap the prefix of the other.

For example:

     read1: TGAGTGGA
     read2: AAGGTGAG

Aligned, the reads look like this:

         TGAGTGGA
     AAGGTGAG



Part B
-------

Look at **lambda_virus.txt**. Each line is a read from a real virus genome but they're in no particular order. 
 
We put a mistake in the reads! Mwhahaha. Using the function from part A, determine which line of DNA belongs to a different organism (i.e. it doesn’t assemble well into this genome).
 

Answer:
-------

The running hypothesis in this experiment was that an extraneous organism would have a minimal resemblance in terms of the overlapping proteins (I'm assuming that is what's represented by letters - **A,G,C,T**, etc.).  

Therefore we need to check all possible combinations for each of the **1650** given sequences: 

    n!/k!(n-k)! 

where k = 2 as we are always comparing 2 strings in ***AssemblyProblem#longestSubstr( )***.  

The result of that experiment as seen in ***AssemblyProblemTest#testCombinationBuilding()*** leads me to believe that the culprit sequence in the given test file is ***sequence\_503*** and consequently the suspect virus is represented by DNA value of "***GGTCCTTTCCGGTGATCCGACAGGTTACG***" as the one having minimum overlap (***3***) with the rest of the population.  Considering that this sequence is also shorter than others (except sequence\_435) that seems to be a plausible conclusion.  

Initially I thought that the outlier would have no overlapping segments with others but from what I see in the experiment's results that doesn't seem to be the case.  