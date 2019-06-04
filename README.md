# 英语四六级成绩查询

> 这个代码是我在2017年大二的时候写的，当时为了学习HttpPost，结果今天【2019年-6-4】又被考古了，整理了一下代码，方便后面留给儿子看。

# 代码解析
## 核心解析类，其实就是从成绩查询网站上获取到的数据提取出来，然后封装一个类接收
### 代码如下
```java
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/*
 * 封装的CET请求
 */
public class HttpCathcer {
	private static String url = "http://www.chsi.com.cn/cet/query?zkzh=NUM&xm=NAME";
	private static Map<String, String> header = new HashMap<String, String>();
	public  static Cet46 getCet46Score(String examNumber, String examName) {
		String result = "";
		Cet46 cet46 = new Cet46();
		url = url.replace("NAME", examName);
		url = url.replace("NUM", examNumber);
		header.put("Accept", "image/png, image/svg+xml, image/jxr, image/*; q=0.8, */*; q=0.5");
		header.put("Accept-Encoding", "gzip, deflate");
		header.put("Accept-Language", "zh-Hans-CN, zh-Hans; q=0.5");
		header.put("Connection", "Keep-Alive");
		header.put("Cookie", "AQAAAIhMp3BbugwAKRFC2uesy+2iO0Lw");
		header.put("Host", "www.chsi.com.cn");
		header.put("Referer", url);
		header.put("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393");
		try {
			Document html = Jsoup.connect(url).headers(header).get();
			result = html.text().substring(html.text().indexOf("结果 姓 名"), html.text().indexOf("口试成绩")).trim()
					.replace("：", "");
			String[] array = result.split(" ");
			cet46.setName(array[2]);
			cet46.setCertificateNumber(array[9]);
			cet46.setSchool(array[4]);
			cet46.setResult(array[11]);
			cet46.setType(array[6]);
			cet46.setListenScore(array[13]);
			cet46.setWrittingAndTranslatingScore(array[17]);
			cet46.setReadingScore(array[15]);
		} catch (Exception e) {
			System.err.println("[查询出错,请认真查看是否填写正确!]");
			System.exit(1);
		}
		return cet46;
	}
}

```
### 数据接收类
```java
public class Cet46 {
	private String name;
	private String school;
	private String type;
	private String listenScore;
	private String readingScore;
	private String writtingAndTranslatingScore;
	private String certificateNumber;
	private String result;
	public String toString() {
		return "{name='" + this.name + '\'' + ", school='" + this.school + '\'' + ", type='" + this.type + '\''
				+ ", listenScore='" + this.listenScore + '\'' + ", readingScore='" + this.readingScore + '\''
				+ ", writtingAndTranslatingScore='" + this.writtingAndTranslatingScore + '\'' + ", certificateNumber='"
				+ this.certificateNumber + '\'' + ", result='" + this.result + '\'' + '}';
	}

}


```

### 使用方法

```text
public static void main(String[] args) {
    Cet46 cet46 = HttpCathcer.getCet46Score("考号", "姓名");
    System.out.println(cet46);
}
```
