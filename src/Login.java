import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login {
    public JPanel mainPanel;
    private JTextField usertextField1;
    private JPasswordField passwordField1;
    private JButton validarButton;

    public Login() {
        /*
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;*/

        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usuario = usertextField1.getText();
                String password = String.valueOf(passwordField1.getPassword());

                user = getAuthenticatedUser(username, password);

                if (user != null) {
                    dispose();
                    Productos productos = new Productos(parent);
                    productos.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(Login.this,
                            "Usuario o Password incorrecto",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        public Username user;
        private User getAuthenticatedUser(String usuario, String password){
            User user = null;

            String URL = "jdbc:mysql://localhost:3306/productos";
            String USER = "root";
            String PASSWORD = "";
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

                String sql = "SELECT * FROM USUARIO WHERE username =? AND password =? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    user = new User();
                    user.setUsuario(resultSet.getString("username"));
                }
                preparedStatement.close();
                resultSet.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
    }


}
