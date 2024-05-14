import csv
import re


# 哈哈哈
input_file = "data.csv"
output_file = "new_data.csv"

with open(input_file, "r", newline="", encoding="utf-8") as infile, open(
    output_file, "w", newline="", encoding="utf-8"
) as outfile:
    reader = csv.reader(infile)
    writer = csv.writer(outfile)

    for row in reader:
        clean_row = [
            re.sub(r"\n", "", cell) for cell in row
        ]  # 去除每个单元格中的换行符
        writer.writerow(clean_row)
