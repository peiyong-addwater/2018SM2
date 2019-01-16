import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import sklearn
from sklearn import linear_model

# data sturcture:
# {ip1:{iperf:{[bandwidth1,bandwidth2,bandwidth3]},ping:{[],[],[]},hopcount:{}}, ip2:{...}, ...}
# bandwidth in Mbits/sec, ping in ms, hopcount is just hops
# pings stored in lists, [min,avg,max,stddev]
ip_list = ["iperf.he.net", "bouygues.testdebit.info", "ping.online.net", "st2.nn.ertelecom.ru",
           "iperf.biznetnetworks.com", "ping-90ms.online.net", "speedtest.serverius.net", "bouygues.iperf.fr",
           "iperf.volia.net", "iperf.it-north.net"]
ip_list_map = {}

i = 1

for c in ip_list:
    ip_list_map[c] = i
    i = i + 1
del i

raw_data = {1: {"iperf": [45.0, 44.9, 45.0],
                "ping": [[162.477, 163.066, 164.527, 0.533], [162.747, 163.405, 166.694, 1.119],
                         [162.451, 163.184, 164.871, 0.668]], "hop": 7},
            2: {"iperf": [20.6, 20.4, 20.8],
                "ping": [[302.396, 303.019, 304.737, 0.668], [302.236, 302.698, 303.118, 0.279],
                         [302.278, 302.725, 303.191, 0.323]], "hop": 19},
            3: {"iperf": [13.5, 18.9, 18.8],
                "ping": [[300.499, 301.070, 301.802, 0.398], [300.601, 301.078, 301.560, 0.338],
                         [300.716, 301.336, 303.475, 0.783]], "hop": 18},
            4: {"iperf": [17.5, 17.4, 17.5],
                "ping": [[357.149, 357.404, 357.717, 0.160], [356.775, 357.301, 358.024, 0.395],
                         [356.692, 357.411, 358.041, 0.353]], "hop": 20},
            5: {"iperf": [31.0, 28.9, 30.5],
                "ping": [[210.342, 211.051, 211.600, 0.469], [210.165, 211.091, 211.548, 0.392],
                         [210.602, 211.094, 211.463, 0.270]], "hop": 10},
            6: {"iperf": [12.4, 12.9, 12.8],
                "ping": [[389.245, 389.797, 390.506, 0.442], [389.030, 389.648, 390.562, 0.462],
                         [389.195, 389.612, 390.063, 0.257]], "hop": 17},
            7: {"iperf": [19.0, 19.2, 19.1],
                "ping": [[300.749, 301.159, 301.376, 0.217], [300.561, 301.269, 302.405, 0.560],
                         [300.648, 301.111, 301.493, 0.302]], "hop": 19},
            8: {"iperf": [20.5, 20.5, 9.74 ],
                "ping": [[302.005, 302.550, 303.163, 0.381], [302.250, 309.420, 366.028, 18.877],
                         [301.978, 327.355, 466.100, 50.409]], "hop": 19},
            9: {"iperf": [18.5, 18.7, 18.7],
                "ping": [[336.623, 337.166, 337.592, 0.322], [336.526, 337.301, 337.970, 0.519],
                         [337.140, 345.545, 419.313, 24.590]], "hop": 19},
            10: {"iperf": [397 * 10 ** (-3), 718 * 10 ** (-3), 813 * 10 ** (-3)],
                 "ping": [[394.153, 394.727, 395.242, 0.397], [394.173, 394.601, 395.250, 0.401],
                          [394.241, 396.619, 411.930, 5.130]], "hop": 23}}

# ip distance got from https://www.ip-adress.com/ip-address-distance

ip_distance_to_home = {1: 7983.11, 2: 10444.19, 3: 10418.95, 4: 8743.70, 5: 3241.62, 6: 10418.95, 7: 10292.70,
                       8: 10444.19, 9: 9193.66, 10: 7585.02}  # in miles

# Task 2.1, trying to find a relationship between the hop counts and the geo distance

hop_count = []
for c in ip_list:
    hop_count.append(raw_data[ip_list_map[c]]["hop"])
