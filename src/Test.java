import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Test extends JFrame{

    private JLabel background, controlBackground;
    private JLabel test;
    private JTextField Player1Input;
    private JTextField Player2Input;
    private JButton submit;
    private Font Bebas;
    private Font LemonMilk;

    private JFrame controls;

    public Test() throws IOException {
        super("Thumbnail Generator");

        controls = new JFrame("Controls");
        //JPanel controlPanel = new JPanel();
        controlBackground = new JLabel();
        controlBackground.setBounds(0, 0, 400, 400);
        controls.add(controlBackground);

        controls.setSize(600, 400);

        try {
            Bebas = Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")).deriveFont(40f);
            LemonMilk = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilklight.otf")).deriveFont(12f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        BufferedImage myPicture = ImageIO.read(new File("Antibodied\\Background.png"));
        BufferedImage banPicture = ImageIO.read(new File("C:\\Users\\skyle\\Pictures\\Saved Pictures\\ban.png"));

        test = new JLabel(new ImageIcon(myPicture));
        test.setBounds(50,50, 200, 200);

        background = new JLabel(new ImageIcon(myPicture));

        Player1Input = new JTextField();
        Player1Input.setBounds(10,10,100,30);

        Player2Input = new JTextField();
        Player2Input.setBounds(290,10,100,30);

        submit = new JButton("Generate");
        submit.setBounds(10,50, 100, 30);

        JLabel Player1 = new JLabel("BONK! W");
        Player1.setForeground(Color.BLACK);
        Player1.setBounds(100, 100, 200, 60);
        Player1.setFont(Bebas);

        JLabel Player2 = new JLabel("CITADEL L");
        Player2.setForeground(Color.BLACK);
        Player2.setBounds(1100, 100, 200, 60);
        Player2.setFont(Bebas);

        add(background);
        controlBackground.add(Player1Input);
        controlBackground.add(Player2Input);
        controlBackground.add(submit);
        background.add(Player1);
        background.add(Player2);

        submit.addActionListener(e -> {
            Player1.setText(Player1Input.getText());
            Player2.setText(Player2Input.getText());
            makeScreenShot(this);
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1294, 757);
        setVisible(true);
        controls.setVisible(true);
        setLocationRelativeTo(null);

        /*BufferedImage bi = new BufferedImage(picLabel.getWidth(), picLabel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        //Graphics g = bi.createGraphics();
        //try {
        //    ImageIO.write(bi,"png",new File("test.png"));
        //}
        //catch (Exception e) {
        }
        */



    }

    public void makeScreenShot(Component component) {
        final JFrame f = new JFrame("Test Screenshot");
        BufferedImage img = getScreenShot(this.getContentPane());
        try {
            // write the image as a PNG
            ImageIO.write(img, "png", new File("screenshot.png"));
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

    public Container returnContainer() {
        return this.getContentPane();
    }

}
