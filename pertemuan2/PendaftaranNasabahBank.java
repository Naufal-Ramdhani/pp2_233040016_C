import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PendaftaranNasabahBank extends JFrame {

    private String checkBoxSelected;
    private JTextField textField;
    private JTextField textTelp;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JComboBox<String> comboBox;
    private JCheckBox checkBox;
    private JTextArea txtOutput;
    private JSpinner spinnerTransaksi;
    private JSpinner spinnerTanggalLahir;
    private JPasswordField passwordField; 
    private JPasswordField confirmPasswordField;
    
    public PendaftaranNasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // Menambahkan item ke menu
        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        //Label Nama
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 20, 350, 10);

        // Input Nama
        textField = new JTextField();
        textField.setBounds(15, 40, 350, 30);

        // Label Telepon
        JLabel labelTelp = new JLabel("Input Nomor Telp: ");
        labelTelp.setBounds(15, 80, 350, 40);

        // Input Telepon
        textTelp = new JTextField();
        textTelp.setBounds(15, 120, 350, 30);

        // Label Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15, 160, 350, 10);

        // Radio Button Jenis Kelamin
        radioButton1 = new JRadioButton("Laki - Laki");
        radioButton1.setBounds(15, 180, 150, 30);

        radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(180, 180, 150, 30);

        // Grouping radio buttons
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Label Jenis Tabungan
        JLabel labelTabungan = new JLabel("Pilih Jenis Tabungan: ");
        labelTabungan.setBounds(15, 220, 350, 10);

        // Pilihan Tabungan
        String[] tabunganOptions = {"Tabungan Biasa", "Tabungan Berjangka", "Tabungan Pendidikan", "Tabungan Investasi"};
        comboBox = new JComboBox<>(tabunganOptions);
        comboBox.setBounds(15, 240, 350, 30);

        // CheckBox WNA
        checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 280, 350, 30);

        // Frekuensi Transaksi
        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi per Bulan (1-100): ");
        labelTransaksi.setBounds(15, 310, 350, 10);

        // Untuk input frekuensi transaksi
        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1); // Default value 1, min 1, max 100, step 1
        spinnerTransaksi = new JSpinner(model);
        spinnerTransaksi.setBounds(15, 330, 350, 30);

        // Label Tanggal Lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir: ");
        labelTanggalLahir.setBounds(15, 370, 350, 10);

        // Untuk Tanggal Lahir
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);
        spinnerTanggalLahir.setBounds(15, 390, 350, 30);

        // Label Password
        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(15, 430, 350, 10);

        // Untuk Input Password
        passwordField = new JPasswordField();
        passwordField.setBounds(15, 450, 350, 30);

        // Label Confirm Password
        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password: ");
        labelConfirmPassword.setBounds(15, 490, 350, 10);

        // Input Confirm Password
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 510, 350, 30);

        // Output Area
        txtOutput = new JTextArea();
        txtOutput.setBounds(15, 600, 350, 140);
        txtOutput.setEditable(false);

        // Button Simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 560, 100, 30);

        // CheckBox WNA
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = (e.getStateChange() == ItemEvent.SELECTED) ? "Ya" : "Bukan";
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = radioButton1.isSelected() ? "Laki - Laki" : "Perempuan";
                String nama = textField.getText();
                String telp = textTelp.getText();
                String selectedTabungan = (String) comboBox.getSelectedItem();
                int frekuensiTransaksi = (int) spinnerTransaksi.getValue();
                Date tanggalLahir = (Date) spinnerTanggalLahir.getValue();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedTanggalLahir = formatter.format(tanggalLahir);
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                txtOutput.append("Nama	: " + nama + "\n");
                txtOutput.append("Nomor HP	: " + telp + "\n");
                txtOutput.append("Jenis Kelamin	: " + jenisKelamin + "\n");
                txtOutput.append("WNA	: " + checkBoxSelected + "\n");
                txtOutput.append("Tabungan	: " + selectedTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi	: " + frekuensiTransaksi + " per bulan\n");
                txtOutput.append("Tanggal Lahir	: " + formattedTanggalLahir + "\n");

                //condition inputan password
                if (password.equals(confirmPassword)) {
                    txtOutput.append("Password cocok.\n");
                } else {
                    txtOutput.append("Password tidak cocok.\n");
                }
                txtOutput.append("========================================\n");
            }
        });

        // Reset Inputan
        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textTelp.setText("");
                bg.clearSelection();
                comboBox.setSelectedIndex(0);
                checkBox.setSelected(false);
                spinnerTransaksi.setValue(1); 
                spinnerTanggalLahir.setValue(new Date()); 
                passwordField.setText(""); 
                confirmPasswordField.setText(""); 
                txtOutput.setText("");
            }
        });

        // Exit Program 
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Menambahkan Komponen ke JFrame
        this.add(labelInput);
        this.add(textField);
        this.add(labelTelp);
        this.add(textTelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelTabungan);
        this.add(comboBox);
        this.add(checkBox);
        this.add(labelTransaksi);
        this.add(spinnerTransaksi);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(button);
        this.add(txtOutput);

        // Pengaturan ukuran dan layout JFrame
        this.setSize(400, 800);
        this.setLayout(null);
    }

    //Program Main
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PendaftaranNasabahBank frame = new PendaftaranNasabahBank();
                frame.setVisible(true);
            }
        });
    }
}