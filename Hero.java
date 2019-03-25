import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;



public class Hero{
    public int xPos = 30;
    public int yPos = 30;
    // animation states
    public int state = 0;

    public BufferedImage image;
    public URL resource = getClass().getResource("run0.png");
    public Draw comp;
    public Hero(Draw comp){
        this.comp = comp;
        try{
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public Hero(Draw comp,int xPass, int yPass){
        xPos = xPass;
        yPos = yPass;
        this.comp = comp;

        try{
            image = ImageIO.read(resource);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public void reloadImage(){

        Thread threadx = new Thread(new Runnable(){
            public void run(){
                state++;

                if(state == 0){
                    resource = getClass().getResource("run0.png");
                }
                else if(state == 1){
                    resource = getClass().getResource("run1.png");
                }
                else if(state == 2){
                    resource = getClass().getResource("run2.png");
                }
                else if(state == 3){
                    resource = getClass().getResource("run3.png");
                }
                else if(state == 4){
                    resource = getClass().getResource("run4.png");
                }
                else if(state == 5){
                    resource = getClass().getResource("run5.png");
                    state = 0;
                }

                try{
                    image = ImageIO.read(resource);
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
        });
        threadx.start();
        
    }

    public void runLeft(){

        Thread threadx = new Thread(new Runnable(){
            public void run(){
                state++;

                if(state == 0){
                    resource = getClass().getResource("runLeft0.png");
                }
                else if(state == 1){
                    resource = getClass().getResource("runLeft1.png");
                }
                else if(state == 2){
                    resource = getClass().getResource("runLeft2.png");
                }
                else if(state == 3){
                    resource = getClass().getResource("runLeft3.png");
                }
                else if(state == 4){
                    resource = getClass().getResource("runLeft4.png");
                }
                else if(state == 5){
                    resource = getClass().getResource("runLeft5.png");
                    state = 0;
                }

                try{
                    image = ImageIO.read(resource);
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
        });
        threadx.start();
        
    }

    public void attack(){
        attackAnimation();
    }

    public void moveUp(){
        yPos = yPos - 5;
        reloadImage();
        comp.repaint();
    }

    public void moveDown(){
        yPos = yPos + 5;
        reloadImage();
        comp.repaint();
    }

    public void moveLeft(){
        xPos = xPos - 5;
        runLeft();
        comp.repaint();
    }

    public void moveRight(){
        xPos = xPos + 5;
        reloadImage();
        comp.repaint();
    }

    public void attackAnimation(){
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                for(int ctr = 0; ctr < 5; ctr++){
                    try {
                        if(ctr==4){
                            resource = getClass().getResource("run0.png");
                        }
                        else{
                            resource = getClass().getResource("attack"+ctr+".png");
                        }
                        
                        try{
                            image = ImageIO.read(resource);
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        comp.repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }

    
}