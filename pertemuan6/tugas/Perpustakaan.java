package pertemuan6.tugas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Perpustakaan extends JFrame {

    private JPanel mainPanel;

    public Perpustakaan () {
        setTitle("Aplikasi Perpustakaan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem dataBukuMenuItem = new JMenuItem("Data Buku");
        JMenuItem preferensiPembacaMenuItem = new JMenuItem("Preferensi Pembaca");
        JMenuItem peminjamanBukuMenuItem = new JMenuItem("Peminjaman Buku");

        menu.add(dataBukuMenuItem);
        menu.add(preferensiPembacaMenuItem);
        menu.add(peminjamanBukuMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel Utama
        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(new FormDataBuku(), "DataBuku");
        mainPanel.add(new FormPreferensiPembaca(), "PreferensiPembaca");
        mainPanel.add(new FormPeminjamanBuku(), "PeminjamanBuku");

        add(mainPanel);

        // Event Listeners
        dataBukuMenuItem.addActionListener(e -> showForm("DataBuku"));
        preferensiPembacaMenuItem.addActionListener(e -> showForm("PreferensiPembaca"));
        peminjamanBukuMenuItem.addActionListener(e -> showForm("PeminjamanBuku"));

        setVisible(true);
    }

    // Menampilkan form berdasarkan nama
    private void showForm(String formName) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, formName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Perpustakaan::new);
    }

    // Form Data Buku
    class FormDataBuku extends JPanel {
        private JTextField textFieldJudul, textFieldPengarang;
        private JComboBox<String> comboKategori;
        private JTextField textFieldPenerbit;
        private JTable table;
        private DefaultTableModel tableModel;

        public FormDataBuku() {
            setLayout(new BorderLayout());

            JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
            textFieldJudul = new JTextField();
            textFieldPengarang = new JTextField();
            comboKategori = new JComboBox<>(new String[]{"Fiksi", "Non-Fiksi", "Sains", "Sejarah", "Biografi"});
            textFieldPenerbit = new JTextField();

            formPanel.add(new JLabel("Judul Buku:"));
            formPanel.add(textFieldJudul);
            formPanel.add(new JLabel("Pengarang:"));
            formPanel.add(textFieldPengarang);
            formPanel.add(new JLabel("Kategori:"));
            formPanel.add(comboKategori);
            formPanel.add(new JLabel("Penerbit:"));
            formPanel.add(textFieldPenerbit);

            tableModel = new DefaultTableModel(new Object[]{"Judul", "Pengarang", "Kategori", "Penerbit"}, 0);
            table = new JTable(tableModel);

            JButton btnSave = new JButton("Simpan");
            btnSave.addActionListener(e -> saveData());

            add(formPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(btnSave, BorderLayout.SOUTH);
        }

        private void saveData() {
            String judul = textFieldJudul.getText();
            String pengarang = textFieldPengarang.getText();
            String kategori = (String) comboKategori.getSelectedItem();
            String penerbit = textFieldPenerbit.getText();

            tableModel.addRow(new Object[]{judul, pengarang, kategori, penerbit});
        }
    }

    // Form Preferensi Pembaca
    class FormPreferensiPembaca extends JPanel {
        private JCheckBox cbFiksi, cbNonFiksi, cbSains, cbSejarah, cbBiografi;
        private JComboBox<String> comboWaktuKunjungan;
        private JTable table;
        private DefaultTableModel tableModel;

        public FormPreferensiPembaca() {
            setLayout(new BorderLayout());

            JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
            cbFiksi = new JCheckBox("Fiksi");
            cbNonFiksi = new JCheckBox("Non-Fiksi");
            cbSains = new JCheckBox("Sains");
            cbSejarah = new JCheckBox("Sejarah");
            cbBiografi = new JCheckBox("Biografi");
            comboWaktuKunjungan = new JComboBox<>(new String[]{"Pagi", "Siang", "Sore", "Malam"});

            formPanel.add(new JLabel("Genre Buku Favorit:"));
            JPanel genrePanel = new JPanel();
            genrePanel.add(cbFiksi);
            genrePanel.add(cbNonFiksi);
            genrePanel.add(cbSains);
            genrePanel.add(cbSejarah);
            genrePanel.add(cbBiografi);
            formPanel.add(genrePanel);
            formPanel.add(new JLabel("Waktu Kunjungan:"));
            formPanel.add(comboWaktuKunjungan);

            tableModel = new DefaultTableModel(new Object[]{"Genre Favorit", "Waktu Kunjungan"}, 0);
            table = new JTable(tableModel);

            JButton btnSave = new JButton("Simpan");
            btnSave.addActionListener(e -> saveData());


            add(formPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(btnSave, BorderLayout.SOUTH);
        }

        private void saveData() {
            String genre = (cbFiksi.isSelected() ? "Fiksi " : "") +
                           (cbNonFiksi.isSelected() ? " Non-Fiksi " : "") +
                           (cbSains.isSelected() ? "Sains " : "") +
                           (cbSejarah.isSelected() ? "Sejarah " : "") +
                           (cbBiografi.isSelected() ? "Biografi " : "");                           ;
            String waktu = (String) comboWaktuKunjungan.getSelectedItem();

            tableModel.addRow(new Object[]{genre, waktu});
        }
    }

    // Form Peminjaman Buku
    class FormPeminjamanBuku extends JPanel {
        private JTextField textFieldNamaBuku;
        private JTextField textFieldNamaPeminjam;
        private JSlider sliderDurasi;
        private JSpinner spinnerJumlahBuku;
        private JTable table;
        private DefaultTableModel tableModel;

        public FormPeminjamanBuku() {
            setLayout(new BorderLayout());

            JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
            textFieldNamaBuku = new JTextField();
            textFieldNamaPeminjam = new JTextField();
            sliderDurasi = new JSlider(1, 14, 7); // Durasi peminjaman 1 - 14 hari
            sliderDurasi.setPaintTicks(true);
            sliderDurasi.setPaintLabels(true);
            sliderDurasi.setMajorTickSpacing(1);
            spinnerJumlahBuku = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

            formPanel.add(new JLabel("Nama Peminjam:"));
            formPanel.add(textFieldNamaPeminjam);
            formPanel.add(new JLabel("Nama Buku:"));
            formPanel.add(textFieldNamaBuku);
            formPanel.add(new JLabel("Durasi Peminjaman (hari):"));
            formPanel.add(sliderDurasi);
            formPanel.add(new JLabel("Jumlah Buku:"));
            formPanel.add(spinnerJumlahBuku);

            tableModel = new DefaultTableModel(new Object[]{"Nama Peminjam", "Nama Buku", "Durasi", "Jumlah Buku"}, 0);
            table = new JTable(tableModel);

            JButton btnSave = new JButton("Simpan");
            btnSave.addActionListener(e -> saveData());


            add(formPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(btnSave, BorderLayout.SOUTH);
        }

        private void saveData() {
            String namaBuku = textFieldNamaBuku.getText();
            String namaPeminjam = textFieldNamaPeminjam.getText();
            int durasi = sliderDurasi.getValue();
            int jumlahBuku = (int) spinnerJumlahBuku.getValue();

            tableModel.addRow(new Object[]{namaPeminjam, namaBuku, durasi, jumlahBuku});
        }
    }
}
