/**
 * 计科2102 王彦鑫
 * 爬取博物馆数据的代码在test里 没注释的部分 其他的是个人练习乱写的代码 无任何关系 懒得删了
 */
package jsoup;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class JsoupFirstTest {
//    @Test
//    public void testUrl() throws Exception{
//        //解析URL地址，第一个参数是url，第二个是超时时间
//        Document doc = Jsoup.parse(new URL("https://www.itcast.cn"),1000);
//
//        //使用标签选择器，获取title标签中的内容
//        String title = doc.getElementsByTag("title").first().text();
//        System.out.println(title);
//    }
//
//    @Test
//    public void testString() throws Exception{
//        //使用工具类读取文件，获取字符串
//        String content = FileUtils.readFileToString(new File("C:\\Users\\27685\\Desktop\\test.html"), "utf8");
//        //解析字符串
//        Document doc = Jsoup.parse(content);
//
//        String title = doc.getElementsByTag("title").first().text();
//
//        System.out.println(title);
//    }
//
//    @Test
//    public void testFile() throws Exception{
//        //解析文件
//        Document doc = Jsoup.parse(new File("C:\\Users\\27685\\Desktop\\test.html"), "utf8");
//        String content = doc.getElementsByTag("title").first().text();
//        System.out.println(content);
//    }
//
//    @Test
//    public void testDom() throws Exception{
//        //解析文件获取documen对象
//        Document doc = Jsoup.parse(new File("C:\\Users\\27685\\Desktop\\test.html"), "utf-8");
//        //id
//        //Element element = doc.getElementById("time");
//        //System.out.println(element.text());
//
//        //标签
////        Element element = doc.getElementsByTag("strong").first();
////        System.out.println(element.text());
//
//        //class
//        //Element element = doc.getElementsByClass("class_a").first();
//
//        //属性
//        Element element = doc.getElementsByAttribute("abc").first();
//        System.out.println(element.text());
//    }
//
//    @Test
//    public void testData() throws Exception{
//        //解析文件，获取document
//        Document doc = Jsoup.parse(new File("C:\\Users\\27685\\Desktop\\test.html"), "utf8");
//
//        //根据id获取元素
//        Element element = doc.getElementById("plast");
//        String str = "";
//
//        //获取id
//        str = element.id();
//        str = element.className();
//        Attributes attributes = element.attributes();
//        System.out.println(attributes);
//
//        System.out.println(str);
//    }
//
//    @Test
//    //选择器
//    public void testSelector() throws Exception{
//        Document doc = Jsoup.parse(new File("C:\\Users\\27685\\Desktop\\test.html"), "utf8");
//        //通过标签选择元素
//        Elements elements = doc.select("span");
//        for (Element element : elements) {
//            System.out.println(element.text());
//        }
//
//        //通过 #id 查找
//        System.out.println(doc.select("#plast").first().text());
//
//        //通过 .class
//        System.out.println(doc.select(".class_a").first().text());
//
//        //通过属性 [abc]
//        System.out.println(doc.select("[abc]").first().text());
//
//        //通过属性值 [key=value]
//        System.out.println(doc.select("[abc=123]").first().text());
//    }
//
//    @Test //选择器组合
//    public void testSelector1() throws Exception{
//        Document doc = Jsoup.parse(new File("C:\\Users\\27685\\Desktop\\test.html"), "utf8");
//        //元素+属性
//        System.out.println(doc.select("p[abc]").first().text());
//
//        //父子关系查询所有     加空格
//        Elements elements = doc.select("#center p");
//        for (Element element : elements) {
//            System.out.println(element.text());
//        }
//
//        //查询直接子元素    >
//        //parent >* 查询父元素下的所有直接子元素
//
//    }

    @Test
    public void testShangHai(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // 创建 ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 创建 Set 存储所有内容
        Set<String> contentSet = new LinkedHashSet<>();

        // 爬取多页内容
        for (int page = 6501; page <= 7151; page++) {
            // 构建当前页的URL
            String url = "https://www.shanghaimuseum.net/mu/frontend/pg/lib1/antique?page=" + page +
                    "&viewType=list&libTypeSort=&libAgeSort=&libTypes=&libAges=&searchText=";

            // 打开页面
            driver.get(url);

            // 等待页面加载
            try {
                Thread.sleep(5000); // 等待5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 使用 Jsoup 解析页面内容
            Document doc = Jsoup.parse(driver.getPageSource());

            // 获取表格内容
            try{
                Element table = doc.select("table.layui-table").first(); // 获取第一个class为layui-table的表格
                Elements rows = table.select("tr"); // 获取所有行

                // 遍历表格内容并添加到 Set 中
                for (int i = 1; i < rows.size(); i++) { // 从第二行开始遍历，跳过标题行
                    Element row = rows.get(i);
                    if (row.text().contains("旧石器时代")|| row.text().contains("新石器时代")|| row.text().contains("夏")|| row.text().contains("商")|| row.text().contains("西周")|| row.text().contains("春秋")
                            || row.text().contains("战国")|| row.text().contains("秦")|| row.text().contains("汉")|| row.text().contains("三国")|| row.text().contains("晋")|| row.text().contains("南北朝")
                            || row.text().contains("隋")|| row.text().contains("唐")|| row.text().contains("五代十国")|| row.text().contains("辽")|| row.text().contains("宋")|| row.text().contains("西夏")
                            || row.text().contains("金")|| row.text().contains("元")|| row.text().contains("明")|| row.text().contains("清")|| row.text().contains("近代")|| row.text().contains("现代")) { // 只处理包含字符的行
                        Elements cells = row.select("td"); // 获取行中的所有单元格

                        // 用于存储当前行的内容
                        StringBuilder rowContent = new StringBuilder();

                        // 拼接当前行的内容
                        for (Element cell : cells) {
                            rowContent.append(cell.text()).append("\t");
                            System.out.println(cell.text());
                            Element link = cell.selectFirst("a");
                            if (link != null) {
                                //String href = "https://www.shanghaimuseum.net/mu/" + link.attr("href");
                                //String imageUrl = getImageUrl(driver, href);
                                String href = "无";
                                String imageUrl = "无";
                                rowContent.append(imageUrl).append("\t").append(href).append("\t");
                            }
                        }

                        // 添加内容到 Set 中
                        synchronized (contentSet) {
                            contentSet.add(rowContent.toString());
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        // 将爬取的数据保存到 Excel 表格中
        saveToExcel(contentSet);

         //输出所有内容
        for (String content : contentSet) {
            System.out.println(content);
        }

        // 关闭浏览器
        driver.quit();
    }

    // 爬取链接对应页面中的图片路径
    private static String getImageUrl(WebDriver driver, String href) {
        driver.get(href);

        try {
            Thread.sleep(500); // 等待0.5秒，可以根据实际情况调整等待时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(driver.getPageSource());
        Element img = doc.selectFirst("img[src^=upload]");
        return img != null ? "https://www.shanghaimuseum.net/mu/"+img.attr("src") : "无";
    }

    // 将爬取的数据保存到 Excel 表格中
    private static void saveToExcel(Set<String> contentSet) {
        // 创建工作簿和工作表
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Museum Data");

        // 创建标题行
        Row headerRow = sheet.createRow(0);
        String[] headers = {"藏品名称", "图片链接", "详情链接","时代", "类别"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // 写入数据行
        int rowNum = 1;
        for (String content : contentSet) {
            String[] data = content.split("\t");
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < data.length; i++) {
                row.createCell(i).setCellValue(data[i]);
            }
        }

        // 自动调整列宽
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // 保存文件
        try (FileOutputStream fileOut = new FileOutputStream("museum_data.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel 文件保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void HKMuseumTest() {
        // 设置 Chrome 驱动路径
        System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // 创建 Chrome 驱动
        WebDriver driver = new ChromeDriver();

        // 定义目标网址
        String url = "https://lingnancrf.ics.cuhk.edu.hk/ancient-books";

        List<String[]> res = new ArrayList<>();
        String[] table = {"藏品名称", "图片链接", "作者","时代", "卷數/冊數","刻本/抄本","尺寸","館藏號碼"};
        try {
            // 打开网页
            driver.get(url);

            // 等待页面加载完毕
            Thread.sleep(3000);

            // 初始化页面高度
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            // 模拟滚动加载直到页面底部
            while (true) {
              ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
              Thread.sleep(2000); // 等待页面加载
              long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
              if (newHeight == lastHeight) {
                  break;
              }
              lastHeight = newHeight;
            }

            // 获取网页源代码
            String html = driver.getPageSource();

            // 使用 Jsoup 解析 HTML
            Document document = Jsoup.parse(html);
            // 通过CSS选择器找到包含文物信息的元素
            Elements artifacts = document.select(".waterfall-item");
            //System.out.println(artifacts);

            // 遍历每个文物元素，提取信息并输出
            for (int i = 0; i < artifacts.size(); i++) {
                String[] info = {"null","null","null","null","null","null","null","null"};

                // 点击图片以获取作品信息
                WebElement image = driver.findElement(By.cssSelector(".waterfall-item:nth-of-type(" + (i + 1) + ") img"));
                Actions actions = new Actions(driver);
                actions.moveToElement(image).click().perform();
                Thread.sleep(2800); // 等待弹出窗口加载完毕
                try{
                    String worksInfoHtml0 = driver.findElement(By.cssSelector(".works-info")).getAttribute("outerHTML");
                    Document worksInfoDocument0 = Jsoup.parse(worksInfoHtml0);
                    Element element = worksInfoDocument0.getElementsByTag("img").first();
                    if(element!=null){
                        info[1] = element.attr("src");
                        System.out.println("url = " + element.attr("src"));
                    }
                    // 点击作品信息以展开作品信息
                    WebElement worksInfoButton = driver.findElement(By.xpath("//div[@class='toolbar']//div[@class='bar-item'][contains(text(),'作品信息')]"));
                    worksInfoButton.click();
                    Thread.sleep(1500); // 等待作品信息加载完毕

                    // 获取作品信息的HTML代码
                    String worksInfoHtml = driver.findElement(By.cssSelector(".works-info")).getAttribute("outerHTML");
                    // 使用 Jsoup 解析作品信息的HTML
                    Document worksInfoDocument = Jsoup.parse(worksInfoHtml);
                    // 获取作品信息的所有子元素
                    Elements worksInfoElements = worksInfoDocument.select(".works-info > *");

                    // 输出作品信息的所有子元素
                    for (Element worksInfoElement : worksInfoElements) {
                        Elements worksName = worksInfoElement.select(".work-name");
                        if(worksName.isEmpty()){
                            System.out.println("藏品 = null");
                        }else{
                            info[0] = worksName.select("h3").text();
                            System.out.println("藏品 = " + worksName.select("h3").text());
                        }
                        Elements author = worksInfoElement.select(".author");
                        if(author.isEmpty()){
                            System.out.println("作者 = null");
                        }else{
                            info[2] = author.select("p").text().replace("作者：","");
                            System.out.println("作者 = " + author.select("p").text().replace("作者：",""));
                        }
                        Elements era = worksInfoElement.select(".era");
                        if(era.isEmpty()){
                            System.out.println("年代 = null");
                        }else{
                            info[3] = era.select("p").text();
                            System.out.println("年代 = " + era.select("p").text());
                        }
                        Elements fieldItemElements = worksInfoElement.select(".field-item");
                        for (Element fieldItemElement : fieldItemElements) {
                            Elements fieldHeadings = fieldItemElement.select("h3");
                            Elements fieldValues = fieldItemElement.select("p,ol,span");
                            for (int j = 0; j < fieldHeadings.size(); j++) {
                                String fieldName = fieldHeadings.get(j).text();
                                String fieldValue = fieldValues.get(j).text();
                                for (int k = 0; k < table.length; k++) {
                                    if(fieldName.equals(table[k])){
                                        info[k] = fieldValue;
                                    }
                                }
                                System.out.println(fieldName + "=" + fieldValue);
                            }
                        }
                    }
                }catch(org.openqa.selenium.NoSuchElementException e){
                    System.out.println("error1");
                    e.printStackTrace();
                }finally {
                    res.add(info);
                    for (int i1 = 0; i1 < info.length; i1++) {
                        System.out.print(info[i1]+"\t");
                    }
                    System.out.println();
                    System.out.println("-----------------------");
                    // 返回到原来的页面
                    ((JavascriptExecutor) driver).executeScript("document.elementFromPoint(20, 20).click();");
                    Thread.sleep(500); // 等待返回到原来的页面
                }
            }
        } catch (Exception e) {
            System.out.println("error2");
            e.printStackTrace();
        } finally {
            try {
                writeDataToExcel(res, table, "output.xlsx");
                System.out.println("Excel 文件生成成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testtt() {
        List<String[]> res = new ArrayList<>();
        String[] table = {"藏品名称", "图片链接", "作者","时代", "卷數/冊數","刻本/抄本","尺寸","館藏號碼"};

        res.add(new String[]{"藏品1", "图片链接1", "作者1", "时代1", "1", "刻本", "100x200", "001"});
        res.add(new String[]{"藏品2", "图片链接2", "作者2", "时代2", "2", "抄本", "150x250", "002"});
        res.add(new String[]{"藏品3", "图片链接3", "作者3", "时代3", "3", "刻本", "200x300", "003"});

        try {
            writeDataToExcel(res, table, "output.xlsx");
            System.out.println("Excel 文件生成成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToExcel(List<String[]> data, String[] headers, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // 设置表头
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // 填充数据
        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            Row row = sheet.createRow(rowIndex + 1);
            String[] rowData = data.get(rowIndex);
            for (int cellIndex = 0; cellIndex < rowData.length; cellIndex++) {
                Cell cell = row.createCell(cellIndex);
                cell.setCellValue(rowData[cellIndex]);
            }
        }

        // 调整列宽
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // 写入文件
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        }

        // 关闭工作簿
        workbook.close();
    }
}
