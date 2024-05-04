package E_App;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {
    private Image img;

    public ImagePanel(String imgPath) {
        URL imgUrl = getClass().getResource(imgPath);
        if (imgUrl != null) {
            try {
                this.img = ImageIO.read(imgUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Image not found: " + imgPath);
        }

        if (img != null) {
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
}