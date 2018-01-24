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
        GradientPaint gp = new GradientPaint(30, 30, Color.white, 0, 0, Color.lightGray, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.darkGray);
        g.setFont(new Font("Courier", Font.LAYOUT_NO_LIMIT_CONTEXT, 30));
        g.drawString("Car Rental Office Application", 220,this.getHeight()/2);
        g.drawImage(image, 150, this.getHeight()/2-40, null);
    }
}
