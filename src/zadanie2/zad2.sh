#!/bin/bash

rm -rf data.csv

javac Main2.java Sort2.java

for K1 in {1..10..1}
do
  for VARIABLE1 in {10..200..10}
  do
    python3 random_number_generator.py "$VARIABLE1" | java Main2
  done
done

for K2 in {1..5..1}
do
  for VARIABLE2 in {1000..20000..1000}
  do
     python3 random_number_generator.py "$VARIABLE2" | java Main2
  done
done

python3 main.py