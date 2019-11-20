package app.expression;

import java.util.Random;

/**
 * La classe Question sera chargée d'
 */
public class Question{
    
    private Random rand;

    public Question(Random rand) {
        this.rand=rand;
    }
    public Opera newRandomExpression(int limit){
        Opera n=getRandomOperator();
        n.setLeft(new Value(rand.nextInt(limit)));
        n.setRight(new Value(rand.nextInt(limit)));

        return n;
    }

    private Opera getRandomOperator(){
        if(rand.nextInt(2)==1){
            return new Soustraction();
        }
        else{
            return new Addition();
        }
        
    }
}