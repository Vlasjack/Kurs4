import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WindowOption implements ActionListener {
    ArrayList<String> List = new ArrayList<>();
    private String[] arr;
    JFrame frame = new JFrame("");
    WindowOption() {
        JButton button1 = new JButton("Проверка подключения к Интернету");
        button1.setLocation(50, 50);
        button1.setSize(450, 50);
        frame.add(button1);
     ActionListener actionListener1 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckI checki = new CheckI();
                String message= checki.CheckerI();
                List.add("1 " + message);
                JOptionPane.showMessageDialog(new JFrame(),message,"Наличие интернет соединения",JOptionPane.INFORMATION_MESSAGE);
                button1.setEnabled(false);
            }
        };
        button1.addActionListener(actionListener1);




        JButton button2 = new JButton("Проверка наличия установленного межсетевого экрана");
        button2.setLocation(50, 150);
        button2.setSize(450, 50);
        frame.add(button2);
        ActionListener actionListener2 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckF checkf = new CheckF();
                String message= checkf.CheckerF();
                List.add("2 " + message);
                JOptionPane.showMessageDialog(new JFrame(),message,"Наличие межсетевого экрана",JOptionPane.INFORMATION_MESSAGE);
                button2.setEnabled(false);
            }
        };
        button2.addActionListener(actionListener2);


        JButton button3 = new JButton("Проверка работоспособности межсетевого экрана");
        button3.setLocation(50, 250);
        button3.setSize(450, 50);
        frame.add(button3);
        ActionListener actionListener3 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckWF checkwf = new CheckWF();
                String message= checkwf.CheckerWF();
                List.add("3 " + message);
                JOptionPane.showMessageDialog(new JFrame(),message,"Работа межсетевого экрана",JOptionPane.INFORMATION_MESSAGE);
                button3.setEnabled(false);
            }
        };
        button3.addActionListener(actionListener3);


        JButton button4 = new JButton("Проверки наличия установленного антивируса.");
        button4.setLocation(50, 350);
        button4.setSize(450, 50);
        frame.add(button4);
        ActionListener actionListener4 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckA checka = new CheckA();
                String message= checka.CheckerA();
                List.add("4 " + message);
                JOptionPane.showMessageDialog(new JFrame(),message,"Наличие антивируса ",JOptionPane.INFORMATION_MESSAGE);
                button4.setEnabled(false);
            }

        };
        button4.addActionListener(actionListener4);


        JButton button5 = new JButton(" Проверки работоспособности антивирусного ПО.");
        button5.setLocation(50, 450);
        button5.setSize(450, 50);
        frame.add(button5);
        ActionListener actionListener5 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckWA checkwa = new CheckWA();
                String message= checkwa.CheckerWA();
                List.add("5 " + message);
                JOptionPane.showMessageDialog(new JFrame(),message,"Наличие работы антивирусного ПО",JOptionPane.INFORMATION_MESSAGE);
                button5.setEnabled(false);
            }
        };
        button5.addActionListener(actionListener5);

        JButton button6 = new JButton("Тестирование антивирусного ПО ");
        button6.setLocation(50, 550);
        button6.setSize(450, 50);
        frame.add(button6);
        ActionListener actionListener6 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckTA checkta = new CheckTA();
                String message= checkta.CheckerTA();
                List.add("6 " + message);
                JOptionPane.showMessageDialog(new JFrame(),message,"Тестирование антивирусного ПО",JOptionPane.INFORMATION_MESSAGE);
                button6.setEnabled(false);
            }
        };
        button6.addActionListener(actionListener6);

        JButton button7 = new JButton("Вывод результатов");
        button7.setLocation(50, 650);
        button7.setSize(450, 50);
        frame.add(button7);
            ActionListener actionListener7 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String[] arr = new String[6];
                    if (button1.isEnabled()) List.add("1 Интернет соединение не проверялось");
                    if (button2.isEnabled()) List.add("2 Наличие фаервола не проверялось");
                    if (button3.isEnabled())List.add("3 Проверка работы фаервола не проверялась");
                    if (button4.isEnabled())List.add("4 Наличие антивируса не проверялось");
                    if (button5.isEnabled()) List.add("5 Работа антивируса не проверялась");
                    if (button6.isEnabled()) List.add ("6 Тестирование антивируса не проводилось");
                    Collections.sort(List);
                    for (int i = 0; i < List.size(); i++) {
                        arr[i] = List.get(i);
                    }

                    JOptionPane.showMessageDialog(new JFrame(), new JList(arr), "Вывод результатов проверки", JOptionPane.INFORMATION_MESSAGE);
                    button7.setEnabled(false);
                }
            };
            button7.addActionListener(actionListener7);


        JButton button8 = new JButton("Сохранения результатов проверки");
        button8.setLocation(50, 750);
        button8.setSize(450, 50);
        frame.add(button8);
        ActionListener actionListener8 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!button7.isEnabled())
                {
                    String array = Arrays.toString(arr);
                    File file;
                    {
                        try {
                            file = new File("Results.txt");
                            if (file.createNewFile()) ;
                            Path path = Paths.get("C:/Users/Vlas/IdeaProjects/Kurs/Results.txt");
                            try {
                                Path writtenFilePath = Files.write(path, List);
                            } catch (Exception d) {
                                d.printStackTrace();
                            }
                            try {
                                if (Desktop.isDesktopSupported())
                                    Desktop.getDesktop().open(new File("C:/Users/Vlas/IdeaProjects/Kurs/Results.txt"));

                            } catch (IOException c) {
                            }
                        } catch (Exception a) {}}
                    button8.setEnabled(false);
                } else  JOptionPane.showMessageDialog(new JFrame(),"Ошибка, нет результатов","Сохранение результатов",JOptionPane.ERROR_MESSAGE);

            }
        };
        button8.addActionListener(actionListener8);

        ImageIcon reset = new ImageIcon("reset.jpg");

        JButton button9 = new JButton(reset);
        button9.setLocation(250, 850);
        button9.setIcon(reset);
        button9.setSize(52, 52);
        frame.add(button9);

        ActionListener actionListener9 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button9)
                {
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                    button5.setEnabled(true);
                    button6.setEnabled(true);
                    button7.setEnabled(true);
                    button8.setEnabled(true);
                    List.clear();
                }
            }
            };        button9.addActionListener(actionListener9);
        Image icon = Toolkit.getDefaultToolkit().getImage("mtusi.png");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Программа проверки информационной безопасности");
        frame.setIconImage(icon);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(560, 970);
        frame.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}