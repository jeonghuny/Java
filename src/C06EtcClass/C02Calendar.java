package C06EtcClass;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class C02Calendar {
    public static void main(String[] args) {
//        java.util패키지의 Calendar클래스
//        Calendar myCalendar = Calendar.getInstance();
//        System.out.println(myCalendar.getTime());
//        System.out.println(myCalendar.get(Calendar.YEAR));
//        System.out.println(myCalendar.get(Calendar.MONTH)+1); // 12월인데 11로 나옴 -> 0부터 센다
//        System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK)); // 요일 (일요일부터 1로 센다)
//        System.out.println(myCalendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(myCalendar.get(Calendar.HOUR));
//        System.out.println(myCalendar.get(Calendar.MINUTE));
//        System.out.println(myCalendar.get(Calendar.SECOND));


//        java.time패키지의 LocalDateTime ★, LocalDate, LocalTime클래스
//        LocalDate myLocalDate = LocalDate.now();
//        System.out.println(myLocalDate);
//        System.out.println(myLocalDate.getYear());
//        System.out.println(myLocalDate.getMonth());
//        System.out.println(myLocalDate.getMonthValue());
//        System.out.println(myLocalDate.getDayOfMonth());
//        System.out.println(myLocalDate.getDayOfWeek());

//        LocalTime myLocalTime = LocalTime.now();
//        System.out.println(myLocalTime.getHour());
//        System.out.println(myLocalTime.getMinute());
//        System.out.println(myLocalTime.getSecond());

        LocalDateTime myLocaldateTime = LocalDateTime.now();
//        System.out.println(myLocaldateTime.getYear());
//        System.out.println(myLocaldateTime.getHour());
//        chronoField매개변수로 다양한 형식의 날짜/시간정보 조회
        System.out.println(myLocaldateTime.get(ChronoField.YEAR));
        System.out.println(myLocaldateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(myLocaldateTime.get(ChronoField.AMPM_OF_DAY)); // 0:오전 , 1:오후
        System.out.println(myLocaldateTime.get(ChronoField.CLOCK_HOUR_OF_DAY)); // 24시체계


//        .of : 임의로 특정시간정보객체를 만들어내고 싶을 때 사용
        LocalDate birthDay = LocalDate.of(2000,11,12);
        System.out.println(birthDay);

        LocalDateTime birthDayTime = LocalDateTime.of(2000,11, 12,15,14,10);
        System.out.println(birthDayTime); // 2000-11-12T15:14:10 (날짜와 시간 사이에 T가 들어감)
    }
}
