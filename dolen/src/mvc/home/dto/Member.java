package mvc.home.dto;

public class Member {
    private int number;
    private String name;
    
    public Member(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public String getName() {
        return name;
    }
}
