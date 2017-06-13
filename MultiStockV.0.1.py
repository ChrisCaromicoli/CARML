#Stock Data Gathering Program V1.0
#Author Andrew Downie 05/23/2017

#Next Steps 
#-add check for validity of stock name 
#-get volume of stocks, using a parabolic model
#-get google finance to work
#-tweek time steps for recording

################################
# TEST DATA
# Good Connection
# 50  -data points 15.43 seconds
# 100 -data points 36.75 seconds
# 150 -data points 64.16 seconds
# waring this includes large print statment
from googlefinance import getQuotes
from yahoo_finance import Share
import pandas
import matplotlib.pyplot as plt
from datetime import datetime
import numpy as np
import json
import time
import csv
import os.path

#Create CSV File
def createCSV(filePath, stockTag):
    with open(filePath,"w+") as outcsv:
        writer = csv.writer(outcsv)
        writer.writerow(('Time','Stock_Price'))
        writer.writerow(('Market Cap',Share(stockTag).get_market_cap()))
        
#Add to CSV File
def appendToCSV(filePath, stockTag):
    with open(filePath,"a") as outcsv:
        writer = csv.writer(outcsv)
        i = 0
        for dataPoint in stockTag[1]:
            writer.writerow(dataPoint)
    
def writeToFile(StockTags):
    for Stock in StockTags:
        filePath = Stock[0] + time.strftime("%Y%b%d") + ".csv"
        if os.path.isfile(filePath):
            appendToCSV(filePath,Stock)
        else:
            createCSV(filePath,Stock[0])
            appendToCSV(filePath,Stock)
        
def getData(StockTags):
    Tindex = 0
    Sindex = 0
    while Tindex <30:
        for Stock in StockTags:
            SQuote = getQuotes(Stock[0])
            Stock[1].append([SQuote[0].get("LastTradeDateTime"),float(SQuote[0].get("LastTradePrice"))])
        Tindex = Tindex+1
        Sindex = 0

#variables
StockTags = (['AAPL'],['TD'],['BNS'],['RY'],['MSFT'])

#main program
for Tag in StockTags:
    Tag.append([])

print len(StockTags)
print StockTags  
getData(StockTags)
print StockTags
writeToFile(StockTags)  
    

#while Tindex < 5:
#   Sindex = 0
#    while Sindex < 4:
#        SQuote = getQuotes(StockTags[Sindex])
#        data[Sindex][Tindex][0] = SQuote.get("LastTradeDateTime")
#        data[Sindex][Tindex][1] = float(SQuote.get("LastTradePrice"))
#Sindex = 0
#while Sindex<4:
#    createCSV(StockTags[Sindex])
#Sindex = 0
#while Sindex<4:
#    appendToCSV(StockTags[Sindex],data[Sindex][][0],data[Sindex][][1])
    
