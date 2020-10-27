
public class CandidateClass implements Comparable<CandidateClass>{
	private String candidateName;
	private int admissionNumber;
	public static String[] subjectNames = {"Mathematics","English","Kiswahili","Science","Social_Studies"};
	private double[] subjectMarks = new double[subjectNames.length];
	private double totalMarks;
	private double averageMarks;
	private String grade;
	private boolean secondaryQualification;
	
	
	
	
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public int getAdmissionNumber() {
		return admissionNumber;
	}
	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}
	public double[] getSubjectMarks() {
		return subjectMarks;
	}
	public void setSubjectMarks(double[] subjectMarks) {
		this.subjectMarks = subjectMarks;
	}
	public void calcTotalMarks() {
		double sum = 0;
		for(int i = 0; i < subjectMarks.length; i++) {
			sum += subjectMarks[i];
		}
		this.totalMarks = sum;
	}
	public double getTotalMarks() {
		return totalMarks;
	}
	public void calcAverageMarks() {
		this.averageMarks = getTotalMarks()/subjectMarks.length;
	}
	public double getAverageMarks() {
		return averageMarks;
	}
	public String getGrade() {
		if(this.averageMarks <= 100.0 && this.averageMarks >= 80.0) {
			grade = "A";
		}else if(this.averageMarks <= 79.9 && this.averageMarks >= 75.0) {
			grade = "A-";
		}else if(this.averageMarks <= 74.9 && this.averageMarks >= 70.0) {
			grade = "B+";
		}else if(this.averageMarks <= 69.9 && this.averageMarks >= 65.0) {
			grade = "B";
		}else if(this.averageMarks <= 64.9 && this.averageMarks >= 60.0) {
			grade = "B-";
		}else if(this.averageMarks <= 59.9 && this.averageMarks >= 55.0) {
			grade = "C+";
		}else if(this.averageMarks <= 54.9 && this.averageMarks >= 50.0) {
			grade = "C";
		}else if(this.averageMarks <= 49.9 && this.averageMarks >= 45.0) {
			grade = "C-";
		}else if(this.averageMarks <= 44.9 && this.averageMarks >= 40.0) {
			grade = "D+";
		}else if(this.averageMarks <= 39.9 && this.averageMarks >= 35.0) {
			grade = "D";
		}else if(this.averageMarks <= 34.9 && this.averageMarks >= 30.0) {
			grade = "D-";
		}else if(this.averageMarks <= 29.9 && this.averageMarks >= 25.0) {
			grade = "E";
		}else {
			grade = "Y";
		}
		return grade;
	}
	public boolean isSecondaryQualification() {
		if(this.totalMarks > 249) {
			secondaryQualification = true;
		}else
			secondaryQualification = false;
		
		return secondaryQualification;
	}
	@Override
	public int compareTo(CandidateClass o) {
		if(o.getTotalMarks() < this.getTotalMarks()) {
			return -1;
		}else if(o.getTotalMarks() > this.getTotalMarks()) {
			return 1;
		}
		return 0;
	}

	
	
	

}
