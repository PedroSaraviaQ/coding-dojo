import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projects;

    public Portfolio() {
        projects = new ArrayList<Project>();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public double getPortfolioCost() {
        double totalCost = 0;
        for (Project project : projects) {
            totalCost += project.getInitialCost();
        }
        return totalCost;
    }

    public void showPortfolio() {
        for (Project project : projects) {
            System.out.println(project.elevatorPitch());
        }
    }
}
