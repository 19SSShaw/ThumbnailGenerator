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
                    System.out.println();
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
