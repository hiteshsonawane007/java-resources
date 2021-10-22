import pandas as pd
import re
from numpy import finfo
from numpy.testing._private.parameterized import param
import csv

#Function to split each row in partitions:
def splitEachRow(line, partitionList):
    lineparts = []
    start = 0
    end = 0

    for partition in partitionList:
        start = end
        end = start + partition
        columndata = line[start:end]
        lineparts.append(columndata)
    return lineparts

if __name__ == '__main__':
    print('-----------------START-------------------')

    #Read prn File lines: and add to list
    with open("C:/Users/Hitesh.Sonawane/Downloads/DETest_Sonawane-master/Workbook2.prn") as file_in:
        list = []
        for line in file_in:
            list.append(line)

    firstLine = list[0]
    firstLine = firstLine.replace('Credit Limit','Credit_Limit')

    #Get Start and End positions of each column from header:
    result = [(m.start(), m.end() - 1) for m in re.finditer(r'\S+', firstLine)][1:]

    #From List of positions calculate starting index of each column:
    partitionList =[]
    listSize = int(len(result))
    #Iterate on tuple:
    for index, tuple in enumerate(result):
        element_one = tuple[0]
        element_two = tuple[1]

        if index == 0:
            partitionList.append(tuple[0])
        elif index == (listSize -1 ):
            partition = element_one - result[index - 1][0]
            partitionList.append(partition)

            partition = element_two - result[index-1][1]
            partitionList.append(partition)
        else:
            partition = element_one - result[index - 1][0]
            partitionList.append(partition)
    print(partitionList)

    #Iterate on each LIne from prn file and separate each column by adding ';'
    modifiedLine = ''
    finallst = []
    with open("<<>prn file path >>>") as file_in:
        for line in file_in:
            lineparts = splitEachRow(line, partitionList)
            for str in lineparts:
                if modifiedLine == '':
                    modifiedLine = modifiedLine + str
                else:
                    modifiedLine = modifiedLine + ';' + str
            finallst.append(modifiedLine)
            modifiedLine = ''

        print('---------------------------------------------------------------------------------------')
        print(finallst)

    #Now generate CSV file from new lien contents:
    myfile = open('prn_converted_CSV.csv', 'w')
    for line in finallst:
        myfile.write(line)
    myfile.close()
    print('---------------------------------------------------------------------------------------')

    #Now parse new generated CSV file by giving separator:
    df = pd.read_csv("<<file path for new generated file>>/prn_converted_CSV.csv", index_col=False, sep=';')
    #print(df)

    #convert dataframe to HTML
    result = df.to_html()

    # write html to file
    text_file = open("index_prn.html", "w", encoding='utf-8')
    text_file.write(result)
    text_file.close()
    print('HTML File generated Sucessfully.')
    print('-----------------END-------------------')