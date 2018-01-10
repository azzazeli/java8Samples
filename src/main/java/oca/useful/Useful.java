package oca.useful;

public interface Useful {
    void beUseful();

    static Useful getOne(int costLimit){
        if( costLimit > 10 ){
            return new ExpensiveUseful();
        }
        else return new CheapUseful();
    }
}
