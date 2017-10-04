
Assume you are asked to write a program for a computer that has 10 registers and contains a memory of 1000 words. Each register and memory location can hold a value of natural number >=0 and <=999. The computer can process an instruction that consists of 3-digit value stored in a memory location. It is assumed that these instructions will be not be stored in the memory but processed one after another. Following scheme is used to create or execute an instruction:

Instruction code
Description
1xx
means halt execution. You can ignore the value of x
2dn
means value of register d = n
3dn
means value of register d = value of register d + n
4dn
means value of register d = value of register d * n
5ds
means value of register d = value of register d / n
6ds
means value of register d = value of register s
7ds
means value of register d = value of register d + value of register s
8dx
means value of register d = sqrt (value of register d). You can ignore the value of x
9ds
means value of register d = (value of register d) S 
0xx
System cannot process any instruction that is in the form of ‘0xx’. Show an error like following:
Output: Instruction code ‘065’ is not supported by the system.

Each register is initialized to 000. The contents of the memory are taken from the input and executed one after another. The result is always saved in the reduced format using modulus of 1000.
To complete this Assignment:
Input
You need to take an input of all the instructions that user wants to execute.
Note: You can reduce the complexity of input by asking user to input a long string of instructions where each instruction is separated by a single space. Your task is to read a string from the user, and repeatedly find a substring of 3 characters to decode and execute instruction until there is no other instruction to be processed.
Output
For the input string, you need to show each instruction being executed and values of all the register (0 to 9) after execution of that instruction.
Sample input and output: 
Enter command: 275
Output: 1: 000, 2:000, 3:000, 4:000, 5:000, 6:000, 7:005, 8:000, 9:000
Enter command: 226
Output: 1: 000, 2:006, 3:000, 4:000, 5:000, 6:000, 7:005, 8:000, 9:000
Enter command: 373
Output: 1: 000, 2:006, 3:000, 4:000, 5:000, 6:000, 7:008, 8:000, 9:000
Enter command: 426
Output: 1: 000, 2:036, 3:000, 4:000, 5:000, 6:000, 7:008, 8:000, 9:000
Enter command: 692
Output: 1: 000, 2:036, 3:000, 4:000, 5:000, 6:000, 7:008, 8:000, 9:036
Enter command: 672
Output: 1: 000, 2:036, 3:000, 4:000, 5:000, 6:000, 7:036, 8:000, 9:036
Enter command: 100
Output: Program terminated.
Sample Input: input is in the form of one long string
Enter commands: 275 226 373 426 692 672 100
Sample Output: 
275
1: 000, 2:000, 3:000, 4:000, 5:000, 6:000, 7:005, 8:000, 9:000
226
1: 000, 2:006, 3:000, 4:000, 5:000, 6:000, 7:005, 8:000, 9:000
373
1: 000, 2:006, 3:000, 4:000, 5:000, 6:000, 7:008, 8:000, 9:000
426
1: 000, 2:036, 3:000, 4:000, 5:000, 6:000, 7:008, 8:000, 9:000
692
1: 000, 2:036, 3:000, 4:000, 5:000, 6:000, 7:008, 8:000, 9:036
672
1: 000, 2:036, 3:000, 4:000, 5:000, 6:000, 7:036, 8:000, 9:036
100
Program terminated.
