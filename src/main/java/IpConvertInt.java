/**
 * <p>
 * Title:
 * </p>
 * Description:
 * <p>
 *
 * @author jerry
 * @version Date: 2019/3/13
 */
public class IpConvertInt {
    public static void main(String[] args) {
//        String ip = "123.53.22.55";
//        int n = ip2int(ip);
//        String nip = int2ip(n);
//
//        System.out.println(ip);
//        System.out.println(n);
//        System.out.println(nip);
    }

    public static int ip2int(String ip){
        String[] ipnums = ip.split("\\.");
        int ipnum = 0;
        for (int i = 0; i<ipnums.length; i++){
            int num = Integer.parseInt(ipnums[i]) << (8 * i);
            ipnum = ipnum | num;
        }

        return ipnum;
    }

    public static String int2ip(int ipnum){
        String[] ip = new String[4];
        for (int i=0;i<4;i++){
            int pos = i * 8;
            int n = ipnum & (255 << pos);
            n = n >>> pos;
            ip[i] = String.valueOf(n);
        }

        return String.join(".", ip);
    }
}
