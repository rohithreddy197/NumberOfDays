import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    @Test
    public  void TestCase1(){
        Weeks weeks=new Weeks();
        int Y=2014;
        String A="April";
        String B="May";
        String W="Wednesday";
        int expected=7;
        int actual=weeks.solution(Y,A,B,W);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public  void TestCase2(){
        Weeks weeks=new Weeks();
        int Y=2014;
        String B="April";
        String A="May";
        String W="Wednesday";
        int expected=-1;
        int actual=weeks.solution(Y,A,B,W);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void Testcase3(){
        Weeks weeks=new Weeks();
        int Y=2014;
        //Proper name for month should be given
        String B="Aprl";
        String A="May";
        String W="Wednesday";
        int expected=-1;
        int actual=weeks.solution(Y,A,B,W);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void Testcase4(){
        Weeks weeks=new Weeks();
        int Y=2016;
        //for leap years
        String A="April";
        String B="May";
        String W="Friday";
        int expected=8;
        int actual=weeks.solution(Y,A,B,W);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void Testcase5(){
        Weeks weeks=new Weeks();
        int Y=2014;
        //for 7 month period
        String A="January";
        String B="July";
        String W="Wednesday";
        int expected=29;
        int actual=weeks.solution(Y,A,B,W);
        Assert.assertEquals(expected,actual);
    }
}
