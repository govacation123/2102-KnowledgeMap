import pandas as pd
import chardet

def get_csv_encoding(file_path):
    with open(file_path, 'rb') as f:
        result = chardet.detect(f.read())
    return result['encoding']

# 读取所有 CSV 文件，合并最后为一个csv文件
file_names = [
    "pachongjyw1_2.csv",
    "pachongjyw3_4.csv",
    "pachongjyw5_6.csv",
    "pachongjyw7_9.csv",
    "pachongjyw10_13.csv",
    "pachongjyw14_16.csv",
    "pachongjyw17_19.csv",
    "pachongjyw20.csv"
]

dfs = []

# 获取每个文件的编码并读取
for file_name in file_names:
    encoding = get_csv_encoding(file_name)
    dfs.append(pd.read_csv(file_name, encoding=encoding))

# 合并所有 DataFrame
merged_df = pd.concat(dfs, ignore_index=True)

# 将合并后的 DataFrame 写入新的 CSV 文件
merged_df.to_csv("pachongSuperMan1.csv", index=False)

print("合并完成，并生成 pachongSuperMan1.csv 文件")
