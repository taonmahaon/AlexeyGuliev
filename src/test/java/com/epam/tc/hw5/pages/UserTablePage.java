package com.epam.tc.hw5.pages;

import static com.epam.tc.hw5.Constants.USER_TABLE_PAGE_TITLE;
import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserTablePage extends BaseJdiTestingPage {

    public UserTablePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "#user-table select")
    private List<WebElement> dropdowns;

    @FindBy(css = "#user-table a")
    private List<WebElement> userNames;

    @FindBy(css = "#user-table div.user-descr span")
    private List<WebElement> userDescription;

    @FindBy(css = "#user-table div.user-descr span")
    private List<WebElement> checkboxes;

    @FindBy(css = "#user-table thead")
    private WebElement userTableHead;

    @FindBy(css = "#user-table tbody")
    private WebElement userTableBody;

    @FindBy(css = "#user-table tbody tr")
    private List<WebElement> userTableRows;

    @FindBy(css = "#user-table tbody tr select option")
    private List<WebElement> romanDropdown;

    @FindBy(css = "td:nth-child(1)")
    private List<WebElement> numbers;

    @FindBy(css = "td:nth-child(2)")
    private List<WebElement> types;

    @FindBy(css = "td:nth-child(3)")
    private List<WebElement> users;

    @FindBy(css = "td:nth-child(4) span")
    private List<WebElement> descriptions;

    @FindBy(id = "ivan")
    private WebElement ivanVipCheckbox;


    public WebElement getIvanVipCheckbox() {
        return ivanVipCheckbox;
    }

    public List<WebElement> getNumbers() {
        return numbers;
    }

    public List<WebElement> getTypes() {
        return types;
    }

    public List<WebElement> getUsers() {
        return users;
    }

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public List<WebElement> getRomanDropdown() {
        return romanDropdown;
    }

    public List<WebElement> getTableRows() {
        return userTableRows;
    }

    public WebElement getUserTableBody() {
        return userTableBody;
    }

    public WebElement getUserTableHead() {
        return userTableHead;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getUserDescription() {
        return userDescription;
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public void assertUserTablePageTitle() {
        assertThat(getPageTitle()).isEqualTo(USER_TABLE_PAGE_TITLE);
    }

    public void assertUserTableDropdowns() {
        assertThat(getDropdowns().size()).isEqualTo(6);
    }

    public void assertUserNames() {
        assertThat(getUserNames().size()).isEqualTo(6);
    }

    public void assertUserDescription() {
        assertThat(getUserDescription().size()).isEqualTo(6);
    }

    public void assertCheckboxes() {
        assertThat(getCheckboxes().size()).isEqualTo(6);
    }

    public void assertTableText(DataTable dataTable) {
        List<Map<String, String>> tempList = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < tempList.size(); i++) {
            assertThat(getNumbers().get(i).getText()).isEqualTo(tempList.get(i).get("Number"));
            assertThat(getUsers().get(i).getText()).isEqualTo(tempList.get(i).get("User"));
            assertThat(getDescriptions().get(i).getText().trim().replace("\n", " "))
                .isEqualTo(tempList.get(i).get("Description"));
        }
    }

    public void assertRomanDropdown(DataTable dataTable) {
        List<String> romanDrops = dataTable.asList().subList(1, 4);
        for (int p = 0; p < romanDrops.size(); p++) {
            assertThat(getRomanDropdown().get(p).getText().trim()).isEqualTo(romanDrops.get(p));
        }
    }

    public void clickIvanVipCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(ivanVipCheckbox)).click();
    }


}
