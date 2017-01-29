package package1;


public class IpAddress {

    private int[] ip = new int[4];

    public IpAddress(String address) throws RuntimeException{

        address = address.replace(" ","");

        if(verifyFormat(address))  setIp(address);
        else System.exit(1);
    }

    public IpAddress(IpAddress ipAddress){
        this.ip = ipAddress.getIp().clone();
    }

    public int[] getIp(){
        return ip;
    }

    public String toString(){
        return ip[0] + "."+ip[1] + "."+ip[2] + "."+ip[3];
    }

    public int compareTo(IpAddress anotherIp){
        return compareToStep(0,anotherIp);
    }

    public void inc() throws RuntimeException{
        incStep(3);
    }

    private int compareToStep(int index,IpAddress anotherIp){
        if(this.ip[index] > anotherIp.ip[index])       return 1;
        else if(this.ip[index] < anotherIp.ip[index])  return -1;
        else if(index == 3) return 0;
        else return compareToStep(++index,anotherIp);
    }

    private void incStep(int index) throws RuntimeException{
        ip[index]++;
        if(ip[index]>255){
            if(index != 0) {
                ip[index] = 0;
                incStep(index-1);
            }
            else {
                //при попытке увеличить значение предельного ip откатим изменения и выдадим исключение
                ip[0]=255;ip[1]=255;ip[2]=255;ip[3]=255;
                RuntimeException incError = new RuntimeException("Достигнуто предельное значение для ip адреса.");
                throw incError;
            }
        }
    }

    private void setIp(String address) throws RuntimeException{
        String sOctet=""; //часть ip адреса
        int pointIndex=0;

        for(int i=0;i<4;i++){
            if(i < 3){
                pointIndex = address.indexOf('.');
                sOctet=address.substring(0,pointIndex);
                address = address.substring(pointIndex+1);
            }else sOctet = address;

            int octet=0;
            try {
                octet = Integer.parseInt(sOctet);
            }
            catch (NumberFormatException e){
                RuntimeException createError = new RuntimeException("Неверное значение ip адреса : "+sOctet);
                throw createError;
            }

            if(octet<0 || octet >255) {
                RuntimeException createError = new RuntimeException(octet + " -недопустимое значение для ip адреса. Все значения должны быть в диапазоне от 0 до 255.");
                throw createError;
            }

            ip[i] = octet;
        }
    }

    private boolean verifyFormat(String address)throws RuntimeException{

        int countPoint=0;
        boolean ok = true;

        if(address.length() == 0) ok = false;
        else {
            for (int i = 0; i < address.length(); i++) {
                if (address.charAt(i) == '.') {
                    countPoint++;
                    if (countPoint > 3) {
                        ok = false;
                        break;
                    }
                } else if (address.charAt(i) < '0' || address.charAt(i) > '9') {
                    ok = false;
                    break;
                }
            }

            if (countPoint < 3) ok = false;
        }

        if (!ok) {
            RuntimeException createError = new RuntimeException("Неверный формат ip адреса. Допустимый формат x.x.x.x , где x - число от 0 до 255.");
            throw createError;
        }

        return ok;
    }
}
