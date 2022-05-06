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
    private JLabel bar;
    private JLabel Player1, Player2, bottomTourneyName, smashLogo, tourneyNumber, date, VS, tourneyFormat, tourneyRound, topTourneyName, subtitle;
    private JLabel Player1Back, Player2Back;
    private JTextField Player1Input;
    private JTextField Player2Input;
    private JButton submit;
    private Font Bebas200, Bebas125, Bebas100, Bebas80, Bebas40, Bebas30;
    private Font LemonMilk40, LemonMilk20;

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
            Bebas200 = Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")).deriveFont(270f);
            Bebas125 = Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")).deriveFont(125f);
            Bebas100 = Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")).deriveFont(100f);
            Bebas80 = Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")).deriveFont(80f);
            Bebas40 = Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")).deriveFont(40f);
            Bebas30 = Font.createFont(Font.TRUETYPE_FONT, new File("BebasNeue-Regular.otf")).deriveFont(30f);
            LemonMilk40 = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilklight.otf")).deriveFont(40f);
            LemonMilk20 = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilklight.otf")).deriveFont(20f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        BufferedImage myPicture = ImageIO.read(new File("Antibodied\\Background.png"));
        BufferedImage blackBar = ImageIO.read(new File("Antibodied\\Rectangle.png"));
        BufferedImage logo = ImageIO.read(new File("Antibodied\\Smash Ultimate Logo.png"));
        BufferedImage Player1Img = ImageIO.read(new File("Antibodied\\Rectangle 3.png"));
        BufferedImage Player2Img = ImageIO.read(new File("Antibodied\\Rectangle 3 copy.png"));

        background = new JLabel(new ImageIcon(myPicture));

        bar = new JLabel(new ImageIcon(blackBar));
        bar.setBounds(0,660, 1280, 70);

        smashLogo = new JLabel(new ImageIcon(logo));
        smashLogo.setBounds(491, 590, 303, 130);

        Player1Back = new JLabel(new ImageIcon(Player1Img));
        Player1Back.setBounds(0, 440, 551, 92);

        Player2Back = new JLabel(new ImageIcon(Player2Img));
        Player2Back.setBounds(773, 440, 507, 92);

        Player1Input = new JTextField();
        Player1Input.setBounds(10,10,100,30);

        Player2Input = new JTextField();
        Player2Input.setBounds(290,10,100,30);

        submit = new JButton("Generate");
        submit.setBounds(10,50, 100, 30);


        bottomTourneyName = new JLabel("ANTIBODIED #");
        bottomTourneyName.setForeground(Color.WHITE);
        bottomTourneyName.setBounds(10,650, 300, 80);
        bottomTourneyName.setFont(LemonMilk40);

        date = new JLabel("11/20/2021");
        date.setForeground(Color.WHITE);
        date.setBounds(992, 663, 236, 52);
        date.setFont(LemonMilk40);

        VS = new JLabel("VS");
        VS.setForeground(Color.BLACK);
        VS.setBounds(520, 342, 222, 293);
        VS.setFont(Bebas200);

        tourneyFormat = new JLabel("Singles");
        tourneyFormat.setForeground(Color.BLACK);
        tourneyFormat.setBounds(509,180, 243, 94);
        tourneyFormat.setFont(Bebas80);

        tourneyRound = new JLabel("Grand Finals");
        tourneyRound.setForeground(Color.BLACK);
        tourneyRound.setBounds(447, 253, 392, 94);
        tourneyRound.setFont(Bebas80);

        topTourneyName = new JLabel("ANTIBODIED");
        topTourneyName.setForeground(Color.BLACK);
        topTourneyName.setBounds(388, 0, 508, 146);
        topTourneyName.setFont(Bebas125);

        subtitle = new JLabel("South Jersey SSBU Monthly");
        subtitle.setForeground(Color.BLACK);
        subtitle.setBounds(480, 115, 416, 50);
        subtitle.setFont(LemonMilk20);

        Player1 = new JLabel("YODA CAGE [W]");
        Player1.setForeground(Color.BLACK);
        Player1.setBounds(10, 440, 500, 100);
        Player1.setFont(Bebas100);

        Player2 = new JLabel("BEAST [L]");
        Player2.setForeground(Color.BLACK);
        Player2.setBounds(897, 440, 500, 100);
        Player2.setFont(Bebas100);

        add(background);
        controlBackground.add(Player1Input);
        controlBackground.add(Player2Input);
        controlBackground.add(submit);
        background.add(topTourneyName);
        background.add(subtitle);
        background.add(tourneyFormat);
        background.add(tourneyRound);
        background.add(VS);
        background.add(Player1);
        background.add(Player2);
        background.add(Player1Back);
        background.add(Player2Back);
        background.add(bottomTourneyName);
        background.add(smashLogo);
        background.add(date);
        background.add(bar);



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
