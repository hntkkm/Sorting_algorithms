#!/bin/bash

javac Main3.java Sort3.java

for VARIABLE1 in {8..32..8}
do
  python3 random_number_generator.py "$VARIABLE1" | java Main3
  python3 random_number_generator.py "$VARIABLE1" true | java Main3
  python3 random_number_generator.py "$VARIABLE1" false | java Main3
done

for K2 in {1..5..1}
do
  for VARIABLE2 in {100..2000..100}
  do
     python3 random_number_generator.py "$VARIABLE2" | java Main3
  done
done

python3 main.py