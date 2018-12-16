import pandas

data = pandas.read_csv('/home/sharhack/Загрузки/waves/SELECT_t___FROM_public_txs_3_t_ORDER_BY_.csv')

#print(f.read())

for i in range(0, 21582):
    f = open('/home/sharhack/Загрузки/waves/notes3.txt', 'r');
    if (f.read().__contains__(str(data['id'][i]))):
        with open('/home/sharhack/Загрузки/waves/desc.txt', 'a') as w:
            w.write(str(data['description'][i])+'\n')