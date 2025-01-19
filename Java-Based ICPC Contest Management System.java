import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Actor interface to represent common properties of actors
interface Actor {
    String getUsername();
}

// TeamCaptain class representing Team Captains
class TeamCaptain implements Actor {
    private String username;

    public TeamCaptain(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }
}

// ProblemSetter class representing Problem Setters
class ProblemSetter implements Actor {
    private String username;

    public ProblemSetter(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }
}

// TeamMember class representing Team Members
class TeamMember implements Actor {
    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    @Override
    public String getUsername() {
        return name;
    }
}

// SystemAdministrator class representing System Administrators
class SystemAdministrator implements Actor {
    private String username;

    public SystemAdministrator(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }
}

// Team class representing a team and its members
class Team {
    private String teamName;
    private String university;
    private List<TeamMember> members;

    public Team(String teamName, String university) {
        this.teamName = teamName;
        this.university = university;
        this.members = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public String getUniversity() {
        return university;
    }

    public List<TeamMember> getMembers() {
        return members;
    }

    public void addTeamMember(TeamMember member) {
        members.add(member);
    }
}

// Problem class representing programming problems
class Problem {
    private String statement;
    private String testCases;
    private String sampleSolutions;
    private String difficultyLevel;
    private String[] tags;
    private String hints;

    public Problem(String statement, String testCases, String sampleSolutions, String difficultyLevel, String[] tags, String hints) {
        this.statement = statement;
        this.testCases = testCases;
        this.sampleSolutions = sampleSolutions;
        this.difficultyLevel = difficultyLevel;
        this.tags = tags;
        this.hints = hints;
    }

    // Getters for problem details
    public String getStatement() {
        return statement;
    }

    public String getTestCases() {
        return testCases;
    }

    public String getSampleSolutions() {
        return sampleSolutions;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String[] getTags() {
        return tags;
    }

    public String getHints() {
        return hints;
    }
}

// TeamRegistrationSystem class to handle the team registration process
class TeamRegistrationSystem {
    private Scanner scanner;

    public TeamRegistrationSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method for team registration
    public Team registerTeam(TeamCaptain teamCaptain) {
        System.out.println("Team Registration Form");
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        System.out.print("Enter university: ");
        String university = scanner.nextLine();

        Team team = new Team(teamName, university);

        System.out.print("Enter the number of team members: ");
        int numMembers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numMembers; i++) {
            System.out.print("Enter team member name: ");
            String memberName = scanner.nextLine();
            TeamMember member = new TeamMember(memberName);
            team.addTeamMember(member);
        }

        // Additional logic for team registration...

        return team;
    }
}

// ProblemSubmissionSystem class to handle the problem addition process
class ProblemSubmissionSystem {
    private Scanner scanner;
    private ProblemRepository problemRepository;

    public ProblemSubmissionSystem(Scanner scanner, ProblemRepository problemRepository) {
        this.scanner = scanner;
        this.problemRepository = problemRepository;
    }

    // Method for adding a new problem
    public void addProblem(ProblemSetter problemSetter) {
        System.out.println("Problem Submission Form");
        System.out.print("Enter problem statement: ");
        String statement = scanner.nextLine();

        // Check if the problem already exists
        if (problemRepository.isProblemExist(statement)) {
            System.out.println("Error: The problem already exists. Please review and update if needed.");
            return;
        }

        System.out.print("Enter test cases: ");
        String testCases = scanner.nextLine();
        System.out.print("Enter sample solutions: ");
        String sampleSolutions = scanner.nextLine();
        System.out.print("Enter problem difficulty level: ");
        String difficultyLevel = scanner.nextLine();
        System.out.print("Enter tags (comma-separated): ");
        String[] tags = scanner.nextLine().split(",");
        System.out.print("Provide hints or explanations for the problem: ");
        String hints = scanner.nextLine();

        Problem problem = new Problem(statement, testCases, sampleSolutions, difficultyLevel, tags, hints);

        // Additional logic for problem submission...

        // Confirm the addition of the new problem
        System.out.print("Do you want to submit the new problem? (yes/no): ");
        String submitChoice = scanner.nextLine().toLowerCase();
        if (submitChoice.equals("yes")) {
            problemRepository.addProblem(problem);
            System.out.println("New problem successfully added to the repository.");
        } else {
            System.out.println("Problem submission canceled.");
        }
    }
}

// ProblemRepository class to manage problems
class ProblemRepository {
    private static final int MAX_PROBLEMS = 100;
    private Problem[] problems;
    private int problemCount;

