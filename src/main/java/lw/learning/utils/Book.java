package lw.learning.utils;

import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-27 17:15:55
 **/
public class Book {

    public static final List<String> twoCities = FileOperation.readFile("a-tale-of-two-cities.txt");

    public static final String twoCitiesBook = "A Tale Of Two Cities";

    public static final List<String> prideAndPrejudice = FileOperation.readFile("pride-and-prejudice.txt");

    public static final String prideAndPrejudiceBook = "Pride And Prejudice";

}
