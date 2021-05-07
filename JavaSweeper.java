import java.awt.*;
import javax.swing.*;
import java.io.*;

public class JavaSweeper extends JFrame
{
    private JPanel panel;


    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;
    public static void main (String[] args)
    {
        new JavaSweeper(); 
    }
    private  JavaSweeper ()
    {   Ranges.setSize (new Coord (COLS, ROWS)); //можно убрать упростив себе жизнь 
        setImages();
        initPanel();
        initFrame();
    }
    private void initFrame()
    {
        pack(); // изменяет размер контейнера такоим образом чтобы все помещалось
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //правильное закрытие окна
        setTitle("Canep");
        setLocationRelativeTo(null);//размещаем окно по центру
        setResizable (false); // запрещаем изменение размера окна
        setVisible(true);// сделать окно видимым
        setIconImage (getImage("icon"));
    }

    private void initPanel()
    {   

        panel = new JPanel()
        {
            @Override 
            protected void paintComponent (Graphics g)
            {   
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords())
                {
                    g.drawImage((Image)Box.bomb.image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
            }
        }; 
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE)); //задаем ей размер
        add (panel);
    }


    private void setImages()
    {
       for (Box box : Box.values())
       {
           box.image = getImage(box.name());
       } 
    }
    private Image getImage (String name)
    {
        String filename = "res/img/" + name.toLowerCase() + ".png"; 
        ImageIcon icon = new ImageIcon (getClass().getResource(filename));
        return icon.getImage();
    }

}
