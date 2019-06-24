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
}
