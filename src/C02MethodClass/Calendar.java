package C02MethodClass;

public class Calendar {
    private String year;
    private String month;
    private String day;

//    생성자 : 객체가 만들어지는(new) 시점에 호출되는 메서드
//    생성자특징 : 1)클래스명과 메서드명이 동일 2)반환타입이 없음(void도 안됨)
//    생성자의 사용목적 : 객체 생성시점에 객체변수값들을 초기화(세팅). 변수의 안정성을 위해 setter 사용을 지양하고, 생성자를 사용.
    public Calendar(String year, String month, String day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
//    직접 생성자를 1개라도 추가할경우 초기(기본)생성자는 무시가 되므로, 필요시 별도로 추가(선언)해야됨
    public Calendar(){

    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }
//    toString()메서드는 객체명으로 출력시 자동으로 메서드가 호출
//    중요한 메서드는 아니고 그냥 확인용으로 주로 쓰는 메서드라고 보면 됨
    @Override
    public String toString() {
        return "Calendar{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
