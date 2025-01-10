import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login {
    public JPanel mainPanel;
    private JTextField usertextField1;
    private JPasswordField passwordField1;
    private JButton validarButton;

    public Login() throws SQLException {

        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
            String url = "jdbc:mysql://localhost:3306/gestion_calificiones";
            String user = "root";
            String password = "123456";


            Connection conn = null;
            PreparedStatement ps = null;

        try{
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Se a conectado correctamente a la base de datos");
                String sql = "insert into usuarios (username, password) values (?,?)";
                ps = conn.prepareStatement(sql);

            }
        catch(Exception e){

                e.printStackTrace();

            }finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    if (ps != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
