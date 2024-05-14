import pandas as pd
import csv

#  第二个
# 读取文件
# df = pd.read_excel('Spider01ChinaTrans.xls')
df = pd.read_csv("add_data_1.csv")

# 打开一个文件用于写入
with open(
    "neo4j_triplets_add_data_1.csv", "w", newline="", encoding="utf-8"
) as csvfile:
    writer = csv.writer(csvfile)
    writer.writerow([":ID", ":TYPE", ":RELATIONSHIP"])

    # 遍历每一行数据
    for index, row in df.iterrows():
        # 为每个属性创建一个三元组
        for column in df.columns:
            writer.writerow(
                [
                    f"{row['id']}",  # 起始节点ID
                    #':ARTIST',  # 起始节点类型
                    f"{row[column]}",  # 结束节点ID，即属性值
                    #':ID',  # 起始节点类型
                    #':ATTRIBUTE',  # 结束节点类型
                    column,  # 关系类型
                ]
            )
