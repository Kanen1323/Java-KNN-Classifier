import java.util.*;


public class Classification {



    private   double[] dany;
    private String type;

    private double distance;

    public Classification(double[] dany, String type) {
        this.dany = dany;
        this.type = type;
    }


    @Override
    public String toString() {
        return "dany=" + Arrays.toString(dany) +
                ", type='" + type ;
    }

    public double[] getDany() {
        return dany;
    }

    public String getType() {
        return type;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static  void sort( List<Classification> classifications ){

        Comparator<Classification> comparator = Comparator.comparing(Classification::getDistance) ;


        Collections.sort(classifications,comparator);

    }

}