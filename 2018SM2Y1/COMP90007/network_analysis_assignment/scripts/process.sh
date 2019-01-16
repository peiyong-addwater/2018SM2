#!/bin/bash
DATETIME="`date '+%Y%m%d%H%M%S'`" 


cd ~/Desktop/COMP90007/network_analysis_assignment/scripts
echo "website list
> -----------------
> iperf.he.net
> bouygues.testdebit.info
> ping.online.net
> st2.nn.ertelecom.ru
> iperf.biznetnetworks.com
> ping-90ms.online.net
> speedtest.serverius.net
> bouygues.iperf.fr 
> iperf.volia.net
> iperf.it-north.net
"

[ -f iperftest ] && mv iperftest iperftest${DATETIME} || touch iperftest
echo "Starting iperf"
echo "Starting iperf" >> iperftest
echo "-------------------------------------------" >> iperftest
echo "iperf.he.net" >>iperftest
echo "1/10"
echo "1st">>iperftest
iperf -c iperf.he.net >> iperftest
echo "2nd">>iperftest
iperf -c iperf.he.net>> iperftest
echo "3rd">>iperftest
iperf -c iperf.he.net>> iperftest
echo "--------------------------------------------">>iperftest

echo "bouygues.testdebit.info" >>iperftest
echo "1st">>iperftest
echo "2/10"
iperf3 -c bouygues.testdebit.info -f 'm' -p 5203 >> iperftest
echo "2nd">>iperftest
iperf3 -c bouygues.testdebit.info -f 'm' -p 5203 >> iperftest
echo "3rd">>iperftest
iperf3 -c bouygues.testdebit.info -f 'm' -p 5203 >> iperftest
echo "--------------------------------------------">>iperftest

echo "ping.online.net" >>iperftest
echo "1st">>iperftest
echo "3/10"
iperf3 -c ping.online.net  >> iperftest
echo "2nd">>iperftest
iperf3 -c ping.online.net >> iperftest
echo "3rd">>iperftest
iperf3 -c ping.online.net  >> iperftest
echo "--------------------------------------------">>iperftest

echo "st2.nn.ertelecom.ru" >>iperftest
echo "4/10"
echo "1st">>iperftest
iperf -c st2.nn.ertelecom.ru >> iperftest
echo "2nd">>iperftest
iperf -c st2.nn.ertelecom.ru>> iperftest
echo "3rd">>iperftest
iperf -c st2.nn.ertelecom.ru>> iperftest
echo "--------------------------------------------">>iperftest

echo "iperf.biznetnetworks.com" >>iperftest
echo "5/10"
echo "1st">>iperftest
iperf3 -c iperf.biznetnetworks.com -p 5202 >> iperftest
echo "2nd">>iperftest
iperf3 -c iperf.biznetnetworks.com -p 5202 >> iperftest
echo "3rd">>iperftest
iperf3 -c iperf.biznetnetworks.com -p 5202  >> iperftest
echo "--------------------------------------------">>iperftest

echo "ping-90ms.online.net" >>iperftest
echo "6/10"
echo "1st">>iperftest
iperf3 -c ping-90ms.online.net  >> iperftest
echo "2nd">>iperftest
iperf3 -c ping-90ms.online.net  >> iperftest
echo "3rd">>iperftest
iperf3 -c ping-90ms.online.net  >> iperftest
echo "--------------------------------------------">>iperftest

echo "speedtest.serverius.net" >>iperftest
echo "7/10"
echo "1st">>iperftest
iperf -c speedtest.serverius.net >> iperftest
echo "2nd">>iperftest
iperf -c speedtest.serverius.net>> iperftest
echo "3rd">>iperftest
iperf -c speedtest.serverius.net>> iperftest
echo "--------------------------------------------">>iperftest

echo "bouygues.iperf.fr" >>iperftest
echo "8/10"
echo "1st">>iperftest
iperf3 -c bouygues.iperf.fr -f 'm'  >> iperftest
echo "2nd">>iperftest
iperf3 -c bouygues.iperf.fr -f 'm' >> iperftest
echo "3rd">>iperftest
iperf3 -c bouygues.iperf.fr -f 'm' >> iperftest
echo " -------------------------------------------- ">>iperftest

echo "iperf.volia.net" >>iperftest
echo "9/10"
echo "1st" >>iperftest
iperf -c iperf.volia.net  >> iperftest
echo "2nd" >>iperftest
iperf -c iperf.volia.net >> iperftest
echo "3rd" >>iperftest
iperf -c iperf.volia.net >> iperftest
echo "--------------------------------------------">>iperftest

echo "iperf.it-north.net" >>iperftest
echo "10/10"
echo "1st">>iperftest
iperf -c iperf.it-north.net  >> iperftest
echo "2nd">>iperftest
iperf -c iperf.it-north.net >> iperftest
echo "3rd">>iperftest
iperf -c iperf.it-north.net >> iperftest
echo "--------------------------------------------">>iperftest

echo "iperf ends"


[ -f pings ] && mv pings pings${DATETIME} || touch pings
echo "starting ping"
echo "starting ping">>pings

echo "iperf.he.net" >>pings
echo "1/10"
echo "1st">>pings
ping -c 10 iperf.he.net >> pings
echo "2nd">>pings
ping -c 10 iperf.he.net>> pings
echo "3rd">>pings
ping -c 10 iperf.he.net>> pings
echo "--------------------------------------------">>pings

