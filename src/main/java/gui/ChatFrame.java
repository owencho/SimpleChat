package gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import mediator.Observer;
import mediator.Publishable;
import mediator.ChatData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tze-Ven Poh
 */
public class ChatFrame extends JFrame implements Observer<ChatData> {
    private final Publishable publisher;
    private static final ImageIcon icon = new ImageIcon("src/images/channel_icon.png");
    
    private ChatFrame(Publishable<ChatData> publisher) {
        initComponents();
    //    initTabComponent(0);
        tabbedPane.remove(0);
        textToSend.requestFocus();
        this.publisher = publisher;
    }   
    
    public static ChatFrame createFrame(String title, 
                                        Publishable<ChatData> publisher) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        ChatFrame newFrame = new ChatFrame(publisher);
        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(title != null)
                    newFrame.setTitle(title);
                newFrame.setVisible(true);                
            }
        });
        return newFrame;
    }
    
    @Override
    public String getObserverName() {
        return getTitle();
    }
    
    @Override
    public void update(ChatData chatData) {
        int index = tabbedPane.indexOfTab(chatData.getChannel());
        if(index >= 0) {    
           getMessageAreaInPanel((JPanel)tabbedPane.getComponentAt(index))
                                    .append(chatData.getMessage() + "\n");
        } // else do nothing        
    }
    
    public void createChannel(String channel) {
        if(channel == null || channel.equals(""))
            return;
        if(tabbedPane.indexOfTab(channel) < 0) {     
            addChannel(channel);
            // ?Not sure why getComponentCount() returns 1 extra component?
            tabbedPane.setSelectedIndex(tabbedPane.getComponentCount() - 2);   
            publisher.joinChannel(channel, this);
        }
    }
    
    public void deleteChannel(String channel) {
        int index;
        if((index = tabbedPane.indexOfTab(channel)) >= 0) {
            tabbedPane.remove(index);
//            publisher.leaveChannel(channelName, this);
        }        
    }
    
    public void sendMessage(String message, String channel) {
        int index;
        if((index = tabbedPane.indexOfTab(channel)) >= 0) {
            JPanel panel = (JPanel)tabbedPane.getComponent(index);
            JTextArea textArea = getMessageAreaInPanel(panel);
            if(textArea != null)
                textArea.append(message + "\n");           
            publisher.sendObject(new ChatData(message, channel, getTitle()), 
                                 this);
        }        
    }
    
    // Return the name/title of the selected tab of a tabbed pane
    protected String getTitleOfSelectedTab(JTabbedPane tabbedPane) {
        return tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
    }
    
    protected JTextArea getMessageAreaInPanel(JPanel panel) {
        if(panel != null) {
            JScrollPane scrollPane = (JScrollPane)panel.getComponent(1);     
            JViewport viewPort = (JViewport)scrollPane.getComponent(0);     
            return (JTextArea)viewPort.getComponent(0);     
        }
        return null;
    }
    
    private void initTabComponent(int i) {
        tabbedPane.setTabComponentAt(i, new ButtonTabComponent(tabbedPane));
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        tabPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        inputPanel = new javax.swing.JPanel();
        send = new javax.swing.JButton();
        textToSend = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        channelMenu = new javax.swing.JMenu();
        menuOpenChannel = new javax.swing.JMenuItem();
        menuDeleteChannel = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        menuClear = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Chat");
        setName("My Chat"); // NOI18N

        tabbedPane.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tabbedPaneComponentRemoved(evt);
            }
        });
        tabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabbedPaneFocusGained(evt);
            }
        });

        messageArea.setEditable(false);
        messageArea.setColumns(20);
        messageArea.setRows(5);
        scrollPane.setViewportView(messageArea);

        send.setText("Send");

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(textToSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send)
                    .addComponent(textToSend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabPanelLayout = new javax.swing.GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabPanelLayout.createSequentialGroup()
                .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        tabPanelLayout.setVerticalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        tabbedPane.addTab("tab1", tabPanel);

        channelMenu.setText("Channel");

        menuOpenChannel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpenChannel.setText("Open Channel");
        menuOpenChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenChannelActionPerformed(evt);
            }
        });
        channelMenu.add(menuOpenChannel);

        menuDeleteChannel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuDeleteChannel.setText("Delete Channel");
        menuDeleteChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteChannelActionPerformed(evt);
            }
        });
        channelMenu.add(menuDeleteChannel);

        menuBar.add(channelMenu);

        editMenu.setText("Edit");

        menuClear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuClear.setText("Clear");
        menuClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClearActionPerformed(evt);
            }
        });
        editMenu.add(menuClear);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpenChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenChannelActionPerformed
        String channelName;
        channelName = (String)JOptionPane.showInputDialog(null, "Channel Name", 
                            "Open Channel", JOptionPane.PLAIN_MESSAGE, icon, 
                            null, null);
        createChannel(channelName);
    }//GEN-LAST:event_menuOpenChannelActionPerformed

    private void menuDeleteChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteChannelActionPerformed
        String channelName;        
        channelName = (String)JOptionPane.showInputDialog(null, "Channel Name", 
                            "Delete Channel", JOptionPane.PLAIN_MESSAGE, icon, 
                            null, null);        
        deleteChannel(channelName);
    }//GEN-LAST:event_menuDeleteChannelActionPerformed

    private void menuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClearActionPerformed
        JPanel panel = (JPanel)tabbedPane.getSelectedComponent();
        JTextArea textArea = getMessageAreaInPanel(panel);
        if(textArea != null)
            textArea.setText(""); 
    }//GEN-LAST:event_menuClearActionPerformed

    private void tabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusGained
        textToSend.requestFocus();  
    }//GEN-LAST:event_tabbedPaneFocusGained

    private void tabbedPaneComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabbedPaneComponentRemoved
        if(evt.getChild() instanceof JPanel) {
            var panel = (JPanel)evt.getChild();
            if(panel.getName() != null)
                publisher.leaveChannel(panel.getName(), this);
        }
    }//GEN-LAST:event_tabbedPaneComponentRemoved
    
    private void addChannel(String title) {
        JPanel tabPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        JTextArea messageArea = new JTextArea();
        JPanel inputPanel = new JPanel();
        JButton send = new JButton();
        JTextField textToSend = new JTextField();

        messageArea.setEditable(false);
        messageArea.setColumns(20);
        messageArea.setRows(5);
        scrollPane.setViewportView(messageArea);

        send.setText("Send");
        ActionListener sendMessage = (ActionEvent evt) -> {
            String text;
            if(!(text = textToSend.getText()).equals("")) {
                messageArea.append(text + "\n");
                ChatData chatData = new ChatData(text,
                                            getTitleOfSelectedTab(tabbedPane),
                                            getTitle());
                publisher.sendObject(chatData, this);
                textToSend.setText("");  
            }
            textToSend.requestFocus();
        };
        send.addActionListener(sendMessage);
        textToSend.addActionListener(sendMessage);

        tabbedPane.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                textToSend.requestFocus();
            }
        });
        
        GroupLayout inputPanelLayout = new GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(textToSend)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(send)
                    .addComponent(textToSend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        GroupLayout tabPanelLayout = new GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(
            tabPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, tabPanelLayout.createSequentialGroup()
                .addComponent(inputPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, tabPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        tabPanelLayout.setVerticalGroup(
            tabPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        tabPanel.setName(title);
        tabbedPane.addTab(title, tabPanel);
        initTabComponent(tabbedPane.getTabCount() - 1);
        textToSend.requestFocus();
    }               
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu channelMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuClear;
    private javax.swing.JMenuItem menuDeleteChannel;
    private javax.swing.JMenuItem menuOpenChannel;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton send;
    private javax.swing.JPanel tabPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextField textToSend;
    // End of variables declaration//GEN-END:variables
}
