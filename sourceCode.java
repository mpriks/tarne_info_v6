import com.sun.xml.internal.bind.v2.TODO;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by martinpr on 31/03/2018.
 */
public class sourceCode {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\martinpr\\OneDrive - Nortal AS\\Prog\\chromeWebDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://jira.arib.pria.ee/secure/Dashboard.jspa");
        //alternatiivne võimalus navigate() meetodile
        //driver.get("http://www.google.com");


        //sisestan kasutajanime, parooli ja klikin logi sisse nupul
        driver.findElement(By.id("login-form-username")).sendKeys("martin_nortal");
        driver.findElement(By.id("login-form-password")).sendKeys("350XN35x3");
        driver.findElement(By.id("login")).click();


        //wait vajalik selleks, et muidu ei leita piisavalt kiiresti elementi
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //navigeerin realese kuvale
        //TODO release kuvale saab nüüd vasakult külgmenüüst, laeva ikoon
        driver.findElement(By.id("browse_link")).click();
        driver.findElement(By.xpath("//*[@id=\"admin_main_proj_link_lnk\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div[1]/nav/div/div[2]/ul/li[2]/a/span[1]")).click();



        //klikin nupul "Välja lastud"
        //TODO nupul klikida pole vaja, on vaikimisi valitud
        driver.findElement(By.xpath("//*[@id=\"version-filter\"]/div[2]/a[1]")).click();


        //leian esimese release kirje
        String row_1Td_1 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[1]/td[2]/div/a")).getText();
        //jagan leitud stringi sümboli "-" juures osadeks
        String [] split_row_1Td_1 = row_1Td_1.split("-");
        //deklareerin stringi osa mida soovin leida
        String versionNr1 = split_row_1Td_1[1];
        String row_1Td_2 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[1]/td[3]/div/span")).getText();
        String row_1Td_3 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[1]/td[5]/div/time")).getText();
        String row_1Td_4 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[1]/td[6]/div/time")).getText();


        //leian teise rea realese kirje
        String row_2Td_1 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[2]/td[2]/div/a")).getText();
        String [] split_row_2Td_1 = row_2Td_1.split("-");
        String versionNr2 = split_row_2Td_1[1];
        String row_2Td_2 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[2]/td[3]/div/span")).getText();
        String row_2Td_3 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[2]/td[5]/div/time")).getText();
        String row_2Td_4 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[2]/td[6]/div/time")).getText();


        //leian kolmanda rea release kirje
        String row_3Td_1 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[3]/td[2]/div/a")).getText();
        String [] split_row_3Td_1 = row_3Td_1.split("-");
        String versionNr3 = split_row_3Td_1[1];
        String row_3Td_2 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[3]/td[3]/div/span")).getText();
        String row_3Td_3 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[3]/td[5]/div/time")).getText();
        String row_3Td_4 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[3]/td[6]/div/time")).getText();


        //leian neljanda rea release kirje
        String row_4Td_1 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[4]/td[2]/div/a")).getText();
        String [] split_row_4Td_1 = row_4Td_1.split("-");
        String versionNr4 = split_row_4Td_1[1];
        String row_4Td_2 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[4]/td[3]/div/span")).getText();
        String row_4Td_3 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[4]/td[5]/div/time")).getText();
        String row_4Td_4 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[4]/td[6]/div/time")).getText();


        //leian viienda rea release kirje
        String row_5Td_1 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[5]/td[2]/div/a")).getText();
        String [] split_row_5Td_1 = row_5Td_1.split("-");
        String versionNr5 = split_row_5Td_1[1];
        String row_5Td_2 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[5]/td[3]/div/span")).getText();
        String row_5Td_3 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[5]/td[5]/div/time")).getText();
        String row_5Td_4 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[5]/td[6]/div/time")).getText();


        //leian kuuenda rea release kirje
        String row_6Td_1 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[6]/td[2]/div/a")).getText();
        String [] split_row_6Td_1 = row_6Td_1.split("-");
        String versionNr6 = split_row_6Td_1[1];
        String row_6Td_2 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[6]/td[3]/div/span")).getText();
        String row_6Td_3 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[6]/td[5]/div/time")).getText();
        String row_6Td_4 = driver.findElement(By.xpath("//*[@id=\"versions-table\"]/tbody[2]/tr[6]/td[6]/div/time")).getText();




        System.out.println(versionNr1 + " " + row_1Td_2 + " " + row_1Td_3 + " " + row_1Td_4);
        System.out.println(versionNr2 + " " + row_2Td_2 + " " + row_2Td_3 + " " + row_2Td_4);
        System.out.println(versionNr3 + " " + row_3Td_2 + " " + row_3Td_3 + " " + row_3Td_4);
        System.out.println(versionNr4 + " " + row_4Td_2 + " " + row_4Td_3 + " " + row_4Td_4);
        System.out.println(versionNr5 + " " + row_5Td_2 + " " + row_5Td_3 + " " + row_5Td_4);
        System.out.println(versionNr6 + " " + row_6Td_2 + " " + row_6Td_3 + " " + row_6Td_4);



