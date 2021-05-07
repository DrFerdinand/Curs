import java.awt.Dimension;

import javax.swing.*;

public class JavaSweeper extends JFrame
{
    private JPanel panel;

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
        panel = new JPanel(); //создаем новую панелъ
        panel.setPreferredSize(new Dimension(500, 500)); //задаем ей размер
        add (panel);
    }


}
