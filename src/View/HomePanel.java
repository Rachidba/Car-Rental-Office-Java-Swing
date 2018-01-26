package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HomePanel extends JPanel {
    public static BufferedImage image;

    public HomePanel ()
    {
        super();
        try
        {
            image = ImageIO.read(new File("png/racing.png"));
        }
        catch (IOException e)
        {
            //Not handled.
        }
    }
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.white, 0, 15, Color.lightGray, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        Font f = new Font("Tahoma", Font.PLAIN, 20);
        Color c = new Color (193, 73, 13);
        Font ff = new Font("Tahoma", Font.PLAIN, 40);
        Color cc = new Color(66, 134, 244);
        Font fff = new Font("Tahoma", Font.PLAIN, 9);
        Color ccc = Color.DARK_GRAY;
        g.setColor(cc);
        g.setFont(ff);
        g.drawImage(image, 150, this.getHeight()/2-40, null);
        g.drawString("Cars Rental System", 220,this.getHeight()/2);
        g.setColor(c);
        g.setFont(f);
        g.drawString("Car Rental Office Application", 440,this.getHeight()/2+40);
        g.setColor(ccc);
        g.setFont(fff);
        g.drawString("Copyright © 2017, 2018 ILISI and/or its affiliates. All rights reserved.", this.getWidth()/4*3-90,this.getHeight()-10);
    }
}
