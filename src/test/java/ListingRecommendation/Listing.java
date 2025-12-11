package ListingRecommendation;

public class Listing {
    int xCoordinate;
    int yCoordinate;
    int distance_squared;

    public Listing(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        distance();
    }

    public int distance(){
        this.distance_squared = (this.xCoordinate * this.xCoordinate) + (this.yCoordinate * this.yCoordinate);
        return this.distance_squared;
    }

}
