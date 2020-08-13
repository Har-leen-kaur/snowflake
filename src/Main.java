import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // 1. Parameter ist die gewünschte Tiefe
        int depth = Integer.parseInt(args[0]);

        // Initialisiere Zeichenfläche, sodass die Schneeflocke
        //  gut sichtbar ist
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(-0.3, 1.3);

        // Definiere die Punkte eines gleichschenkligen Dreiecks ...
        double AX = 0.0;
        double AY = 0.0;

        double BX = 0.5;
        double BY = Math.sqrt(3) / 2;

        double CX = 1.0;
        double CY = 0.0;


        // ... rufe für jede Seite des Dreiecks die rekursive Funktion
        // zum Zeichnen der Kochkurve auf. Hierdurch entsteht dann eine
        // Schneeflocke
        zeichneKochKurve(depth, AX, AY, BX, BY);
        zeichneKochKurve(depth, BX, BY, CX, CY);
        zeichneKochKurve(depth, CX, CY, AX, AY);
    }


    public static void zeichneKochKurve(int tiefe, double x1, double y1, double x5, double y5) {
        // TODO: Implementieren Sie das Zeichnen der Koch-Kurve


/**
 * We use a total of 3 steps in making koch curve.
 * @param x2,y2 = coordinates of 1/3 of length of the line
 * @param x3,y3 = coordinates of the equilateral triangle top between coordinates x2 and x4
 * @param x4,y4 =  coordinates of 1/3 of length of the line
 */


        //Step 1 : Calculating the cooardinates for the middle triangles

        double x2, y2, x3, y3, x4, y4;

        x2 = x1 + (float) 1 / 3 * (x5 - x1);
        y2 = y1 + (float) 1 / 3 * (y5 - y1);
        x3 = (0.5 * (x1 + x5)) + (Math.sqrt(3) / 6) * (y1 - y5);
        y3 = (0.5 * (y1 + y5)) + (Math.sqrt(3) / 6) * (x5 - x1);
        x4 = x1 + (float) 2 / 3 * (x5 - x1);
        y4 = y1 + (float) 2 / 3 * (y5 - y1);


        if (tiefe == 0) {

            //Step 2: Draw a line from x1 to x5 when length is 0 so that we just have a triangle.
            StdDraw.line(x1, y1, x5, y5);
            return;


        } else if (tiefe > 0) {


            /* Step 3 : We call the recursive function so that when the height reaches 0, then
             *it starts working backwards and starts drawing the smallest line segments first.*/

            zeichneKochKurve(tiefe - 1, x1, y1, x2, y2);
            zeichneKochKurve(tiefe - 1, x2, y2, x3, y3);
            zeichneKochKurve(tiefe - 1, x3, y3, x4, y4);
            zeichneKochKurve(tiefe - 1, x4, y4, x5, y5);

        }

    }
}


