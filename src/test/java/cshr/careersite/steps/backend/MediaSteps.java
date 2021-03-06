package cshr.careersite.steps.backend;

import cshr.careersite.pages.backend.media.MediaPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class MediaSteps {

    private MediaPage mediaPage;

    @Step
    public void addSampleMedia()
    {
        mediaPage.addNewMedia();
        String baseDir = System.getProperty("user.dir").toString();
        addMediaByFileName(baseDir + "/src/test/resources/team1.png");

    }

    public boolean addMediaByFileName(String fileNameWholePath)
    {
        mediaPage.addNewMedia();
        return mediaPage.uploadMedia(fileNameWholePath);
    }

    @Step
    public void addMediaRequiredForTests()
    {
        mediaPage.openAllMediaPage();
        String baseDir = System.getProperty("user.dir").toString();

        // Team1
        boolean addMedia = addMediaByFileName(baseDir + "/src/test/resources/team1.png");

        if(addMedia) {
            mediaPage.selectTeam(true, false);
        }

        mediaPage.openAllMediaPage();
        Assert.assertTrue(mediaPage.checkIfMediaExists("team1"));

        // Team2
        addMedia = addMediaByFileName(baseDir + "/src/test/resources/team2.jpg");

        if(addMedia) {
            mediaPage.selectTeam(false, true);
        }

        mediaPage.openAllMediaPage();
        Assert.assertTrue(mediaPage.checkIfMediaExists("team2"));

        // Team1 and Team2
        addMedia = addMediaByFileName(baseDir + "/src/test/resources/team1and2.jpg");

        if(addMedia) {
            mediaPage.selectTeam(true, true);
        }

        mediaPage.openAllMediaPage();

        Assert.assertTrue(mediaPage.checkIfMediaExists("team1and2"));

    }

    public boolean deleteMedia(String mediaName) {
        mediaPage.openAllMediaPage();
        mediaPage.selectMediaByName(mediaName);
        mediaPage.delete();
        mediaPage.waitFor(mediaPage.addMedia);
        return mediaPage.checkIfMediaExists(mediaName);
    }

    public boolean uploadMedia(String fileName) {
        mediaPage.openAllMediaPage();
        String baseDir = System.getProperty("user.dir").toString();
        return addMediaByFileName(baseDir + "/src/test/resources/" + fileName);

    }
}
