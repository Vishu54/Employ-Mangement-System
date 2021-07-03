public class Employ {

    public Employ() {
    }

    public Employ(int uid, String pass, String name, String dept, String salary, String mobileNum) {
        id = uid;
        password = pass;
        Name = name;
        Dept = dept;
        Salary = salary;
        MobileNum = mobileNum;
    }

    static private int id;
    static private String password;
    static String Name;
    static String Dept;
    static String Salary;
    static String MobileNum;

    public int getId() {
        return Employ.id;
    }

    public void setId(int id) {
        Employ.id = id;
    }

    public String getPassword() {
        return Employ.password;
    }

    public void setPassword(String password) {
        Employ.password = password;
    }

    public String getName() {
        return Employ.Name;
    }

    public void setName(String Name) {
        Employ.Name = Name;
    }

    public String getDept() {
        return Employ.Dept;
    }

    public void setDept(String Dept) {
        Employ.Dept = Dept;
    }

    public String getSalary() {
        return Employ.Salary;
    }

    public void setSalary(String Salary) {
        Employ.Salary = Salary;
    }

    public String getMobileNum() {
        return Employ.MobileNum;
    }

    public void setMobileNum(String MobileNum) {
        Employ.MobileNum = MobileNum;
    }

    @Override
    public String toString() {
        return "ID-> " + Employ.id + " Name-> " + Employ.Name + " Mobile-> " + Employ.MobileNum + " Dept-> "
                + Employ.Dept + " Salary-> " + Employ.Salary;
    }

    static Employ obj = new Employ();
}
