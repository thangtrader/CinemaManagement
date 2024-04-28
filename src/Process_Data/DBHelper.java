	package Process_Data;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.Types;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.sql.CallableStatement;
	
	public class DBHelper {
	    private static DBHelper _Instance;
	    protected Connection cnn;
	    private Statement stm;
	
	    private DBHelper(String url) {
	        try {
	            cnn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public static DBHelper getInstance() {
	        if (_Instance == null) {
	            String url = "jdbc:sqlserver://" + "localhost" + ":1433;databaseName=" + "QuanLyRapChieuPhim" + ";user=" + "sa" + " ;password=" + "Thang@3008" + ";encrypt=true;trustServerCertificate=true";
	            _Instance = new DBHelper(url);
	        }
	        return _Instance;
	    }
	
	    public Connection getConnection() {
	        return cnn;
	    }
	    public DBHelper() {
	        try {
	            String DriverClass, DriverURL;
	            String UserName = "sa";
	            String PassWord = "Thang@3008";
	            String DataBaseName = "QuanLyRapChieuPhim";
	            String ServerName = "localhost";
	
	            String IntegratedSecurity = "IntegratedSecurity=false";
	            DriverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	            DriverURL = "jdbc:sqlserver://" + ServerName + ":1433;databaseName=" + DataBaseName + ";user=" + UserName + " ;password=" + PassWord + ";encrypt=true;trustServerCertificate=true";
	            Class.forName(DriverClass);
	            this.cnn = DriverManager.getConnection(DriverURL);
	            this.stm = this.cnn.createStatement();
	
	        } catch (SQLException ex) {
	        } catch (Exception e) {
	        }
	    }
	
	    public Object executeScalar(String tenTaiKhoan, String matKhau) {
	        Object data = null;
	        try {
	            // Chuẩn bị câu lệnh gọi stored procedure với hai tham số
	            String query = "{call KiemTraDangNhap(?, ?)}";
	            CallableStatement statement = this.cnn.prepareCall(query);
	
	            // Truyền giá trị cho hai tham số
	            statement.setString(1, tenTaiKhoan);
	            statement.setString(2, matKhau);
	
	            // Thực thi truy vấn
	            statement.execute();
	
	            // Lấy kết quả trả về từ stored procedure
	            if (statement.getResultSet() != null && statement.getResultSet().next()) {
	                data = statement.getResultSet().getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
	    
	    public ResultSet getResultSet_StoredProcedures(String procName) {
	        ResultSet rs = null;
	        CallableStatement cs = null;
	        try {
	            cs = cnn.prepareCall("{call " + procName + "}");
	            rs = cs.executeQuery();
	        } catch (Exception e) {
	            return rs;
	        }
	        return rs;
	    }
	    
	    public ResultSet getResultSet_StoredProcedures(String NameStoredProcedures, Object[] param) {
	        ResultSet rs = null;
	        CallableStatement cs = null;
	        String p = "(";
	        for (int i = 0; i < param.length - 1; i++) {
	            p += "?, ";
	        }
	        if (param.length > 0) {
	            p += "?";
	        }
	        p += ")";
	//        System.out.println(p);
	        try {
	            cs = cnn.prepareCall("{call " + NameStoredProcedures + p + "}");
	            if (param != null) {
	                int i = 1;
	                for (Object value : param) {
	                    cs.setObject(i, value);
	                    i++;
	                }
	            }
	            rs = cs.executeQuery();
	//            cs.close();
	            return rs;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }
	    public int Execute_StoredProcedures(String NameStoredProcedures, Object[] param) {
	        CallableStatement cs = null;
	        String p = "(";
	        for (int i = 0; i < param.length - 1; i++) {
	            p += "?,";
	        }
	        if (param.length > 0) {
	            p += "?";
	        }
	        p += ")";
	//        System.out.println(p);
	        try {
	            int k = 0;
	            cs = this.cnn.prepareCall("{call " + NameStoredProcedures + p + "}");
	            int i = 1;
	            for (Object value : param) {
	                cs.setObject(i, value);
	                i++;
	            }
	            k = cs.executeUpdate();
	//            cs.close();
	            return k;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	    public ResultSet executeQuery(String query, Object[] parameter) {
	        ResultSet resultSet = null;
	        try {
	            PreparedStatement statement = cnn.prepareStatement(query);
	            if (parameter != null) {
	                for (int i = 0; i < parameter.length; i++) {
	                    statement.setObject(i + 1, parameter[i]);
	                }
	            }
	            resultSet = statement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return resultSet;
	    }
	
	    public int executeNonQuery(String query, Object[] parameter) {
	        int data = 0;
	        try {
	            PreparedStatement statement = cnn.prepareStatement(query);
	            if (parameter != null) {
	                for (int i = 0; i < parameter.length; i++) {
	                    statement.setObject(i + 1, parameter[i]);
	                }
	            }
	            data = statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }
	
	    public void command(String query, Object[] parameter) {
	        try {
	            PreparedStatement statement = cnn.prepareStatement(query);
	            if (parameter != null) {
	                for (int i = 0; i < parameter.length; i++) {
	                    statement.setObject(i + 1, parameter[i]);
	                }
	            }
	            statement.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    
	    
	    public ResultSet ExecuteQuery(String query, Object[] parameters) throws SQLException {
	        ResultSet resultSet = null;
	        try {
	            PreparedStatement preparedStatement = cnn.prepareStatement(query);
	            if (parameters != null) {
	                String[] listData = query.split(" ");
	                int i = 0;
	                for (String item : listData) {
	                    if (item.contains("@")) {
	                        preparedStatement.setObject(i + 1, parameters[i]);
	                        if (parameters[i] == null) {
	                            preparedStatement.setObject(i + 1, null);
	                        }
	                        i++;
	                    }
	                }
	            }
	            resultSet = preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return resultSet;
	    }
	}
