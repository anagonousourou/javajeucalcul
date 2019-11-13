package app;


class ResultatSession{
    private final int essais;
    private final int succes;
    private final boolean hasTried;
    ResultatSession(boolean hasTried,int essais,int succes){
        this.hasTried=hasTried;
        this.essais=essais;
        this.succes=succes;

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
}