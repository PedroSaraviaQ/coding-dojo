public class ProjectTest {
    public static void main(String[] args) {
        //* Projects
        Project project_1 = new Project();
        project_1.setName("Zoom");
        project_1.setDescription("A video conferencing app");
        project_1.setInitialCost(1000.00);
        System.out.println(project_1.elevatorPitch());

        Project project_2 = new Project("Slack");
        System.out.println(project_2.getName());

        Project project_3 = new Project("Google", "A search engine");
        project_3.setDescription("A search engine and more");
        System.out.println(project_3.getDescription());

        //* Optional: Portfolios
        Portfolio portfolio = new Portfolio();
        portfolio.addProject(project_1);
        portfolio.addProject(project_2);
        portfolio.addProject(project_3);

        System.out.println("Total cost: " + portfolio.getPortfolioCost());
        portfolio.showPortfolio();
    }
}
