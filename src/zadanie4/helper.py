import math

import matplotlib.pyplot as plt


def create_plot_1(list_x, list_y, x_label_name='', y_label_name='', title='', pic_name='pic.png'):
    plt.plot(list_x, list_y, 'b.', markersize=5)
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_plot_2(list_x, list_x2, list_y, list_y2, x_label_name='', pic_name='pic.png',
                  title='', y_label_name='', y1_label='', y2_label=''):
    line1, = plt.plot(list_x, list_y, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x2, list_y2, 'r.', markersize=5, label=y2_label)
    plt.legend(handles=[line1, line2])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_plot_3(list_x, list_x_plus2, list_data1, list_data2, list_data3, pic_name='pic.png',
                  x_label_name='', y_label_name='', title='', y1_label='', y2_label='', y3_label=''):
    line1, = plt.plot(list_x, list_data1, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x_plus2, list_data2, 'r.', markersize=5, label=y2_label)
    line3, = plt.plot(list_x_plus2, list_data3, 'g.', markersize=5, label=y3_label)
    plt.legend(handles=[line1, line2, line3])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_plot_4(list_x, list_x_plus2, list_data1, list_data2, list_data3, list_data4, pic_name='pic.png',
                  x_label_name='', y_label_name='', title='', y1_label='', y2_label='', y3_label='', y4_label=''):
    line1, = plt.plot(list_x, list_data1, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x_plus2, list_data2, 'r.', markersize=5, label=y2_label)
    line3, = plt.plot(list_x_plus2, list_data3, 'g.', markersize=5, label=y3_label)
    line4, = plt.plot(list_x_plus2, list_data4, 'c.', markersize=5, label=y4_label)
    plt.legend(handles=[line1, line2, line3, line4])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_plot_5(list_x, list_x_plus2, list_data1, list_data2, list_data3, list_data4, list_data5, pic_name='pic.png',
                  x_label_name='', y_label_name='', title='', y1_label='', y2_label='', y3_label='', y4_label='',
                  y5_label=''):
    line1, = plt.plot(list_x, list_data1, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x_plus2, list_data2, 'r.', markersize=5, label=y2_label)
    line3, = plt.plot(list_x_plus2, list_data3, 'g.', markersize=5, label=y3_label)
    line4, = plt.plot(list_x_plus2, list_data4, 'c.', markersize=5, label=y4_label)
    line5, = plt.plot(list_x_plus2, list_data5, 'm.', markersize=5, label=y5_label)
    plt.legend(handles=[line1, line2, line3, line4, line5])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_small_plot_2(list_x, list_data1, list_data2, pic_name='pic.png',
                        x_label_name='', y_label_name='', title='', y1_label='', y2_label=''):

    length = len(list_x)
    line1, = plt.plot(list_x, list_data1, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x, list_data2[:length], 'r.', markersize=5, label=y2_label)
    plt.legend(handles=[line1, line2])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_small_plot_3(list_x, list_data1, list_data2, list_data3, pic_name='pic.png',
                        x_label_name='', y_label_name='', title='', y1_label='', y2_label='', y3_label=''):

    length = len(list_x)
    line1, = plt.plot(list_x, list_data1, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x, list_data2[:length], 'r.', markersize=5, label=y2_label)
    line3, = plt.plot(list_x, list_data3[:length], 'g.', markersize=5, label=y3_label)
    plt.legend(handles=[line1, line2, line3])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_small_plot_4(list_x, list_data1, list_data2, list_data3, list_data4, pic_name='pic.png',
                        x_label_name='', y_label_name='', title='', y1_label='', y2_label='', y3_label='', y4_label=''):

    length = len(list_x)
    line1, = plt.plot(list_x, list_data1, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x, list_data2[:length], 'r.', markersize=5, label=y2_label)
    line3, = plt.plot(list_x, list_data3[:length], 'g.', markersize=5, label=y3_label)
    line4, = plt.plot(list_x, list_data4[:length], 'c.', markersize=5, label=y4_label)
    plt.legend(handles=[line1, line2, line3, line4])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def create_small_plot_5(list_x, list_data1, list_data2, list_data3, list_data4, list_data5, pic_name='pic.png',
                        x_label_name='', y_label_name='', title='', y1_label='', y2_label='', y3_label='', y4_label='',
                        y5_label=''):

    length = len(list_x)
    line1, = plt.plot(list_x, list_data1, 'b.', markersize=5, label=y1_label)
    line2, = plt.plot(list_x, list_data2[:length], 'r.', markersize=5, label=y2_label)
    line3, = plt.plot(list_x, list_data3[:length], 'g.', markersize=5, label=y3_label)
    line4, = plt.plot(list_x, list_data4[:length], 'c.', markersize=5, label=y4_label)
    line5, = plt.plot(list_x, list_data5[:length], 'm.', markersize=5, label=y5_label)
    plt.legend(handles=[line1, line2, line3, line4, line5])
    plt.xlabel(x_label_name)
    plt.ylabel(y_label_name)
    plt.title(title)
    plt.savefig(pic_name)
    plt.cla()
    plt.clf()


def complexity_n_log_n(list_x, a):
    list_to_return = []

    for x in list_x:
        list_to_return.append(a * x * math.log(x))

    return list_to_return
