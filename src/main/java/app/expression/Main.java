package app.expression;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Question q=new Question(new Random());
        System.out.println(q.newRandomExpression(4).apply());
        

    }
}