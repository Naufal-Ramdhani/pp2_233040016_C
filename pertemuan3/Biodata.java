

import java.awt.*;
import javax.swing.*;

public class Biodata extends JFrame {

    private JPanel panel;

    public Biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Biodata"); 
        this.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);

        JLabel headerLabel = new JLabel("Form Biodata");
        JLabel namaLabel = new JLabel("Nama:");
        JLabel hpLabel = new JLabel("Nomor HP:");
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin:");

        JTextField namaField = new JTextField(5);
        JTextField hpField = new JTextField(5);

        JRadioButton lakiRadioButton = new JRadioButton("Laki-Laki");
        JRadioButton perempuanRadioButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(lakiRadioButton);
        genderGroup.add(perempuanRadioButton);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");

        JButton simpanButton = new JButton("Simpan");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        add(headerLabel, gbc);

        gbc.gridwidth = 1; 
        gbc.anchor = GridBagConstraints.WEST; 

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(namaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(hpLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(hpField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(jenisKelaminLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(lakiRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(perempuanRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2; 
        add(checkBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(simpanButton, gbc);

        this.setSize(800, 800);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata h = new Biodata();
                h.setVisible(true);
            }
        });
    }
}