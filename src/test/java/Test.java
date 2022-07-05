import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:mzq
 * @DATE:2019/8/2717:37
 * @VERSION:1.0.0
 */

public class Test {
    public static void main(String[] args) throws IOException {
        String cmd = "cmd "+"/c "+"ipconfig/all";
        Process process = Runtime.getRuntime().exec(cmd);
        Scanner scanner = new Scanner(process.getInputStream());

        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }



    public void test2() {
        //动态配置短信模板内容！
        try {
            Map<String, String> map = new HashMap<String, String>();
            //volity
            //短信模板
            String templateString = "${username}/zhangsan";
            Template t = new Template("name1", new StringReader(templateString), new Configuration());

            //具体填充内容
            map.put("username", "lisi");
            StringWriter result = new StringWriter();
            t.process(map, result);
            System.out.println(result.toString());
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
