package DzLess5;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        Person[] kolltektiv = new Person[5];
        kolltektiv[0]=new Person("Иванов Иван Иванович", "Гендиректор", "direktor@company.com",
                45, "+777777777", 1000);
        kolltektiv[1]=new Person("Петров Петр Петрович", "Секретарь", "info@company.com",
                20, "+888888888", 200);
        kolltektiv[2]=new Person("Сидоров Сидор Сидорович", "Главный специалист", "sidorov@company.com",
                50, "+999999999", 800);
        kolltektiv[3]=new Person("Васильев Василий Васильевич", "Специалист", "vasiliev@company.com",
                30, "+111111111", 500);
        kolltektiv[4]=new Person("Федоров Федор Федорович", "Уборщик", "-",
                25, "-", 200);
       
        for (int i = 0; i <kolltektiv.length ; i++) {
            if (kolltektiv[i].getAge() > 40) {
                kolltektiv[i].information();
            }

        }


    }
}
 class Person {
    private String Name;
    private String Position;
    private String Mail;
    private int Age;
    private String Phone;
    private double Salary;

    public void information () {
        System.out.println("ФИО: "+ Name);
        System.out.println("Должность: "+ Position);
        System.out.println("E-mail: "+ Mail);
        System.out.println("Возраст: "+ Age);
        System.out.println("Телефон: "+ Phone);
        System.out.println("Оклад: "+ Salary);
    }
    public String getName (){
        String name1 = this.Name;
        return name1;
    }
     public String getPosition (){
         String position1 = this.Position;
         return position1;
     }
     public String getMail (){
         String mail1= this.Mail;
         return mail1;
     }
     public String getPhone(){
         String phone1 = this.Phone;
         return phone1;
     }
     public int getAge() {return this.Age;}
     public double getSalary() {return this.Salary;}


    public Person(String name, String position, String mail, int age, String phone, double salary) {
        Name = name;
        Position = position;
        Mail = mail;
        Age = age;
        Phone = phone;
        Salary = salary;
    }
}
