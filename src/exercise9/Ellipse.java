package exercise9;

public class Ellipse {
  private Point startPoint;
  private double a;
  private double b;

  public Ellipse (){
    startPoint = new Point (0, 0);
    a=1;
    b=1;
  }
  public Ellipse (Point startPoint, double a, double b){
    this.startPoint = new Point (startPoint);
    this.a = a;
    this.b = b;
  }
  public Ellipse (Ellipse otherElipse) {
    startPoint = new Point (otherElipse.startPoint);
    a = otherElipse.a;
    b = otherElipse.b;
  }
  public boolean isValid(){
    return a > 0 && b > 0;
  }
  public void initialize(){
    do {
      startPoint.initialize();
      System.out.println ("Enter a: ");
      a = Utils.INPUT.nextDouble();
      System.out.println ("Enter b: ");
      b = Utils.INPUT.nextDouble();
    }
    while (!isValid());
  }
  public double calculatePerimeter(){
    return Math.PI * (3.0*(a+b) - Math.sqrt((3.0*a+b)*(a + 3.0*b)));
  }
  public double calculateArea (){
    return Math.PI * a *b;
  }
  public String getType (){
    return (a==b) ? "Cycle" : "Ellipse";
  }
  public String toString (){
    return String.format ("%s - [%s, %s], %s, P=%s, A=%s", startPoint, a, b, getType(), calculatePerimeter(), calculateArea());
  }
  public boolean equal (Ellipse otherElipse){
    boolean sameHeight = Utils.equals (a, otherElipse.a);
    boolean sameWidth = Utils.equals (b, otherElipse.b);
    boolean sameHeightReversed = Utils.equals (a, otherElipse.b);
    boolean sameWidthReversed = Utils.equals (b, otherElipse.a);
    return (sameHeight && sameWidth) || (sameHeightReversed && sameWidthReversed);
  }
}
