import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    
    /**
     * Metodo para crear tantas bolas como se elija de manera random
     */
    public void bounce(int numberOfBalls){
        int ground = 400;   
        myCanvas.setVisible(true);
        
        
        
        
        
        
        myCanvas.drawLine(50, ground, 550, ground);

        ArrayList<BouncingBall> balls = new ArrayList<>(); //Arraylist para guardar las bolas
        Random rnd = new Random();
        int radio;
        int rColor;
        int gColor;
        int bColor;
        int ejex;
        int ejey;
        
        for (int i = 0; i < numberOfBalls; i++) { //Creara tantas bolas como numero de bolas dando radio color y posicion aleatorias
            radio = rnd.nextInt(50);
            rColor = rnd.nextInt(255);
            gColor = rnd.nextInt(255);
            bColor = rnd.nextInt(255);
            ejex = rnd.nextInt(70);
            ejey = rnd.nextInt(70);       

            balls.add(new BouncingBall(ejex, ejey, radio, new Color(rColor,gColor,bColor), ground, myCanvas));
            balls.get(i).draw();
        }
        boolean finished =  false;
        while(!finished) { //Si ninguaa se has salido repite todo hasta que suceda
            myCanvas.wait(50);
            for (int i = 0; i < numberOfBalls; i++) { //Por cada bola se movera la posicion
                balls.get(i).move(); 
                if(balls.get(i).getXPosition() >= 550) { //Con esto comprobamos cuando alguna de las bolas se ha salido
                    finished = true;
                }
            }
           
        }
    }
    /**
     * 
     */
    public void boxBounce()
    {
        int ground = 450;
        myCanvas.drawLine(10,10,10,450);    //Borde izquierdo del rectángulo.
        myCanvas.drawLine(550,10,550,450);  //Borde derecho del rectángulo.
        myCanvas.drawLine(10,10,550,10);    //Borde superior del rectángulo.
        myCanvas.drawLine(10,450,550,450);  //Borde inferior del rectángulo.
        myCanvas.setVisible(true);
        
       
    }
   
    }
    
    
    