    public ProblemRepository() {
        this.problems = new Problem[MAX_PROBLEMS];
        this.problemCount = 0;
    }

    public void addProblem(Problem problem) {
        problems[problemCount++] = problem;
    }

    public boolean isProblemExist(String statement) {
        for (int i = 0; i < problemCount; i++) {
            if (problems[i].getStatement().equalsIgnoreCase(statement)) {
                return true;
            }
        }
        return false;
    }
}

// TeamSubmissionSystem class to handle the team submission process
class TeamSubmissionSystem {
    private Scanner scanner;

    public TeamSubmissionSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method for submitting a solution
    public void submitSolution(TeamMember teamMember) {
        System.out.println("Solution Submission Form");
        System.out.print("Select the problem for submission: ");
        String selectedProblem = scanner.nextLine();
        System.out.print("Upload the solution code: ");
        String solutionCode = scanner.nextLine();
        System.out.print("Provide additional comments or explanations: ");
        String comments = scanner.nextLine();

        // Additional logic for solution submission...

        // Confirm the submission
        System.out.print("Do you want to submit the solution? (yes/no): ");
        String submitChoice = scanner.nextLine().toLowerCase();
        if (submitChoice.equals("yes")) {
            System.out.println("Solution successfully submitted.");
        } else {
            System.out.println("Solution submission canceled.");
        }
    }
}

// AccessControlSystem class to handle access control configuration
class AccessControlSystem {
    private Scanner scanner;

    public AccessControlSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method for configuring access control
    public void configureAccessControl(SystemAdministrator systemAdministrator) {
        System.out.println("Access Control Configuration");
        System.out.print("Enter the number of user roles to define: ");
        int numRoles = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Additional logic for defining user roles and permissions...

        // Confirm the configuration
        System.out.print("Do you want to save the changes? (yes/no): ");
        String saveChoice = scanner.nextLine().toLowerCase();
        if (saveChoice.equals("yes")) {
            System.out.println("Access control configuration saved.");
        } else {
            System.out.println("Access control configuration canceled.");
        }
    }
}

public class ICPCApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize repositories
        ProblemRepository problemRepository = new ProblemRepository();

        // Use Case 1: Register Team
        System.out.print("Enter Team Captain's username: ");
        String teamCaptainUsername = scanner.nextLine();
        TeamCaptain teamCaptain = new TeamCaptain(teamCaptainUsername);
        TeamRegistrationSystem teamRegistrationSystem = new TeamRegistrationSystem(scanner);
        Team team = teamRegistrationSystem.registerTeam(teamCaptain);

        // Use Case 2: Add Problem
        System.out.print("Enter Problem Setter's username: ");
        String problemSetterUsername = scanner.nextLine();
        ProblemSetter problemSetter = new ProblemSetter(problemSetterUsername);
        ProblemSubmissionSystem problemSubmissionSystem = new ProblemSubmissionSystem(scanner, problemRepository);
        problemSubmissionSystem.addProblem(problemSetter);

        // Use Case 3: Submit Solution
        System.out.print("Enter Team Member's name: ");
        String teamMemberName = scanner.nextLine();
        TeamMember teamMember = new TeamMember(teamMemberName);
        TeamSubmissionSystem teamSubmissionSystem = new TeamSubmissionSystem(scanner);
        teamSubmissionSystem.submitSolution(teamMember);

        // Use Case 4: Access Control
        System.out.print("Enter System Administrator's username: ");
        String adminUsername = scanner.nextLine();
        SystemAdministrator systemAdministrator = new SystemAdministrator(adminUsername);
        AccessControlSystem accessControlSystem = new AccessControlSystem(scanner);
        accessControlSystem.configureAccessControl(systemAdministrator);

        // Additional logic...

        scanner.close();
    }
}
