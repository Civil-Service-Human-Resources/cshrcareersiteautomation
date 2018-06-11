package cshr.careersite.steps;

import cshr.careersite.model.UserType;
import cshr.careersite.pages.backend.teams.TeamPage;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.MediaSteps;
import cshr.careersite.steps.backend.TeamPageSteps;
import cshr.careersite.steps.backend.UserSteps;
import net.thucydides.core.annotations.Steps;

public class BeforeAllTests {

    @Steps
    private UserSteps userSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private TeamPageSteps teamPageSteps;

    @Steps
    private MediaSteps mediaSteps;

    private TeamPage teamPage;


    public void BeforeAll() {

      /* File lockFile = new File("./lock");
       File file = new File("./BeforeAll.txt");

       try {
           if(lockFile.createNewFile()) {
               if (file.createNewFile()) {
                   System.out.println("File is created!");*/
        createTeam1And2();
        assignTeamsToDefaultRoles();
        uploadRelevantImages();
              /* } else {
                   System.out.println("File already exists.");
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }*/
    }

    private void createTeam1And2()
    {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.TECH_ADMIN.getValue());
        teamPageSteps.openTeamListPage();
        if (!teamPage.checkIfTeamNameExists("Team1")) {
            teamPage.typeInto(teamPage.teamName, "Team1");
            teamPage.typeInto(teamPage.teamDescription, "Team1");
            teamPage.addNewTeamButton.click();
        }

        if (!teamPage.checkIfTeamNameExists("Team2")) {
            teamPage.typeInto(teamPage.teamName, "Team2");
            teamPage.typeInto(teamPage.teamDescription, "Team2");
            teamPage.addNewTeamButton.click();
        }
    }

    private void assignTeamsToDefaultRoles()
    {
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentAdmin1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentApprover1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentAuthor1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentPublisher1", "team1And2");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentSnippets1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("techadmin", "team1And2");
    }

    private void uploadRelevantImages()
    {
        System.out.println("before @media");
        mediaSteps.addMediaRequiredForTests();
    }
}
