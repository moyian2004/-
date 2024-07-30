package poess;


	import java.sql.*; 
	public class test {
	   public static Connection connect(){
		   
		      Connection con=null;
		      Statement sql; 
		      ResultSet rs;
		     
		      try{  Class.forName("com.mysql.cj.jdbc.Driver"); 
		      }
		      catch(Exception e){}
		      
		     String uri = "jdbc:mysql://localhost:3306/ccc?"+"useSSL=true&serverTimezone=GMT";


		      String student ="root";
		      String password ="chk531887512";
		      try{  
		         con = DriverManager.getConnection(uri,student,password); 
		      }
		      catch(SQLException e){ }
		     /* try { 
		          sql=con.createStatement();
		          rs=sql.executeQuery("SELECT * FROM student"); //��ѯmess��
		          while(rs.next()) {
		             String name=rs.getString(1);
		             int ps=rs.getInt(2);
		          //   Date date=rs.getDate(3);
		         //    float height=rs.getFloat(4);
		             System.out.printf("%s\t",name);
		             System.out.printf("%d\t",ps);
		          //   System.out.printf("%s\t",date); 
		          // //  System.out.printf("%.2f\n",height);
		          }
		          con.close();
		      }
		      catch(SQLException e) { 
		         System.out.println(e);
		      }   */
		      return con;
	  }
	}


