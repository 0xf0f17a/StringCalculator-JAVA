# StringCalculator-Java
String Calculator TDD Kata implemented in Java

![Build Status](https://github.com/0xf0f17a/StringCalculator-Java/actions/workflows/testing.yml/badge.svg)

## TODO List

- [x] Create a simple String calculator with a method signature: `int Add(string numbers)`. 
  - The method can take up to two numbers, separated by commas, and will return their sum.
  - "" will return 0
  - "1" will return 1
  - "1,2" will return 3
- [x] Allow the Add method to handle an unknown amount of numbers
- [x] Allow the Add method to handle new lines between numbers (instead of commas).
  - “1\n2,3” will return 6
  - “1,\n” will throw exception 
- [x] Support different delimiters
  - beginning of string will contain optional separate line that looks like this: “//[delimiter]\n[numbers…]”
  - “//;\n1;2” will return 3
- [x] Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.
  - if there are multiple negatives, show all of them in the exception message.
- [] Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
- [] Delimiters can be of any length with the following format: “//[delimiter]\n”
  - “//[***]\n1***2***3” will return 6 
- [] Allow multiple delimiters like this: “//[delim1][delim2]\n”
  - “//[*][%]\n1*2%3” will return 6.
- [] Allow multiple delimiters with length longer than one char
