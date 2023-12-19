package exercise2;

public class Program {
    public static void main(String[] args) {
        PersonAccount personAccount = new PersonAccount("0987654321","Customer A",50000,2000);
        personAccount.withDraw(5000);
        personAccount.deposite(10000);
        System.out.println(personAccount);
        SaveingAccount saveingAccount = new SaveingAccount("9834764823423","Customer Name",1900000000,12,23);
        saveingAccount.checkInterest();
        System.out.println(saveingAccount);
    }
}
