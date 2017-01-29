package package1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IpAddress[] ip ={null,null};
        IpAddress tempIp;
        String str;

        System.out.println("Пожалуйста введите два ip адреса");
        for(int i=0; i< ip.length;i++){
            System.out.print( i+1 + ": ");
            str = reader.readLine();
            while(ip[i] == null ){
                try {
                    ip[i] = new IpAddress(str);
                }
                catch(RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Повторите ввод ip адреса или завершите программу (для этого введите \"exit\")");
                    System.out.print( i+1 + ": ");
                    str = reader.readLine();
                    if(str.equals("exit")) System.exit(0);
                }
            }
        }

        System.out.println("Допустимые адреса в введенном диапазоне:");
        tempIp = new IpAddress(ip[0]);
        try {
            tempIp.inc();
        }catch(RuntimeException e){} //действие не требуется

        while(tempIp.compareTo(ip[1]) < 0){
            System.out.println(tempIp.toString());
            tempIp.inc();
        }
    }
}
