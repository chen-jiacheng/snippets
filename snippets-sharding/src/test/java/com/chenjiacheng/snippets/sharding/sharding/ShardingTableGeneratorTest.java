package com.chenjiacheng.snippets.sharding.sharding;

import org.apache.commons.text.StringSubstitutor;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chenjiacheng on 2024/2/5 23:27
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class ShardingTableGeneratorTest {

    public static void main(String[] args) throws IOException {
        String fileName = "user.sharding";
        String template = loadTemplate(fileName);

        List<String> sqls = generatorSql(template, DateShardingAlgorithm.DAY.getPattern());

        BufferedWriter writer = new BufferedWriter(new FileWriter("./" + fileName + ".sql"));
        for (String sql : sqls) {
            writer.write(sql);
            writer.newLine();
            writer.flush();
        }
        writer.close();

    }

    private static String loadTemplate(String path) throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String template = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        reader.close();
        return template;
    }

    private static List<String> generatorSql(String template, String pattern) {
        List<String> sqls = new ArrayList<>();

        Map<String, String> params = new HashMap<>();
        StringSubstitutor substitutor = new StringSubstitutor(params);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        for (int month = 1; month <= 12; month++) {
            calendar.set(Calendar.MONTH,month-1);
            int maxDay = calendar.getMaximum(Calendar.DAY_OF_MONTH);
            for (int day = 1; day <= maxDay; day++) {
                String value = "" + year + (month < 10 ? "0" + month : month) + (day < 10 ? "0" + day : day);
                params.put("pattern",value);
                String result = substitutor.replace(template);
                sqls.add(result);
            }

        }
        return sqls;
    }



     enum DateShardingAlgorithm {
        DAY("yyyyMMdd", "日表"),
        MONTY("yyyyMM", "月表"),
        YEAR("yyyy", "年表"),
        ;
        private String pattern;
        private String message;

        DateShardingAlgorithm(String pattern, String message) {
            this.pattern = pattern;
            this.message = message;
        }

        public String getPattern() {
            return pattern;
        }

        public String getMessage() {
            return message;
        }
    }



}
