public class Square {
    private float side;
    public Square(float side) {
        this.side = side;
    }
    public float getSide() {
        return side;
    }
    public void setSide(float side) {
        this.side = side;
    }
    public void displaySide(){
        System.out.println("Side : " + side);
    }
    public void displayParameter(){
        float parameter = side * 4;
        System.out.println("Parameter : " + parameter);
    }
    public void displayArea(){
        float area = side * side;
        System.out.println("Area : " + area);
    }
    public void displayAll(){
        float area = side * side;
        float parameter = side * 4;
        System.out.println("Side : " + side);
        System.out.println("Parameter: " + parameter);
        System.out.println("Area: " + area);
    }}
