package ChatFrames;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ChatSimple extends JFrame {
    private JLabel clockLabel;
    private JComboBox<String> timeZoneComboBox;

    public ChatSimple() {
        super("World Clock");

        // Khởi tạo giao diện
        initUI();

        // Thiết lập sự kiện cho ô chọn múi giờ
        timeZoneComboBox.addActionListener(e -> updateClock());

        // Tự động cập nhật đồng hồ mỗi giây
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();
    }

    private void initUI() {
        // Tạo panel chính
        JPanel mainPanel = new JPanel();

        // Tạo label cho đồng hồ
        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setBounds(0, 0, 818, 389);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 48));

        // Tạo ô chọn múi giờ
        String[] timeZones = TimeZone.getAvailableIDs();
        timeZoneComboBox = new JComboBox<>(timeZones);
        timeZoneComboBox.setBounds(0, 389, 818, 19);
        mainPanel.setLayout(null);

        // Thêm các thành phần vào panel
        mainPanel.add(clockLabel);
        mainPanel.add(timeZoneComboBox);

        // Thiết lập frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(832, 445);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
    }

    private void updateClock() {
        // Lấy múi giờ được chọn
        String selectedTimeZone = (String) timeZoneComboBox.getSelectedItem();

        // Lấy thời gian hiện tại theo múi giờ được chọn
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(selectedTimeZone));
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setTimeZone(calendar.getTimeZone());
        String currentTime = dateFormat.format(calendar.getTime());

        // Cập nhật label của đồng hồ
        clockLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	ChatSimple worldClockApp = new ChatSimple();
            worldClockApp.setVisible(true);
        });
    }
}
