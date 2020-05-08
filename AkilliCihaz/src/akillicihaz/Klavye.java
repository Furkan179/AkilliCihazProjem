package akillicihaz;

import java.util.Scanner;

public class Klavye implements IKlavye{

    @Override
    public int veriAl() {
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }  

    @Override
    public String S_veriAl() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }
}
