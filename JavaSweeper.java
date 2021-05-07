import java.awt.*;
import javax.swing.*;
import java.io.*;

public class JavaSweeper extends JFrame
{
    private JPanel panel;


    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;
    public static void main (String[] args)
    {
        new JavaSweeper(); 
    }
    private  JavaSweeper ()
    {
        initPanel();
        initFrame();
    }
    private void initFrame()
    {
        pack (); // изменяет размер контейнера такоим образом чтобы все помещалось
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //правильное закрытие окна
        setTitle("Canep");
        setLocationRelativeTo(null);//размещаем окно по центру
        setResizable (false); // запрещаем изменение размера окна
        setVisible(true);// сделать окно видимым
    }

    private void initPanel()
    {   

        panel = new JPanel()
        {
            @Override 
            protected void paintComponent (Graphics g)
            {
                super.paintComponent(g);
                g.drawImage( getImage("bomb"), 0, 0, this);
                g.drawImage( getImage("nobomb"), IMAGE_SIZE, 0, this);
                g.drawImage( getImage("num1"),  2 * IMAGE_SIZE , 0, this);
                g.drawImage( getImage("flaged"), 3  * IMAGE_SIZE , 0, this);
            }
        }; 
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE)); //задаем ей размер
        add (panel);
    }

    private Image getImage (String name)
    {
        String filename = "res/img/" + name.toLowerCase() + ".png"; 
        ImageIcon icon = new ImageIcon (getClass().getResource(filename));
        return icon.getImage();
    }

}
