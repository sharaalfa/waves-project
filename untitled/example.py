import pandas

data = pandas.read_csv('/home/sharhack/Загрузки/waves/SELECT_t___FROM_public_txs_3_t_ORDER_BY_.csv', usecols=['asset_id','description'])
with open ('/home/sharhack/Загрузки/waves/data_full.txt', 'a') as f:
    for i in range(0, 21582):
        f.write(str(data['description'][i]) + '\n');
        
with open ('/home/sharhack/Загрузки/waves/data_full2.txt', 'a') as f:
    for i in range(0, 21582):
        f.write(str(data['asset_id'][i]) + '\n');
#print(data)