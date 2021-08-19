# Scramblies challenge

### Task 1 (scrambler-server)

Complete the function (scramble str1 str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false

Notes:
Only lower case letters will be used (a-z). No punctuation or digits will be included.
Performance needs to be considered

```
Examples:
(scramble? “rekqodlw” ”world”) ==> true
(scramble? “cedewaraaossoqqyt” ”codewars”) ==> true
(scramble? “katas” “steak”) ==> false
```

### Task 2 (scrambler-server)

Create a web service that accepts two strings in a request and applies function scramble? from previous task to them.

### Task 3 (scrambler-client)

Create a UI in ClojureScript with two inputs for strings and a scramble button. When the button is fired it should call the API from previous task and display a result.

# How to run the server

the server project is inside the scrambler-server directory
requirements: clojure 1.10.3

open a command line and run

1. `clojure -X:uberjar`
2. `java -jar scrambler.jar`

to run the test suite
`clojure -X:test`

# How to run the client

the client project is inside the scrambler-client directory

1. `npm install`
2. `npm start`

# Future steps

1. make client app pretty, right now is a plain form that answers to an alert
2. provide proper logging both on client and server apps
3. add specs for the incoming data both in client and server
4. dockerize apps so users can run it on any machine
5. add swagger for api documentation