print('hop unsorted', hop_count)
distance = []
for c in ip_list:
    distance.append(ip_distance_to_home[ip_list_map[c]])
print('distance unsorted', distance)
x_hop_y_dist = []
for i in range(len(hop_count)):
    x_hop_y_dist.append([hop_count[i], distance[i]])
# print('unsorted x hop y dist', x_hop_y_dist)
x_hop_y_dist.sort()

hop_dist = np.array(x_hop_y_dist)

plt.figure()
plt.xlabel("hop count")
plt.ylabel("distance in miles")
plt.grid(True)
plt.scatter(hop_dist[:, 0], hop_dist[:, 1])
plt.savefig('hopdist.png', bbox_inches='tight')
plt.close()

x = np.asarray(hop_dist[:, 0]).reshape(-1, 1)
y = np.asarray(hop_dist[:, 1])

model_t21 = sklearn.linear_model.LinearRegression()
model_t21.fit(x, y)
print("the R^2 between distance and hop count is",model_t21.score(x, y))
y2 = model_t21.predict(x)
plt.figure()
plt.xlabel("hop count")
plt.ylabel("distance in miles")
plt.grid(True)
plt.scatter(hop_dist[:, 0], hop_dist[:, 1])
plt.plot(x, y2, 'b--')
plt.savefig('hop_dist_fit.png')
plt.close()
# Task 3.1 Measuring delay and jitter
# relationship between delay and distance
avg_delay = []
for c in ip_list:
    pings = raw_data[ip_list_map[c]]["ping"]
    avg_delay.append((pings[0][1]+pings[1][1]+pings[2][1])/3)

y_delay_x_distance = []
for i in range(len(avg_delay)):
    y_delay_x_distance.append([distance[i],avg_delay[i]])
print('avg_delay unsorted', avg_delay)
y_delay_x_distance.sort()
dist_delay = np.array(y_delay_x_distance)

x = np.asarray(dist_delay[:,0]).reshape(-1,1)
y = np.asarray(dist_delay[:,1])

model_t31 = sklearn.linear_model.LinearRegression()
model_t31.fit(x,y)
print("the R^2 between delay and distance is",model_t31.score(x,y))
y2 = model_t31.predict(x)
plt.figure()
plt.xlabel("distance in miles")
plt.ylabel("delay in ms")
plt.grid(True)
plt.scatter(dist_delay[:,0], dist_delay[:,1])
plt.plot(x, y2, 'b--')
plt.savefig('dist_delay_fit.png')
plt.close()


# relationship between jitter and distance
avg_jitter = []
for c in ip_list:
    jitters_in_ping = raw_data[ip_list_map[c]]["ping"]
    avg_jitter.append(((jitters_in_ping[0][3]**2+jitters_in_ping[1][3]**2+jitters_in_ping[2][3]**2)/3)**(1/2))
print('jitter avg unsorted', avg_jitter)
y_jitter_x_distance = []
for i in range(len(avg_jitter)):
    y_jitter_x_distance.append([distance[i], avg_jitter[i]])
y_jitter_x_distance.sort()
jitter_dist = np.array(y_jitter_x_distance)

x = np.asarray(jitter_dist[:,0]).reshape(-1,1) #distance
y = np.asarray(jitter_dist[:,1]) # jitter

model_t32 = sklearn.linear_model.LinearRegression()
model_t32.fit(x,y)
print("the R^2 between jitter and distance (linear regression) is",model_t32.score(x,y))
y2 = model_t32.predict(x)
plt.figure()
plt.xlabel("distance in miles")
plt.ylabel("jitter in ms")
plt.grid(True)
plt.scatter(jitter_dist[:,0],jitter_dist[:,1])
plt.plot(x, y2, 'b--')
plt.savefig('distance_jitter_fit_linear.png')
plt.close()


# Task 4.1 the bandwidth-delay product
# calculate the avreage bandwidth
avg_bandwidth = []
for c in ip_list:
    bw = raw_data[ip_list_map[c]]["iperf"]
    avg_bandwidth.append(np.mean(bw)*1000) # convert from mega to kilo
