import csv
import http
import json
import random
import time

import jsonpath
import urllib.request
from urllib.error import URLError
#这是一个能运行的代码。目前最多10页，请记住
'''
def create_request(page):
    url = "https://hermitagemuseum.org/api/v10/search?resultLang=en&queryLang=en&collection=mainweb|kamis|rooms|hermitage&query=china%20AND%20meta_authoring_template:(%22WOA%22)&pageSize=10&"
    url = url + 'page=' + str(page) + '&output=application/json'
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 SLBrowser/9.0.3.1311 SLBChan/103',
    }
    request = urllib.request.Request(url=url, headers=headers)
    return request

def get_content(request):
    try:
        response = urllib.request.urlopen(request, timeout=50000)  # 设置超时时间为 10 秒
        content = response.read().decode('utf-8')
        return content
    except URLError as e:
        print("URLError occurred:", e)
        return None

if __name__ == '__main__':
    start_page = int(input("起始页码："))
    end_page = int(input("结束页码："))
    ImgPath = []

    with open('pachong05.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['Title', 'Dimension', 'Inventory', 'Prvnc', 'Nation', 'Date', 'Name', 'Technique', 'Collection', 'Category', 'AntiqueImgPath']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for page in range(start_page, end_page + 1):
            request = create_request(page)
            content = get_content(request)
            if content is not None:
                obj = json.loads(content)

                title = jsonpath.jsonpath(obj, '$..es_title') or []
                dimension = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_dimension")][\u0023text]') or []
                inventory = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_inventory")][\u0023text]') or []
                prvnc = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_prvnc")][\u0023text]') or []
                nation = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_subcollection")][\u0023text]') or []
                date = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_date")][\u0023text]') or []
                name = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_name")][\u0023text]') or []
                technique = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_technique")][\u0023text]') or []
                collection = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_collection")][\u0023text]') or []
                category = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_category_main")][\u0023text]') or []

                for i in range(len(title)):
                    # 得到每个文物图片的路径
                    antiqueImgPath = 'https://hermitagemuseum.org/images/' + title[i][0] + '/' + title[i][1] + '/' + title[i] + '.s.jpg'
                    ImgPath.append(antiqueImgPath)

                for i in range(len(title)):
                    row = {
                        'Title': title[i] if i < len(title) else '',
                        'Dimension': dimension[i] if i < len(dimension) else '',
                        'Inventory': inventory[i] if i < len(inventory) else '',
                        'Prvnc': prvnc[i] if i < len(prvnc) else '',
                        'Nation': nation[i] if i < len(nation) else '',
                        'Date': date[i] if i < len(date) else '',
                        'Name': name[i] if i < len(name) else '',
                        'Technique': technique[i] if i < len(technique) else '',
                        'Collection': collection[i] if i < len(collection) else '',
                        'Category': category[i] if i < len(category) else '',
                        'AntiqueImgPath': ImgPath[i] if i < len(ImgPath) else ''
                    }
                    writer.writerow(row)
            else:
                print("Failed to fetch content for page", page)
'''
import csv
import json
import jsonpath
import urllib.request
from urllib.error import URLError
    #https://hermitagemuseum.org/api/v10/search?resultLang=en&queryLang=en&collection=mainweb|kamis|rooms|hermitage&query=china%20AND%20meta_authoring_template:(%22WOA%22)&pageSize=100&page=1&output=application/json
#创建请求连接
def create_request(page):
    url = "https://hermitagemuseum.org/api/v10/search?resultLang=en&queryLang=en&collection=mainweb|kamis|rooms|hermitage&query=china%20AND%20meta_authoring_template:(%22WOA%22)&pageSize=100&"
    url = url + 'page=' + str(page) + '&output=application/json'
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 SLBrowser/9.0.3.1311 SLBChan/103',
    }
    request = urllib.request.Request(url=url, headers=headers)
    return request
#获取网页信息
def get_content(request):
    try:
        response = urllib.request.urlopen(request, timeout=50)  # 设置超时时间为 10 秒
        content = response.read().decode('utf-8') # 获取到content内容，注意此时不是json格式
        return content

    except URLError as e:
        print("URLError occurred:", e)
        return None


if __name__ == '__main__':
    start_page = int(input("起始页码："))
    end_page = int(input("结束页码："))
    ImgPath = []

    with open('pachong1_20.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['Title', 'Dimension', 'Inventory', 'Prvnc', 'Nation', 'Date', 'Name', 'Technique', 'Collection', 'Category', 'AntiqueImgPath']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for page in range(start_page, end_page + 1):
            request = create_request(page)
            content = get_content(request)
            if content is not None:
                obj = json.loads(content) # 读取json格式数据
                title = jsonpath.jsonpath(obj, '$..es_title') or []
                dimension = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_dimension")][\u0023text]') or []
                inventory = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_inventory")][\u0023text]') or []
                prvnc = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_prvnc")][\u0023text]') or []
                nation = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_subcollection")][\u0023text]') or []
                date = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_date")][\u0023text]') or []
                name = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_name")][\u0023text]') or []
                technique = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_technique")][\u0023text]') or []
                collection = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_collection")][\u0023text]') or []
                category = jsonpath.jsonpath(obj, '$..[?(@.id=="meta_woa_category_main")][\u0023text]') or []

                # 注意清空ImgPath
                ImgPath.clear()
                for i in range(len(title)):
                    # 得到每个文物图片的路径
                    antiqueImgPath = 'https://hermitagemuseum.org/images/' + title[i][0] + '/' + title[i][1] + '/' + title[i] + '.s.jpg'
                    ImgPath.append(antiqueImgPath)

                for i in range(len(title)):
                    row = {
                        'Title': title[i] if i < len(title) else '',
                        'Dimension': dimension[i] if i < len(dimension) else '',
                        'Inventory': inventory[i] if i < len(inventory) else '',
                        'Prvnc': prvnc[i] if i < len(prvnc) else '',
                        'Nation': nation[i] if i < len(nation) else '',
                        'Date': date[i] if i < len(date) else '',
                        'Name': name[i] if i < len(name) else '',
                        'Technique': technique[i] if i < len(technique) else '',
                        'Collection': collection[i] if i < len(collection) else '',
                        'Category': category[i] if i < len(category) else '',
                        'AntiqueImgPath': ImgPath[i] if i < len(ImgPath) else ''
                    }
                    writer.writerow(row)
            else:
                print("Failed to fetch content for page", page)
                print("Error occurred at page", page)  # 输出错误页码
                break  # 在出现错误时停止循环
