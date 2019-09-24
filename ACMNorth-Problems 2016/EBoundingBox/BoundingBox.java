import java.awt.geom.Point2D;
import java.util.Scanner;

/**
 * Created by dpotikan on 22/07/2016.
 */
public class BoundingBox {

    private static Point2D p1, p2;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int j=0; j<cases; j++) {
            p1 = new Point2D.Double(100.0,-100.0);
            p2 = new Point2D.Double(-100.0,100.0);

            while(true) {

                String shape = sc.nextLine();
                shape = shape.toLowerCase();
                //System.out.println(shape);

                if (shape.startsWith("0"))
                    break;
                else if (shape.startsWith("c"))
                    addCircle(shape);
                else if (shape.startsWith("r"))
                    addRectangle(shape);
                else if (shape.startsWith("l"))
                    addLine(shape);
            }

            System.out.println(p1.getX() + "," + p1.getY());
            System.out.println(p2.getX() + "," + p2.getY());
        }
        sc.close();
    }

    private static void calculateBB(Point2D r1, Point2D r2) {
        // calculate new top-left coordinate
        if (p1.getX()>r1.getX())
            p1.setLocation(r1.getX(),p1.getY());
        if (p1.getY()<r1.getY())
            p1.setLocation(p1.getX(),r1.getY());

        // calculate new bottom-right coordinate
        if (p2.getX()<r2.getX())
            p2.setLocation(r2.getX(),p2.getY());
        if (p2.getY()>r2.getY())
            p2.setLocation(p2.getX(),r2.getY());

    }

    private static void addLine(String shape) {
        Scanner s = new Scanner(shape);
        s.next();

        double p1x = s.nextDouble(), p1y = s.nextDouble(), p2x = s.nextDouble(), p2y = s.nextDouble();
        double x1 = (p1x<p2x)?p1x:p2x, y1 = (p1y>p2y)?p1y:p2y;          // finding top-left
        double x2 = (p1x>p2x)?p1x:p2x, y2 = (p1y<p2y)?p1y:p2y;          // finding bottom-right
        Point2D p1 = new Point2D.Double(x1,y1);
        Point2D p2 = new Point2D.Double(x2,y2);

        calculateBB(p1,p2);
    }

    private static void addRectangle(String shape) {
        // String pattern: r x y width height
        Scanner s = new Scanner(shape);
        s.next();

        //System.out.println (s.nextDouble()+" "+s.nextDouble()+" "+s.nextDouble()+" "+s.nextDouble());

        Point2D r1 = new Point2D.Double(s.nextDouble(),s.nextDouble());                         // get top-left
        Point2D r2 = new Point2D.Double(r1.getX()+s.nextDouble(), r1.getY()-s.nextDouble());    // get bottom-right

        calculateBB(r1,r2);
    }

    private static void addCircle(String shape) {
        // String pattern: c x y radius
        Scanner s = new Scanner(shape);
        s.next();

        //System.out.println (s.nextDouble()+" "+s.nextDouble()+" "+s.nextDouble());

        double cx = s.nextDouble(), cy = s.nextDouble(), r = s.nextDouble();
        Point2D c1 = new Point2D.Double(cx-r,cy+r);     // get top-left
        Point2D c2 = new Point2D.Double(cx+r,cy-r);     // get bottom-right

        calculateBB(c1,c2);
    }

}
