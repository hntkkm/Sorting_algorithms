#!/bin/bash

javac Main4.java Sort4.java
rm -rf data.csv

for VARIABLE1 in {8..32..8}
do
  python3 random_number_generator.py "$VARIABLE1" | java Main4 6
done

for K1 in {1..5..1}
do
  for VARIABLE1 in {100..1000..50}
  do
  python3 random_number_generator.py "$VARIABLE1" | java Main4 6
  python3 random_number_generator.py "$VARIABLE1" true | java Main4 6
  python3 random_number_generator.py "$VARIABLE1" false | java Main4 6
  echo "$VARIABLE1"
  done
done
python3 main.py