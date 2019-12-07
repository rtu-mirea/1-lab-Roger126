package laba4;


public class UniversityStaff {
    String Surname;
    String Name;
    String Address;
    String Sex;
    String Birthday;
    int AmountChildren;
    int TabNumber;

    public UniversityStaff(String Surname, String Name, String Address, String Sex, String Birthday, int AmountChildren, int TabNumber) {
        this.Surname = Surname;
        this.Name = Name;
        this.Address = Address;
        this.Sex = Sex;
        this.AmountChildren = AmountChildren;
        this.Birthday = Birthday;
        this.TabNumber = TabNumber;
    }

    public int compare(UniversityStaff sub) {
        if (sub.AmountChildren == this.AmountChildren) {
            return 1;
        }
        return 0;
    }

    public String getData(int TabNumber) {
        if (this.TabNumber == TabNumber) {
            return ("Имя " + this.Name + " Фамилия " + this.Surname + " Дата роджения " + this.Birthday + " Пол " + this.Sex);
        } else return null;
    }
}


