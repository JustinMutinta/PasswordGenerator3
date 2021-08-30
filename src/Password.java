import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Password extends JFrame {


    public Password(){
        setTitle("Password Generator");                             //Set title of Frame
        setSize(600, 150);                              //Set Size. Wanted everything in a long layout from left to right
        setDefaultCloseOperation(EXIT_ON_CLOSE);                    //Close GUI when X is clicked

        JPanel passwordPanel = new JPanel();                        //Created a new Panel
        passwordPanel.setLayout(null);                              //Set Layout to null. Wanted to be able to customize it myself

        Insets insets = getInsets();                                //Created Insets to help with object placement
        Dimension size;                                             //Created size object to edit button and box size. Not initiated yet

        JButton closeButton = new JButton("Close");             //First Button is close button
        size = closeButton.getPreferredSize();                      //Initialized size to .getPrefferedSize();
        closeButton.setBounds(500 + insets.left, 25 + insets.top, size.width + 10, size.height); //placement of button on the panel
        passwordPanel.add(closeButton);                             //Added element to Panel

        JButton generateButton = new JButton("Generate");
        size = generateButton.getPreferredSize();
        generateButton.setBounds(400 + insets.left, 25 + insets.top, size.width + 5, size.height);
        passwordPanel.add(generateButton);

        JTextField passwordBox = new JTextField();
        size = passwordBox.getPreferredSize();
        passwordBox.setBounds(5 + insets.left, 25 + insets.top, size.width + 280, size.height + 8);
        passwordPanel.add(passwordBox);

                                                                    //Creation of Labels to instruct users to enter quantity of letters/numbers/symbols
        JLabel numberQuantity = new JLabel();
        JLabel letterQuantity = new JLabel();
        JLabel symbolQuantity = new JLabel();

        numberQuantity.setText("How many numbers: ");
        letterQuantity.setText("How many letters: ");
        symbolQuantity.setText("How many symbols: ");

        size = numberQuantity.getPreferredSize();
        numberQuantity.setBounds(205 + insets.left, 70 + insets.top, size.width + 10, size.height + 8);
        passwordPanel.add(numberQuantity);

        size = letterQuantity.getPreferredSize();
        letterQuantity.setBounds(5 + insets.left, 70 + insets.top, size.width + 10, size.height + 8);
        passwordPanel.add(letterQuantity);

        size = symbolQuantity.getPreferredSize();
        symbolQuantity.setBounds(405 + insets.left, 70 + insets.top, size.width + 10, size.height + 8);
        passwordPanel.add(symbolQuantity);

        JTextField letterNumberBox = new JTextField();
        letterNumberBox.setText("1");
        size = letterNumberBox.getPreferredSize();
        letterNumberBox.setBounds(110 + insets.left, 70 + insets.top, size.width + 30, size.height + 8);
        passwordPanel.add(letterNumberBox);

        JTextField numberNumberBox = new JTextField();
        numberNumberBox.setText("1");
        size = numberNumberBox.getPreferredSize();
        numberNumberBox.setBounds(325 + insets.left, 70 + insets.top, size.width + 30, size.height + 8);
        passwordPanel.add(numberNumberBox);

        JTextField symbolNumberBox = new JTextField();
        symbolNumberBox.setText("1");
        size = symbolNumberBox.getPreferredSize();
        symbolNumberBox.setBounds(525 + insets.left, 70 + insets.top, size.width + 30, size.height + 8);
        passwordPanel.add(symbolNumberBox);


                                                                            //Action listener for close button
        closeButton.addActionListener(e -> {
            System.exit(0);                                           //Close the window
        });

                                                                            //Action listener for Generate button.
                                                                            //Convert values from boxes into ints
                                                                            //Run the function below
        generateButton.addActionListener(e ->{
            int letterNum = Integer.parseInt(letterNumberBox.getText());
            int numberNum = Integer.parseInt(numberNumberBox.getText());
            int symbolNum = Integer.parseInt(symbolNumberBox.getText());

            passwordBox.setText(createPassword(letterNum, numberNum, symbolNum));
        });



        add(passwordPanel);                         //Adds panel to frame
        setVisible(true);                           //Set to visible
    }


                                                    //Function to create password based on values selected by user
    public String createPassword(int letterNum, int numberNum, int symbolNum){
        char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] symbols = {'!', '#', '$', '%', '&', '(', ')', '*', '+'};

        ArrayList<Character> totalPassword = new ArrayList<>();     //ArrayList to hold values. Allows flexibility
        StringBuilder finalPassword = new StringBuilder();          //return String value
        Random rand = new Random();                                 //Random Object

        for(int i = 0; i < letterNum; i++){                         //Add to the Arraylist
            totalPassword.add(letter[rand.nextInt(letter.length)]);
        }

        for(int i = 0; i < numberNum; i++){
            totalPassword.add(numbers[rand.nextInt(numbers.length)]);
        }

        for(int i = 0; i < symbolNum; i++){
            totalPassword.add(symbols[rand.nextInt(symbols.length)]);
        }

        Collections.shuffle(totalPassword);                     //Shuffle order of the Arraylist

        for (Character character : totalPassword) {             //Add values to String
            finalPassword.append(character);
        }

        return finalPassword.toString();                        //Return String
    }



}
