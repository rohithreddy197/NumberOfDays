import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Month;

class Weeks
{
    /**
     *
     * @param monthName: Name of the month
     * @return Month name converted into capitals
     */
    int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

    /**
     *
     * @param date1 startdate of vacation
     * @param date2 enddate of vacation
     * @return weeks between startdate and end date
     */

    int weeksInBetween(Date date1, Date date2){
        int daysInBetween = (int)(TimeUnit.DAYS.convert(date1.getTime()-date2.getTime(), TimeUnit.MILLISECONDS));
        int weeksInBetween=(daysInBetween+1)/7;
        return weeksInBetween;
    }

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
            //Converting LocalDate to Date as timeunit works only on dates
            Date d1=java.sql.Date.valueOf(dateOfLastSunday);
            Date d2=java.sql.Date.valueOf(dateOfFirstMonday);
            int WeeksInBetween=weeksInBetween(d1,d2);
            return WeeksInBetween;
        }

         catch (IllegalArgumentException E){
            System.out.println("Please enter valid month name");
        }
       return -1;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Weeks weeks=new Weeks();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the year in which John goes to vacation");
        int Y=sc.nextInt();
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