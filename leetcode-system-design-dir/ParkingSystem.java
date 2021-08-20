class ParkingSystem {
    int big, bigCounter;
    int medium,mediumCounter;
    int small,smallCounter;
    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            if(big==bigCounter)
                return false;
            else 
                bigCounter++;
            return true;
        } 
        else if(carType==2){
            if(medium==mediumCounter)
                return false;
            else
                mediumCounter++;
            return true;
        } 
        else if(carType==3){
            if(small==smallCounter)
                return false;
            else
                smallCounter++;
            return true;
        } 
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
