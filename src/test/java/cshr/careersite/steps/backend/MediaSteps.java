package cshr.careersite.steps.backend;

import cshr.careersite.pages.backend.media.MediaPage;
import net.thucydides.core.annotations.Step;

public class MediaSteps {

    MediaPage mediaPage;

    @Step
    public void openAddNew()
    {
        mediaPage.addMedia.click();
        mediaPage.selectFiles.waitUntilVisible();
    }

    @Step
    public void addSampleMedia()
    {
        String baseDir = System.getProperty("user.dir").toString();
        addMediaByFileName(baseDir + "/src/test/resources/team.png");

    }

    public void addMediaByFileName(String fileNameWholePath)
    {
        mediaPage.uploadMedia(fileNameWholePath);
    }
}
