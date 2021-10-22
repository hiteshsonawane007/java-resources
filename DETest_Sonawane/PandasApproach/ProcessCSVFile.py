import pandas as pd

if __name__ == '__main__':
    print('-----------------START-------------------')

    df = pd.read_csv("<<CSV File Path>>")
   
    print(df)
    result = df.to_html()
    print(result)
    # write html to file
    text_file = open("index_csv.html", "w", encoding='utf-8')
    text_file.write(result)
    text_file.close()
    print('-----------------END-------------------')