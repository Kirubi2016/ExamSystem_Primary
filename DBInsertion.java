import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInsertion {
	
	public static void updateMondayTable (CandidateClass candidate) {
		//Establish Connection
		String url = "jdbc:mysql://127.0.0.1:3308/monday_test";
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, "root", "Vic@2016");
			
			//Statement creation
			Statement statement = connection.createStatement();
			
			//Execute statement
			String sql = "";
			sql = "INSERT INTO monday_candidate VALUE\r\n" + 
					"(NULL,'"+candidate.getCandidateName()+"',"+candidate.getAdmissionNumber()+","
							+ candidate.getSubjectMarks()[0]+","+candidate.getSubjectMarks()[1]+","+candidate.getSubjectMarks()[2]+","+candidate.getSubjectMarks()[3]+","+candidate.getSubjectMarks()[4]+","+
							candidate.getTotalMarks()+","+candidate.getAverageMarks()+",'"+ candidate.getGrade() +"','"+candidate.isSecondaryQualification()+"');";
			statement.executeUpdate(sql);
			
//			for(int i = 0; i < CandidateClass.subjectNames.length; i++) {
//				sql = "INSERT INTO monday_candidate(NULL,"+CandidateClass.subjectNames[i]+") VALUE"
//						+ "("+candidate.getSubjectMarks()[i]+");";
//				statement.executeUpdate(sql);
//			}
//			sql = "INSERT INTO monday_candidate(Total_Marks,Average_Marks,Grade,Secondary_Qualification) VALUE("
//					+ candidate.getTotalMarks()+","+candidate.getAverageMarks()+",'"+ candidate.getGrade() +"','"+candidate.isSecondaryQualification()+"');";
//			statement.executeUpdate(sql);
			
			System.out.println("Successful DB insertion!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			
	}

}
