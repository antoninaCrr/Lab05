package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.polito.tdp.anagrammi.db.DBConnect;


public class AnagrammiDAO {
	
	public boolean isCorrect(String anagramma) {
		String sql = "SELECT nome FROM parola WHERE nome = ? ";
		boolean result;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			result = rs.first();

			conn.close();
			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}
	}

}
