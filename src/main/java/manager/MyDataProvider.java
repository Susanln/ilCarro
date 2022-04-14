package manager;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> validLoginData()
    {
        List<Object[]>list=  new ArrayList<>();
        list.add(new Object[]{"qdas1@mail.ru","Qweasd12"});
        list.add(new Object[]{"qdas1@mail.ru","Qweasd12"});
        list.add(new Object[]{"qdas1@mail.ru","Qweasd12"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validAddNewCarData()
    {
        int index = (int)System.currentTimeMillis()/1000%3600;
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Tel aviv","BMW","M5","2022","2.5","Petrol","AT",
                "AWD","5","5","C","6.5","100-52-"+ index,"65","500","Type of features","Very good"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validRegData()
    {
        int index = (int)System.currentTimeMillis()/1000%3600;
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Anna","Lomar", "akdx"+index+"zc@gmail.com","Zcvbb2ds2!"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validSearchData()
    {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Tel Aviv","05/05/2022","04/05/2023"});
        list.add(new Object[]{"Tel Aviv","06/05/2022","03/05/2023"});
        return list.iterator();

    }
}
