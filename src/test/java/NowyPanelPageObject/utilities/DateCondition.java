package NowyPanelPageObject.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateCondition {


    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DayOfWeek dateTimeDayOfWeek = date.getDayOfWeek();
        LocalDate saturday = null;

        switch (dateTimeDayOfWeek) {
            case MONDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.MONDAY)) {
                    saturday = date.plusDays(6);
                }
                break;
            case TUESDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.TUESDAY)) {
                    saturday = date.plusDays(5);
                }
                break;
            case WEDNESDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.WEDNESDAY)) {
                    saturday = date.plusDays(4);
                }
                break;
            case THURSDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.THURSDAY)) {
                    saturday = date.plusDays(3);
                }
                break;
            case FRIDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.FRIDAY)) {
                    saturday = date.plusDays(2);
                }
                break;
            case SATURDAY:
                if (dateTimeDayOfWeek.equals(DayOfWeek.SATURDAY)) {
                    saturday = date.plusDays(1);
                }
                break;
            default: {
                saturday = date;
            }
            break;
        }

        System.out.println(saturday);
    }


}






