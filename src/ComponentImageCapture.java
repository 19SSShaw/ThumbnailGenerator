import java.awt.*;

import java.awt.image.BufferedImage;

import javax.swing.*;

import javax.imageio.ImageIO;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/**
 Create a screenshot of a component.
 @author Andrew Thompson
 */
class ComponentImageCapture {
    static BufferedImage retVal = null;
    static final String HELP =
            "Type Ctrl-0 to get a screenshot of the current GUI.\n" +
                    "The screenshot will be saved to the current " +
                    "directory as 'screenshot.png'.";

    public static void makeScreenShot(Component component) {
            final JFrame f = new JFrame("Test Screenshot");
            //BufferedImage img = new BufferedImage();
            try {
                // write the image as a PNG
               // ImageIO.write(img, "png", new File("screenshot.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static BufferedImage getScreenShot(Container component) {

        BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        // call the Component's paint method, using
        // the Graphics object of the image.
        component.paint( image.getGraphics() );
        return image;
    }

    public static void main(String[] args) {
        /*
        Runnable r = new Runnable() {
            public void run() {
                final JFrame f = new JFrame("Test Screenshot");
                 BufferedImage img = getScreenShot(f.getContentPane());
                 JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth(null)/2,img.getHeight(null)/2, Image.SCALE_SMOOTH ))));
                 try {
                     // write the image as a PNG
                     ImageIO.write(img, "png", new File("screenshot.png"));
                 } catch(Exception e) {
                     e.printStackTrace();
                 }
            }
        };
        SwingUtilities.invokeLater(r);*/
    }
}