import java.sql.*;
import java.util.Scanner;

public class Main { 
    private static final String URL = "jdbc:sqlite:meus_contatos.db";

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC"); 

            try (Connection conn = DriverManager.getConnection(URL)) {
                if (conn != null) {
                    criarTabela(conn);
                    menu(conn);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: O driver SQLite nao foi encontrado. Verifique o arquivo .jar");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    private static void criarTabela(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS contatos (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nome TEXT NOT NULL," +
                     "telefone TEXT NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private static void menu(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- AGENDA JAVA ---");
            System.out.println("1. Adicionar");
            System.out.println("2. Listar");
            System.out.println("3. Sair");
            System.out.print("Opcao: "); // Sem cedilha
            
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": adicionar(conn, scanner); break;
                case "2": listar(conn); break;
                case "3": return;
                default: System.out.println("Invalido!");
            }
        }
    }

    private static void adicionar(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String tel = scanner.nextLine();

        String sql = "INSERT INTO contatos(nome, telefone) VALUES(?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, tel);
            pstmt.executeUpdate();
            System.out.println("Salvo!");
        }
    }

    private static void listar(Connection conn) throws SQLException {
        String sql = "SELECT * FROM contatos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- LISTA ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + 
                                   rs.getString("nome") + " - " + 
                                   rs.getString("telefone"));
            }
        }
    }
}