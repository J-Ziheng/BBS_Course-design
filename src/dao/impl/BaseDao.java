/*
 * Dao�Ļ��࣬ʹ��JDBC�������ݿ⡢�ͷ���Դ��ִ��sql�����Ա�����Daoʵ����̳л�ʵ����ʹ��
 */
package dao.impl;

import java.sql.*;

public class BaseDao {
	public final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ���ݿ�����
	public final static String url = "jdbc:sqlserver://localhost:1433;DataBaseName=bbs"; // url
	public final static String dbName = "sa"; // ���ݿ��û���
	public final static String dbPass = "sa123456"; // ���ݿ�����

	/**
	 * �õ����ݿ�����
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return ���ݿ�����
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(driver); // ע������
		Connection conn = DriverManager.getConnection(url, dbName, dbPass); // ������ݿ�����
		return conn; // ��������
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param pstmt
	 *            PreparedStatement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		/* ���rs���գ��ر�rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���pstmt���գ��ر�pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���conn���գ��ر�conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
	 * 
	 * @param sql
	 *            Ԥ����� SQL ���
	 * @param param
	 *            Ԥ����� SQL ����еġ������������ַ�������
	 * @return Ӱ�������
	 */
	public int executeSQL(String preparedSql, String[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			num = pstmt.executeUpdate(); // ִ��SQL���
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			closeAll(conn, pstmt, null); // �ͷ���Դ
		}
		return num;
	}
}
