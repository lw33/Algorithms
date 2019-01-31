package lw.learning.utils;

import lw.learning.ds.Graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @Author lw
 * @Date 2019-01-27 17:12:30
 **/
public class FileOperation {

    // 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
    public static List<String> readFile(String filename) {
        List<String> words = new ArrayList<>();
        if (filename == null) {
            System.out.println("filename is null or words is null");
            return words;
        }

        // 文件读取
        Scanner scanner = getScanner(filename);
        if (scanner == null)
            return words;

        // 简单分词
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }

        return words;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }

    private static Scanner getScanner(String filename) {
        if (filename == null) {
            System.out.println("filename is null or words is null");
            return null;
        }

        // 文件读取
        Scanner scanner;

        try {
            URL resource = FileOperation.class.getClassLoader().getResource(filename);
            File file = new File(resource.getFile());
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else
                return null;
        } catch (IOException ioe) {
            System.out.println("Cannot open " + filename);
            return null;
        }
        return scanner;
    }

    public static Graph readGrap(Class< ? extends Graph> graph, boolean directed, String filename)  {


        // 文件读取
        Scanner scanner = getScanner(filename);
        if (scanner == null)
            return null;

        String mateData = scanner.nextLine();
        String[] strs = mateData.split(" ");
        int n = Integer.parseInt(strs[0]);
        Graph g = null;
        try {
            g = graph.getDeclaredConstructor(int.class, boolean.class).newInstance(n, directed);
            while (scanner.hasNextLine()) {
                String edge = scanner.nextLine();
                String[] s = edge.split(" ");
                int v = Integer.parseInt(s[0]);
                int w = Integer.parseInt(s[1]);
                g.addEdge(v, w);
            }
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