        //siit algab Jsoup kood
        //vajadusel saan muud koodiosa kahjustamata Jsoup osa eemaldada
        try {

            File input = new File("C:\\Users\\martinpr\\IdeaProjects\\SeleniumGetReleaseVersion\\src\\test\\java\\tarne.html");
            Document doc = Jsoup.parse(input, "UTF-8", "C:\\Users\\martinpr\\IdeaProjects\\SeleniumGetReleaseVersion\\src\\test\\java\\tarne.html");


            //leian html elemendi id järgi
            //select väärtus sain:
            //browseris parem klik elemendil -> Copy Selector
            Element row20_tb10 = doc.select("#row_20Td_10").first();
            //annan html elemendile uue väärtuse
            row20_tb10.text(row_1Td_2);

            Element row20_tb20 = doc.select("#row_20Td_20").first();
            row20_tb20.text(versionNr1);

            Element row20_tb30 = doc.select("#row_20Td_30").first();
            row20_tb30.text(row_1Td_3);

            Element row20_tb40 = doc.select("#row_20Td_40").first();
            row20_tb40.text(row_1Td_4);

            Element row20_tb50 = doc.select("#row_20Td_50").first();
            row20_tb50.text(" ");


            //leian ja täidan uute väärtustega tarne html tabeli teise kirje
            Element row30_tb10 = doc.select("#row_30Td_10").first();
            row30_tb10.text(row_2Td_2);
            Element row30_tb20 = doc.select("#row_30Td_20").first();
            row30_tb20.text(versionNr2);
            Element row30_tb30 = doc.select("#row_30Td_30").first();
            row30_tb30.text(row_2Td_3);
            Element row30_tb40 = doc.select("#row_30Td_40").first();
            row30_tb40.text(row_2Td_4);
            Element row30_tb50 = doc.select("#row_30Td_50").first();
            row30_tb50.text(" ");


            //leian ja täidan uute väärtustega tarne html tabeli kolmanda kirje
            Element row40_tb10 = doc.select("#row_40Td_10").first();
            row40_tb10.text(row_3Td_2);
            Element row40_tb20 = doc.select("#row_40Td_20").first();
            row40_tb20.text(versionNr3);
            Element row40_tb30 = doc.select("#row_40Td_30").first();
            row40_tb30.text(row_3Td_3);
            Element row40_tb40 = doc.select("#row_40Td_40").first();
            row40_tb40.text(row_3Td_4);
            Element row40_tb50 = doc.select("#row_40Td_50").first();
            row40_tb50.text(" ");


            //leian ja täidan uute väärtustega tarne html tabeli neljanda kirje
            Element row50_tb10 = doc.select("#row_50Td_10").first();
            row50_tb10.text(row_4Td_2);
            Element row50_tb20 = doc.select("#row_50Td_20").first();
            row50_tb20.text(versionNr4);
            Element row50_tb30 = doc.select("#row_50Td_30").first();
            row50_tb30.text(row_4Td_3);
            Element row50_tb40 = doc.select("#row_50Td_40").first();
            row50_tb40.text(row_4Td_4);
            Element row50_tb50 = doc.select("#row_50Td_50").first();
            row50_tb50.text(" ");


            //leian ja täidan uute väärtustega tarne html tabeli viienda kirje
            Element row60_tb10 = doc.select("#row_60Td_10").first();
            row60_tb10.text(row_5Td_2);
            Element row60_tb20 = doc.select("#row_60Td_20").first();
            row60_tb20.text(versionNr5);
            Element row60_tb30 = doc.select("#row_60Td_30").first();
            row60_tb30.text(row_5Td_3);
            Element row60_tb40 = doc.select("#row_60Td_40").first();
            row60_tb40.text(row_5Td_4);
            Element row60_tb50 = doc.select("#row_60Td_50").first();
            row60_tb50.text(" ");


            //leian ja täidan uute väärtustega tarne html tabeli kuuenda kirje
            Element row70_tb10 = doc.select("#row_70Td_10").first();
            row70_tb10.text(row_6Td_2);
            Element row70_tb20 = doc.select("#row_70Td_20").first();
            row70_tb20.text(versionNr6);
            Element row70_tb30 = doc.select("#row_70Td_30").first();
            row70_tb30.text(row_6Td_3);
            Element row70_tb40 = doc.select("#row_70Td_40").first();
            row70_tb40.text(row_6Td_4);
            Element row70_tb50 = doc.select("#row_70Td_50").first();
            row70_tb50.text(" ");







            //sisendina antud html fail "luuakse" uuesti, uute element väärtustega
            File output = new File("C:\\Users\\martinpr\\IdeaProjects\\SeleniumGetReleaseVersion\\src\\test\\java\\tarne.html");
            FileUtils.writeStringToFile(output, doc.outerHtml(), "UTF-8");

        }

        catch (IOException e){
            e.printStackTrace();
        }





        //siin lõppeb Jsoup kood


        //// TODO: 31/03/2018 välja kommenteeritud seniks, kui saan Wait meetodi tööle
        //01.04.18 kommenteerisin sisse, tundub, et piisab ajast mis kulub elemendi leidmiseks.
        driver.close();
        driver.quit();


    }
}