echo "bouygues.testdebit.info" >>pings
echo "2/10"
echo "1st">>pings
ping -c 10 bouygues.testdebit.info >> pings
echo "2nd">>pings
ping -c 10 bouygues.testdebit.info >> pings
echo "3rd">>pings
ping -c 10 bouygues.testdebit.info >> pings
echo "--------------------------------------------">>pings

echo "ping.online.net" >>pings
echo "3/10"
echo "1st">>pings
ping -c 10 ping.online.net >> pings
echo "2nd">>pings
ping -c 10 ping.online.net >> pings
echo "3rd">>pings
ping -c 10 ping.online.net >> pings
echo "--------------------------------------------">>pings

echo "st2.nn.ertelecom.ru" >>pings
echo "4/10"
echo "1st">>pings
ping -c 10 st2.nn.ertelecom.ru >> pings
echo "2nd">>pings
ping -c 10 st2.nn.ertelecom.ru >> pings
echo "3rd">>pings
ping -c 10 st2.nn.ertelecom.ru >> pings
echo "--------------------------------------------">>pings

echo "iperf.biznetnetworks.com" >>pings
echo "5/10"
echo "1st">>pings
ping -c 10 iperf.biznetnetworks.com >> pings
echo "2nd">>pings
ping -c 10 iperf.biznetnetworks.com >> pings
echo "3rd">>pings
ping -c 10 iperf.biznetnetworks.com >> pings
echo "--------------------------------------------">>pings

echo "ping-90ms.online.net" >>pings
echo "6/10"
echo "1st">>pings
ping -c 10 ping-90ms.online.net >> pings
echo "2nd">>pings
ping -c 10 ping-90ms.online.net >> pings
echo "3rd">>pings
ping -c 10 ping-90ms.online.net >> pings
echo "--------------------------------------------">>pings

echo "speedtest.serverius.net" >>pings
echo "7/10"
echo "1st">>pings
ping -c 10 speedtest.serverius.net >> pings
echo "2nd">>pings
ping -c 10 speedtest.serverius.net >> pings
echo "3rd">>pings
ping -c 10 speedtest.serverius.net >> pings
echo "--------------------------------------------">>pings

echo "bouygues.iperf.fr" >>pings
echo "8/10"
echo "1st">>pings
ping -c 10 bouygues.iperf.fr >> pings
echo "2nd">>pings
ping -c 10 bouygues.iperf.fr >> pings
echo "3rd">>pings
ping -c 10 bouygues.iperf.fr >> pings
echo "-------------------------------------------------"  >>pings

echo "iperf.volia.net" >>pings
echo "9/10"
echo "1st">>pings
ping -c 10 iperf.volia.net >> pings
echo "2nd">>pings
ping -c 10 iperf.volia.net >> pings
echo "3rd">>pings
ping -c 10 iperf.volia.net >> pings
echo "--------------------------------------------">>pings

echo "iperf.it-north.net" >>pings
echo "10/10"
echo "1st">>pings
ping -c 10 iperf.it-north.net >> pings
echo "2nd">>pings
ping -c 10 iperf.it-north.net >> pings
echo "3rd">>pings
ping -c 10 iperf.it-north.net >> pings
echo "--------------------------------------------">>pings

echo "ping ends" >>pings
echo "ping ends"

[ -f hopcount ] && mv hopcount hopcount${DATETIME} || touch hopcount
echo "Starting hopcount"
echo "Starting hopcount" >>hopcount
echo "--------------------------------------------">>hopcount
echo "1/10"
echo "iperf.he.net" >> hopcount
traceroute -P icmp -nw1 iperf.he.net >> hopcount 
echo "--------------------------------------------">>hopcount
echo "2/10"
echo "bouygues.testdebit.info" >>hopcount
traceroute -P icmp -nw1 bouygues.testdebit.info >>hopcount
echo "--------------------------------------------">>hopcount
echo "3/10"
echo "ping.online.net" >> hopcount
traceroute -P icmp -nw1 ping.online.net >>hopcount
echo "--------------------------------------------">>hopcount
echo "4/10"
echo "st2.nn.ertelecom.ru" >> hopcount
traceroute -P icmp -nw1 st2.nn.ertelecom.ru>>hopcount
echo "--------------------------------------------">>hopcount
echo "5/10"
echo "iperf.biznetnetworks.com" >> hopcount
traceroute -P icmp -nw1 iperf.biznetnetworks.com>>hopcount
echo "--------------------------------------------">>hopcount
echo "6/10"
echo "ping-90ms.online.net" >> hopcount
traceroute -P icmp -nw1 ping-90ms.online.net>>hopcount
echo "--------------------------------------------">>hopcount
echo "7/10"
echo "speedtest.serverius.net" >> hopcount
traceroute -P icmp -nw1 speedtest.serverius.net>>hopcount
echo "--------------------------------------------">>hopcount
echo "8/10"
echo "bouygues.iperf.fr" >> hopcount
traceroute -P icmp -nw1 bouygues.iperf.fr >>hopcount
echo "--------------------------------------------">>hopcount
echo "9/10"
echo "iperf.volia.net" >> hopcount
traceroute -P icmp -nw1 iperf.volia.net >>hopcount
echo "--------------------------------------------">>hopcount
echo "10/10"
echo "iperf.it-north.net" >> hopcount
traceroute -P icmp -nw1 iperf.it-north.net >>hopcount
echo "--------------------------------------------">>hopcount

echo "hopcount completed"
echo "hopcount completed" >> hopcount

echo "ALL DONE!"