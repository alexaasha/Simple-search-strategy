This repo consists code from [Hyperskill project.][1] It was very 
helpful for me to dive fast into kotlin.

Several words about project:
It's a simple search engine based on hash table: program
parses an incoming file and splits it into tokens. Then 
it stores each token with list of numbers of lines where 
this token located in the file.  

Here is the demo of program:

```
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
Print the number of line
                        
2
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
            
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
Print the number of line
                        
1
Select a matching strategy: ALL, ANY, NONE
ALL
Enter a name or email to search all suitable people.
Erick
Erick Harrington harrington@gmail.com
Erick Burgess
            
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
Print the number of line
                        
1
Select a matching strategy: ALL, ANY, NONE
ALL
Enter a name or email to search all suitable people.
Erick Burgess
Erick Burgess
            
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
Print the number of line
                        
1
Select a matching strategy: ALL, ANY, NONE
ANY
Enter a name or email to search all suitable people.
Burgess Erick
No matching people found.
            
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
Print the number of line
                        
1
Select a matching strategy: ALL, ANY, NONE
ANY
Enter a name or email to search all suitable people.
Erick Burgess
Erick Burgess
Erick Harrington harrington@gmail.com
            
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
Print the number of line
                        
0
Bye!
```

[1]: https://hyperskill.org/tracks
