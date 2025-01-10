import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Calificaciones {
    public JPanel mainPanel2;
    private JTextField cedulatextField1;
    private JButton registrarButton;
    private JTextField calificacion1;
    private JTextField calificacion2;
    private JTextField calificacion3;
    private JTextField calificacion4;
    private JTextField calificacion5;
    private JButton validarButton;
    private JTextField nombretextField1;


    public Calificaciones() {

        public void actionPerformed(ActionEvent e) {
            String url = "jdbc:mysql://localhost:3306/gestion_calificaciones";
            String user = "root";
            String password = "123456";

        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/gestion_calificaciones";
                String user = "root";
                String password = "123456";

                try{
                    Connection conn = DriverManager.getConnection(url, user, password);

                    int insertarFilas = ps.executeUpdate();
                    System.out.println("insertarFilas: " + insertarFilas);

                    String sql = "insert into estudiantes values cedula, nombre,calificacion1, calificacion2, calificacion3, calificacion4, calificacion5 = ?,?,?,?,?,?,?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, cedulatextField1.getText());
                    ps.setString(2, nombretextField1.getText());
                    ps.setString(1, calificacion1.getText());
                    ps.setString(2, calificacion2.getText());
                    ps.setString(3, calificacion3.getText());
                    ps.setString(4, calificacion4.getText());
                    ps.setString(5, calificacion5.getText());
                    ResultSet rs = ps.executeQuery();
                    rs.next();


                    JFrame frame = new JFrame();
                    frame.setContentPane(new Historial_calificaciones().mainPanel3);
                    frame.setContentPane(frame.getContentPane());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setVisible(true);


                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void setVisible(boolean b) {
    }
}
