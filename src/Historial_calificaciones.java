import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Historial_calificaciones {
    private JTable table1;
    public JPanel mainPanel3;
    private JButton salirButton;

    public Historial_calificaciones() {

        String url = "jdbc:mysql://localhost:3306/gestion_calificaciones";
        String user = "root";
        String password = "1234";

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Calificacion1");
        model.addColumn("Calificacion2");
        model.addColumn("Calificacion3");
        model.addColumn("Calificacion4");
        model.addColumn("Calificacion5");

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM estudiantes";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("calificacion1"),
                        rs.getString("calificacion2"),
                        rs.getString("calificacion3"),
                        rs.getString("calificacion4"),
                        rs.getString("calificacion5")
                });
            }

            table1.setModel(model);
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
