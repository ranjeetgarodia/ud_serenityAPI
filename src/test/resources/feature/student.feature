Feature: Testing Student App request

Scenario: Student App can be accessed by user with valid response
When user send GET request to list Student, they should get response statusCode 200  

Scenario: Student App can be accessed by user with Invalid response
When user send GET request to list Student, they should get response statusCode 201  


  Scenario Outline:simple_Outline
     When simple_Outline testcase fname <firstName>
   
    Examples: 
      | firstName |
      | mark |
      
      
  Scenario Outline: Create a new student & verify if the student is added
     When I create a new student by providing the information firstName <firstName> lastName <lastName> email <email> programme <programme> courses <courses>
    Then I verify that the student with <email> is created

    Examples: 
      | firstName | lastName | email                                    | programme        | courses |
      | Declan    | Smith    | nnon.ante.bibendum@risusDonecegestas.edu | Computer Science | Java    |
      | Mark    | Taylor    | nnon2.ante.bibendum@risusDonecegestas.edu | Computer Science | Java    |
      
     