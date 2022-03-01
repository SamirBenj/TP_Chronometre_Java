import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;

public class Chrono extends JFrame implements Runnable {
    Thread t;
    private int second;
    private int minute;
    private int milisecond;

    public Chrono(){
        this.second=0;
        this.milisecond=0;
        this.minute=0;
        setSize(500,500);
        setVisible(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width/2 - this.getWidth()/2,d.height/2 -this.getHeight()/2);
        t = new Thread(this);
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String S=minute+" m :"+ second+" s :"+milisecond+" mili";
        g.drawRect(50,100,400,200);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        g.setColor(new Color(255,45,0));
        g.drawString(S,110,200);

    }

    @Override
    public void run() {
         while (t!=null){
            try{
                t.sleep(200);
                if(milisecond>1000){
                    milisecond = 0;
                    second++;
                }
                if(second >60){
                    second =0;
                    minute++;
                }
                if(minute>60){
                    milisecond = 0;
                    second = 0;
                    minute =0;
                }
                milisecond++;
                repaint();
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        Chrono chrono = new Chrono();
    }

}
