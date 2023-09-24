package pages;

public class HomePage {

    util.BrowserActions browserActions;

    public HomePage () {
        browserActions.initBrowser();
    }

    public void getLink(String link) {
        browserActions.openSite(link);
    }
}
