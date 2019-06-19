package GUI_Collection;

import Player_Entity.Party;
import Generic_Character.GenericCharacter;
import Player_Entity.PartyWallet;
import Move_Creation.StatusEffect;
import Player_Entity.PlayerEntity;
import Generic_Character.LevelMechanics;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;

public class MainMenu extends CommonGUIMethods
{
    // frame meant to store components in a desired layout 
    private JFrame frame = new JFrame("Capstone RPG");
    
    // store JFrame that originally called frame of this class to return to it later 
    private JFrame callingFrame = new JFrame();
    
    // usable buttons that provide different results upon click 
    private JButton items, equip, moves, status, settings, datalog, exitMenu;

    // font size used for text of all componenets 
    private Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    
    // vertical padding in pixels for buttons 
    private int buttonVerticalPadding = 45;
    
    // JList storing all party members for easy viewing
    private JList partyMemberJList;
    
    
    
    // START: CREATING USABLE BUTTONS
    /*******************************************************************************/
    
    private JButton usableButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setFont(font);
        
        return button;
    }
    
    public void buttonComponentPlacement(JButton button, int loopCount, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = 0 + loopCount;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up 
        gridBagConstraints.weighty = 0.11;
        
        // specified row length component takes up 
        gridBagConstraints.weightx = 0.10;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 1;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) Insets(0, -225, 0, -125);
        gridBagConstraints.insets = new Insets(5, 0, 0, 150);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    public void addUsableButtonsWithActionListeners(JFrame frame, PlayerEntity entity)
    {
        items = usableButton("Items");
            items.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // shift focus to SubmenuItems frame and store calling frame 
                        new SubmenuItems(callingFrame, entity);
                        
                        // dispose of Main menu frame 
                        frame.dispose();
                    }
                }); 
                    items.setEnabled(true);
                        buttonComponentPlacement(items, 0, frame);
        
        equip = usableButton("Equips");
            equip.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // shift focus to SubmenuEquipment frame and store calling frame 
                        new SubmenuEquipment(callingFrame, entity);
                        
                        // dispose of Main menu frame 
                        frame.dispose();
                    }
                }); 
                    equip.setEnabled(true);
                        buttonComponentPlacement(equip, 1, frame);
              
        moves = usableButton("Moves");
            moves.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    moves.setEnabled(false);
                        buttonComponentPlacement(moves, 2, frame);

        status = usableButton("Status");
            status.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    status.setEnabled(false);
                        buttonComponentPlacement(status, 3, frame);
        
        settings = usableButton("Settings");
            settings.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    settings.setEnabled(false);
                        buttonComponentPlacement(settings, 4, frame);
        
        datalog = usableButton("Datalogs");
            datalog.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    datalog.setEnabled(false);
                        buttonComponentPlacement(datalog, 5, frame);
        
        exitMenu = usableButton("Exit Menu");
            exitMenu.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // return focus to frame that orginally called Main Menu 
                        displayFrameWindow(callingFrame);
                        
                        // dispose of Main menu frame 
                        frame.dispose();
                    }
                }); 
                    exitMenu.setEnabled(true);
                        buttonComponentPlacement(exitMenu, 6, frame);
        
        JButton[] privateButtons = {items, equip, moves, status, settings, 
            datalog, exitMenu};
        
        // add button column functionality for keyboard and mouse wheel 
        CommonGUIMethods.buttonColumnKeyboardNavigation(privateButtons);
        CommonGUIMethods.frameMouseWheel(frame, privateButtons);
    }
    
    // END: CREATING USABLE BUTTONS
    /*******************************************************************************/

    

    // START: PARTY WALLET INFORMATION 
    /*******************************************************************************/

    public String walletDescription(PartyWallet wallet)
    {
        String walletSize = String.format("Size: %-6s", wallet.getSizeString());
        
        String walletTier = String.format("Tier: %s", wallet.getTierString().charAt(
            wallet.getTierString().length() - 1));
        
        String walletMoney = String.format("Money: %s / %s", String.valueOf(
            (int)wallet.getCurrentMoney()), String.valueOf((int)wallet.getWalletCapacity()));
        
        String walletInfo = String.format("%-14s %-13s %-9s %s", "Wallet Info:", 
            walletSize, walletTier, walletMoney);
        
        return walletInfo;
    }
    
    public JButton walletButton(PartyWallet wallet)
    {
        JButton button = new JButton(walletDescription(wallet));
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setFont(font);
        
        return button;
    }
    
    public void addWalletInformationButton(PartyWallet wallet, JFrame frame)
    {
        JButton button = walletButton(wallet);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = 8;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up 
        gridBagConstraints.weighty = 0.11;
        
        // specified row length component takes up 
        gridBagConstraints.weightx = 0.20;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 4;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) Insets(0, -225, 0, -125);
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    // END: PARTY WALLET INFORMATION 
    /*******************************************************************************/

    
    
    // START: PANEL DISPLAYING CHARACTER PARTY INFORMATION
    /*******************************************************************************/
    
    public String nameWithMemberNumber(GenericCharacter character, int counter)
    {
        // format so all names up to 26 characters are correctly structured 
        String formattedName = String.format("%-52s %s: %-2s", character.getGeneralFeatures().getName(),
            "Member", String.valueOf(counter));
                return formattedName;
    }
    
    public String healthAndLevel(GenericCharacter character)
    {
        String formattedHealthAndLevel = String.format("%-3s: %-25s %-13s: %s", "HP", 
            formatCurrentMaxGauges(character.getGeneralFeatures().getCurrentHealth(), 
            character.getTotalStats().getTotalMaxHealth()), "Lv", character.
            getGeneralFeatures().getLevel());
                return formattedHealthAndLevel;
    }
    
    public String staminaAndCurrentExperience(GenericCharacter character)
    {
        String formattedStaminaAndCurrentExperience = String.format("%-3s: %-25s %-13s: %s", 
            "SP", formatCurrentMaxGauges(character.getGeneralFeatures().getCurrentStamina(), 
            character.getTotalStats().getTotalMaxStamina()), "Current EXP", String.valueOf(
            character.getGeneralFeatures().getExperience()));
                return formattedStaminaAndCurrentExperience;
    }
    
    public String nanoAndNextLevelExperience(GenericCharacter character)
    {
        LevelMechanics level = new LevelMechanics();
        
        String formattedStaminaAndCurrentExperience = String.format("%-3s: %-25s %-13s: %s", 
            "SP", formatCurrentMaxGauges(character.getGeneralFeatures().getCurrentNano(), 
            character.getTotalStats().getTotalMaxNano()), "To Next Level", String.valueOf(
            level.nextLevelExp(character)));
                return formattedStaminaAndCurrentExperience;
    }
    
    public String statusEffectString(GenericCharacter character)
    {
        StringBuilder builder = new StringBuilder("Status Effects: ");
        
        int counter = 0;
        
        for(StatusEffect status : character.getStatusEffectContainer().getStatusEffects())
        {
            // account for when one status effect exists (no , after it)
            if(character.getStatusEffectContainer().getStatusEffects().size() == 1)
            {
                builder.append(status.getName());
            }
            // account for last status effect (no , after it)
            else if(counter == (character.getStatusEffectContainer().getStatusEffects().size() - 1))
            {
                builder.append(status.getName());
            }
            // account for next status effect ( , after it)
            else
            {
                builder.append(status.getName());
                    builder.append(", ");
                        counter++;
            }
        }
        
        return builder.toString();
    }
    
    // Note: new line is called AFTER element is added to model 
    public void addPartyMemberDetails(DefaultListModel<String> partyMemberModel, 
        GenericCharacter character, int counter)
    {
        // counter is used to identify number of party members 
        partyMemberModel.addElement(nameWithMemberNumber(character, counter));
        partyMemberModel.addElement(healthAndLevel(character));
        partyMemberModel.addElement(staminaAndCurrentExperience(character));
        partyMemberModel.addElement(nanoAndNextLevelExperience(character));
        partyMemberModel.addElement(statusEffectString(character));
    }
    
    public DefaultListModel<String> partyMembersModel(Party party)
    {
        DefaultListModel<String> partyMembers = new DefaultListModel<>();
       
        int counter = 1;
        
        partyMembers.addElement("Party Info");
        partyMembers.addElement(" ");
        
        for(GenericCharacter character : party.getPartyMembers())
        {
            if(party.getPartyMembers().size() == 1)
            {
                addPartyMemberDetails(partyMembers, character, counter);
            }
            else if(counter == party.getPartyMembers().size())
            {
                addPartyMemberDetails(partyMembers, character, counter);
            }
            else
            {
                addPartyMemberDetails(partyMembers, character, counter);
                partyMembers.addElement("\n\n");
            }
            
            counter++;
        }
        
        return partyMembers;
    }
    
    public static void addPartyMemberJListComponent(JList jList, int gridy, int gridx, 
        int gridheight, int gridwidth, JFrame frame)
    {
        jList.setForeground(Color.WHITE);
        
        jList.setBackground(Color.BLACK);
        
        jList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane statsScroll = new JScrollPane(jList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 0;
        
        // column of specified row position
        gridBagConstraints.gridx = 1;
        
        // specified column length component takes up of frame height
        gridBagConstraints.weighty = 0.60;
        
        // specified row length component takes up of frame width
        gridBagConstraints.weightx = 0.60;
        
        // height of component in given column 
        gridBagConstraints.gridheight = 8;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 0;
        
        // vertical padding in pixels for component in given row 
	//gridBagConstraints.ipady = 150;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, -145, 5, 0);
        
        // add button to frame with positioning 
        frame.add(statsScroll, gridBagConstraints);
    }
    
    public void addPartyMemberJLists(Party party, JFrame frame)
    {
        partyMemberJList = new JList(partyMembersModel(party));
            addPartyMemberJListComponent(partyMemberJList, 11, 0, 4, 6, frame);
    }
    
    // END: PANEL DISPLAYING CHARACTER PARTY INFORMATION
    /*******************************************************************************/

    
    
    // START: CONSTRUCTOR 
    /*******************************************************************************/

    public MainMenu(JFrame callingFrame, PlayerEntity entity)
    {
        // store former frame to call it later 
        this.callingFrame = callingFrame;
        
        // set properties for frame for GUI consistency 
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(new GridBagLayout());
        
        // add usable buttons that perform an action upon click to frame 
        addUsableButtonsWithActionListeners(frame, entity);

        addWalletInformationButton(entity.getPartyWallet(), frame);
        
        // JList presents all party members to player 
        addPartyMemberJLists(entity.getParty(), frame);

        displayFrameWindow(frame);
    }
    
    // END: CONSTRUCTOR 
    /*******************************************************************************/
}
