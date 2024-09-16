package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/db_agenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "root";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Creates the.
	 *
	 * @param contato the contato
	 */
	public void create(JavaBeans contato) {
		String create = "insert into contatos(nome,fone,email) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String query = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet sr = pst.executeQuery();
			while (sr.next()) {
				int id = sr.getInt(1);
				String nome = sr.getString(2);
				String fone = sr.getString(3);
				String email = sr.getString(4);

				contatos.add(new JavaBeans(id, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read = "select * from contatos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setInt(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Update.
	 *
	 * @param contato the contato
	 */
	public void update(JavaBeans contato) {
		String update = "update contatos set nome=?, fone=?, email=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setInt(4, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Delete.
	 *
	 * @param contato the contato
	 */
	public void delete(JavaBeans contato) {
		String delete = "delete from contatos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
