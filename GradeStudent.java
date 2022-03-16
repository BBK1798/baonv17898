import java.util.Scanner;

public class GradeStudent {

	private int weight;
	private double weightedScore;
	private double scoreEarned;
	private int shifted;
	private double shiftAmount = 0;
	private double totalPoints;
	private int attend;
	private double maxTotal;
	private double sectionPoints;
	private int numberAssignments;
	private double pointAssignments;
	private double totalPointAssignments = 0;
	private double maxPointAssignments = 0;
	private double totalMaxPointAssignments = 0;
	private double maxSectionpoint = 30;
	private double overallPercentage;
	private int tongWeight;
	private double gpa = 0;
	String noti = "This program reads exam/homework scores and reports your overall course grade";
	Scanner sc = new Scanner(System.in);
	Scanner ec = new Scanner(System.in);


	public void begin() {
		System.out.println(noti);
		
	}

	public double Midterm() {

		System.out.println("Midterm : ");
		System.out.println("Weight ? ");

		weight = sc.nextInt();
		if (weight > 100) {
			weight = 100;
		} else if (weight < 0) {
			weight = 0;
		}
		System.out.println("Score Earned ? ");

		scoreEarned = sc.nextDouble();
		if (scoreEarned > 100) {
			scoreEarned = 100;
		} else if (scoreEarned < 0) {
			scoreEarned = 0;
		}
		System.out.println("Were scores shifted (1 = yes, 2=no) ? ");
		shifted = sc.nextInt();

		if (shifted == 1) {
			System.out.println("Shift amount ? ");
			shiftAmount = sc.nextDouble();
			if (shiftAmount > 100) {
				shiftAmount = 100;
			} else if (shiftAmount < 0) {
				shiftAmount = 0;
			}
		}

		totalPoints = shiftAmount + scoreEarned;
		if (totalPoints > 100) {
			totalPoints = 100;
		}
		System.out.println("Total points = " + totalPoints + " / 100");

		weightedScore = (double) Math.round(((totalPoints / 100) * (double) weight) * 10) / 10;
		System.out.println("Weighted score = " + weightedScore + " / " + weight);
		tongWeight += weight;
		return overallPercentage += weightedScore;
	}

	 public void Final() {
		System.out.println(" ");
		System.out.println("Final : ");
		System.out.println("Weight ? ");
		weight = sc.nextInt();		
		if (weight > 100) {
			weight = 100;
		} else if (weight < 0) {
			weight = 0;
		}
		System.out.println("Score Earned ? ");
		scoreEarned = sc.nextDouble();
		if (scoreEarned > 100) {
			scoreEarned = 100;
		} else if (scoreEarned < 0) {
			scoreEarned = 0;
		}
		System.out.println("Were scores shifted (1 = yes, 2=no) : ");
		shifted = sc.nextInt();
		if (shifted == 1) {
			System.out.println("Shift amount ? ");
			shiftAmount = sc.nextDouble();
			if (shiftAmount > 100) {
				shiftAmount = 100;
			} else if (shiftAmount < 0) {
				shiftAmount = 0;
			}
		}
		totalPoints = shiftAmount + scoreEarned;
		if (totalPoints > 100) {
			totalPoints = 100;
		}
		System.out.println("Total points = " + totalPoints + " / 100");
		weightedScore = (double) Math.round(((totalPoints / 100) * (double) weight) * 10) / 10;
		System.out.println("Weighted score = " + weightedScore + " / " + weight);
		tongWeight += weight;
		overallPercentage += weightedScore;
	}

 
	public void HomeWork() {
		boolean a = true;
		System.out.println(" ");
		System.out.println("Home work : ");
		System.out.println("Weight ? ");
		weight = sc.nextInt();
		do {
			if (100 != weight + tongWeight) {
				System.err.println("Total weight point = 100");
				System.out.println("Re-enter the weight point: ");
				weight = sc.nextInt();
				a = true;
			} else {
				a = false;
			}
		} while (a);
		System.out.println("Number of assignments ? ");
		numberAssignments = sc.nextInt();
		for (int i = 1; i <= numberAssignments; i++) {
			System.out.println("Assignments " + i + " score and max ?");
			pointAssignments = sc.nextDouble();
			maxPointAssignments = sc.nextDouble();
			totalPointAssignments += pointAssignments;
			totalMaxPointAssignments += maxPointAssignments;
		}
		if (maxPointAssignments > 150 || totalPointAssignments > 150) {
			maxPointAssignments = 150;
			totalPointAssignments = 150;
		}
		System.out.println("How many sections did you attend ? ");
		attend = sc.nextInt();
		sectionPoints = attend * 5;
		if (sectionPoints > maxSectionpoint) {
			sectionPoints = maxSectionpoint;
		}
		System.out.println("Section point = " + (int) sectionPoints + "/" + (int) maxSectionpoint);
		totalPoints = totalPointAssignments + sectionPoints;
		maxTotal = totalMaxPointAssignments + maxSectionpoint;
		System.out.println("Total points = " + (int) totalPoints + "/" + (int) maxTotal);
		weightedScore = (double) Math.round(((totalPoints / maxTotal) * (double) weight) * 10) / 10;
		System.out.println("Weighted score = " + weightedScore + " / " + weight);
		tongWeight += weight;
		overallPercentage += weightedScore;
	}

	public void report() {
		Scanner ec = new Scanner(System.in);
		System.out.println("Overall percentage = " + overallPercentage);
		if (overallPercentage >= 85) {
			gpa = 3.0;
		} else if (overallPercentage < 85 && overallPercentage > 75) {
			gpa = 2.0;
		} else if (overallPercentage > 60 && overallPercentage < 75) {
			gpa = 1.0;
		} else if (overallPercentage < 60) {
			gpa = 0.0;
		}
		System.out.println("Your grade will be at least: " + gpa);
		System.out.println(" <<   your custom grade message here   >>");
		String ecc = ec.nextLine();
		System.out.println(ecc);
	}

	public static void main(String[] args) {
		GradeStudent sinhVien = new GradeStudent();
		sinhVien.begin();
		sinhVien.Midterm();
		sinhVien.Final();
		sinhVien.HomeWork();
		sinhVien.report();
	}
}
