import sys
import random

if __name__ == '__main__':
    gen = random.Random()
    arguments = sys.argv
    random_list = []

    if len(arguments) > 1:
        size = int(arguments[1])

        for i in range(size):
            random_list.append(gen.randint(0, 2 * size - 1))

    if len(arguments) > 2:
        if arguments[2] == 'true':
            random_list.sort(reverse=False)
        elif arguments[2] == 'false':
            random_list.sort(reverse=True)

    for ran in random_list:
        print(ran, end=' ')
