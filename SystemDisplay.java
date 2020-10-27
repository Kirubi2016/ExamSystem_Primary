import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SystemDisplay {
	public static void headerDisplay() {
		System.out.println("\t\t\t\t\t---------------------------------");
		System.out.println("-----------------------------------------|  WELCOME TO MTIHANI SYSTEM  |------------------------------------------------");
		System.out.println("\t\t\t\t\t---------------------------------\n\n\t\t");
	}
	
	public static void headerMarkList() {
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("Name\t\tADM\tMATH\tENG\tSWA\tSCIE\tSS/RE\tTOTAL\tAVG\tGRD\tQUALIFICATION   ");
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}
	
	public static void input(int numberOfCandidates) {
		Scanner scanner = new Scanner(System.in);
		CandidateClass[] candidate = new CandidateClass[numberOfCandidates];
		
		int label = 0;
		
		for(int i = 0; i < numberOfCandidates; i++) {
			boolean isErrorPresent = true;
			
			double[] subMarksTemp = new double[CandidateClass.subjectNames.length];
			label++;
			candidate[i] = new CandidateClass();
			
			System.out.print("\nEnter Name of Candidate["+label+"]: ");
			candidate[i].setCandidateName(scanner.nextLine());
			
			while(isErrorPresent) {
				try {
					System.out.print("Enter Admission No. of Candidate: ");
					candidate[i].setAdmissionNumber(Integer.parseInt(scanner.nextLine()));
					isErrorPresent = false;
				}catch(NumberFormatException e) {
					System.out.println("\t-----INVALID ENTRY! Use numerals.-----\n");
				}
			}  
			
			for(int x = 0; x < CandidateClass.subjectNames.length; x++) {
				isErrorPresent = true;
				while(isErrorPresent) {
					try {
						System.out.print("\tEnter Marks for "+ CandidateClass.subjectNames[x]+": ");
						subMarksTemp[x] = Double.parseDouble(scanner.nextLine());
						if(subMarksTemp[x] > 100 || subMarksTemp[x] < 0) throw new RangeException();
						isErrorPresent = false;
					}catch(NumberFormatException e) {
						System.out.println("\t-----INVALID ENTRY! Use numerals.-----\n");
					}catch(RangeException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			
			candidate[i].setSubjectMarks(subMarksTemp);
			candidate[i].calcTotalMarks();
			candidate[i].calcAverageMarks();
			
			DBInsertion.updateMondayTable(candidate[i]);
		}
		
		ArrayList<CandidateClass> candidateList = new ArrayList<>();
		for(int i = 0; i < candidate.length; i++) {
			candidateList.add(candidate[i]);
		}
		Collections.sort(candidateList);
		
		output(candidateList);
	}
	
	
	
	public static void output(ArrayList<CandidateClass> candidateList) {
		System.out.println();
		headerMarkList();
		int label = 0;
		for(int i = 0; i < candidateList.size(); i++) {
			label++;
			System.out.print(label+". "+candidateList.get(i).getCandidateName()+"\t");
			System.out.print(candidateList.get(i).getAdmissionNumber()+"\t");
			
			for(int x = 0; x < CandidateClass.subjectNames.length; x++) {
				System.out.print(candidateList.get(i).getSubjectMarks()[x]+"\t");
			}
			
			System.out.print(candidateList.get(i).getTotalMarks()+"\t");
			System.out.print(candidateList.get(i).getAverageMarks()+"\t");
			System.out.print(candidateList.get(i).getGrade()+"\t");
			System.out.println(candidateList.get(i).isSecondaryQualification());
			
		}
	}

}