print('avg bandwidth unsorted', avg_bandwidth)
ip_bandwidth_delay_product_dic = {}
ip_bandwidth = {}
for i in range(len(avg_bandwidth)):
    ip_bandwidth_delay_product_dic[ip_list[i]] = avg_bandwidth[i]*avg_delay[i]/1000 #convert ms to second
    ip_bandwidth[ip_list[i]] = avg_bandwidth[i]
ip_bandwidth = pd.DataFrame(list(ip_bandwidth.items()), columns=['IP Address', 'Bandwidth in kbps'])

ip_bandwidth_delay_product = pd.DataFrame(list(ip_bandwidth_delay_product_dic.items()),columns=['IP Address', 'Bandwidth Delay Product(kbps)'])
print(ip_bandwidth)
print(ip_bandwidth_delay_product)
plt.figure()
ax = ip_bandwidth_delay_product.plot.bar(x = 'IP Address', y='Bandwidth Delay Product(kbps)', fontsize=6, figsize=(15, 15))
plt.savefig('bandwidth_delay_bar.png')
plt.close()


ip_log_product = {}

# calculate log of bandwidth delay product
ip_bandwidth_delay_product_log_dic = {}
for c in ip_list:
    ip_bandwidth_delay_product_log_dic[c] = np.log(ip_bandwidth_delay_product_dic[c])

ip_bandwidth_delay_product_log = pd.DataFrame(list(ip_bandwidth_delay_product_log_dic.items()), columns=['IP Address', 'Log of Bandwidth Delay Product(kbps)'])
print(ip_bandwidth_delay_product_log)
plt.figure()
ax = ip_bandwidth_delay_product_log.plot.bar(x = 'IP Address', y='Log of Bandwidth Delay Product(kbps)', fontsize=6, figsize=(15, 15))
plt.savefig('bandwidth_delay_log_bar.png')
plt.close()

x_hop_y_bandwidth_delay_product = []
for i in range(len(hop_count)):
    x_hop_y_bandwidth_delay_product.append([hop_count[i], avg_bandwidth[i]*avg_delay[i]/1000])
x_hop_y_bandwidth_delay_product.sort()
hop_bdp = np.array(x_hop_y_bandwidth_delay_product)
plt.figure(figsize=(8, 6))
plt.scatter(hop_bdp[:,0], hop_bdp[:,1])
plt.xlabel('hop count')
plt.ylabel('bandwidth delay product')
plt.grid(True)

plt.savefig('hop_vs_bdp.png')

#reject outliers by restricting the product between u-2s and u+2s, of which u is the average product and s is the standard s
hop_bdp_df = pd.DataFrame(x_hop_y_bandwidth_delay_product,columns=['hop_count', 'bandwidth_delay_product'])
print(hop_bdp_df)
u = np.mean(hop_bdp_df['bandwidth_delay_product'])
s = np.std(hop_bdp_df['bandwidth_delay_product'])
hop_bdp_df_filtered = hop_bdp_df[(hop_bdp_df['bandwidth_delay_product']>u-2*s)&(hop_bdp_df['bandwidth_delay_product']<u+2*s)]
print(hop_bdp_df_filtered)
hop_bdp_filtered_array = hop_bdp_df_filtered.values
model_t41 = sklearn.linear_model.LinearRegression()
x = np.asarray(hop_bdp_filtered_array[:,0]).reshape(-1,1)
y = np.asarray(hop_bdp_filtered_array[:,1])
model_t41.fit(x, y)
print("the R^2 between hopcount and bandwidth-delay product (linear regression, outlier rejected) is",model_t41.score(x,y))
y2 = model_t41.predict(x)
plt.figure(figsize=(8, 6))
plt.xlabel('hop count (outliers rejected)')
plt.ylabel('bandwidth-delay product (outliers rejected)')
plt.grid(True)
plt.scatter(hop_bdp_filtered_array[:,0], hop_bdp_filtered_array[:,1])
plt.plot(x, y2, 'b--')
plt.savefig('hop_bdp_linear_fit_outliers_rejected.png')