package im.atzma.lista.appmanager;

import im.atzma.lista.model.ClientData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ClientListPage extends HelperBase {
    public ClientListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='מאגר לקוחות']")
    WebElement title_on_clienPage;

    @FindBy(xpath = "//span[@class='app-clients-list__header-title count']")
    WebElement number_of_client;

    @FindBy(xpath = "//*[@data-id]")
    List<WebElement> clients_in_List;

    @FindBy(xpath = "//a[@class='item__tel']")
    List<WebElement> clients_link_in_List;

    @FindBy(xpath = "//*[@class='del-btn']//button")
    WebElement btn_deleteClient;

    @FindBy(xpath = "//button[@class='yes-btn']")
    WebElement btn_deleteClient_confirm;

    public boolean verifyTitleText() throws InterruptedException {
        waitForElement(title_on_clienPage);
        highlight(title_on_clienPage);
        if (title_on_clienPage.isDisplayed()) {
            return true;
        } else return false;
    }

    public String verifyNumberOfClient() throws InterruptedException {
        highlight(number_of_client);
        System.out.println("number of client: " + number_of_client.getText());
//        if(number_of_client.getText().contentEquals("(1)")) {
//            return true;
//        }
//        else return false;
        String n = number_of_client.getText();
        return n;
    }


    public int getClientCount() {
        return clients_in_List.size();
    }

    public void deleteSelectedClient() {
        for (int i = 0; i < clients_link_in_List.size() ; i++) {
            click(clients_link_in_List.get(i));
        }
        click(btn_deleteClient);
        click(btn_deleteClient_confirm);
    }


    public void selectClient(int index) {
        click(clients_link_in_List.get(index));
    }
}
