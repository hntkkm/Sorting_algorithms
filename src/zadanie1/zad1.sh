#!/bin/bash

javac Main1.java Sort1.java

python3 random_number_generator.py 8 | java Main1
python3 random_number_generator.py 8 true | java Main1
python3 random_number_generator.py 8 false | java Main1

python3 random_number_generator.py 16 | java Main1
python3 random_number_generator.py 16 true | java Main1
python3 random_number_generator.py 16 false | java Main1

python3 random_number_generator.py 32 | java Main1
python3 random_number_generator.py 32 true | java Main1
python3 random_number_generator.py 32 false | java Main1