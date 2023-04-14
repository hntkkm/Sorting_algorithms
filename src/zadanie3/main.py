import helper


def __sort_helper(elem):
    return lambda _list: _list[elem]


def get_list_from_list_of_tuples(list_of_tuples, index):
    to_return = []
    accumulator = []
    prev_tuple = (0, 0, 0)

    for tup in list_of_tuples:
        if prev_tuple[0] < tup[0]:
            average = 0
            for num in accumulator:
                average += num

            if average != len(accumulator):
                average /= len(accumulator)
                to_return.append(average)

            accumulator = []

        prev_tuple = tup
        accumulator.append(tup[index])

    average = 0
    for num in accumulator:
        average += num

    if len(accumulator) != 0:
        average /= len(accumulator)
        to_return.append(average)

    return to_return


def read_data():
    read = open('data.csv')
    csv = read.read().split('\n')
    read.close()
    x_value_set = set(())
    insert_sort_list = []
    quick_sort_list = []
    double_quick_sort_list = []
    merge_sort_list = []
    hybrid_sort_list = []

    for line in csv:
        if line != '':
            arguments = line.split(';')
            x_value_set.update(arguments[1])

            if arguments[0] == 'IS':
                insert_sort_list.append((int(arguments[1]), int(arguments[2]), int(arguments[3])))

            elif arguments[0] == 'QS':
                quick_sort_list.append((int(arguments[1]), int(arguments[2]), int(arguments[3])))

            elif arguments[0] == 'MS':
                merge_sort_list.append((int(arguments[1]), int(arguments[2]), int(arguments[3])))

            elif arguments[0] == 'DQS':
                double_quick_sort_list.append((int(arguments[1]), int(arguments[2]), int(arguments[3])))

            elif arguments[0] == 'HS':
                hybrid_sort_list.append((int(arguments[1]), int(arguments[2]), int(arguments[3])))

    insert_sort_list.sort(key=__sort_helper(0))
    quick_sort_list.sort(key=__sort_helper(0))
    double_quick_sort_list.sort(key=__sort_helper(0))
    merge_sort_list.sort(key=__sort_helper(0))
    hybrid_sort_list.sort(key=__sort_helper(0))

    return x_value_set, insert_sort_list, quick_sort_list, double_quick_sort_list, merge_sort_list, hybrid_sort_list


def zad3(input_data):
    # x_set = input_data[0]
    # insert_list = input_data[1]
    quick_list = input_data[2]
    double_quick_list = input_data[3]
    # merge_list = input_data[4]
    # print(len(insert_list), len(quick_list), len(double_list), len(merge_list))

    x_list = get_list_from_list_of_tuples(quick_list, 0)

    helper.create_small_plot_2(x_list,
                               get_list_from_list_of_tuples(quick_list, 1),
                               helper.complexity_n_log_n(x_list, 1.6),      # W tym miejscu eksperymentalnie dobieramy zmienna dla single QS
                               pic_name='single_qs.png',
                               y1_label='Number of comparisons',
                               y2_label='Graph a * n log(n) for experimental a',
                               title='Results for Single Pivot Quick Sort')

    helper.create_small_plot_2(x_list,
                               get_list_from_list_of_tuples(double_quick_list, 1),
                               helper.complexity_n_log_n(x_list, 1.6),      # W tym miejscu eksperymentalnie dobieramy zmienna dla double QS
                               pic_name='double_qs.png',
                               y1_label='Number of comparisons',
                               y2_label='Graph a * n log(n) for experimental a',
                               title='Results for Double Pivot Quick Sort')


if __name__ == '__main__':
    data = read_data()
    zad3(data)
