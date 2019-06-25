import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Month;

class Weeks
{
    /**
     *
     * @param Y Year in which john goes to vacation
     * @param A Month in which john starts vacation
     * @return first monday of the month A
     */
    LocalDate getFirstMonday(int Y,String A){
        LocalDate date1=LocalDate.of(Y,Month.valueOf(A),1);
        return date1.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    /**
     *
     * @param Y Year in which john goes to vacation
     * @param B Month in which ends  starts vacation
     * @return Last sunday of month B
     */

    LocalDate getLastSunday(int Y,String B){
        LocalDate date1=LocalDate.of(Y,Month.valueOf(B),1);
        return date1.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
    }

    int solution(int Y, String A, String B, String W){
        //Convert month names to uppercase

            A = A.toUpperCase();
            B = B.toUpperCase();


        //Finding first monday and last sunday of initial and final months
        try{
            LocalDate dateOfFirstMonday=getFirstMonday(Y,A);
            LocalDate dateOfLastSunday=getLastSunday(Y,B);
            //number of days between first monday of month john goes and last sunday of month john comes
            int noOfDaysBetween = (int) ChronoUnit.DAYS.between(dateOfFirstMonday, dateOfLastSunday);
            return (noOfDaysBetween+1)/7;
        }

         catch (IllegalArgumentException E){
            System.out.println("Please enter valid month name");
        }
       return -1;
    }

    public static void main (String[] args) throws java.lang.Exception
    {   int Y=2001;
        Weeks weeks=new Weeks();
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter the year in which John goes to vacation");
            Y=sc.nextInt();
        }
        catch (InputMismatchException E){
            System.out.println("please enter valid year. Year 2001 is being considered by default");
        }
        sc.nextLine();
        System.out.println("Enter the month name in which John goes to vacation");
        String A=sc.nextLine();
        System.out.println("Enter the month name in which John comes back from  vacation");
        String B=sc.nextLine();
        System.out.println("Enter the first day of the year");
        String W=sc.nextLine();
        int weeksInBetween=weeks.solution(Y,A,B,W);
        if(weeksInBetween>=0) {
            System.out.println(weeksInBetween);
        }
        else{
            System.out.println("End month cant be before start month");
        }
    }
}