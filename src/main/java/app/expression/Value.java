package app.expression;

public class Value extends Opera{

    private int valeur;
    @Override
    public int apply() {
        return valeur;
    }

    Value(int value){
        this.valeur=value;

    }

    @Override
    public void setLeft(Opera left) {
        
    }

    @Override
    public void setRight(Opera right) {
        
    }
    

    @Override
    public String toString() {
        return ""+valeur;
    }
}