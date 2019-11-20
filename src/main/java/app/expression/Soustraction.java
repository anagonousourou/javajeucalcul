package app.expression;

public class Soustraction extends Opera {

    @Override
    public int apply() {
        return this.left.apply()-this.left.apply();
    }
    

    @Override
    public String toString() {
        String resultat="";
        if(left!=null){
            resultat+=left.toString();
        }
        resultat+=" - ";
        if(right!=null){
            resultat+=right.toString();
        }

        return resultat;
    }
}