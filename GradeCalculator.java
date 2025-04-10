import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine() + "\n" + scanner.nextLine();
        scanner.close();

        String[] lines = input.split("\n");

        String[] firstLine = lines[0].split(" ");
        int n = Integer.parseInt(firstLine[0]);

        if (n == 0) {
            System.out.println("invalid input");
            return;
        }

        int[] assignmentScores = new int[n];
        int totalAssignmentScore = 0;

        for (int i = 0; i < n; i++) {
            assignmentScores[i] = Integer.parseInt(firstLine[i + 1]);
            if (assignmentScores[i] < 0 || assignmentScores[i] > 100) {
                System.out.println("invalid input");
                return;
            }
            totalAssignmentScore += assignmentScores[i];
        }

        String[] secondLine = lines[1].split(" ");
        int midtermScore = Integer.parseInt(secondLine[0]);
        int finalScore = Integer.parseInt(secondLine[1]);

        if (midtermScore < 0 || midtermScore > 100 || finalScore < 0 || finalScore > 100) {
            System.out.println("invalid input");
            return;
        }

        double averageAssignmentScore = totalAssignmentScore / (double) n;

        double overallScore = (averageAssignmentScore * 0.5) + (midtermScore * 0.125) + (finalScore * 0.375);

        char grade;

        if (overallScore >= 90 && overallScore <= 100) {
            grade = 'A';
        }
        else if (overallScore >= 80 && overallScore < 90) {
            grade = 'B';
        }
        else if (overallScore >= 70 && overallScore < 80) {
            grade = 'C';
        }
        else if (overallScore >= 60 && overallScore < 70) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        
        System.out.println(overallScore);
        System.out.println(grade);
    }
}