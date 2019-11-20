package app.expression;

public class Addition extends Opera{

    @Override
    public int apply() {
        return this.left.apply()+this.right.apply();
    }

    @Override
    public String toString() {
        String resultat="";
        if(left!=null){
            resultat+=left.toString();
        }
        resultat+=" + ";
        if(right!=null){
            resultat+=right.toString();
        }

        return resultat;
    }
    
}