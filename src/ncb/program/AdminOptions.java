/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncb.program;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.beans.Beans.isDesignTime;
import static javax.persistence.Persistence.createEntityManagerFactory;

/**
 *
 * @author Malik Heron
 */
public class AdminOptions {
    // Create and set up the windows
    private final JPanel panel = new JPanel();

    // declare image objects
    private static final String Path = "D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\Plain UI.jpg";

    // declare buttons
    private static final JButton logoutButton = new JButton("Log out");

    private final JTable table = new JTable();
    EntityManager NCB_ProgramPUEntityManager = isDesignTime() ? null : createEntityManagerFactory("users?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
    Query dataQuery = isDesignTime() ? null : NCB_ProgramPUEntityManager.createQuery("SELECT d FROM Data d");
    List<ncb.program.Data> dataList = isDesignTime() ? java.util.Collections.emptyList() : dataQuery.getResultList();
    BindingGroup bindingGroup = new BindingGroup();
    JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, dataList, table);
    JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${id}"));

    public AdminOptions() throws Exception {
        // Display the window
        panel.setSize(600, 500);
        panel.setOpaque(false);
        panel.setVisible(true);
        panel.setLayout(new GridLayout(1, 1));

        // set panel properties
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));
        panel1.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        panel2.setLayout(null);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 1));
        panel3.setLayout(null);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 1));
        panel4.setLayout(null);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1, 1));
        panel5.setLayout(null);

        // set properties for table
        table.setFocusable(false);
        table.setFont(new Font("times new roman", Font.PLAIN, 16));

        // set binding fields
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${first}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${last}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${accountNumber}"));
        columnBinding.setColumnName("Account Number");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${time}"));
        columnBinding.setColumnName("Time Created");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${accessTime}"));
        columnBinding.setColumnName("Last Accessed");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);

        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        // declare other objects
        JScrollPane jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(table);

        bindingGroup.bind();

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 600, 500);

        // set properties for images
        JLabel image = new JLabel(new ImageIcon(Path));
        image.setSize(600, 500);
        panel.add(image);

        JLabel image1 = new JLabel(new ImageIcon(Path));
        image1.setSize(600, 500);
        panel1.add(image1);

        JLabel image2 = new JLabel(new ImageIcon(Path));
        image2.setSize(600, 500);
        panel2.add(image2);

        JLabel image3 = new JLabel(new ImageIcon(Path));
        image3.setSize(600, 500);
        panel3.add(image);

        JLabel image4 = new JLabel(new ImageIcon(Path));
        image4.setSize(600, 500);
        panel4.add(image4);

        // set properties for logoutButton
        logoutButton.setBounds(80, 220, 200, 50);
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("times new roman", Font.PLAIN, 16));

        // set properties for image
        JLabel image5 = new JLabel(new ImageIcon(Path));
        image5.setSize(600, 500);
        panel5.add(image5);

        // set properties for tabs
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFocusable(false);
        tabbedPane.setFont(new Font("times new roman", Font.PLAIN, 16));
        tabbedPane.addTab("Accounts on System", panel1);

        // set contents for window
        panel.add(tabbedPane);

        // what the button does when pressed
        logoutButton.addActionListener((ActionEvent e) -> {
            boolean isYes;

            int selection = Messages.logoutPrompt(MainScreen.jPanel1);

            isYes = (selection == JOptionPane.YES_OPTION);

            if (isYes) {
                System.exit(0);
            }
        });
    }

    public JPanel getComponent() {
        return panel;
    }

    public static void createAndShowUI() throws Exception {
        MainScreen.jPanel1.removeAll();
        MainScreen.jPanel1.repaint();
        MainScreen.jPanel1.revalidate();

        MainScreen.jPanel1.add(logoutButton);
        MainScreen.jPanel1.repaint();
        MainScreen.jPanel1.revalidate();

        MainScreen.jPanel2.removeAll();
        MainScreen.jPanel2.repaint();
        MainScreen.jPanel2.revalidate();

        MainScreen.jPanel2.add(new AdminOptions().getComponent());
        MainScreen.jPanel2.repaint();
        MainScreen.jPanel2.revalidate();
    }
}