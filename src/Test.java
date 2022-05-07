import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Test extends JFrame{

    private JLabel background, controlBackground;
    private JLabel bar;
    private JLabel Player1, Player2, bottomTourneyName, smashLogo, date, VS, tourneyFormat, tourneyRound, topTourneyName, subtitle;
    private JLabel Player1Back, Player2Back;
    private JLabel Player1Img1, Player1Img2, Player2Img1, Player2Img2;
    private JLabel Player1Label, Player2Label, dateLabel, formatLabel, roundLabel, numberLabel, Player1Char1Label, Player1Char2Label, Player2Char1Label, Player2Char2Label;
    private JTextField Player1Input, Player2Input, dateInput, formatInput, roundInput, numberInput;
    private JComboBox Player1Char1, Player1Char2, Player2Char1, Player2Char2;
    private String allCharacters[] = new String[663];
    private JButton submit;
    private Font Bebas200, Bebas125, Bebas100, Bebas80, Bebas40, Bebas30;
    private Font LemonMilk40, LemonMilk20;

    private JFrame controls;

    public Test() throws IOException {
        super("Thumbnail Generator");
        //Load character names into the array allCharacters
        allCharacters = initCharacters();

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
        BufferedImage Yoda1 = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr - Morton.png"));
        BufferedImage Beast1 = ImageIO.read(new File("SSBU Character Renders\\For Player 2\\PT - Charizard Default.png"));

        Yoda1 = scale1(Yoda1, 0.5);
        Beast1 = scale1(Beast1, 0.8);
        Player1Img1 = new JLabel(new ImageIcon(Yoda1));
        Player1Img1.setBounds(-110, 114, 760, 700);

        Player2Img1 = new JLabel(new ImageIcon(Beast1));
        Player2Img1.setBounds(666, 0, 760, 720);

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
        Player1Input.setBounds(10,40,100,30);

        Player1Label = new JLabel("Player 1 Name: ");
        Player1Label.setBounds(10, 10, 100, 30);

        Player2Input = new JTextField();
        Player2Input.setBounds(290,40,100,30);

        Player2Label = new JLabel("Player 2 Name: ");
        Player2Label.setBounds(290, 10, 100, 30);

        formatInput = new JTextField();
        formatInput.setBounds(10, 90, 100, 30);

        formatLabel = new JLabel("Tournament Format: ");
        formatLabel.setBounds(10, 60, 200, 30);

        roundInput = new JTextField();
        roundInput.setBounds(290, 90, 100, 30);

        roundLabel = new JLabel("Current Round: ");
        roundLabel.setBounds(290, 60, 200, 30);

        numberInput = new JTextField();
        numberInput.setBounds(10, 140, 100, 30);

        numberLabel = new JLabel("Tournament Number: ");
        numberLabel.setBounds(10, 110, 200, 30);

        dateInput = new JTextField();
        dateInput.setBounds(290, 140, 100, 30);

        dateLabel = new JLabel("Date of Tournament: ");
        dateLabel.setBounds(290, 110, 200, 30);

        Player1Char1 = new JComboBox(allCharacters);
        Player1Char1.setBounds(10, 190, 200, 30);

        Player1Char1Label = new JLabel("Player 1 Character 1");
        Player1Char1Label.setBounds(10, 160, 200, 30);

        Player1Char2 = new JComboBox(allCharacters);
        Player1Char2.setBounds(10, 240, 200, 30);

        Player1Char2Label = new JLabel("Player 1 Character 2");
        Player1Char2Label.setBounds(10, 215, 200, 30);

        Player2Char1 = new JComboBox(allCharacters);
        Player2Char1.setBounds(290, 190, 200, 30);

        Player2Char1Label = new JLabel("Player 2 Character 1");
        Player2Char1Label.setBounds(290, 160, 200, 30);

        Player2Char2 = new JComboBox(allCharacters);
        Player2Char2.setBounds(290, 240, 200, 30);

        Player2Char2Label = new JLabel("Player 2 Character 2");
        Player2Char2Label.setBounds(290, 215, 200, 30);

        submit = new JButton("Generate");
        submit.setBounds(10,280, 100, 30);


        bottomTourneyName = new JLabel("ANTIBODIED #3");
        bottomTourneyName.setForeground(Color.WHITE);
        bottomTourneyName.setBounds(10,650, 400, 80);
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

        tourneyRound = new JLabel("Grand Finals", SwingConstants.CENTER);
        tourneyRound.setForeground(Color.BLACK);
        tourneyRound.setBounds(-40, 253, 1280, 94);
        tourneyRound.setFont(Bebas80);

        topTourneyName = new JLabel("ANTIBODIED");
        topTourneyName.setForeground(Color.BLACK);
        topTourneyName.setBounds(388, 0, 508, 146);
        topTourneyName.setFont(Bebas125);

        subtitle = new JLabel("South Jersey SSBU Monthly");
        subtitle.setForeground(Color.BLACK);
        subtitle.setBounds(480, 115, 416, 50);
        subtitle.setFont(LemonMilk20);

        Player1 = new JLabel("YODA CAGE [W]", SwingConstants.CENTER);
        Player1.setForeground(Color.BLACK);
        Player1.setBounds(10, 440, 480, 100);
        Player1.setFont(Bebas100);

        Player2 = new JLabel("BEAST [L]", SwingConstants.CENTER);
        Player2.setForeground(Color.BLACK);
        Player2.setBounds(800, 440, 507, 100);
        Player2.setFont(Bebas100);

        controlBackground.add(Player1Label);
        controlBackground.add(Player2Label);
        controlBackground.add(formatLabel);
        controlBackground.add(roundLabel);
        controlBackground.add(numberLabel);
        controlBackground.add(dateLabel);
        controlBackground.add(Player1Input);
        controlBackground.add(Player2Input);
        controlBackground.add(formatInput);
        controlBackground.add(roundInput);
        controlBackground.add(numberInput);
        controlBackground.add(dateInput);
        controlBackground.add(Player1Char1);
        controlBackground.add(Player1Char1Label);
        controlBackground.add(Player1Char2);
        controlBackground.add(Player1Char2Label);
        controlBackground.add(Player2Char1);
        controlBackground.add(Player2Char1Label);
        controlBackground.add(Player2Char2);
        controlBackground.add(Player2Char2Label);
        controlBackground.add(submit);

        add(background);
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
        background.add(Player1Img1);
        background.add(Player2Img1);



        submit.addActionListener(e -> {
            Player1.setText(Player1Input.getText());
            Player2.setText(Player2Input.getText());
            tourneyFormat.setText(formatInput.getText());
            tourneyRound.setText(roundInput.getText());
            bottomTourneyName.setText("ANTIBODIED #" + numberInput.getText());
            date.setText(dateInput.getText());
            Player1Img1.setIcon(new ImageIcon(chooseCharToLoad(Player1Char1.getSelectedItem().toString(), 1)));
            Player2Img1.setIcon(new ImageIcon(chooseCharToLoad(Player2Char1.getSelectedItem().toString(), 2)));
            makeScreenShot(this);
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1294, 757);
        setVisible(true);
        controls.setVisible(true);
        setLocationRelativeTo(null);
    }

    private BufferedImage chooseCharToLoad(String name, int player) {
        BufferedImage image = null;
        try {
            if(player == 1) {
                if(name == "Mario 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - Default.png"));
                if(name == "Mario 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - America.png"));
                if(name == "Mario 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - Blue.png"));
                if(name == "Mario 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - Brown.png"));
                if(name == "Mario 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - Green.png"));
                if(name == "Mario 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - Purple.png"));
                if(name == "Mario 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - Builder.png"));
                if(name == "Mario 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Mario - Wedding.png"));
                if(name == "Olimar 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Olimar - Default.png"));
                if(name == "Olimar 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Olimar - Red.png"));
                if(name == "Olimar 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Olimar - Green.png"));
                if(name == "Olimar 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Olimar - White.png"));
                if(name == "Olimar 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Alph - Default.png"));
                if(name == "Olimar 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Alph - Green.png"));
                if(name == "Olimar 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Alph - Pink.png"));
                if(name == "Olimar 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Alph - Red.png"));
                if(name == "Banjo 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - Default.png"));
                if(name == "Banjo 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - Pink.png"));
                if(name == "Banjo 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - Black.png"));
                if(name == "Banjo 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - Purple.png"));
                if(name == "Banjo 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - White.png"));
                if(name == "Banjo 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - Yellow.png"));
                if(name == "Banjo 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - Blue.png"));
                if(name == "Banjo 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Banjo - Zombie.png"));
                if(name == "Bayonetta 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - Default.png"));
                if(name == "Bayonetta 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - Alt Default.png"));
                if(name == "Bayonetta 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - Yellow.png"));
                if(name == "Bayonetta 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - Green.png"));
                if(name == "Bayonetta 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - Red.png"));
                if(name == "Bayonetta 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - Alt Red.png"));
                if(name == "Bayonetta 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - White.png"));
                if(name == "Bayonetta 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bayo - Alt Blue.png"));
                if(name == "Bowser 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Default.png"));
                if(name == "Bowser 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Dark.png"));
                if(name == "Bowser 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Yellow.png"));
                if(name == "Bowser 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Green.png"));
                if(name == "Bowser 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Grey.png"));
                if(name == "Bowser 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Melon.png"));
                if(name == "Bowser 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Red.png"));
                if(name == "Bowser 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser - Blue.png"));
                if(name == "Bowser Jr. 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Default.png"));
                if(name == "Bowser Jr. 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Larry.png"));
                if(name == "Bowser Jr. 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Roy.png"));
                if(name == "Bowser Jr. 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Wendy.png"));
                if(name == "Bowser Jr. 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Iggy.png"));
                if(name == "Bowser Jr. 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Morton.png"));
                if(name == "Bowser Jr. 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Lemmy.png"));
                if(name == "Bowser Jr. 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Bowser Jr. - Ludwig.png"));
                if(name == "Byleth 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Default.png"));
                if(name == "Byleth 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Alt Default.png"));
                if(name == "Byleth 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Blue.png"));
                if(name == "Byleth 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Alt Red.png"));
                if(name == "Byleth 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Yellow.png"));
                if(name == "Byleth 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Alt Green.png"));
                if(name == "Byleth 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Black.png"));
                if(name == "Byleth 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Byleth - Alt Black.png"));
                if(name == "Captain Falcon 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Default.png"));
                if(name == "Captain Falcon 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Black.png"));
                if(name == "Captain Falcon 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Red.png"));
                if(name == "Captain Falcon 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Green.png"));
                if(name == "Captain Falcon 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Alt Blue.png"));
                if(name == "Captain Falcon 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Pink.png"));
                if(name == "Captain Falcon 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Gold.png"));
                if(name == "Captain Falcon 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Captain Falcon - Blue.png"));
                if(name == "Chrom 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - Default.png"));
                if(name == "Chrom 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - Red.png"));
                if(name == "Chrom 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - Green.png"));
                if(name == "Chrom 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - Yellow.png"));
                if(name == "Chrom 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - Brown.png"));
                if(name == "Chrom 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - Purple.png"));
                if(name == "Chrom 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - White.png"));
                if(name == "Chrom 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Chrom - Black.png"));
                if(name == "Cloud 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Default.png"));
                if(name == "Cloud 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Alt Default.png"));
                if(name == "Cloud 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Blue.png"));
                if(name == "Cloud 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Alt Blue.png"));
                if(name == "Cloud 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Red.png"));
                if(name == "Cloud 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Black.png"));
                if(name == "Cloud 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Yellow.png"));
                if(name == "Cloud 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Cloud - Purple.png"));
                if(name == "Corrin 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Default.png"));
                if(name == "Corrin 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Alt Default.png"));
                if(name == "Corrin 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Red.png"));
                if(name == "Corrin 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Alt Orange.png"));
                if(name == "Corrin 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Blue.png"));
                if(name == "Corrin 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Alt Pink.png"));
                if(name == "Corrin 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Green.png"));
                if(name == "Corrin 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Corrin - Alt Black.png"));
                if(name == "Daisy 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - Default.png"));
                if(name == "Daisy 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - Green.png"));
                if(name == "Daisy 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - RedWhite.png"));
                if(name == "Daisy 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - Blue.png"));
                if(name == "Daisy 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - RedBlack.png"));
                if(name == "Daisy 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - Purple.png"));
                if(name == "Daisy 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - White.png"));
                if(name == "Daisy 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Daisy - Black.png"));
                if(name == "Dark Pit 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - Default.png"));
                if(name == "Dark Pit 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - Green.png"));
                if(name == "Dark Pit 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - BlackRed.png"));
                if(name == "Dark Pit 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - Yellow.png"));
                if(name == "Dark Pit 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - Red.png"));
                if(name == "Dark Pit 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - Blue.png"));
                if(name == "Dark Pit 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - White.png"));
                if(name == "Dark Pit 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Pit - Purple.png"));
                if(name == "Dark Samus 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - Default.png"));
                if(name == "Dark Samus 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - Green.png"));
                if(name == "Dark Samus 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - Purple.png"));
                if(name == "Dark Samus 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - Red.png"));
                if(name == "Dark Samus 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - Yellow.png"));
                if(name == "Dark Samus 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - White.png"));
                if(name == "Dark Samus 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - Black.png"));
                if(name == "Dark Samus 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dark Samus - Pink.png"));
                if(name == "Diddy 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - Default.png"));
                if(name == "Diddy 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - Yellow.png"));
                if(name == "Diddy 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - Pink.png"));
                if(name == "Diddy 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - Purple.png"));
                if(name == "Diddy 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - Green.png"));
                if(name == "Diddy 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - Blue.png"));
                if(name == "Diddy 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - Brown.png"));
                if(name == "Diddy 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Diddy - White.png"));
                if(name == "Donkey Kong 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - Default.png"));
                if(name == "Donkey Kong 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - Black.png"));
                if(name == "Donkey Kong 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - Red.png"));
                if(name == "Donkey Kong 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - Purple.png"));
                if(name == "Donkey Kong 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - Green.png"));
                if(name == "Donkey Kong 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - White.png"));
                if(name == "Donkey Kong 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - Yellow.png"));
                if(name == "Donkey Kong 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Donkey Kong - Pink.png"));
                if(name == "Dr. Mario 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Default.png"));
                if(name == "Dr. Mario 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Red.png"));
                if(name == "Dr. Mario 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Blue.png"));
                if(name == "Dr. Mario 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Green.png"));
                if(name == "Dr. Mario 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Black.png"));
                if(name == "Dr. Mario 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Yellow.png"));
                if(name == "Dr. Mario 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Purple.png"));
                if(name == "Dr. Mario 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Dr. Mario - Pink.png"));
                if(name == "Duck Hunt 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Default.png"));
                if(name == "Duck Hunt 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Black.png"));
                if(name == "Duck Hunt 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Light Brown.png"));
                if(name == "Duck Hunt 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Brown.png"));
                if(name == "Duck Hunt 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Dalmation.png"));
                if(name == "Duck Hunt 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Red.png"));
                if(name == "Duck Hunt 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Yellow.png"));
                if(name == "Duck Hunt 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Duck Hunt - Dark Brown.png"));
                if(name == "Falco 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - Default.png"));
                if(name == "Falco 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - Orange.png"));
                if(name == "Falco 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - Blue.png"));
                if(name == "Falco 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - Pink.png"));
                if(name == "Falco 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - Green.png"));
                if(name == "Falco 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - Black.png"));
                if(name == "Falco 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - White.png"));
                if(name == "Falco 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Falco - Purple.png"));
                if(name == "Fox 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - Default.png"));
                if(name == "Fox 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - Black.png"));
                if(name == "Fox 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - Pink.png"));
                if(name == "Fox 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - Green.png"));
                if(name == "Fox 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - Orange.png"));
                if(name == "Fox 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - White.png"));
                if(name == "Fox 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - Yellow.png"));
                if(name == "Fox 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Fox - Alt Wolf.png"));
                if(name == "Ganondorf 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Default.png"));
                if(name == "Ganondorf 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Purple.png"));
                if(name == "Ganondorf 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Blue.png"));
                if(name == "Ganondorf 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Green.png"));
                if(name == "Ganondorf 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Dark Purple.png"));
                if(name == "Ganondorf 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Pink.png"));
                if(name == "Ganondorf 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Dark.png"));
                if(name == "Ganondorf 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ganondorf - Green Skin.png"));
                if(name == "GnW 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - Default.png"));
                if(name == "GnW 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - Red.png"));
                if(name == "GnW 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - Yellow.png"));
                if(name == "GnW 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - Blue.png"));
                if(name == "GnW 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - Teal.png"));
                if(name == "GnW 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - Mint.png"));
                if(name == "GnW 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - Green.png"));
                if(name == "GnW 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\GnW - White.png"));
                if(name == "Greninja 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - Default.png"));
                if(name == "Greninja 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - Red.png"));
                if(name == "Greninja 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - Pink.png"));
                if(name == "Greninja 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - Black.png"));
                if(name == "Greninja 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - Purple.png"));
                if(name == "Greninja 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - Green.png"));
                if(name == "Greninja 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - White.png"));
                if(name == "Greninja 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Greninja - Dark Purple.png"));
                if(name == "Hero 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Hero - Default.png"));
                if(name == "Hero 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Hero - Erdrick.png"));
                if(name == "Hero 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Hero - Solo.png"));
                if(name == "Hero 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Hero - Eight.png"));
                if(name == "Ice Climbers 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - Default.png"));
                if(name == "Ice Climbers 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - Light Blue Pair.png"));
                if(name == "Ice Climbers 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - Green.png"));
                if(name == "Ice Climbers 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - Blue Pair.png"));
                if(name == "Ice Climbers 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - Red.png"));
                if(name == "Ice Climbers 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - Brown.png"));
                if(name == "Ice Climbers 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - White.png"));
                if(name == "Ice Climbers 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ice Climbers - Orange.png"));
                if(name == "Ike 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - Default.png"));
                if(name == "Ike 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - Alt Default.png"));
                if(name == "Ike 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - Purple.png"));
                if(name == "Ike 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - Alt Red.png"));
                if(name == "Ike 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - Green.png"));
                if(name == "Ike 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - Alt Green.png"));
                if(name == "Ike 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - White.png"));
                if(name == "Ike 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ike - Alt Black.png"));
                if(name == "Incineroar 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - Default.png"));
                if(name == "Incineroar 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - Green.png"));
                if(name == "Incineroar 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - BlackRed.png"));
                if(name == "Incineroar 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - Blue.png"));
                if(name == "Incineroar 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - Orange.png"));
                if(name == "Incineroar 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - Purple.png"));
                if(name == "Incineroar 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - Black.png"));
                if(name == "Incineroar 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Incineroar - WhtieRed.png"));
                if(name == "Inkling 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Orange.png"));
                if(name == "Inkling 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Blue.png"));
                if(name == "Inkling 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Yellow.png"));
                if(name == "Inkling 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Green.png"));
                if(name == "Inkling 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Pink.png"));
                if(name == "Inkling 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Hipster.png"));
                if(name == "Inkling 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Purple.png"));
                if(name == "Inkling 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Inkling - Dark Purple.png"));
                if(name == "Isabelle 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabell - Default.png"));
                if(name == "Isabelle 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabell - Orange.png"));
                if(name == "Isabelle 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabell - Pink.png"));
                if(name == "Isabelle 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabell - Red.png"));
                if(name == "Isabelle 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabell - Purple.png"));
                if(name == "Isabelle 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabell - Green.png"));
                if(name == "Isabelle 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabell Grey.png"));
                if(name == "Isabelle 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Isabelle - Light Blue.png"));
                if(name == "Jigglypuff 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Default.png"));
                if(name == "Jigglypuff 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Flower.png"));
                if(name == "Jigglypuff 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Poke Hat.png"));
                if(name == "Jigglypuff 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Sombrero.png"));
                if(name == "Jigglypuff 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Sleep Cap.png"));
                if(name == "Jigglypuff 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Ribbon.png"));
                if(name == "Jigglypuff 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Nurse Joy.png"));
                if(name == "Jigglypuff 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Jigglypuff - Kalos Hat.png"));
                if(name == "Joker 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - Default.png"));
                if(name == "Joker 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - Purple.png"));
                if(name == "Joker 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - Blue.png"));
                if(name == "Joker 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - Yellow.png"));
                if(name == "Joker 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - Red.png"));
                if(name == "Joker 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - White.png"));
                if(name == "Joker 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - Alt Default.png"));
                if(name == "Joker 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Joker - Alt White.png"));
                if(name == "Kazuya 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kazuya - default.png"));
                if(name == "Kazuya 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kazuya - Alt Default.png"));
                if(name == "Ken 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - Default.png"));
                if(name == "Ken 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - Black.png"));
                if(name == "Ken 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - Purple.png"));
                if(name == "Ken 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - White.png"));
                if(name == "Ken 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - Green.png"));
                if(name == "Ken 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - Yellow.png"));
                if(name == "Ken 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - Blue.png"));
                if(name == "Ken 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Ken - Alt Violent Ken.png"));
                if(name == "King DeDeDe 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - Default.png"));
                if(name == "King DeDeDe 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - Pink.png"));
                if(name == "King DeDeDe 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - BlueOrange.png"));
                if(name == "King DeDeDe 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - Yellow.png"));
                if(name == "King DeDeDe 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - Light Blue.png"));
                if(name == "King DeDeDe 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - Grey.png"));
                if(name == "King DeDeDe 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - White.png"));
                if(name == "King DeDeDe 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King DeDeDe - Purple.png"));
                if(name == "King K. Rool 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - Default.png"));
                if(name == "King K. Rool 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - Red.png"));
                if(name == "King K. Rool 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - Blue.png"));
                if(name == "King K. Rool 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - Yellow.png"));
                if(name == "King K. Rool 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - Pink.png"));
                if(name == "King K. Rool 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - Black.png"));
                if(name == "King K. Rool 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - Maroon.png"));
                if(name == "King K. Rool 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\King K. Rool - White.png"));
                if(name == "Kirby 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - Default.png"));
                if(name == "Kirby 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - Yellow.png"));
                if(name == "Kirby 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - Blue.png"));
                if(name == "Kirby 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - Red.png"));
                if(name == "Kirby 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - Green.png"));
                if(name == "Kirby 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - White.png"));
                if(name == "Kirby 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - Orange.png"));
                if(name == "Kirby 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Kirby - Black.png"));
                if(name == "Link 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - Default.png"));
                if(name == "Link 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - Alt Green.png"));
                if(name == "Link 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - Red.png"));
                if(name == "Link 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - Alt Diety.png"));
                if(name == "Link 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - Blue.png"));
                if(name == "Link 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - Alt Default.png"));
                if(name == "Link 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - White.png"));
                if(name == "Link 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Link - Alt Dark Link.png"));
                if(name == "Little Mac 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - Default.png"));
                if(name == "Little Mac 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - Yellow.png"));
                if(name == "Little Mac 3")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - White.png"));
                if(name == "Little Mac 4")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - Blue.png"));
                if(name == "Little Mac 5")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - Alt Blonde.png"));
                if(name == "Little Mac 6")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - Alt Pink.png"));
                if(name == "Little Mac 7")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - Alt Wire.png"));
                if(name == "Little Mac 8")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 1\\Little Mac - Alt Green.png"));

            }
            else if(player == 2) {
                if(name == "Mario 1")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 2\\Mario - Default.png"));
                if(name == "Mario 2")
                    image = ImageIO.read(new File("SSBU Character Renders\\For Player 2\\Mario - America.png"));
                if(name == "Mario 3")
                    System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = scale1(image, 0.5);
        JLabel retLabel = new JLabel(new ImageIcon(image));

        return image;
    }

    private String[] initCharacters() {
        String characters[] = {
                "Mario 1",
                "Mario 2",
                "Mario 3",
                "Mario 4",
                "Mario 5",
                "Mario 6",
                "Mario 7",
                "Mario 8",
                "Donkey Kong 1",
                "Donkey Kong 2",
                "Donkey Kong 3",
                "Donkey Kong 4",
                "Donkey Kong 5",
                "Donkey Kong 6",
                "Donkey Kong 7",
                "Donkey Kong 8",
                "Link 1",
                "Link 2",
                "Link 3",
                "Link 4",
                "Link 5",
                "Link 6",
                "Link 7",
                "Link 8",
                "Samus 1",
                "Samus 2",
                "Samus 3",
                "Samus 4",
                "Samus 5",
                "Samus 6",
                "Samus 7",
                "Samus 8",
                "Dark Samus 1",
                "Dark Samus 2",
                "Dark Samus 3",
                "Dark Samus 4",
                "Dark Samus 5",
                "Dark Samus 6",
                "Dark Samus 7",
                "Dark Samus 8",
                "Yoshi 1",
                "Yoshi 2",
                "Yoshi 3",
                "Yoshi 4",
                "Yoshi 5",
                "Yoshi 6",
                "Yoshi 7",
                "Yoshi 8",
                "Kirby 1",
                "Kirby 2",
                "Kirby 3",
                "Kirby 4",
                "Kirby 5",
                "Kirby 6",
                "Kirby 7",
                "Kirby 8",
                "Fox 1",
                "Fox 2",
                "Fox 3",
                "Fox 4",
                "Fox 5",
                "Fox 6",
                "Fox 7",
                "Fox 8",
                "Pikachu 1",
                "Pikachu 2",
                "Pikachu 3",
                "Pikachu 4",
                "Pikachu 5",
                "Pikachu 6",
                "Pikachu 7",
                "Pikachu 8",
                "Luigi 1",
                "Luigi 2",
                "Luigi 3",
                "Luigi 4",
                "Luigi 5",
                "Luigi 6",
                "Luigi 7",
                "Luigi 8",
                "Ness 1",
                "Ness 2",
                "Ness 3",
                "Ness 4",
                "Ness 5",
                "Ness 6",
                "Ness 7",
                "Ness 8",
                "Captain Falcon 1",
                "Captain Falcon 2",
                "Captain Falcon 3",
                "Captain Falcon 4",
                "Captain Falcon 5",
                "Captain Falcon 6",
                "Captain Falcon 7",
                "Captain Falcon 8",
                "Jigglypuff 1",
                "Jigglypuff 2",
                "Jigglypuff 3",
                "Jigglypuff 4",
                "Jigglypuff 5",
                "Jigglypuff 6",
                "Jigglypuff 7",
                "Jigglypuff 8",
                "Peach 1",
                "Peach 2",
                "Peach 3",
                "Peach 4",
                "Peach 5",
                "Peach 6",
                "Peach 7",
                "Peach 8",
                "Daisy 1",
                "Daisy 2",
                "Daisy 3",
                "Daisy 4",
                "Daisy 5",
                "Daisy 6",
                "Daisy 7",
                "Daisy 8",
                "Bowser 1",
                "Bowser 2",
                "Bowser 3",
                "Bowser 4",
                "Bowser 5",
                "Bowser 6",
                "Bowser 7",
                "Bowser 8",
                "Ice Climbers 1",
                "Ice Climbers 2",
                "Ice Climbers 3",
                "Ice Climbers 4",
                "Ice Climbers 5",
                "Ice Climbers 6",
                "Ice Climbers 7",
                "Ice Climbers 8",
                "Sheik 1",
                "Sheik 2",
                "Sheik 3",
                "Sheik 4",
                "Sheik 5",
                "Sheik 6",
                "Sheik 7",
                "Sheik 8",
                "Zelda 1",
                "Zelda 2",
                "Zelda 3",
                "Zelda 4",
                "Zelda 5",
                "Zelda 6",
                "Zelda 7",
                "Zelda 8",
                "Dr. Mario 1",
                "Dr. Mario 2",
                "Dr. Mario 3",
                "Dr. Mario 4",
                "Dr. Mario 5",
                "Dr. Mario 6",
                "Dr. Mario 7",
                "Dr. Mario 8",
                "Pichu 1",
                "Pichu 2",
                "Pichu 3",
                "Pichu 4",
                "Pichu 5",
                "Pichu 6",
                "Pichu 7",
                "Pichu 8",
                "Falco 1",
                "Falco 2",
                "Falco 3",
                "Falco 4",
                "Falco 5",
                "Falco 6",
                "Falco 7",
                "Falco 8",
                "Marth 1",
                "Marth 2",
                "Marth 3",
                "Marth 4",
                "Marth 5",
                "Marth 6",
                "Marth 7",
                "Marth 8",
                "Lucina 1",
                "Lucina 2",
                "Lucina 3",
                "Lucina 4",
                "Lucina 5",
                "Lucina 6",
                "Lucina 7",
                "Lucina 8",
                "Young Link 1",
                "Young Link 2",
                "Young Link 3",
                "Young Link 4",
                "Young Link 5",
                "Young Link 6",
                "Young Link 7",
                "Young Link 8",
                "Ganondorf 1",
                "Ganondorf 2",
                "Ganondorf 3",
                "Ganondorf 4",
                "Ganondorf 5",
                "Ganondorf 6",
                "Ganondorf 7",
                "Ganondorf 8",
                "Mewtwo 1",
                "Mewtwo 2",
                "Mewtwo 3",
                "Mewtwo 4",
                "Mewtwo 5",
                "Mewtwo 6",
                "Mewtwo 7",
                "Mewtwo 8",
                "Roy 1",
                "Roy 2",
                "Roy 3",
                "Roy 4",
                "Roy 5",
                "Roy 6",
                "Roy 7",
                "Roy 8",
                "Chrom 1",
                "Chrom 2",
                "Chrom 3",
                "Chrom 4",
                "Chrom 5",
                "Chrom 6",
                "Chrom 7",
                "Chrom 8",
                "GnW 1",
                "GnW 2",
                "GnW 3",
                "GnW 4",
                "GnW 5",
                "GnW 6",
                "GnW 7",
                "GnW 8",
                "Meta Knight 1",
                "Meta Knight 2",
                "Meta Knight 3",
                "Meta Knight 4",
                "Meta Knight 5",
                "Meta Knight 6",
                "Meta Knight 7",
                "Meta Knight 8",
                "Pit 1",
                "Pit 2",
                "Pit 3",
                "Pit 4",
                "Pit 5",
                "Pit 6",
                "Pit 7",
                "Pit 8",
                "Dark Pit 1",
                "Dark Pit 2",
                "Dark Pit 3",
                "Dark Pit 4",
                "Dark Pit 5",
                "Dark Pit 6",
                "Dark Pit 7",
                "Dark Pit 8",
                "ZSS 1",
                "ZSS 2",
                "ZSS 3",
                "ZSS 4",
                "ZSS 5",
                "ZSS 6",
                "ZSS 7",
                "ZSS 8",
                "Wario 1",
                "Wario 2",
                "Wario 3",
                "Wario 4",
                "Wario 5",
                "Wario 6",
                "Wario 7",
                "Wario 8",
                "Snake 1",
                "Snake 2",
                "Snake 3",
                "Snake 4",
                "Snake 5",
                "Snake 6",
                "Snake 7",
                "Snake 8",
                "Ike 1",
                "Ike 2",
                "Ike 3",
                "Ike 4",
                "Ike 5",
                "Ike 6",
                "Ike 7",
                "Ike 8",
                "PT 1",
                "PT 2",
                "PT 3",
                "PT 4",
                "PT 5",
                "PT 6",
                "PT 7",
                "PT 8",
                "PT-Char",
                "PT-Ivy",
                "PT-Squ",
                "PT-Trainer",
                "Diddy 1",
                "Diddy 2",
                "Diddy 3",
                "Diddy 4",
                "Diddy 5",
                "Diddy 6",
                "Diddy 7",
                "Diddy 8",
                "Lucas 1",
                "Lucas 2",
                "Lucas 3",
                "Lucas 4",
                "Lucas 5",
                "Lucas 6",
                "Lucas 7",
                "Lucas 8",
                "Sonic 1",
                "Sonic 2",
                "Sonic 3",
                "Sonic 4",
                "Sonic 5",
                "Sonic 6",
                "Sonic 7",
                "Sonic 8",
                "King DeDeDe 1",
                "King DeDeDe 2",
                "King DeDeDe 3",
                "King DeDeDe 4",
                "King DeDeDe 5",
                "King DeDeDe 6",
                "King DeDeDe 7",
                "King DeDeDe 8",
                "Olimar 1",
                "Olimar 2",
                "Olimar 3",
                "Olimar 4",
                "Olimar 5",
                "Olimar 6",
                "Olimar 7",
                "Olimar 8",
                "Lucario 1",
                "Lucario 2",
                "Lucario 3",
                "Lucario 4",
                "Lucario 5",
                "Lucario 6",
                "Lucario 7",
                "Lucario 8",
                "R.O.B 1",
                "R.O.B 2",
                "R.O.B 3",
                "R.O.B 4",
                "R.O.B 5",
                "R.O.B 6",
                "R.O.B 7",
                "R.O.B 8",
                "Toon Link 1",
                "Toon Link 2",
                "Toon Link 3",
                "Toon Link 4",
                "Toon Link 5",
                "Toon Link 6",
                "Toon Link 7",
                "Toon Link 8",
                "Wolf 1",
                "Wolf 2",
                "Wolf 3",
                "Wolf 4",
                "Wolf 5",
                "Wolf 6",
                "Wolf 7",
                "Wolf 8",
                "Villager 1",
                "Villager 2",
                "Villager 3",
                "Villager 4",
                "Villager 5",
                "Villager 6",
                "Villager 7",
                "Villager 8",
                "Mega Man 1",
                "Mega Man 2",
                "Mega Man 3",
                "Mega Man 4",
                "Mega Man 5",
                "Mega Man 6",
                "Mega Man 7",
                "Mega Man 8",
                "Wii Fit 1",
                "Wii Fit 2",
                "Wii Fit 3",
                "Wii Fit 4",
                "Wii Fit 5",
                "Wii Fit 6",
                "Wii Fit 7",
                "Wii Fit 8",
                "Rosalina 1",
                "Rosalina 2",
                "Rosalina 3",
                "Rosalina 4",
                "Rosalina 5",
                "Rosalina 6",
                "Rosalina 7",
                "Rosalina 8",
                "Little Mac 1",
                "Little Mac 2",
                "Little Mac 3",
                "Little Mac 4",
                "Little Mac 5",
                "Little Mac 6",
                "Little Mac 7",
                "Little Mac 8",
                "Greninja 1",
                "Greninja 2",
                "Greninja 3",
                "Greninja 4",
                "Greninja 5",
                "Greninja 6",
                "Greninja 7",
                "Greninja 8",
                "Mii Brawler",
                "Mii Gunner 1",
                "Mii Gunner - Sans",
                "Palutena 1",
                "Palutena 2",
                "Palutena 3",
                "Palutena 4",
                "Palutena 5",
                "Palutena 6",
                "Palutena 7",
                "Palutena 8",
                "Pac-Man 1",
                "Pac-Man 2",
                "Pac-Man 3",
                "Pac-Man 4",
                "Pac-Man 5",
                "Pac-Man 6",
                "Pac-Man 7",
                "Pac-Man 8",
                "Robin 1",
                "Robin 2",
                "Robin 3",
                "Robin 4",
                "Robin 5",
                "Robin 6",
                "Robin 7",
                "Robin 8",
                "Shulk 1",
                "Shulk 2",
                "Shulk 3",
                "Shulk 4",
                "Shulk 5",
                "Shulk 6",
                "Shulk 7",
                "Shulk 8",
                "Bowser Jr. 1",
                "Bowser Jr. 2",
                "Bowser Jr. 3",
                "Bowser Jr. 4",
                "Bowser Jr. 5",
                "Bowser Jr. 6",
                "Bowser Jr. 7",
                "Bowser Jr. 8",
                "Duck Hunt 1",
                "Duck Hunt 2",
                "Duck Hunt 3",
                "Duck Hunt 4",
                "Duck Hunt 5",
                "Duck Hunt 6",
                "Duck Hunt 7",
                "Duck Hunt 8",
                "Ryu 1",
                "Ryu 2",
                "Ryu 3",
                "Ryu 4",
                "Ryu 5",
                "Ryu 6",
                "Ryu 7",
                "Ryu 8",
                "Ken 1",
                "Ken 2",
                "Ken 3",
                "Ken 4",
                "Ken 5",
                "Ken 6",
                "Ken 7",
                "Ken 8",
                "Cloud 1",
                "Cloud 2",
                "Cloud 3",
                "Cloud 4",
                "Cloud 5",
                "Cloud 6",
                "Cloud 7",
                "Cloud 8",
                "Corrin 1",
                "Corrin 2",
                "Corrin 3",
                "Corrin 4",
                "Corrin 5",
                "Corrin 6",
                "Corrin 7",
                "Corrin 8",
                "Bayonetta 1",
                "Bayonetta 2",
                "Bayonetta 3",
                "Bayonetta 4",
                "Bayonetta 5",
                "Bayonetta 6",
                "Bayonetta 7",
                "Bayonetta 8",
                "Inkling 1",
                "Inkling 2",
                "Inkling 3",
                "Inkling 4",
                "Inkling 5",
                "Inkling 6",
                "Inkling 7",
                "Inkling 8",
                "Ridley 1",
                "Ridley 2",
                "Ridley 3",
                "Ridley 4",
                "Ridley 5",
                "Ridley 6",
                "Ridley 7",
                "Ridley 8",
                "Simon 1",
                "Simon 2",
                "Simon 3",
                "Simon 4",
                "Simon 5",
                "Simon 6",
                "Simon 7",
                "Simon 8",
                "Richter 1",
                "Richter 2",
                "Richter 3",
                "Richter 4",
                "Richter 5",
                "Richter 6",
                "Richter 7",
                "Richter 8",
                "King K. Rool 1",
                "King K. Rool 2",
                "King K. Rool 3",
                "King K. Rool 4",
                "King K. Rool 5",
                "King K. Rool 6",
                "King K. Rool 7",
                "King K. Rool 8",
                "Isabelle 1",
                "Isabelle 2",
                "Isabelle 3",
                "Isabelle 4",
                "Isabelle 5",
                "Isabelle 6",
                "Isabelle 7",
                "Isabelle 8",
                "Incineroar 1",
                "Incineroar 2",
                "Incineroar 3",
                "Incineroar 4",
                "Incineroar 5",
                "Incineroar 6",
                "Incineroar 7",
                "Incineroar 8",
                "Plant 1",
                "Plant 2",
                "Plant 3",
                "Plant 4",
                "Plant 5",
                "Plant 6",
                "Plant 7",
                "Plant 8",
                "Joker 1",
                "Joker 2",
                "Joker 3",
                "Joker 4",
                "Joker 5",
                "Joker 6",
                "Joker 7",
                "Joker 8",
                "Hero 1",
                "Hero 2",
                "Hero 3",
                "Hero 4",
                "Banjo 1",
                "Banjo 2",
                "Banjo 3",
                "Banjo 4",
                "Banjo 5",
                "Banjo 6",
                "Banjo 7",
                "Banjo 8",
                "Terry 1",
                "Terry 2",
                "Terry 3",
                "Terry 4",
                "Terry 5",
                "Terry 6",
                "Terry 7",
                "Terry 8",
                "Byleth 1",
                "Byleth 2",
                "Byleth 3",
                "Byleth 4",
                "Byleth 5",
                "Byleth 6",
                "Byleth 7",
                "Byleth 8",
                "Min Min 1",
                "Min Min 2",
                "Min Min 3",
                "Min Min 4",
                "Min Min 5",
                "Min Min 6",
                "Min Min 7",
                "Min Min 8",
                "Steve 1",
                "Steve 2",
                "Steve 3",
                "Steve 4",
                "Steve 5",
                "Steve 6",
                "Steve 7",
                "Steve 8",
                "Sephiroth 1",
                "Sephiroth 2",
                "Sephiroth 3",
                "Sephiroth 4",
                "Sephiroth 5",
                "Sephiroth 6",
                "Sephiroth 7",
                "Sephiroth 8",
                "Pyra Mythra 1",
                "Pyra Mythra 2",
                "Pyra Mythra 3",
                "Pyra Mythra 4",
                "Pyra Mythra 5",
                "Pyra Mythra 6",
                "Pyra Mythra 7",
                "Pyra Mythra 8",
                "Pyra Solo",
                "Mythra Solo",
                "Kazuya 1",
                "Kazuya 2",
                "Sora 1",
                "Sora 2",
                "Sora 3",
                "Sora 4",
                "Sora 5",
                "Sora 6",
                "Sora 7",
                "Sora 8",
        };

        return characters;
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

    private BufferedImage scale1(BufferedImage before, double scale) {
        int w = before.getWidth();
        int h = before.getHeight();
        // Create a new image of the proper size
        int w2 = (int) (w * scale);
        int h2 = (int) (h * scale);
        BufferedImage after = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB);
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(scale, scale);
        AffineTransformOp scaleOp
                = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);

        scaleOp.filter(before, after);
        return after;
    }

}
