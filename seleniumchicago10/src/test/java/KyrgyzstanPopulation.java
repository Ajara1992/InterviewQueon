import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import java.awt.*;
import java.util.List;

public class KyrgyzstanPopulation {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/List_of_countries_by_population_(United_Nations)");
    }

    @Test
    public void test1() {
        List<WebElement>listOfHeader=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']"));
        int indexFoprCountries=0;
        int indexForPopulation=0;

        for(int i =0; i< listOfHeader.size(); i++){
            if(listOfHeader.get(i).getText().contains("Polpulation") && listOfHeader.get(i).getText().contains("1 JUly 2017")){
                indexFoprCountries= i+1;
                indexForPopulation= i+1;
            }
            if(listOfHeader.get(i).getText().equals("Country of area")){
                indexForPopulation=i+1;

            }
        }




        List<WebElement> listOfCountries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td["+indexFoprCountries+"]"));
        List<WebElement> ListOfPopulations = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td["+indexForPopulation+"]"));


        for (int i = 0; i < listOfCountries.size(); i++){
            if(listOfCountries.get(i).getText().contains("Kyrgyzstan")){
                System.out.println(listOfCountries.get(i).getText() + " " + ListOfPopulations.get(i).getText());
            }
        }
    }
}