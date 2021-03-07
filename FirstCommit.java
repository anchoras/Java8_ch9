/*
    first commit for start new repository
*/

class TwoDShape {
    private double width;
    private double height;
    private String name;

    TwoDShape() {                   // default constructor
        width = height = 0.0;
        name = "none";
    }

    TwoDShape(double w, double h, String n) {
        width = w;
        height = h;
        name = n;
    }

    TwoDShape(double x, String n) {           // constructor for figure with even sides
        width = height = x;
        name = n;
    }

    TwoDShape(TwoDShape obj) {
        width = obj.width;
        height = obj.height;
        name = obj.name;
    }

    double getWidth() {
        return width;
    }
    double getHeight() {
        return height;
    }
    String getName() {
        return name;
    }

    void setWidth(double w) {
        width = w;
    }
    void setHeight(double h) {
        height = h;
    }
    void setName(String n) {
        name = n;
    }

    void showDim() {
        System.out.println("Width: " + width + "   Heigth: " + height);
    }
    void showName() {
        System.out.println("The figure's name is " + name);
    }

    double area() {
        System.out.println("This method should be overrided in subclasses");
        return 0.0;
    }
}

class Triangle extends TwoDShape {
    private String style;

    Triangle() {                                //default constructor
        super();
        style = "none";
    }

    Triangle (String s, double w, double h) {
        super(w, h, "Triangle");
        style = s;
    }

    Triangle (double x) {
        super(x, "Triangle");
        style = "Painted over";
    }

    Triangle (Triangle obj) {
        super(obj);
        style = obj.style;
    }

    double area() {
        return getWidth() * getHeight() /2;
    }

    void showStyle() {
        System.out.println("Triangle " + style);
    }
}

class Rectangle extends TwoDShape {
    private boolean isSquare;

    Rectangle() {
        super();
        isSquare = false;
    }

    Rectangle(double w, double h) {
        super(w, h, "Rectangle");
        if (w == h)
            isSquare = true;
        else
            isSquare = false;
    }

    Rectangle(double x) {
        super(x, "Rectangle");
        isSquare = true;
    }

    Rectangle(Rectangle obj) {
        super(obj);
        isSquare = obj.isSquare;
    }

    double area() {
        return getWidth() * getHeight();
    }

    void showIsSquare() {
        if (isSquare)
            System.out.println("This rectangle is square");
        else
            System.out.println("This rectangle is NOT square");
    }

}

class InheritanceDemo {
    public static void main(String args[]) {
        TwoDShape[] shapes = new TwoDShape[6];

        shapes[0] = new Triangle("contour", 8.0, 12.0);
        shapes[1] = new Rectangle(10);
        shapes[2] = new Rectangle(10, 4);
        shapes[3] = new Triangle(7.0);
        shapes[4] = new TwoDShape(10, 20, "some figure");
        shapes[5] = shapes[0];

        for(int i=0; i<shapes.length; i++) {
            System.out.println("Object -- " + shapes[i].getName());
            System.out.println("Area is: " + shapes[i].area());
            System.out.println();
        }
    }
}