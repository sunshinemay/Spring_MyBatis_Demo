package demo.util;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import freemarker.template.Template;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

public class GenerateSource {

    private final static String CODE_PATH = "src/main/java/";
    private final static String PACKAGE = "demo";
    private final static String DATABASE = "demo";
    private static final String PAGE_PATH = "src/main/webapp/";
    private static final String CONF_PATH = "src/main/resources/";
    private final static String PATH = CODE_PATH + PACKAGE.replace(".", "/");
    private final static String[] CODE_TPLS = {"Model", "Dao", "Dao.Impl", "Service", "Service.Impl", "Controller"};
    private final static String[] PAGE_TPLS = {"index", "add", "list", "edit"};
    private final static String[] CONF_TPLS = {"mapper"};
    private static String model;
    private static String pk;
    private static String properties;
    private static Scanner scanner = new Scanner(System.in);
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("freemarker.xml");

    public static void main(String[] args) throws Exception {
        input();
        for (String tpl : CODE_TPLS) {
            generate(tpl, "code");
        }
        for (String tpl : PAGE_TPLS) {
            generate(tpl, "page");
        }
        for (String tpl : CONF_TPLS) {
            generate(tpl, "conf");
        }
        System.out.println("done.");
    }

    public static void input() {
        System.out.println("input model class name, e.g:Person:");
        model = scanner.nextLine();
        System.out.println("input primary key type, e.g:Integer:");
        pk = scanner.nextLine();
        System.out.println("input properties, e.g:String name, :");
        properties = scanner.nextLine();
    }

    private static void generate(String tpl, String type) throws Exception {
        Map<String, String> hashMap = new LinkedHashMap<>();
        for (String kv : properties.split(", ")) {
            String[] strings = kv.split(" ");
            hashMap.put(strings[1], strings[0]);
        }
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("properties", hashMap);
        map.put("package", PACKAGE);
        map.put("model", model);
        map.put("PK", pk);
        map.put("db", DATABASE);

        File file = null;
        String name = null;
        switch (type) {
            case "page": {
                File path = new File(PAGE_PATH + model.toLowerCase());
                if (!path.exists()) {
                    System.out.println("make page directories..." + path.mkdir());
                }
                file = new File(path + "/" + tpl + ".jsp");
                name = "page/" + tpl + ".ftl";
                break;
            }
            case "code":
                file = new File(PATH + "/" + tpl.toLowerCase().replace('.', '/') + "/" + model + tpl.replace(".", "") + ".java");
                if (tpl.equals("Model")) {
                    file = new File(PATH + "/model/" + model + ".java");
                }
                name = "code/" + tpl + ".ftl";
                break;
            case "conf": {
                File path = new File(CONF_PATH + "mapper");
                if (!path.exists()) {
                    System.out.println("make conf directories..." + path.mkdir());
                }
                file = new File(path + "/" + model.toLowerCase() + "-mapper" + ".xml");
                name = "conf/" + tpl + ".ftl";
                break;
            }
        }
        Writer writer = null;
        if (file != null) {
            writer = new FileWriter(file);
        }
        FreeMarkerConfig freeMarkerConfig = applicationContext.getBean(FreeMarkerConfigurer.class);
        System.out.println("name: " + name);
        Template template = freeMarkerConfig.getConfiguration().getTemplate(name);
        template.process(map, writer);
        if (writer != null) {
            writer.close();
        }

        System.out.println("\t" + file + " \t generated!");
    }
}
