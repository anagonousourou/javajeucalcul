package app;

/**
 * @author ANAGONOU Patrick
 */
class ResultatSession{
    private final int essais;
    private final int succes;
    private final boolean hasTried;
    private int tempsPasse;
    ResultatSession(boolean hasTried,int essais,int succes,int tempsPasse){
        this.hasTried=hasTried;
        this.essais=essais;
        this.succes=succes;
        this.tempsPasse=tempsPasse;

    }

    public int getEssais() {
        return essais;
    }
 

    public int getSucces() {
        return succes;
    }

    public boolean isHasTried() {
        return hasTried;
    }

    public double getScore(){
        
        return ((double)succes/(tempsPasse/10));

    }
}