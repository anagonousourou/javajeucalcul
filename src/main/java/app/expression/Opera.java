package app.expression;

public abstract class Opera {

    protected Opera left;
    protected Opera right;
    abstract public int apply();

    public Opera getLeft() {
        return left;
    }

    public void setLeft(Opera left) {
        this.left = left;
    }

    public Opera getRight() {
        return right;
    }

    public void setRight(Opera right) {
        this.right = right;
    }
    
    
    
    
}